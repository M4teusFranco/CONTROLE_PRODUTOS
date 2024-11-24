package ClasseCon; // Utilização do Pacote Classe Concreta
import ClasseAbs.Produto; // Importação da Classe Produto do Pacote Classe Abstrata

//Criação da Classe Produto Vestuário, herdando a Classe Produto
public class ProdutoVestuario extends Produto {
    private String tamanho; // Atributos da Classe Vestuário
    private String cor;
    private String material;

    // Construtor da Classe Produto Vestuário
    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
		// Chama o construtor da Classe Produto para inicializar os valores
    	super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho; // Inicializa o Tamanho do Vestuário
        this.cor = cor; // Inicializa a Cor do Vestuário
        this.material = material; // Inicializa o Material do Vestuário
    }
}