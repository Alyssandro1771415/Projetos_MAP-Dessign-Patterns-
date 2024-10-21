package com.example.presunto;

public class PresuntoFrango implements Presunto {
    @Override
    public String getTipo() {

        try {
            return "Presunto de Frango";        
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;
    
    }
}