package com.example.queijos;

public class QueijoCheddar implements Queijo {
    @Override
    public String getTipo() {

        try {
            return "Queijo Cheddar";
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;
    
    }
}
