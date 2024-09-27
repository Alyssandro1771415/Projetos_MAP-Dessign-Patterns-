import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.Almoxarifado;

public class AlmoxarifadoTest {

    private Almoxarifado almoxarifado;

    @BeforeEach
    public void setup() {

        almoxarifado = new Almoxarifado();
    
    }

    @Test
    public void testAdicionarItem() {

        almoxarifado.adicionarItem("Caneta", 10);

        String resultado = almoxarifado.mostrarEstoque();

        assertTrue(resultado.contains("Caneta: 10 unidades"));

    }

    @Test
    public void testAdicionarItemComQuantidadeInvalida() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            almoxarifado.adicionarItem("Caneta", -5);
        });

        assertEquals("Erro: Dados inválidos para adicionar item ao estoque.", exception.getMessage());

    }

    @Test
    public void testAdicionarItemComNomeNulo() {
    
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            almoxarifado.adicionarItem(null, 5);
        });
    
        assertEquals("Erro: Dados inválidos para adicionar item ao estoque.", exception.getMessage());
    
    }

    @Test
    public void testMostrarEstoqueVazio() {
    
        String resultado = almoxarifado.mostrarEstoque();
        assertEquals("Estoque vazio. Nenhum item disponível.", resultado);
    
    }

    @Test
    public void testMostrarEstoqueComItens() {
   
        almoxarifado.adicionarItem("Caneta", 10);
        almoxarifado.adicionarItem("Lápis", 5);
        
        String resultado = almoxarifado.mostrarEstoque();
        
        assertTrue(resultado.contains("Caneta: 10 unidades"));
        assertTrue(resultado.contains("Lápis: 5 unidades"));
    
    }

    @Test
    public void testPedidoDeCompraItemNaoDisponivel() {
    
        String resultado = almoxarifado.pedidoDeCompra("Papel", 50);
        assertEquals("Pedido de compra registrado para Papel com quantidade 50.", resultado);
    
    }

    @Test
    public void testPedidoDeCompraItemDisponivel() {
        
        almoxarifado.adicionarItem("Caneta", 10);
        String resultado = almoxarifado.pedidoDeCompra("Caneta", 50);
        assertEquals("Pedido de compra não necessário. Item disponível: Caneta.", resultado);
    
    }

    @Test
    public void testPedidoDeCompraComDadosInvalidos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            almoxarifado.pedidoDeCompra(null, 10);
        });
        assertEquals("Erro: Dados inválidos para pedido de compra.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            almoxarifado.pedidoDeCompra("Papel", -1);
        });
        assertEquals("Erro: Dados inválidos para pedido de compra.", exception.getMessage());
    }
}
