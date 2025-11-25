package com.example.java;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operation")
@CrossOrigin(origins = "*")
public class CalculadoraController {

    @PostMapping("/soma/{a}/{b}")
    public double soma(@PathVariable double a, @PathVariable double b) {
        System.out.println("Soma: " + a + " + " + b);
        return a + b;
    }

    @PostMapping("/subtracao/{a}/{b}")
    public double subtracao(@PathVariable double a, @PathVariable double b) {
        System.out.println("Subtração: " + a + " - " + b);
        return a - b;
    }

    @PostMapping("/multiplicacao/{a}/{b}")
    public double multiplicacao(@PathVariable double a, @PathVariable double b) {
        System.out.println("Multiplicação: " + a + " * " + b);
        return a * b;
    }

    @PostMapping("/divisao/{a}/{b}")
    public double divisao(@PathVariable double a, @PathVariable double b) {
        System.out.println("Divisão: " + a + " / " + b);
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        return a / b;
    }
}