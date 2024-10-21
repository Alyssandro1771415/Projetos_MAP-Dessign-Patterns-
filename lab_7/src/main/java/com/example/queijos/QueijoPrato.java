package com.example.queijos;

public class QueijoPrato implements Queijo {
    @Override
    public String getTipo() {

        try {
            return "Queijo Prato";
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }

        return null;
    
    }
}
