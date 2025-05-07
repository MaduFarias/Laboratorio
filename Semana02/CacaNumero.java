package Semana02;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class CacaNumero {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random ();
    static ArrayList<String> chutesLista = new ArrayList<String>();
    static int Pontos = 0;
    static int Rodadas = 0;

    static Integer Dificuldade() {
        while (true) {
            System.out.println("""
                    Dificuldade:
                    
                    [1] Fácil (número de 1 a 50)
                    [2] Médio (número de 1 a 100)
                    [3] Difícil (número de 1 a 500)
                    """);

            System.out.println("Informe o número da dificuldade: ");
            int dificuldade = scanner.nextInt();
            scanner.nextLine();

            if (dificuldade < 1 || dificuldade > 3) {
                System.out.println("Dificuldade inexistente, digite um número válido");
            } else {
                return dificuldade;
            }
        }

    }

    static Integer numeroSecreto() {
        int dificuldadeFacil = 50;
        int dificuldadeMedio = 100;
        int dificuldadeDificil = 500;

        switch (Dificuldade()) {
            case 1:
                int numeroFacil = random.nextInt((dificuldadeFacil) + 1);
                return numeroFacil;
            case 2:
                int numeroMedio = random.nextInt((dificuldadeMedio) + 1);
                return numeroMedio;
            case 3:
                int numeroDificil = random.nextInt((dificuldadeDificil) + 1);
                return numeroDificil;
            default:
                System.out.println("Erro na operação, tente um número válido");
                return Dificuldade();
        }
    }

    static void Jogo() {
        System.out.println("Você tem 10 tentativas para acertar. Boa sorte!");
        System.out.println("Para acessar o histórico, digite H");
        Chutes();

    }

    static void Chutes(){
        String numSecreto = Integer.toString(numeroSecreto());
        while (true) {
            System.out.println("Digite seu chute: ");
            String chute = scanner.nextLine();

            if (chutesLista.size() <= 10) {
                if (numSecreto.equals(chute)) {
                    System.out.print("Parabéns você acertou! O número era " + numSecreto);
                    break;
                } else if (chute.equalsIgnoreCase("H")) {
                    System.out.println(chutesLista);
                } else {
                    chutesLista.add(chute);
                    System.out.println("Que pena, você errou! Você tem mais " + (10 - chutesLista.size()) + " tentativas.");
                }
            } else {
                System.out.println("Suas tentativas acabaram, o número era: " + numSecreto);
                break;
            }
        }
    }


    public static void main(String[] args) {
        Jogo();
    }
}
