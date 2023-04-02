package com.javatechie.service;

import com.javatechie.entity.ImageData;
import com.javatechie.respository.StorageRepository;
import com.javatechie.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public List<ImageData> listAllImages() {
        return repository.findAll();
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

//        public List<String> listAllFiles() {
//        File[] files = new File(uploadDir).listFiles();
//        if (files == null) {
//            return new ArrayList<>();
//        }
//        return Arrays.stream(files)
//                .filter(File::isFile)
//                .map(File::getName)
//                .collect(Collectors.toList());
//    }
}

//@Service
//public class StorageService {
//
//    @Value("${file.upload-dir}")
//    private String uploadDir;
//
//    public String uploadImage(MultipartFile file) throws IOException {
//        if (file.isEmpty()) {
//            throw new IllegalArgumentException("Failed to upload empty file");
//        }
//
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        File dest = new File(uploadDir + "/" + fileName);
//        file.transferTo(dest);
//        return fileName;
//    }
//
//    public byte[] downloadImage(String fileName) {
//        try {
//            Resource resource = new PathMatchingResourcePatternResolver().getResource("file:" + uploadDir + "/" + fileName);
//            return resource.getInputStream().readAllBytes();
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to download image", e);
//        }
//    }
//
//    public List<String> listAllFiles() {
//        File[] files = new File(uploadDir).listFiles();
//        if (files == null) {
//            return new ArrayList<>();
//        }
//        return Arrays.stream(files)
//                .filter(File::isFile)
//                .map(File::getName)
//                .collect(Collectors.toList());
//    }
//}