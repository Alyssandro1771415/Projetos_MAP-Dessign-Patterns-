package com.example;
//Visitor
public interface Visitante {
    String visitarCirculo(Circulo c);
    String visitarTriangulo(Triangulo t);
    String visitarRetangulo(Retangulo r);
    String visitarTrapezio(Trapezio t);
}
