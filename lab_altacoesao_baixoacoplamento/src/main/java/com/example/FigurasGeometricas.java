package com.example;

public class FigurasGeometricas {
	
	private Quadrado quadrado;
	private Circulo circulo;
	private Retangulo retangulo;
	
	public Quadrado getQuadrado() {
		return quadrado;
	}

	public void setQuadrado(Quadrado quadrado) {
		this.quadrado = quadrado;
	}

	public Circulo getCirculo() {
		return circulo;
	}

	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}

	public Retangulo getRetangulo() {
		return retangulo;
	}

	public void setRetangulo(Retangulo retangulo) {
		this.retangulo = retangulo;
	}

	public FigurasGeometricas(int alturaRetangulo, int larguraRetangulo, int ladoQuadrado, int raioCirculo){
		this.quadrado = new Quadrado(ladoQuadrado);
		this.circulo = new Circulo(raioCirculo);
		this.retangulo = new Retangulo(larguraRetangulo, alturaRetangulo);
	}

	public String toString(){
		return ("O retângulo criado tem altura: " + this.retangulo.getAltura() + " e largura de: " + this.retangulo.getLargura() + ".\n" +
		"O quadrado criado tem lados de: " + this.quadrado.getLargura() + ".\n" +
		"O circulo criado tem raio de: " + this.circulo.getRaio()) + ".";
	}
}
