package com.javatechie;

import com.javatechie.controller.ProductController;
import com.javatechie.entity.ImageData;
import com.javatechie.respository.StorageRepository;
import com.javatechie.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

//@SpringBootApplication
//@RestController
//@RequestMapping("/image")
//public class StorageServiceApplication {
//
//	@Autowired
//	private StorageService service;
//
//	@Autowired
//	private StorageRepository repository;
//
//	@PostMapping
//	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
//		String uploadImage = service.uploadImage(file);
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(uploadImage);
//	}
//
//	@GetMapping("/{fileName}")
//	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
//		byte[] imageData=service.downloadImage(fileName);
//		return ResponseEntity.status(HttpStatus.OK)
//				.contentType(MediaType.valueOf("image/png"))
//				.body(imageData);
//	}
////	@GetMapping
////	public ResponseEntity<?> listAllFiles() {
//////		List<String> fileNames = service.listAllFiles();
////		List<ImageData> fileNames = service.listAllImages();
////		return ResponseEntity.status(HttpStatus.OK).body(fileNames);
////	}
//@GetMapping
//	public List<Image> getAllImages() throws IOException {
//		List<ImageData> imageDataList =repository.findAll();
//		List<Image> imageList = new ArrayList<>();
//		for (ImageData imageData : imageDataList) {
//			byte[] imageDataBytes = imageData.getImageData();
//			byte[] imageBytes = Base64.getDecoder().decode(imageDataBytes);
//			Image image = new Image() {
//				@Override
//				public int getWidth(ImageObserver observer) {
//					return 0;
//				}
//
//				@Override
//				public int getHeight(ImageObserver observer) {
//					return 0;
//				}
//
//				@Override
//				public ImageProducer getSource() {
//					return null;
//				}
//
//				@Override
//				public Graphics getGraphics() {
//					return null;
//				}
//
//				@Override
//				public Object getProperty(String name, ImageObserver observer) {
//					return null;
//				}
//			};
//			imageList.add(image);
//		}
//		return imageList;
//	}

@SpringBootApplication
public class StorageServiceApplication {
	public static void main(String[] args) {
		new File(ProductController.uploadDir).mkdir();
		SpringApplication.run(StorageServiceApplication.class, args);
	}

}
