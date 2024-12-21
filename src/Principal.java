import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean fim = false;
        String moeda;
        String base_code;
        String moedaAConverter;
        String target_code;
        Double conversion_rate;
        Double conversion_result;
        Double taxa;
        moeda = "";
        moedaAConverter = "";
        Double valorConvertido;
        valorConvertido = 0.0;
        conversion_rate = 0.000000;
        conversion_result = 0.0000;

        while (fim == false) {
            System.out.println("***********************************");
            System.out.println(" ");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moeda ");
            System.out.println(" ");

            System.out.println("1) Dolar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dolar");
            System.out.println("3) Dolar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dolar");
            System.out.println("5) Dolar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dolar");
            System.out.println("7) Sair");
            System.out.println(" ");
            System.out.println("Escolha uma opção válida:");
            System.out.println("***********************************");

            Scanner leitura = new Scanner(System.in);
            int opcaoMoeda = leitura.nextInt();

            if (opcaoMoeda != 1 &&
                    opcaoMoeda != 2 &&
                    opcaoMoeda != 3 &&
                    opcaoMoeda != 4 &&
                    opcaoMoeda != 5 &&
                    opcaoMoeda != 6 &&
                    opcaoMoeda != 7) {
                System.out.println("Opção inválida!");

            } else {


                if (opcaoMoeda == 1) {
                    moeda = "USD";
                    moedaAConverter = "ARS";
                } else {
                    if (opcaoMoeda == 2) {
                        moeda = "ARS";
                        moedaAConverter = "USD";
                    } else {
                        if (opcaoMoeda == 3) {
                            moeda = "USD";
                            moedaAConverter = "BRL";
                        } else {
                            if (opcaoMoeda == 4) {
                                moeda = "BRL";
                                moedaAConverter = "USD";
                            } else {
                                if (opcaoMoeda == 5) {
                                    moeda = "USD";
                                    moedaAConverter = "COP";
                                } else {
                                    if (opcaoMoeda == 6) {
                                        moeda = "COP";
                                        moedaAConverter = "USD";
                                    } else {
                                        if (opcaoMoeda == 7) {
                                            fim = true;
                                        } else {
                                            System.out.println("Opção inválida!");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


                if (fim == false) {
                    System.out.println("Digite o valor que deseja converter: ");
                    double valor = leitura.nextDouble();
                    base_code = moeda;
                    target_code = moedaAConverter;


                   ConverteValor converteValor = new ConverteValor();
                   Conversor conversor = converteValor.buscaConversao(base_code,
                            target_code, conversion_rate, valor,
                   conversion_result);

                    System.out.println("Valor " + valor + "[" + moeda + "]" +
                            " corresponde ao valor final de =>>> " + conversor.conversion_result() +
                            "[" + moedaAConverter + "]");

                }


            }
        }
    }
}

