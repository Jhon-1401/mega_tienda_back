package org.megatienda.cart.service;

import org.megatienda.cart.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

@Service
public class CartService {

    private List<CartItem> cart = new ArrayList<>();
    private RestTemplate restTemplate = new RestTemplate();

    public List<CartItem> getCart(){

        System.out.println("ENTRO AL GETCART NUEVO");

    List<CartItem> cartResponse = new ArrayList<>();

    try{

        String url = "http://nginx/products/all";

        List<Map<String,Object>> products =
                restTemplate.getForObject(url, List.class);

        for(CartItem item : cart){

            CartItem responseItem = new CartItem();

            responseItem.setProductId(item.getProductId());
            responseItem.setQuantity(item.getQuantity());

            for(Map<String,Object> product : products){

                String id = product.get("id").toString();

                if(id.equals(String.valueOf(item.getProductId()))){

                    responseItem.setName(product.get("name").toString());
                    responseItem.setPrice(Double.parseDouble(product.get("price").toString()));
                    responseItem.setImageUrl(product.get("imageUrl").toString());

                    break;
                }
            }

            cartResponse.add(responseItem); 
        }

    }catch(Exception e){

        System.out.println("Error obteniendo productos: " + e.getMessage());
        cartResponse = cart;
    }

    return cartResponse;
}



    public void addItem(CartItem item){

    for (int i = 0; i < cart.size(); i++) {

        CartItem cartItem = cart.get(i);

        if (cartItem.getProductId() == item.getProductId()) {

            int newQuantity = cartItem.getQuantity() + item.getQuantity();

            if (newQuantity <= 0) {
                cart.remove(i);
            } else {
                cartItem.setQuantity(newQuantity);
            }

            return;
        }
    }

    if (item.getQuantity() > 0) {
        cart.add(item);
    }
}

   public void removeItem(int productId){

    for(int i = 0; i < cart.size(); i++){

        CartItem item = cart.get(i);

        if(item.getProductId() == productId){

            if(item.getQuantity() > 1){
                item.setQuantity(item.getQuantity() - 1);
            }else{
                cart.remove(i);
            }

            return;
        }
    }
}

    public void clearCart(){
        cart.clear();
    }

    public int getCartSize(){

    int total = 0;

    for(CartItem item : cart){
        total += item.getQuantity();
    }

    return total;
}
}