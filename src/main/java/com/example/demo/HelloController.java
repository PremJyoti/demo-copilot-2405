package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam; // Import the RequestParam class

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Received request for /hello");
        String response = "Hello, World!";
        System.out.println("Sending response: " + response);
        return response;
    }

    @GetMapping("/reverse")
    public String reverse(@RequestParam("input") String input) {
        System.out.println("Received request for /reverse with input: " + input);
        StringBuilder reversed = new StringBuilder(input);
        String response = reversed.reverse().toString();
        System.out.println("Sending response: " + response);
        return response;
    }

    // operación para verificar si una palabra es un palindromo
    @GetMapping("/palindrome")
    public boolean palindrome(@RequestParam("input") String input) {
        System.out.println("Received request for /palindrome with input: " + input);
        boolean isPalindrome = input.equals(new StringBuilder(input).reverse().toString());
        System.out.println("Sending response: " + isPalindrome);
        return isPalindrome;
    }
}
