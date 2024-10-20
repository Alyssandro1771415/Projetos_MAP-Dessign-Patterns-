package com.example;
import com.example.paes.*;
import com.example.ovos.*;
import com.example.presunto.*;
import com.example.queijos.*;

public class Sanduiche3 extends Sanduiche {
    @Override
    public Pao criaPao() {
        return new PaoBola();
    }

    @Override
    public Queijo criaQueijo() {
        return new QueijoCheddar();
    }

    @Override
    public Presunto criaPresunto() {
        return new PresuntoPeru();
    }

    @Override
    public Ovo criaOvo() {
        return new OvoCapoeira();
    }
}
