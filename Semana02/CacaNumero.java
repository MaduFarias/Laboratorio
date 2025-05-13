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
        switch (Dificuldade()) {
            case 1:
                int numeroFacil = random.nextInt((50) + 1);
                return numeroFacil;
            case 2:
                int numeroMedio = random.nextInt((100) + 1);
                return numeroMedio;
            case 3:
                int numeroDificil = random.nextInt((500) + 1);
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
        int numSecretoInt = numeroSecreto();
        String numSecreto = Integer.toString(numSecretoInt);
        while (true) {
            System.out.println("Digite seu chute: ");
            String chute = scanner.nextLine();

            if (chutesLista.size() <= 8) {
                if (numSecreto.equals(chute)) {
                    System.out.println("Parabéns você acertou! O número era " + numSecreto);
                    System.out.println("Pontos: " + Pontos);
                    break;
                } else if (chute.equalsIgnoreCase("H")) {
                    System.out.println(chutesLista);
                } else {
                    chutesLista.add(chute);
                    System.out.println("Que pena, você errou! Você tem mais " + (10 - chutesLista.size()) + " tentativas.");
                    //MaiorMenor(numSecretoInt, chute);
                }
            } else {
                System.out.println("Suas tentativas acabaram, o número era: " + numSecreto);
                System.out.println("Pontos: " + Pontos);
                break;
            }
        }
    }

//    static void MaiorMenor(int numSecretoInt, String chute) {
//        int chutesInt = Integer.parseInt(chute);
//
//        }
//    }


    public static void main(String[] args) {
        Jogo();
    }
}
