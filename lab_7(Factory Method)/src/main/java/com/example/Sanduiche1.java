package com.example;
import com.example.paes.*;
import com.example.ovos.*;
import com.example.presunto.*;
import com.example.queijos.*;
import com.example.tomate.Tomate;
import com.example.tomate.TomateTradicional;

public class Sanduiche1 extends Sanduiche {

    @Override
    public Pao criaPao() {
        try {
            return new PaoIntegral();
        } catch (Exception e) {
            System.out.println("Erro ao retornar o Pão! " + e);
            return null;
        }
    }

    @Override
    public Queijo criaQueijo() {
        try {
            return new QueijoPrato();
        } catch (Exception e) {
            System.out.println("Erro ao retornar o Queijo! " + e);
            return null;
        }
    }

    @Override
    public Presunto criaPresunto() {
        try {
            return new PresuntoFrango();
        } catch (Exception e) {
            System.out.println("Erro ao retornar o Presunto! " + e);
            return null;
        }
    }

    @Override
    public Ovo criaOvo() {
        try {
            return new OvoCapoeira();
        } catch (Exception e) {
            System.out.println("Erro ao retornar o Ovo! " + e);
            return null;
        }
    }

    @Override
    public Tomate criarTomate() {
        try {
            return new TomateTradicional();
        } catch (Exception e) {
            System.out.println("Erro ao retornar o Tomate! " + e);
            return null;
        }
    }
}
