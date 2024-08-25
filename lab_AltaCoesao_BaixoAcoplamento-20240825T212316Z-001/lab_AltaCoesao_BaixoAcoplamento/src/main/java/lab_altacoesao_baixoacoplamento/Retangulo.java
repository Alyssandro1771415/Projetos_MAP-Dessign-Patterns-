package lab_altacoesao_baixoacoplamento;

public class Retangulo implements Figura {
    private double largura;
    private double altura;

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }
    
    public String toString(){
        return ("O retangulo criado tem altura de tamanho: " + this.altura + 
			"e largura de tamanho: " + this.largura);
    }
}
