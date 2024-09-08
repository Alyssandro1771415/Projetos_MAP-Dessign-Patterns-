public class Main {
    public static void main(String[] args) {
        ControleDeAcesso controleGloboFilmes =new ControleDeAcesso();
        
        // Criando funcionários

        controleGloboFilmes.cadastrarFuncionario("Danilo", "11111111111"); //11111111111

        controleGloboFilmes.cadastrarFuncionario("Pedro", "11111111112"); //11111111112

        controleGloboFilmes.cadastrarFuncionario("Valerio", "11111111113"); //11111111113

        // Criando um filme

        controleGloboFilmes.cadastrarFilme("Scream IV", 2010, "00001");//id: 00001

        // Colocando funcionarios no filme

        controleGloboFilmes.adicionarEmElenco("00001", "11111111111");
        controleGloboFilmes.adicionarEmElenco("00001", "11111111112");
        controleGloboFilmes.adicionarEmElenco("00001", "11111111113");
        controleGloboFilmes.adicionarNaProducao("00001", "11111111113");
        controleGloboFilmes.getFilme("00001").setTrilhaSonora("Wicked game - Chris Isaak");

         // Adicionando funções aos funcionários

        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111111", 2); //Diretor

        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111112", 6); //Ator
 
        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111113", 1); //Ator
 
        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111113", 2); //Produtor

        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111113", 6); //Camera


        //Retornando um filme
        System.out.println(controleGloboFilmes.getFilme("00001").toString());;
        
        //Exibindo filmografia do ator
        System.out.println(controleGloboFilmes.getFuncionario("11111111113").toString());
        System.out.println(controleGloboFilmes.getFuncionario("11111111113").toStringFilmografia());
    }
}
