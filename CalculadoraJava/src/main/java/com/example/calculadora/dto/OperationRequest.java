package com.example.calculadora.dto;

public class OperationRequest {
    private double a;
    private double b;
    private String op;

    public double getA() { return a; }
    public void setA(double a) { this.a = a; }

    public double getB() { return b; }
    public void setB(double b) { this.b = b; }

    public String getOp() { return op; }
    public void setOp(String op) { this.op = op; }
}
