package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(HelloController.class)
public class HelloControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, World!"));
    }

    @Test
    public void testReverse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleh"));
    }

    // test reverse con caracteres especiales
    @Test
    public void testReverseSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", "hola!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("!aloh"));
    }

    // test reverse con parametro vacio
    @Test
    public void testReverseEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

    @Test
    public void testPalindrome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/palindrome").param("input", "racecar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    // test palindrome con caracteres especiales
    @Test
    public void testPalindromeSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/palindrome").param("input", "hola!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

    // test palindrome con parametro vacio
    @Test
    public void testPalindromeEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/palindrome").param("input", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));
    }

    // test palindrome con una palabra que no es palindromo
    @Test
    public void testPalindromeNot() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/palindrome").param("input", "hola"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));
    }

}