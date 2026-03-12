package org.megatienda.products.controllers;

import org.megatienda.modelss.product.ModelProduct;
import org.megatienda.products.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Agregar producto
    @PostMapping
    public String addProduct(@RequestBody ModelProduct product) throws IOException {
        List<ModelProduct> products = service.getAllProducts();
        product.setId(String.valueOf((long) (products.size() + 1)));
        product.setActive(true);
        product.setEnabled(true);
        products.add(product);
        service.saveProducts(products);
        return "Producto agregado";
    }

    // Modificar producto
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody ModelProduct updated) throws IOException {
        List<ModelProduct> products = service.getAllProducts();
        for (ModelProduct p : products) {
            if (p.getId().equals(id.toString())) {
                p.setName(updated.getName());
                p.setPrice(updated.getPrice());
                service.saveProducts(products);
                return "Producto actualizado";
            }
        }
        return "Producto no encontrado";
    }

    // Inhabilitar producto
    @DeleteMapping("/{id}")
    public String disableProduct(@PathVariable Long id) throws IOException {
        List<ModelProduct> products = service.getAllProducts();
        for (ModelProduct p : products) {
            if (p.getId().equals(id.toString())) {
                p.setActive(false);
                p.setEnabled(false);
                service.saveProducts(products);
                return "Producto inhabilitado";
            }
        }
        return "Producto no encontrado";
    }

    // Buscar productos
    @GetMapping
    public List<ModelProduct> getProducts() throws IOException {
        return service.getAllProducts();
    }
}




