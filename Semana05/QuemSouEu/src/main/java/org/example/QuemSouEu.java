package org.example;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.Random;

public class QuemSouEu {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    static Menu menu = new Menu();
    static Jogo jogo = new Jogo();
    static String input;
    static int sorteio;

    public static void main(String[] args) throws Exception {
        jogo.JSON();
        IniciarSistema();
        scanner.close();
    }

    static void IniciarSistema () throws Exception {
        do {
            sorteio = jogo.Sortear();
            menu.MenuString();
            VerificarSistemaInput();
        } while (!(input.equals("sim") || input.equals("1")) || (jogo.elementosArray.size() == jogo.elementosTamanho));
    }

    static void VerificarSistemaInput() throws Exception {
        input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        if (SwitchSistema(input) == 1) {
            menu.OperacaoEnter();
            input = "";
        } else if (SwitchSistema(input) == 2) {
            input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            if (!(input.equals("nao") || input.equals("2") || input.equals("sim") || input.equals("1"))) {
                menu.OperacaoInvalida();
            }
        } else {
            jogo.IniciarJogo();
            input = "";
        }

    }

    static int SwitchSistema(String input) throws Exception {
        switch (input) {
            case "1", "jogar" -> {
                return 0;
            }
            case "2", "ajuda" -> {
                menu.Ajuda();
                return 1;
            }
            case "3", "leaderboard" -> {
                menu.Leaderboard();
                return 1;
            }
            case "4", "sair" -> {
                menu.Sair();
                return 2;
            }
            default -> {
                menu.OperacaoInvalida();
                return 0;
            }
        }
    }
}
