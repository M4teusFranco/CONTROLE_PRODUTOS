package ClasseAbs;// Utilização do Pacote Classe Abstrata
	
//Criação da Classe Abstrata Produto
public abstract class Produto {
	 private String nome; // Atributos da Classe Produto
	 private double custoAlimento;
	 private double vendaAlimento;
	 	
	 	// Construtor da Classe Produto
	    public Produto(String nome, double custoAlimento, double vendaAlimento) {
	        this.nome = nome; // Inicializa o Nome do Produto
	        this.custoAlimento = custoAlimento; // Inicializa o Preço de Custo do Produto
	        this.vendaAlimento = vendaAlimento; // Inicializa o Preço de Venda do Produto
	    }

	    // Método para calcular o Lucro do Produto
	    public double calcularLucro() {
	        return custoAlimento - vendaAlimento; // Retorna a diferença entre Preço de Venda e Preço de Custo
	    }
	}

