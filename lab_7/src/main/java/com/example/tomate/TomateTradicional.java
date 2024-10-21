package com.example.tomate;

public class TomateTradicional implements Tomate {

    @Override
    public String getTipo() {

        try {
            return "Tomate Tradicional";
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;
    
    }

}
