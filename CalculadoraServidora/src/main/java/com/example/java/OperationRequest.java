// Define o pacote onde esta classe está localizada
// DEVE ser o mesmo pacote do CalculadoraController
package com.example.java;

// Classe que representa o modelo de dados para requisições
// Usada para desserializar JSON em objetos Java
public class OperationRequest {
    // Atributos privados que representam os dados da operação
    private double a;      // Primeiro operando
    private double b;      // Segundo operando  
    private String op;     // Operação a ser realizada

    // CONSTRUTORES (IMPORTANTE para o Spring)

    // Construtor padrão (sem argumentos) - OBRIGATÓRIO
    // Necessário para desserialização JSON → Java
    public OperationRequest() {}

    // Construtor com argumentos - OPICIONAL mas útil
    public OperationRequest(double a, double b, String op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    // GETTERS E SETTERS (OBRIGATÓRIOS para o Spring)

    // Getter para o atributo 'a'
    // Permite acesso externo ao valor de 'a'
    public double getA() { 
        return a; 
    }
    
    // Setter para o atributo 'a'
    // Permite modificar o valor de 'a' externamente
    public void setA(double a) { 
        this.a = a; 
    }

    // Getter para o atributo 'b'
    public double getB() { 
        return b; 
    }
    
    // Setter para o atributo 'b'
    public void setB(double b) { 
        this.b = b; 
    }

    // Getter para o atributo 'op' (operação)
    public String getOp() { 
        return op; 
    }
    
    // Setter para o atributo 'op'
    public void setOp(String op) { 
        this.op = op; 
    }
}