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
    public String reverse(@RequestParam("text") String input) {
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

   //Endpoint to remove vowels from a string.
    @GetMapping("/disemvowel")
    public String removeVowel(@RequestParam("text") String text){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<text.length();i++) {

            if(text.charAt(i)=='a'||text.charAt(i)=='e'||text.charAt(i)=='i'||text.charAt(i)=='o'||
                    text.charAt(i)=='u'||text.charAt(i)=='A'||text.charAt(i)=='E'||text.charAt(i)=='I'||text.charAt(i)=='O'
                    ||text.charAt(i)=='U') {
                continue;
            }
            else {
                sb.append(text.charAt(i));
            }

        }
        return sb.toString();
    }

}
