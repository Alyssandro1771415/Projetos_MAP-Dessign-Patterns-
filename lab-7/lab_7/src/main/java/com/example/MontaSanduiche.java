package com.example;

public class MontaSanduiche {
    public static void main(String[] args) {
        Sanduiche sanduiche1 = new Sanduiche1();
        Sanduiche sanduiche2 = new Sanduiche2();
        Sanduiche sanduiche3 = new Sanduiche3();

        System.out.println("Montando Sanduíche 1:");
        System.out.println(sanduiche1.montaSanduiche());

        System.out.println("\nMontando Sanduíche 2:");
        System.out.println(sanduiche2.montaSanduiche());

        System.out.println("\nMontando Sanduíche 3:");
        System.out.println(sanduiche3.montaSanduiche());
    }
}

