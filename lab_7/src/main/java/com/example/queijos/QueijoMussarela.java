package com.example.queijos;

public class QueijoMussarela implements Queijo {
    @Override
    public String getTipo() {

        try {
            return "Queijo Mussarela";
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;
    
    }
}