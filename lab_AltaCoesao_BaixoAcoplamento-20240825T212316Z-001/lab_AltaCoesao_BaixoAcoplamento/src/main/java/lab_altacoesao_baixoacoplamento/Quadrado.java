package lab_altacoesao_baixoacoplamento;

public class Quadrado extends Retangulo {

    public Quadrado(double lado) {
        super(lado, lado);
    }

    @Override
    public String toString() {
        return "O quadrado criado tem lado de tamanho: " + this.getLargura();
    }
}
