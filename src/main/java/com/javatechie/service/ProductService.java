package com.javatechie.service;

import com.javatechie.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> listProducts(MultipartFile file);
}
