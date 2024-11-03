package com.example;

public class MontaSanduiche {
    public static void main(String[] args) {
        Sanduiche sanduiche1 = null;
        Sanduiche sanduiche2 = null;
        Sanduiche sanduiche3 = null;

        try {
            sanduiche1 = new Sanduiche1();
            sanduiche2 = new Sanduiche2();
            sanduiche3 = new Sanduiche3();   
        } catch (Exception e) {
            System.out.println("Erro ao realizar a montagem dos sanduíches! " + e);
        }

        if (sanduiche1 != null) {
            System.out.println("Montando Sanduíche 1:");
            System.out.println(sanduiche1.montaSanduiche());
        }

        if (sanduiche2 != null) {
            System.out.println("\nMontando Sanduíche 2:");
            System.out.println(sanduiche2.montaSanduiche());
        }

        if (sanduiche3 != null) {
            System.out.println("\nMontando Sanduíche 3:");
            System.out.println(sanduiche3.montaSanduiche());
        }
    }
}
