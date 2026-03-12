package org.megatienda.cart.controllers;

import org.megatienda.cart.model.CartItem;
import org.megatienda.cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

// obtener productos del carrito 

    @GetMapping
    public List<CartItem> getCart(){
        return cartService.getCart();
    }
// agregar producto al carrito
    @PostMapping("/add")
    public String addItem(@RequestBody CartItem item){
        cartService.addItem(item);
        return "Producto agregado al carrito";
    }

//eliminar producto del carrito por id

    @DeleteMapping("/remove/{productId}")
    public String removeItem(@PathVariable int productId){
        cartService.removeItem(productId);
        return "Producto eliminado del carrito";
    }

//vaciar carrito de comprar
    @DeleteMapping("/clear")
    public String clearCart(){
        cartService.clearCart();
        return "Carrito vaciado";
    }
// contar productos del carrito
    @GetMapping("/count")
    public int countItems() {
        return cartService.getCartSize();
    }
    
}
