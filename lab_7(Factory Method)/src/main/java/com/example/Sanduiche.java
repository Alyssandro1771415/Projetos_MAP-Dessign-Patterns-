package com.example;
import com.example.paes.*;
import com.example.ovos.*;
import com.example.presunto.*;
import com.example.queijos.*;
import com.example.tomate.Tomate;

public abstract class Sanduiche {
    // Factory Methods
    public abstract Pao criaPao();
    public abstract Queijo criaQueijo();
    public abstract Presunto criaPresunto();
    public abstract Ovo criaOvo();
    public abstract Tomate criarTomate();

    // Método para montar o sanduíche
    public String montaSanduiche() {
        try {
            Pao pao = criaPao();
            Queijo queijo = criaQueijo();
            Presunto presunto = criaPresunto();
            Ovo ovo = criaOvo();
            Tomate tomate = criarTomate();
    
            return "Sanduíche com: " + pao.getTipo() + ", " +
                                   queijo.getTipo() + ", " +
                                   presunto.getTipo() + ", " +
                                   ovo.getTipo() + " e " + tomate.getTipo() + ".";
        } catch (Exception e) {
            return "Erro inesperado ao montar o sanduíche.";
        }
    }
    
}
