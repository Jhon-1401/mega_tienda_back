package org.megatienda.products.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.megatienda.modelss.product.ModelProduct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ObjectMapper mapper = new ObjectMapper();
    private List<ModelProduct> products = new ArrayList<>();

    // Constructor: carga productos.json desde resources
    public ProductService() throws IOException {
        ClassPathResource resource = new ClassPathResource("products.json");
        try (InputStream inputStream = resource.getInputStream()) {
            this.products = mapper.readValue(inputStream, new TypeReference<List<ModelProduct>>() {});
        }
    }

    // Devuelve todos los productos cargados
    public List<ModelProduct> getAllProducts() {
        return new ArrayList<>(products);
    }

    // Guarda los productos en memoria y opcionalmente en archivo externo
    public void saveProducts(List<ModelProduct> products) throws IOException {
        this.products = new ArrayList<>(products);

        // Si quieres persistir en un archivo físico fuera del jar:
        // mapper.writeValue(new File("/app/products.json"), products);
        // (montado como volumen en Docker)
    }

}

