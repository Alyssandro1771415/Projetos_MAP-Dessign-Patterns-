package com.example.ovos;

public class OvoCapoeira implements Ovo {
    @Override
    public String getTipo() {
        
        try {
            return "Ovo de Capoeira";            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao retornar o tipo!" + e);
        }
        
        return null;
    
    }
}
