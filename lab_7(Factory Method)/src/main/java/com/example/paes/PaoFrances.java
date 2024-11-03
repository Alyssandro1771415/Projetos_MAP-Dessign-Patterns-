package com.example.paes;

public class PaoFrances implements Pao {
    @Override
    public String getTipo() {
        
        try {
            return "Pão Francês";            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;

    }

}
