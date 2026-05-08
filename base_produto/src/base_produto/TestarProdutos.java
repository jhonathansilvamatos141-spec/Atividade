package base_produto;

import java.util.Scanner;


public class TestarProdutos {
public static void main(String[] args) {
			produtosDAO prod = new produtosDAO();
			int opcao = 0, resp = 1, quantidade, cod_unidade, unidade, idProd;
			double preco_unitario;
			String nome_produto,cigla;
			
			Scanner sc = new Scanner(System.in);
			Scanner LerString = new Scanner(System.in);
			
			while(resp == 1) {
				System.out.println("INDIQUE A OPERAÇÃO DESEJADA");
				System.out.println("1 - INSERIR PRODUTO");
				System.out.println("2 - LISTAR PRODUTOS");
				System.out.println("3 - ATUALIZAR");
				System.out.println("4 - DELETAR ");
				System.out.println("5 - INSERIR UNIDADES");
				System.out.println("6 - LISTAR UNIDADES");
				opcao = sc.nextInt();
				
				switch(opcao) {
				case 1:
					System.out.println("nome do produto: ");
					nome_produto = LerString.nextLine();
					System.out.println("Quantidade: ");
					quantidade = sc.nextInt();
					System.out.println("Código da unidade: ");
					cod_unidade = sc.nextInt();
					System.out.println("Preço unitário");
					preco_unitario = sc.nextDouble();
					
					prod.inserirProd(nome_produto, quantidade, cod_unidade, preco_unitario);
					break;
				case 2: 
					System.out.println("Lista de Produtos: ");
					for(String gg : prod.listarProd()) {
						System.out.println(gg);
					}
					break;
				case 3:
					System.out.println("Digite o id do produto que deseja atualizar: ");
					idProd = sc.nextInt();
					System.out.println("Novo nome do produto: ");
					nome_produto = sc.nextLine();
					System.out.println("Nova Quantidade: ");
					quantidade = sc.nextInt();
					System.out.println("Novo Código da unidade: ");
					cod_unidade = sc.nextInt();
					System.out.println("Novo preço unitário");
					preco_unitario = sc.nextDouble();
				prod.atualizarProd(idProd, nome_produto, quantidade, cod_unidade, preco_unitario);
					break;
				case 4:
					System.out.println("Digite o id do Produto que deseja deletar: ");
					idProd = sc.nextInt();
					prod.deletarProd(idProd); 
					break;
				case 5: 
					System.out.println("Cigla do produto(MÁXIMO 5): ");
					cigla = sc.nextLine();
					System.out.println("Unidade: ");
					unidade = sc.nextInt();
				
					prod.inserirUNI(cigla, unidade);
					break;
				case 6: 
					System.out.println("Lista de Produtos: ");
					for(String gg : prod.listarUni()) {
						System.out.println(gg);
					}
					break;
					default:
						System.out.println("opção inválida!");
				}
				System.out.println("\nContinuar? 1 = sim / 2 = não");
				resp = sc.nextInt();
			}
		/*	prod.inserirUNI("games", 5);
			prod.inserirProd("borracha", 6,9, 5.00);
			for(String gg : prod.listarProd()) {
				System.out.println(gg);
			}
			for(String gg : prod.listarUni()) {
				System.out.println(gg);
			}
			prod.atualizarProd(8, "CANETA",5 , 6, 90.00);
			prod.atualizarUni(2, "skol", 7);
			prod.deletarProd(4);
			prod.deletarUni(1);
		}
		*/
		}

	}


