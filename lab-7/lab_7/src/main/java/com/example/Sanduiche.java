package com.example;
import com.example.paes.*;
import com.example.ovos.*;
import com.example.presunto.*;
import com.example.queijos.*;

public abstract class Sanduiche {
    // Factory Methods
    public abstract Pao criaPao();
    public abstract Queijo criaQueijo();
    public abstract Presunto criaPresunto();
    public abstract Ovo criaOvo();

    // Método para montar o sanduíche
    public String montaSanduiche() {
        Pao pao = criaPao();
        Queijo queijo = criaQueijo();
        Presunto presunto = criaPresunto();
        Ovo ovo = criaOvo();
        
        return ("Sanduíche com: " + pao.getTipo() + ", " +
                           queijo.getTipo() + ", " +
                           presunto.getTipo() + ", " +
                           ovo.getTipo() + " e tomate.");
    }
}
