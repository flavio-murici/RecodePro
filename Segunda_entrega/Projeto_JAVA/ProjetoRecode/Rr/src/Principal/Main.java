package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import PrincipalDAO.DestinoDAO;
import PrincipalDAO.PacotesDAO;
import PrincipalDAO.UsuarioDAO;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//PacotesDAO pacotesDAO = new PacotesDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PacotesDAO pacotesDAO = new PacotesDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		//ReservaDAO reservaDAO = new ReservaDAO();

		while (true) {
			System.out.println("******* Menu *******");
			System.out.println("1. Cadastrar Usuário");
			System.out.println("2. Atualizar Usuário");
			System.out.println("3. Excluir Usuário");
			System.out.println("4. Cadastrar Destino");
			System.out.println("5. Atualizar Destino");
			System.out.println("6. Excluir Destino");
			System.out.println("7. Cadastrar Pacote");
			System.out.println("8. Atualizar Pacote");
			System.out.println("9. Excluir Pacote");
			System.out.println("10. Consultar");
			System.out.println("11. Sair");
			System.out.println(" **Digite uma opção*** ");

			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:

				// CADASTRAR USUÁRIO.
				Usuario Usuario = new Usuario();
				System.out.print("Nome do Usuário: ");
				Usuario.setNome_usuario(scanner.nextLine());

				scanner.nextLine();
				System.out.println(" Digite seu CPF: ");
				Usuario.setCpf_usuario(scanner.nextLine());

				System.out.println("Digite seu email:");
				Usuario.setEmail(scanner.nextLine());
				scanner.nextLine();

				System.out.println("Digite seu telefone:");
				Usuario.setTelefone(scanner.nextLine());
				scanner.nextLine();


				System.out.println("cadastro realizado com sucesso");
				break;

			case 2:// ATUALIZAR USUÁRIO.
				System.out.println(("INFORME ID DO USUÁRIO A SER ATUALIZADO"));
				scanner.next();
				int atualizarUsuario = scanner.nextInt();
				Usuario usuarioAtualizar = usuarioDAO.buscarUsuario(atualizarUsuario);
				if (usuarioAtualizar != null) {
					System.out.println("NOVO NOME DO USUÁRIO: ");
					scanner.nextLine();
					usuarioAtualizar.setNome_usuario(scanner.nextLine());
					System.out.println("NOVO CPF DO USUÁRIO: ");
					scanner.nextLine();
					usuarioAtualizar.setCpf_usuario(scanner.nextLine());
					System.out.println("NOVO EMAIL DO USUÁRIO: ");
					scanner.nextLine();
					usuarioAtualizar.setEmail(scanner.next());
					System.out.println("NOVO TELEFONE DO USUÁRIO: ");
					scanner.nextLine();
					usuarioAtualizar.setTelefone(scanner.nextLine());
				} else {
					System.out.println("Usuário não encontrado. ");

				}
				break;

			case 3:// EXCLUIR USUÁRIO.
				System.out.println("INFORME ID DO USUÁRIO PARA EXCLUSÃO : ");
				int usuarioIdExcluir = scanner.nextInt();
				Usuario usuarioExcluir = usuarioDAO.buscarUsuario(usuarioIdExcluir);
				if (usuarioExcluir != null) {
					System.out.println("USUÁRIO EXCLUÍDO COM SUCESSO.");
				} else {
					System.out.println("USUÁRIO NÃO ENCONTRADO.");
				}
				break;
			case 4:// CADASTRAR DESTINO.
				Destino destino = new Destino();
				System.out.println("NOME DO DESTINO: ");
				Destino.setNome_destino(scanner.nextLine());

				scanner.nextLine();
				System.out.println(" DIGITE O VALOR DO DESTINO: ");
				Destino.setValor_destino(scanner.nextLine());
				
			case 5:// CONSULTAR DESTINO.
				scanner.nextLine();
					destino.setConsulta_destino(consulta_destino);
					System.out.println("Informe o id do destino a ser consultado");
					String consulta_destino = scanner.next();
					if (consulta_destino != null) {
						System.out.println("Usuário não encontrado.");
				break;
			case 6:	// excluir destino
				System.out.println("Informe Id do destino para exclusão : ");
				int excluir_destino = scanner.nextInt();
				Destino excluir_destino = DestinoDAO.buscarDestino(excluir_destino);
				if (excluir_destino != null) {
					System.out.println("Destino excluído com sucesso.");
				} else {
					System.out.println("Destino não encontrado.");
				}
				break;
				
			case 7:// atualizar pacotes
				System.out.println("ID da pacote para atualizar: ");
				int promocoesId1 = scanner.nextInt();
				Promocoes promocoesAtualizar = promocoesDAO.buscarPromocoes(promocoesId1);
				if (promocoesAtualizar != null) {
					System.out.println("Nova data para promoções (dd/mm/yyyy):");
					String novaDataString = scanner.next();

					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd//mm/yyy");
						Date novaDataConsulta = sdf.parse(novaDataString);
						promocoesAtualizar.setDiaDaCompra(novaDataString);
						promocoesDAO.atualizarPromocoes(promocoesAtualizar);
						System.out.println("Promoção aplicada com Sucesso!!");
					} catch (ParseException e) {
						System.out.println("Formato invalido: Use dd/mm/yyyy");
					}
				} else {
					System.out.println("Promoção com data EXPIRADA!!");
				}

			case 6:
				// excluir promoção
				System.out.println("ID da promocão para exclusão");
				int excluirIdPromocoes = scanner.nextInt();
				Promocoes excluirPromocoes = promocoesDAO.excluirPromocoes(excluirIdPromocoes);
				if (excluirPromocoes != null) {
					promocoesDAO.excluirPromocoes(excluirIdPromocoes);
					System.out.println("Promoção excluida com sucesso");
				} else {
					System.out.println("Promocão não encontrada.");
				}

				break;

			case 7:// Cadastrar pacotes
				Pacotes pacotes = new Pacotes();
				System.out.println("Id do pacote");
				int usuarioId = scanner.nextInt();
				Usuario usuarioPacotes = usuarioDAO.buscarUsuario(usuarioId);
				if ( usuarioPacotes != null) {
					pacotes.setId_usuario(usuarioId);
					System.out.println("ID do Usuário:");
					int pacotesId = scanner.nextInt();
					
				
				}
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			case 14:
				// Sair
				System.out.println("Saindo do sistema...");
				// reservaDAO.fecharConexao();
				// promocoesDAO.fecharConexao();
				usuarioDAO.fecharConexao();
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
			}
		}
	}


