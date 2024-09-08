public class Main {
    
    public static final int ATOR = 1;
    public static final int DIRETOR = 2;
    public static final int ROTEIRISTA = 3;
    public static final int PRODUTOR = 4;
    public static final int CINEGRAFISTA = 5;
    public static final int CAMERA = 6;

    public static void main(String[] args) {
        ControleDeAcesso controleGloboFilmes =new ControleDeAcesso();
        
        // Criando funcionários

        controleGloboFilmes.cadastrarFuncionario("Danilo", "11111111111"); //11111111111

        controleGloboFilmes.cadastrarFuncionario("Pedro", "11111111112"); //11111111112

        controleGloboFilmes.cadastrarFuncionario("Valerio", "11111111113"); //11111111113

        // Criando um filme

        controleGloboFilmes.cadastrarFilme("Scream IV", 2011, "00001");
        controleGloboFilmes.cadastrarFilme("Superman - O filme", 1978, "00002");
        // Colocando funcionarios no filme

        controleGloboFilmes.adicionarEmElenco("00001", "11111111111");
        controleGloboFilmes.adicionarEmElenco("00001", "11111111112");
        controleGloboFilmes.adicionarEmElenco("00001", "11111111113");
        controleGloboFilmes.adicionarNaProducao("00001", "11111111113");
        controleGloboFilmes.getFilme("00001").setTrilhaSonora("Wicked game - Chris Isaak");

         // Adicionando funções aos funcionários

        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111111", DIRETOR); //Diretor

        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111112", ATOR); //Ator
 
        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111113", ATOR); //Ator
 
        controleGloboFilmes.getFilme("00001").atribuirFuncaoFuncionario("11111111113", ROTEIRISTA); //Produtor

        //Fazendo o mesmo que foi feito para o filme de id 00002

        controleGloboFilmes.adicionarEmElenco("00002", "11111111111");
        controleGloboFilmes.adicionarEmElenco("00002", "11111111113");
        controleGloboFilmes.getFilme("00002").atribuirFuncaoFuncionario("11111111111", ATOR); //Diretor
        controleGloboFilmes.getFilme("00002").atribuirFuncaoFuncionario("11111111113", DIRETOR); //Ator
        controleGloboFilmes.getFilme("00002").setTrilhaSonora("Superman Theme - John Williams");

        //Printando todos os filmes
        controleGloboFilmes.obterFilmes();
        
        //Exibindo filmografia do ator
        System.out.println(controleGloboFilmes.getFuncionario("11111111113").toString());
        System.out.println(controleGloboFilmes.getFuncionario("11111111113").toStringFilmografia());
    }
}
