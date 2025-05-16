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

            System.out.println("Você tem 10 tentativas para acertar");
            System.out.println("Para acessar o histórico, digite H");
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
        System.out.println("""
                   _____                  _   _   __                          \s
                  / ____|                | \\ | | /_/                          \s
                 | |     __ _  ___ __ _  |  \\| |_   _ _ __ ___   ___ _ __ ___ \s
                 | |    / _` |/ __/ _` | | . ` | | | | '_ ` _ \\ / _ \\ '__/ _ \\\s
                 | |___| (_| | (_| (_| | | |\\  | |_| | | | | | |  __/ | | (_) |
                  \\_____\\__,_|\\___\\__,_| |_| \\_|\\__,_|_| |_| |_|\\___|_|  \\___/\s
                               )_)                                            \s
                                                                              \s
        """);
        while (true) {
            Chutes();
            System.out.println("Deseja continuar a jogar?");
            System.out.println("[1] Sim");
            System.out.println("[2] Não");
            int continuar = scanner.nextInt();
            scanner.nextLine();
            if (continuar == 1) {
                continue;
            } else {
                System.out.println("Obrigada por jogar! :> ");
                System.out.println("Pontuação: " + Pontos);
                System.out.println("Rodadas jogadas: " + Rodadas);
                break;
            }
        }
    }

    static void Chutes() {
        int numSecretoInt = numeroSecreto();
        String numSecreto = Integer.toString(numSecretoInt);
        while (true) {
            System.out.println("Digite seu chute: ");
            String chute = scanner.nextLine();

            if (chutesLista.size() <= 8) {
                if (numSecreto.equals(chute)) {
                    System.out.println("Parabéns você acertou! O número era " + numSecreto);
                    Pontos += 1;
                    Rodadas += 1;
                    System.out.println("Pontos: " + Pontos);
                    break;
                } else if (chute.equalsIgnoreCase("H")) {
                    System.out.println(chutesLista);
                } else {
                    chutesLista.add(chute);
                    System.out.println("Tentativa restantes: " + (10 - chutesLista.size()));
                    System.out.println("Seu chute: " + chute);
                    MaiorMenor(numSecretoInt, chute);
                }
            } else {
                System.out.println("Suas tentativas acabaram, o número era: " + numSecreto);
                System.out.println("Pontos: " + Pontos);
                Rodadas += 1;
                break;
            }
        }
    }

    static void MaiorMenor(int numSecretoInt, String chute) {
        int chutesInt = Integer.parseInt(chute);
        if (numSecretoInt > chutesInt) {
            System.out.println("O número secreto é maior!");
        } else if (numSecretoInt < chutesInt) {
            System.out.println("O número secreto é menor!");
        }
    }

    public static void main(String[] args) {
        Jogo();
    }
}
