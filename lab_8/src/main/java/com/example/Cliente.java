package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {
    public static void main(String[] args) {
        try {

            List<String> normalList = new ArrayList<>();
            normalList.add("Elemento 1");
            normalList.add("Elemento 2");
            normalList.add("Elemento 3");
            
            System.out.println("Elementos adicionados na lista normal:");
            for (String element : normalList) {
                System.out.println(element);
            }

            System.out.println("\nVerificando se a lista normal contém a string \"Elemento 1\": " + (normalList.contains("Elemento 1") ? "Contém" : "Não contém"));
        
            MapToListAdapter<Integer, String> mapToListAdapter = new MapToListAdapter<>();
            mapToListAdapter.add("Elemento 1");
            mapToListAdapter.add("Elemento 2");
            mapToListAdapter.add("Elemento 3");
        
            System.out.println("\nElementos adicionados no Mapa adaptado para lista:");
            for (String element : mapToListAdapter) {
                System.out.println(element);
            }
            
            System.out.println("\nVerificando se o map adaptado para lista contém a string \"Elemento 1\": " + (mapToListAdapter.contains("Elemento 1") ? "Contém" : "Não contém"));

            System.out.println("---------------------------------------------------------------------------------------------------------");

            Map<Integer, String> normalMap = new HashMap<>();
            normalMap.put(0, "Elemento A");
            normalMap.put(1, "Elemento B");
            normalMap.put(2, "Elemento C");

            System.out.println("\nElementos adicionados no Mapa normal:");
            for (int i = 0; i < normalMap.size(); i++) {
                System.out.println("Chave: " + i + ", Valor: " + normalMap.get(i));
            }

            System.out.println("\nMapa normal: Retornando o valor para a chave 2: " + normalMap.get(2));
            System.out.println("\nMapa normal: Verificando se o map normal contém o valor de tipo string \"Elemento A\": " + (normalMap.containsValue("Elemento A") ? "Contém" : "Não contém"));

            ListToMapAdapter<Integer, String> listToMapAdapter = new ListToMapAdapter<>(normalList);
            listToMapAdapter.put(0, "Elemento A");
            listToMapAdapter.put(1, "Elemento B");
            listToMapAdapter.put(2, "Elemento C");

            System.out.println("\nElementos adicionados na Lista adaptada para Map:");
            for (int i = 0; i < listToMapAdapter.size(); i++) {
                System.out.println("Chave: " + i + ", Valor: " + listToMapAdapter.get(i));
            }

            System.out.println("\nLista adaptada para Map: Retornando o valor para a chave 2: " + listToMapAdapter.get(2));
            System.out.println("\nLista adaptada para Map: Verificando se o map normal contém o valor de tipo string \"Elemento A\": " + (listToMapAdapter.containsValue("Elemento A") ? "Contém" : "Não contém"));

        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
