package com.example.paes;

public class PaoBola implements Pao {
    @Override
    public String getTipo() {
        
        try {
            return "Pão Bola";            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }
        
        return null;
    
    }
}