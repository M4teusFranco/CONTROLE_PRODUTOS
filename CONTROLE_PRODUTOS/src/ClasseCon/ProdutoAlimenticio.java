package ClasseCon; // Utilização do Pacote Classe Concreta
import ClasseAbs.Produto; // Importação da Classe Produto do Pacote Classe Abstrata

// Criação da Classe Produto Alimentício, herdando a Classe Produto
public class ProdutoAlimenticio extends Produto {
    private String validade; // Atributos da Classe Produto Alimentício
    
    // Construtor da Classe Produto Alimentício
    public ProdutoAlimenticio(String nome, double custoAlimento, double vendaAlimento, String validade) {
		// Chama o construtor da Classe Produto para inicializar os valores
    	super(nome, custoAlimento, vendaAlimento);
        this.validade = validade; // Inicializa a Data de Validade do Alimento
    }
}
