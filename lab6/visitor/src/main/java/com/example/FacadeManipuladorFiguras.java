package com.example;

import java.util.ArrayList;
import java.util.List;

public class FacadeManipuladorFiguras {

    //Observação: Os métodos desta classe manipulam uma lista de figuras e o visitor passam por elas.
    //Implementação de lista para o programa possuir quantas figuras for necessário.
    private List<Figura> figuras;
    private Visitante visitanteDesenho;
    private Visitante visitanteArea;
    private Visitante visitanteMaximizacao;
    private Visitante visitanteInfo;

    public FacadeManipuladorFiguras() {
        figuras = new ArrayList<>();
        visitanteDesenho = new VisitanteDesenho();
        visitanteArea = new VisitanteArea();
        visitanteMaximizacao = new VisitanteMaximizacao();
        visitanteInfo = new VisitanteInfo();
    }

    public String adicionarFigura(Figura figura) {
        figuras.add(figura);
        return "Adicionado: "+figura.aceitar(visitanteInfo) + ".\n";
    }

    public String desenharFiguras() {
        StringBuilder sb = new StringBuilder();
        sb.append("Desenho:\n");
        for (Figura figura : figuras) {
            sb.append(figura.aceitar(visitanteDesenho)).append("\n");
        }
        return sb.toString();
    }

    public String calcularAreas() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nÁrea:\n");
        for (Figura figura : figuras) {
            sb.append(figura.aceitar(visitanteArea)).append("\n");
        }
        return sb.toString();
    }

    public String maximizarFiguras() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMaximização:\n");
        for (Figura figura : figuras) {
            sb.append(figura.aceitar(visitanteMaximizacao)).append("\n");
        }
        return sb.toString();
    }
}
