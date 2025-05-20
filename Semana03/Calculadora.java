package Semana03;

import java.util.Scanner;

public class Calculadora {
    static Scanner scanner = new Scanner(System.in);

    static void Calcular(String operation) {
        //double result = 0;
        System.out.print("Digite o primeiro número: ");
        double firstNumber = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o segundo número: ");
        double secondNumber = scanner.nextDouble();
        scanner.nextLine();

        switch (operation) {
            case "adição":
            case "+":
                double adicaoResultado = firstNumber + secondNumber;
                //resultado = firstNumber + secondNumber;
                System.out.println("Resultado: " + firstNumber + " + " + secondNumber + " = " + adicaoResultado);
                break;
            case "subtração":
            case "-":
                double subtracaoResultado = firstNumber - secondNumber;
                System.out.println("Resultado: " + firstNumber + " - " + secondNumber + " = " + subtracaoResultado);
                break;
            case "multiplicação":
            case "*":
                double multiplicacaoResultado = firstNumber * secondNumber;
                System.out.println("Resultado: " + firstNumber + " * " + secondNumber + " = " + multiplicacaoResultado);
                break;
            case "divisão":
            case "/":
                if (secondNumber == 0) {
                    System.out.println("Erro: Divisão por zero não é permitida. Encerrando...");
                    //System.exit(0);
                } else {
                    double divisaoResultado = firstNumber / secondNumber;
                    System.out.println("Resultado: " + firstNumber + " / " + secondNumber + " = " + divisaoResultado);
                }
                break;
            default:
                break;
        }
        //System.out.println("Resultado: " + firstNumber + " " + operation + " " + secondNumber + " = " + resultado);
    }

    public static void main(String[] args) {
        //String[] allowedOperation = {"+", "-", "*", "/"};
        //String[] allowedOperationDesc = {"adicao", "subtracao", "multiplicacao", "divisao"};

        while (true) {
            System.out.println("\n== CALCULADORA BÁSICA ==");
            System.out.print("""
                    Digite uma operação!
                    adição          +
                    subtração       -
                    multiplicação   *
                    divisão         /
                    >>>\s""");
            String operation = scanner.nextLine().trim().toLowerCase();

            //Comando para tirar acentuação
            //(!Arrays.asList(allowedOperations).contains(operation)) || 
            //(!Arrays.asList(allowedOperationsDesc).contains(operation))

            if ((operation.equals("adição") || operation.equals("+") ||
                    operation.equals("subtração") || operation.equals("-") ||
                    operation.equals("multiplicação") || operation.equals("*") ||
                    operation.equals("divisão") || operation.equals("/"))) {

                Calcular(operation);

            } else {
                System.out.println("Operação inválida, reinicie o programa");
                //System.exit(0);
            }

            System.out.print("Deseja fazer outra operação? (sim/não) ");
            String resposta = scanner.nextLine().trim();

            if (!(resposta.equalsIgnoreCase("sim"))) {
                System.out.println("O programa será encerrado, obrigada por sua participação!");
                break;
            }
        }
            
        scanner.close();
    }

}