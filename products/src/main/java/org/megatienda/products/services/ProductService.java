package org.megatienda.products.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.megatienda.modelss.product.ModelProduct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final File file;

    public ProductService() throws IOException {
        // Carga el archivo desde resources
        this.file = new ClassPathResource("products.json").getFile();
    }

    public List<ModelProduct> getAllProducts() throws IOException {
        if (!file.exists()) return new ArrayList<>();
        return mapper.readValue(file, new TypeReference<List<ModelProduct>>() {});
    }

    public void saveProducts(List<ModelProduct> products) throws IOException {
        mapper.writeValue(file, products);
    }
}

