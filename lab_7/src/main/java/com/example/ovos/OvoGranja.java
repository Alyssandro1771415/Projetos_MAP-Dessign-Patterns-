package com.example.ovos;

public class OvoGranja implements Ovo {
    @Override
    public String getTipo() {
        
        try {
            return "Ovo de Granja";
            
        } catch (Exception e) {
            System.out.println("Ocorreu algum erro ao retornar o tipo!" + e);
        }
        
        return null;
    
    }
}
