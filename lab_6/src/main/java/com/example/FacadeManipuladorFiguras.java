package com.example;

import java.util.ArrayList;
import java.util.List;

public class FacadeManipuladorFiguras {

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

    public String adicionarFigura(Figura figura) throws Exception {
        if (figura == null) {
            throw new Exception("Figura não pode ser nula.");
        }
        figuras.add(figura);
        return "Adicionado: " + figura.aceitar(visitanteInfo) + ".\n";
    }

    public String desenharFiguras() throws Exception {
        if (figuras.isEmpty()) {
            throw new Exception("Não há figuras para desenhar.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Desenho:\n");
        for (Figura figura : figuras) {
            sb.append(figura.aceitar(visitanteDesenho)).append("\n");
        }
        return sb.toString();
    }

    public String calcularAreas() throws Exception {
        if (figuras.isEmpty()) {
            throw new Exception("Não há figuras para calcular a área.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nÁrea:\n");
        for (Figura figura : figuras) {
            sb.append(figura.aceitar(visitanteArea)).append("\n");
        }
        return sb.toString();
    }

    public String maximizarFiguras() throws Exception {
        if (figuras.isEmpty()) {
            throw new Exception("Não há figuras para maximizar.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nMaximização:\n");
        for (Figura figura : figuras) {
            sb.append(figura.aceitar(visitanteMaximizacao)).append("\n");
        }
        return sb.toString();
    }
}
