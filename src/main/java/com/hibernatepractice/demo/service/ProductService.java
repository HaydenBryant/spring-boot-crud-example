package com.hibernatepractice.demo.service;

import com.hibernatepractice.demo.entity.Product;
import com.hibernatepractice.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    @PostMapping
    public Product saveProduct(Product product){
        return repo.save(product);
    }

    @PostMapping
    public List<Product> saveProducts(List<Product> products){
        return repo.saveAll(products);
    }

    @GetMapping
    public List<Product> getProducts(){
        return repo.findAll();
    }

    @GetMapping
    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }

    @GetMapping
    public Product getProductByName(String name){
        return repo.findByName(name);
    }

    @DeleteMapping
    public String deleteProduct(int id){
        repo.deleteById(id);
        return "Product Deleted !!" + id ;
    }

    @PostMapping
    public Product updateProduct(Product product){
        Product existingProduct = repo.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repo.save(existingProduct);
    }
}
