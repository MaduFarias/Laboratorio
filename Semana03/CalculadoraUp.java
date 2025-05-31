package Semana03;

import java.util.Scanner;
import java.util.Arrays;
import java.text.Normalizer;

public class CalculadoraUp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] allowedOperations = {"+", "-", "*", "/", "adicao", "subtracao", "multiplicacao", "divisao"};
        String resposta;

        do {
            System.out.println("\n== CALCULADORA BÁSICA ==");
            System.out.print("""
                    Digite uma operação!
                    adição          +
                    subtração       -
                    multiplicação   *
                    divisão         /
                    >>>\s""");

            String operation = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

            if (Arrays.asList(allowedOperations).contains(operation)) {
                System.out.print("Digite o primeiro número: ");
                double firstNumber = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Digite o segundo número: ");
                double secondNumber = scanner.nextDouble();
                scanner.nextLine();

                Calcular(operation, firstNumber, secondNumber);

            } else {
                System.out.println("Operação inválida, o programa será reiniciado");
                return;
            }

            System.out.print("Deseja fazer outra operação? (sim/não) ");
            resposta = scanner.nextLine().trim().toLowerCase();


        } while (resposta.equals("sim") || resposta.equals("s"));

        System.out.println("O programa será encerrado, obrigada por sua participação!");
        scanner.close();
    }

    static void Calcular(String operation, double firstNumber, double secondNumber) {
        double result = 0;

        switch (operation) {
            case "adicao":
            case "+":
                result = firstNumber + secondNumber;
                operation = "+";
                break;
            case "subtracao":
            case "-":
                result = firstNumber - secondNumber;
                operation = "-";
                break;
            case "multiplicacao":
            case "*":
                result = firstNumber * secondNumber;
                operation = "*";
                break;
            case "divisao":
            case "/":
                if (secondNumber == 0) {
                    System.out.println("Erro: Divisão por zero não é permitida. Encerrando...");
                    System.exit(0);
                } else {
                    result = firstNumber / secondNumber;
                    operation = "/";
                }
                break;
            default:
                break;
        }
        System.out.println("Resultado: " + firstNumber + " " + operation + " " + secondNumber + " = " + result);
    }
}