package com.example;
import com.example.paes.*;
import com.example.ovos.*;
import com.example.presunto.*;
import com.example.queijos.*;

public class Sanduiche1 extends Sanduiche {
    @Override
    public Pao criaPao() {
        return new PaoIntegral();
    }

    @Override
    public Queijo criaQueijo() {
        return new QueijoPrato();
    }

    @Override
    public Presunto criaPresunto() {
        return new PresuntoFrango();
    }

    @Override
    public Ovo criaOvo() {
        return new OvoCapoeira();
    }
   
}