package com.example.calculadora.controllers;

import com.example.calculadora.dto.OperationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculadoraController {

    @PostMapping("/calcular")
    public double calcular(@ModelAttribute OperationRequest req) {

        return switch (req.getOp()) {
            case "somar" -> req.getA() + req.getB();
            case "subtrair" -> req.getA() - req.getB();
            case "multiplicar" -> req.getA() * req.getB();
            case "dividir" -> req.getA() / req.getB();
            default -> throw new IllegalArgumentException("Operação inválida");
        };
    }
}
