package lab_altacoesao_baixoacoplamento;

public class Circulo implements Figura {
    
    private double raio;

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
    
    @Override
    public String toString() {
        return (" O circulo criado tem raio de: " + getRaio());
    }

    
}