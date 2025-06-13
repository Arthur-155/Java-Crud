import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Crud {
    public static void main(String[] args) throws IOException {
        int opcoes;
        Scanner leitor = new Scanner(System.in);
        Carro carro = new Carro();
        Moto moto = new Moto();
        ArrayList<Veiculo>Veiculos = new ArrayList<>();
        FileWriter arquivo = new FileWriter("veiculos.txt",true);
        try{
            do{
                System.out.println("1-Cadastrar Veiculo\n2-Listar todos os veículos cadastrados\n" +
                        "3-Atualizar os dados de um veículo (marca e modelo)\n4-Remover um veículo do sistema pela placa\n" +
                        "5-Realizar manutenção em um veículo selecionado\n6-Sair do sistema");
                System.out.print("Selecione uma das opções: ");
                opcoes = leitor.nextInt();
                leitor.nextLine();
                switch (opcoes){
                    case 1:
                        System.out.println(" -- Qual tipo de veículo deseja cadastrar: -- ");
                        System.out.println("\n1-Carro\n2-Moto");
                        System.out.print("Escolha uma das opcoes: ");
                        opcoes = leitor.nextInt();
                        leitor.nextLine();
                        if(opcoes == 1){
                            System.out.println("Digite a placa do carro: ");
                            carro.placa = leitor.nextLine();
                            System.out.println("Digite a marca do carro: ");
                            carro.marca = leitor.nextLine();
                            System.out.println("Digite o modelo do carro: ");
                            carro.modelo = leitor.nextLine();
                            Veiculos.add(carro);
                            arquivo.write("\nCarro;" + carro.placa+";"+ carro.marca+";"+ carro.modelo);
                        } else if (opcoes ==2) {
                            System.out.println("Digite a placa da moto: ");
                            moto.placa = leitor.nextLine();
                            System.out.println("Digite a marca da moto: ");
                            moto.marca = leitor.nextLine();
                            System.out.println("Digite o modelo da moto: ");
                            moto.modelo = leitor.nextLine();
                            Veiculos.add(moto);
                            arquivo.write("\nMoto;"+ moto.placa+ ";" + moto.marca+";"+ moto.modelo);
                        }
                        break;
                    case 2:
                        System.out.println(" -- VEÍCULOS CADASTRADOS -- ");
                        for(Veiculo mostrarVeiculos : Veiculos){
                            mostrarVeiculos.exibirDados();
                        }
                        break;
                    case 3:
                        System.out.println("Deseja atualizar infomações de algum veículo ?\n" +
                                "Digite a posição do veículo que deseja alterar: ");
                        int posicao = leitor.nextInt();
                        leitor.nextLine();
                        if(posicao >=0 && posicao<Veiculos.size()){
                            Veiculo veiculoSelecionado = Veiculos.get(posicao);

                            System.out.println("Digite a nova marca: ");
                            String novaMarca = leitor.nextLine();
                            System.out.println("Digite o novo modelo: ");
                            String novoModelo = leitor.nextLine();
                            veiculoSelecionado.marca = novaMarca;
                            veiculoSelecionado.modelo = novoModelo;
                        }else{
                            System.out.println("Posição digitada não existe no array!");
                        }
                        break;
                    case 4:
                        System.out.print("Digite a posição do elemento que deseja remover: ");
                        int posicaoParaExcluir = leitor.nextInt();
                        leitor.nextLine();
                        if(posicaoParaExcluir >= 0 && posicaoParaExcluir < Veiculos.size()){
                            Veiculo veiculoSelecionadoExcluir = Veiculos.remove(posicaoParaExcluir);
                            System.out.println("\nElemento excluído com sucesso!");
                        }else{
                            System.out.println("Index inserido não existe no Array");
                        }
                        break;
                    case 5:
                        System.out.println("Deseja realizar manutenção de algum veículo ?");
                        System.out.print("Digite a posição do veículo que deseja realizar a manutencão: ");
                        int posicaoManutencao = leitor.nextInt();
                        leitor.nextLine();
                        if(posicaoManutencao >= 0 && posicaoManutencao<Veiculos.size()){
                            Veiculo veiculoSelecionado = Veiculos.get(posicaoManutencao);
                            System.out.println("Manutenção realizada com sucesso no veículo: ");
                            veiculoSelecionado.exibirDados();
                        }else{
                            System.out.println("Index inserido não existe no Array");
                        }
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                }
            }while (opcoes !=6);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            arquivo.close();
        }
      }
    }

