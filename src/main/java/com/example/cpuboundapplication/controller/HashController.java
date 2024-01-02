package com.example.cpuboundapplication.controller;

import jakarta.xml.bind.DatatypeConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class HashController {

    @RequestMapping("/hash/{input}")
    public String getDigest(
            @PathVariable("input") String input
    ) throws NoSuchAlgorithmException {
        for (int i = 0; i < 1000000; i++) {
            input = getMD5Digest(input);
        }
        return input;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    private String getMD5Digest(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();

        return DatatypeConverter
                .printHexBinary(digest).toUpperCase();
    }

}
