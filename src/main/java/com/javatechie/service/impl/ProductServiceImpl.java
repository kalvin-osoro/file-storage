package com.javatechie.service.impl;

import com.javatechie.model.Product;
import com.javatechie.respository.ProductRepository;
import com.javatechie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl  {

    @Autowired
    ProductRepository productRepository;




    public List<Product> listProducts(MultipartFile file) {
        List<Product> products = productRepository.findAll();
        List<Product> productList = new ArrayList<>();

        return productList;
    }


}
