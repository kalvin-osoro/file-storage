package com.javatechie.controller;

import com.javatechie.model.Product;
import com.javatechie.respository.ProductRepository;
import com.javatechie.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    ProductRepository productRepository;

    public static String uploadDir = System.getProperty("product.dir") + "/src/main/static/uploads";

    @PostMapping("/add")
    @ResponseBody
    public String addProduct(Product product, @RequestParam("img") MultipartFile file) {
        StringBuilder fileNames = new StringBuilder();
        String filename = product.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
        Path fileNameAndPath = Paths.get(uploadDir, filename);
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(filename);
        productRepository.save(product);
        return "Save Data Successfully! ";

    }

}
