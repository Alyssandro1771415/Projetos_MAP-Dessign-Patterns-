package com.example.presunto;

public class PresuntoPeru implements Presunto {
    @Override
    public String getTipo() {

        try {
            return "Presunto de Peru";        
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;
    
    }
}
