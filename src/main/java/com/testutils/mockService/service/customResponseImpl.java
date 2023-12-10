package com.testutils.mockService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testutils.mockService.Entity.customResponse;
import jakarta.annotation.Resources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.Map;
import java.util.Scanner;

@Service
public class customResponseImpl implements customResponse {


    @Override
    public String getResponseFile(String responseFileName) {


        String resourcesPath = "CustomResponse/"+responseFileName+".json";


        try {

//            ClassPathResource resource = new ClassPathResource(resourcesPath);
//            InputStream inputStream = resource.getInputStream();

            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+resourcesPath);

            String content = new String(Files.readAllBytes(file.toPath()));

//            Scanner scanner = new Scanner(file);
//            String fileContent = scanner.toString();
//
//            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//            InputStream is = classloader.getResourceAsStream(responseFileName+".json");
//            System.out.println("from Input Stream reader :- "+is.toString());
//
//            StringBuilder stringBuilder = new StringBuilder((CharSequence) file);
//            System.out.println("from String Builder :- "+stringBuilder.toString());

            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = mapper.readValue(content,Map.class);
            System.out.println("from Objectmapper map  :- "+map.toString());

            return content;
        } catch (Exception e) {
            return "error :"+e.toString();
        }
    }
}
