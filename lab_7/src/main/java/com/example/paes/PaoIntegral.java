package com.example.paes;

public class PaoIntegral implements Pao {
    @Override
    public String getTipo() {

        try {
            return "Pão Integral";            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;

    }
}