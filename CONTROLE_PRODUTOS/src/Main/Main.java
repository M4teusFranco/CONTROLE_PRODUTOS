package Main; // Esta classe pertence ao pacote main
import java.util.HashSet; //Importação de Classes e Bibliotecas necessárias para funcionalidade do código
import java.nio.file.spi.FileSystemProvider;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.aula.conexao.*;
	

// Criação da Classe Main da interface
public class Main {
    
		public static void main(String[] args) {
			Connection conexao = ConexaoDB.conectar(); // Puxa o método Conectar para estabelecer a conexão com o Banco de Dados
				
			Scanner scanner = new Scanner (System.in); // Cria o Objeto scanner para receber os números digitado
			Set<String> alimentos = new HashSet<>(); // Cria um Set para armazenar nomes de frutas
			
			while(true) {
				try {
			
			// Exibição das opções do Usuário
			System.out.println("\n===== Menu Principal ======\n"); 
			System.out.println("Deseja gerenciar os Alimentos ou Vestuários?\n");
			System.out.println("1. Alimentos");
			System.out.println("2. Vestuários");
			
			System.out.println("------------------------");
			System.out.println("Escolha uma opção: ");
			
			int opcao0 = scanner.nextInt(); // Váriavel que armazenará o número digitado pelo Usuário
			scanner.nextLine(); // Limpa o buffer
			
			// Inicialização do Switch de escolhas do Usuário	
			switch(opcao0) {
			case 1: // Caso o Usuário escolha a Opção 1 (Gereciamento de Alimentos)
			
			
			// Enquanto o usuário digitar os números dentre as opções, a operação continua
			while(true) {
				try {
					
					System.out.println("\n------- Alimentos -------"); 
					System.out.println("1. Inserir Alimento");
					System.out.println("2. Atualizar Alimento");
					System.out.println("3. Deletar Alimento");
					System.out.println("4. Ler Registros de Alimento");
					System.out.println("0. Sair");
					System.out.println("------------------------");
					System.out.println("\nEscolha uma opção: ");
					
					int opcao = scanner.nextInt(); // Váriavel que armazenará o número digitado pelo Usuário
					scanner.nextLine(); // Limpa o buffer
					
					// Inicialização do Switch de escolhas do Usuário
					switch(opcao) {
					case 1: // Caso o Usuário escolha a Opção 1 (Inserir Alimentos)
					
					// Verifica se a conexão foi feita
					if(conexao != null) {
						// Define a instrução sql para inserir os dados na tabela alimentos
						String sql = "INSERT INTO alimentos (nome, custoAlimento, vendaAlimento, validade, lucro) VALUES (?, ?, ?, ?, ?)";
						
						System.out.println("Digite o nome do Alimento: "); // Solicita a inserção do nome
						String nome = scanner.nextLine(); // Armazena o nome
						
						System.out.println("Digite a data de validade do Alimento: "); // Solicita a validade do alimento
						String validade = scanner.nextLine(); // Armazena a validade do alimento
						
						System.out.println("Digite o custo do Alimento: "); // Solicita o custo do alimento
						float custoAlimento = scanner.nextFloat(); // Armazena o nome
						
						System.out.println("Digite o preço de venda do Alimento: "); // Solicita o preço de venda do alimento
						float vendaAlimento = scanner.nextFloat(); // Armazena o preço de venda do alimento
						
						float lucro = vendaAlimento - custoAlimento; // Armazena e calcula o lucro
						
						try { // Realização da inserção dos dados no banco de dados
							
							PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
							stmt.setString(1, nome); // Substitui o primeiro (?) pelo novo nome informado
							stmt.setFloat(2, custoAlimento); // Substitui o segundo (?) pelo custo infomado
							stmt.setFloat(3, vendaAlimento); // Substitui o terceiro (?) pelo preço de venda infomado
							stmt.setString(4, validade); // Substitui o quarto (?) pela validade informada
							stmt.setFloat(5, lucro); // Substitui o quinto (?) pelo lucro

							
							int rowsUpdated = stmt.executeUpdate(); // Executa a instrução
							
							System.out.println("\nDados inseridos com sucesso!"); // Informa que os dados foram inseridos com sucesso
						} catch (SQLException e ) {
							System.err.println("Erro ao inserir dados: " + e.getMessage()); // Informa que houve um erro na inserção de dados
						}						
					} 	break;

					case 2: // Caso o Usuário escolha a Opção 2 (Atualizar Alimentos)
						// Verifica se a conexão foi feita
						if (conexao != null) {
							// Define a instrução sql para editar os dados na tabela alimentos
							String sql = "UPDATE alimentos SET nome = ?, custoAlimento = ?, vendaAlimento = ?, validade = ?, lucro = ? WHERE id = ?";
						
							System.out.println("Digite o ID do Alimento que deseja atualizar: "); // Solicita o ID do alimento que será editado
							int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
							scanner.nextLine();
							
							System.out.println("Digite o novo nome do Alimento: "); // Solicita a inserção do novo nome
							String nome = scanner.nextLine(); // Armazena o novo nome
							
							System.out.println("Digite a nova validade do Alimento: "); // Solicita a nova validade
							String validade = scanner.nextLine(); // Armazena a validade
							
							System.out.println("Digite o novo custo do Alimento: "); // Solicita a inserção do novo custo
							float custoAlimento = scanner.nextFloat(); // Armazena o novo custo
							
							System.out.println("Digite o novo preço de venda do Alimento: "); // Solicita a inserção do novo preço de venda
							float vendaAlimento = scanner.nextFloat(); // Armazena o novo preço de venda
							
							float lucro = vendaAlimento - custoAlimento; // Armazena e calcula o lucro
							
							
							
						try { // Realização da edição dos dados no banco de dados 
							
							PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
							stmt.setString(1, nome); // Substitui o primeiro (?) pelo novo nome informado
							stmt.setFloat(2, custoAlimento); // Substitui o segundo (?) pelo novo custo infomado
							stmt.setFloat(3, vendaAlimento); // Substitui o terceiro (?) pelo novo preço de venda infomado
							stmt.setString(4, validade); // Substitui o quarto (?) pela nova validade infomada
							stmt.setFloat(5, lucro); // Substitui o quinto (?) pelo novo lucro
							stmt.setInt(6, id); // Informa o sexto (?), o ID

							
							int rowsUpdated = stmt.executeUpdate(); // Executa a instrução e informa quantos registros foram afetados
							
							if (rowsUpdated > 0 ) { 
								System.out.println("Registro atualizado com sucesso!"); // Se pelo menos 1 registro for alterado, o sistema informará que a operação ocorreu com sucesso
							} else {
								System.err.println("Nenhum registro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
							}
						} catch (SQLException e) {
								System.out.println("Erro ao atualizar dados: " + e.getMessage()); // Informa o fracasso ao tentar editar algum registro do banco de dados
							} 
						} break;
					
					case 3: // Caso o Usuário escolha a Opção 3 (Deletar Alimentos)
						// Verifica se a conexão foi feita
						if (conexao != null) {
							// Define a instrução sql para deletar os dados na tabela alimentos
							String sql = "DELETE FROM alimentos WHERE id=?";
							System.out.println("Digite o ID do Alimento que deseja deletar: "); // Solicita o ID do aluno que será removido
							int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
							
						try { // Realização da remoção dos dados no banco de dados
							
							PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
							stmt.setInt(1, id); // Substitui o (?) pelo ID informado
							
							int rowsDeleted = stmt.executeUpdate(); // Executa a instrução e informa quantos registros foram afetados
							
							if (rowsDeleted >0) { 
								System.out.println("Registro deletado com sucesso!"); // Se pelo menos 1 registro for deletado, o sistema informará que a operação ocorreu com sucesso
							} else {		
								System.out.println("Nenhum reistro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
							}
						} catch (SQLException e) {
							System.err.println("Erro ao deletar dados: " + e.getMessage()); //Infoma o fracasso ao tentar remover um registro
						} 	
					} break;
						
						
					case 4: // Caso o Usuário escolha a Opção 4 (Ler Registros de Alimentos)
						// Verifica se a conexão foi feita
						if (conexao != null) {
							// Define a instrução sql para ler todos os dados na tabela alimentos
							String sql = "SELECT * FROM alimentos"; 
							
							try { // Tentativa de ler os dados da tabela
								PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
								ResultSet rs = stmt.executeQuery(); // Faz a consulta e armazena os resultados no ResultSet
							
								System.out.println("\nRegistros da tabela 'Alimentos':\n"); // Título da exibição dos dados
								while (rs.next()) { // Loop para percorrer os dados retornados pela consulta
									int id = rs.getInt("id"); // Puxa o ID 
									String nome = rs.getString("nome"); // Puxa o Nome 
									float custoAlimento = rs.getFloat("custoAlimento"); // Puxa o Custo
									float vendaAlimento = rs.getFloat("vendaAlimento"); // Puxa o Preço de Venda
									String validade = rs.getString("validade"); // Puxa a Validade
									float lucro = vendaAlimento - custoAlimento;

									System.out.println("\nID: " +id+ "\nNome: " +nome+ "\nCusto: " +custoAlimento+ "\nPreço de Venda: " +vendaAlimento+ "\nLucro: " +lucro+ "\nValidade: " + validade); // Exibe os dados da consulta
								}
							} catch (SQLException e) { // Ação para tratat exceções no banco de dados
								System.err.println("Erro ao ler dados: " + e.getMessage()); // Caso ocorra um erro na leitura dos dados, o sistema informará
							} 
						
						} break;
						
					case 0: // Caso o Usuário queira sair do sistema (Sair)
						System.out.println("Saindo..."); // Mensagem que informa a saída
						scanner.close();
						return; // Encerra o programa
						
					default:
                       System.out.println("Opção inválida. Tente novamente."); // Informa que a opção digitada não existe e solicita uma nova
					}
				} catch (InputMismatchException e) {
	                // Caso o Usuário insira algum tipo de dado incorreto no lugar dos dígitos designidados
					System.out.println("Entrada inválida. Por favor, digite um número.");
					scanner.nextLine();
					}
			}
			
			case 2: // Caso o Usuário escolha a Opção 2 (Gereciamento de Vestuário)
				
				while(true) {
					try {
						System.out.println("\n------- Vestuários -------"); 
						System.out.println("1. Inserir Vestuário");
						System.out.println("2. Atualizar Vestuário");
						System.out.println("3. Deletar Vestuário");
						System.out.println("4. Ler Registros de Vestuário");
						System.out.println("0. Sair");
						System.out.println("------------------------");
						System.out.println("\nEscolha uma opção: ");
						
						int opcao = scanner.nextInt(); // Váriavel que armazenará o número digitado pelo Usuário
						scanner.nextLine(); // Limpa o buffer
						
						// Inicialização do Switch de escolhas do Usuário
						switch(opcao) {
						case 1: // Caso o Usuário escolha a Opção 1 (Inserir Vestuário)
						
						// Verifica se a conexão foi feita
						if(conexao != null) {
							// Define a instrução sql para inserir os dados na tabela alunos
							String sql = "INSERT INTO vestuarios (nome, tamanho, cor, material, custoVestuario, vendaVestuario, lucro) VALUES (?, ?, ?, ?, ?, ?, ?)";
							
							System.out.println("Digite o nome do Vestuário: "); // Solicita a inserção do nome
							String nome = scanner.nextLine(); // Armazena o nome
							
							System.out.println("Digite o tamanho do Vestuário: "); // Solicita o tamanho do vestuário
							String tamanho = scanner.nextLine(); // Armazena o tamanho
							
							System.out.println("Digite a cor do Vestuário: "); // Solicita a cor do vestuário
							String cor = scanner.nextLine(); // Armazena a cor
							
							System.out.println("Digite o material do Vestuário: "); // Solicita o material do vestuário
							String material = scanner.nextLine(); // Armazena o material
							
							System.out.println("Digite o custo do Vestuário: "); // Solicita o custo do vestuário
							float custoVestuario = scanner.nextFloat(); // Armazena o custo
							
							System.out.println("Digite o preço de venda Vestuário: "); // Solicita o preço de venda do vestuário
							float vendaVestuario = scanner.nextFloat(); // Armazena o preço de venda
							
							float lucro = vendaVestuario - custoVestuario; // Armazena e calcula o lucro
							
							try { // Realização da inserção dos dados no banco de dados
								
								PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
								stmt.setString(1, nome); // Substitui o primeiro (?) pelo novo nome informado
								stmt.setString(2, tamanho); // Substitui o segundo (?) pelo tamanho informada
								stmt.setString(3, cor); // Substitui o terceiro (?) pela cor informada
								stmt.setString(4, material); // Substitui o quarto (?) pelo material informado
								stmt.setFloat(5, custoVestuario); // Substitui o quinto (?) pelo custo infomado
								stmt.setFloat(6, vendaVestuario); // Substitui o sexto (?) pelo preço de venda infomado
								stmt.setFloat(7, lucro); // Substitui o sétimo (?) pelo lucro

								
								int rowsUpdated = stmt.executeUpdate(); // Executa a instrução
								
								System.out.println("\nDados inseridos com sucesso!"); // Informa que os dados foram inseridos com sucesso
							} catch (SQLException e ) {
								System.err.println("Erro ao inserir dados: " + e.getMessage()); // Informa que houve um erro na inserção de dados
							}						
						} 	break;

						case 2: // Caso o Usuário escolha a Opção 2 (Atualizar Vestuário)
							// Verifica se a conexão foi feita
							if (conexao != null) {
								// Define a instrução sql para editar os dados na tabela vestuário
								String sql = "UPDATE vestuarios SET nome = ?, tamanho = ?, cor = ?, material = ?, custoVestuario = ?, vendaVestuario = ?, lucro = ? WHERE id = ?";
							
								System.out.println("Digite o ID do Vestuário que deseja atualizar: "); // Solicita o ID do vestuário que será editado
								int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
								scanner.nextLine();
								
								System.out.println("Digite o novo nome do Vestuário: "); // Solicita a inserção do novo nome
								String nome = scanner.nextLine(); // Armazena o novo nome
								
								System.out.println("Digite o novo tamanho do Vestuário: "); // Solicita o novo tamanho
								String tamanho = scanner.nextLine(); // Armazena o tamanho
								
								System.out.println("Digite a nova cor do Vestuário: "); // Solicita a nova cor
								String cor = scanner.nextLine(); // Armazena a cor
								
								System.out.println("Digite o novo material do Vestuário: "); // Solicita o novo material
								String material = scanner.nextLine(); // Armazena o material
								
								System.out.println("Digite o novo custo do Vestuário: "); // Solicita a inserção do novo custo
								float custoAlimento = scanner.nextFloat(); // Armazena o novo custo
								
								System.out.println("Digite o novo preço de venda do Vestuário: "); // Solicita a inserção do novo preço de venda
								float vendaAlimento = scanner.nextFloat(); // Armazena o novo preço de venda
								
								float lucro = vendaAlimento - custoAlimento; // Armazena e calcula o lucro
								
								
								
							try { // Realização da edição dos dados no banco de dados 
								
								PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
								stmt.setString(1, nome); // Substitui o primeiro (?) pelo novo nome informado
								stmt.setString(2, tamanho); // Substitui o segundo (?) pelo novo tamanho infomada
								stmt.setString(3, cor); // Substitui o terceiro (?) pela nova cor infomada
								stmt.setString(4, material); // Substitui o quarto (?) pelo novo material infomado
								stmt.setFloat(5, custoAlimento); // Substitui o quinto (?) pelo novo custo infomado
								stmt.setFloat(6, vendaAlimento); // Substitui o sexto (?) pelo novo preço de venda infomado
								stmt.setFloat(7, lucro); // Substitui o sétimo (?) pelo novo lucro
								stmt.setInt(8, id); // Informa o oitavo (?), o ID

								int rowsUpdated = stmt.executeUpdate(); // Executa a instrução e informa quantos registros foram afetados
								
								if (rowsUpdated > 0 ) { 
									System.out.println("Registro atualizado com sucesso!"); // Se pelo menos 1 registro for alterado, o sistema informará que a operação ocorreu com sucesso
								} else {
									System.err.println("Nenhum registro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
								}
							} catch (SQLException e) {
									System.out.println("Erro ao atualizar dados: " + e.getMessage()); // Informa o fracasso ao tentar editar algum registro do banco de dados
								} 
							} break;
						
						case 3: // Caso o Usuário escolha a Opção 3 (Deletar Vestuário)
							// Verifica se a conexão foi feita
							if (conexao != null) {
								// Define a instrução sql para deletar os dados na tabela vestuário
								String sql = "DELETE FROM vestuarios WHERE id=?";
								System.out.println("Digite o ID do Vestuário que deseja deletar: "); // Solicita o ID do vestuário que será removido
								int id = scanner.nextInt(); // Armazena o ID informado pelo usuário
								
							try { // Realização da remoção dos dados no banco de dados
								
								PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
								stmt.setInt(1, id); // Substitui o (?) pelo ID informado
								
								int rowsDeleted = stmt.executeUpdate(); // Executa a instrução e informa quantos registros foram afetados
								
								if (rowsDeleted >0) { 
									System.out.println("Registro deletado com sucesso!"); // Se pelo menos 1 registro for deletado, o sistema informará que a operação ocorreu com sucesso
								} else {		
									System.out.println("Nenhum reistro encontrado com o ID especificado"); // Se nenhum registro foi feito, o sistema informará que o ID informado não foi encontrado no banco de dados
								}
							} catch (SQLException e) {
								System.err.println("Erro ao deletar dados: " + e.getMessage()); //Infoma o fracasso ao tentar remover um registro
							} 	
						} break;
							
							
						case 4: // Caso o Usuário escolha a Opção 4 (Ler Registros de Vestuários)
							// Verifica se a conexão foi feita
							if (conexao != null) {
								// Define a instrução sql para ler todos os dados na tabela vestuários
								String sql = "SELECT * FROM vestuarios"; 
								
								try { // Tentativa de ler os dados da tabela
									PreparedStatement stmt = conexao.prepareStatement(sql); // Cria um objeto PreparedStatement para executar a instrução
									ResultSet rs = stmt.executeQuery(); // Faz a consulta e armazena os resultados no ResultSet
								
									System.out.println("\nRegistros da tabela 'Vestuário':\n"); // Título da exibição dos dados
									while (rs.next()) { // Loop para percorrer os dados retornados pela consulta
										int id = rs.getInt("id"); // Puxa o ID 
										String nome = rs.getString("nome"); // Puxa o Nome 
										String tamanho = rs.getString("tamanho"); // Puxa o Tamanho
										String cor = rs.getString("cor"); // Puxa a Cor
										String material = rs.getString("material"); // Puxa o Material
										float custoVestuario = rs.getFloat("custoVestuario"); // Puxa o Custo
										float vendaVestuario = rs.getFloat("vendaVestuario"); // Puxa o Preço de Venda
										float lucro = vendaVestuario - custoVestuario; // Armazena e calcula o lucro

										System.out.println("\nID: " +id+ "\nNome: " +nome+ "\nTamanho: " +tamanho+ "\nCor: " +cor+ "\nMaterial: " +material+ "\nCusto: " +custoVestuario+ "\nPreço de Venda: " +vendaVestuario+ "\nLucro: " +lucro); // Exibe os dados da consulta
									}
								} catch (SQLException e) { // Ação para tratat exceções no banco de dados
									System.err.println("Erro ao ler dados: " + e.getMessage()); // Caso ocorra um erro na leitura dos dados, o sistema informará
								} 
							
							} break;
							
						case 0: // Caso o Usuário queira sair do sistema (Sair)
							System.out.println("Saindo..."); // Mensagem que informa a saída
							scanner.close();
							return; // Encerra o programa
							
						default:
	                       System.out.println("Opção inválida. Tente novamente."); // Informa que a opção digitada não existe e solicita uma nova
						}
					} catch (InputMismatchException e) {
		                // Caso o Usuário insira algum tipo de dado incorreto no lugar dos dígitos designidados
						System.out.println("Entrada inválida. Por favor, digite um número.");
						scanner.nextLine();
						}
				}
				
				
				default:
                    System.out.println("Opção inválida. Tente novamente."); // Informa que a opção digitada não existe e solicita uma nova
					}
				} catch (InputMismatchException e) {
	                // Caso o Usuário insira algum tipo de dado incorreto no lugar dos dígitos designidados
					System.out.println("Entrada inválida. Por favor, digite um número.");
					scanner.nextLine();
					}
				
				
				}
			}	
		}
		
