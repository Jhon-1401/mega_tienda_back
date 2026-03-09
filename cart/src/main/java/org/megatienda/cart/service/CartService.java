package org.megatienda.cart.service;

import org.megatienda.cart.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private List<CartItem> cart = new 
ArrayList<>();
    private RestTemplate restTemplate = 
new RestTemplate();

    public List<CartItem> getCart(){
        return cart;
    }

    public void addItem(CartItem item){

        // url desde donde se van a consumir los productos

 //       String url =
//"http://localhost:8081/products/" +
//item.getProductId();

  //      Object product = 
//restTemplate.getForObject(url, Object.class); 

  //      if(product != null){
             cart.add(item);
        }
    //}

    public void removeItem(int productId){
        cart.removeIf(item -> 
item.getProductId() == productId);
    }
    public void clearCart(){
        cart.clear();
    }
    public int getCartSize(){
        return cart.size();
    }
}