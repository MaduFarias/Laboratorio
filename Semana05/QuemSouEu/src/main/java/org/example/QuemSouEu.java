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


    public static void main(String[] args) throws Exception {
        IniciarMenu();
    }

    static void IniciarMenu () throws Exception {
        do {
            menu.Menu();
            VerificarMenuInput();
        } while (!(input.equals("sim") || input.equals("1")));
    }

    static void VerificarMenuInput() throws Exception {
        input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        if (SwitchMenu(input) == 1) {
            menu.OperacaoEnter();
        } else if (SwitchMenu(input) == 2) {
            input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            if (!(input.equals("nao") || input.equals("2") || input.equals("sim") || input.equals("1"))) {
                menu.OperacaoInvalida();
            }
        } else {
            jogo.IniciarJogo();
            input = "";
        }
    }

    static int SwitchMenu(String input) throws Exception {
        switch (input) {
            case "1", "jogar" -> {
                return 0;
            }
            case "2", "ajuda" -> {
                menu.Ajuda();
                return 1;
            }
            case "3", "leaderboard" -> {
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




    /*static void Json(JSONArray elementos) {
        int elementosTamanho = elementos.length();
        JSONObject objeto = elementos.getJSONObject(0);
        String categoria = elementos.getJSONObject(0).getString("categoria");
        JSONArray dicasTodas = elementos.getJSONObject(0).getJSONArray("dicas");
        String dicax = elementos.getJSONObject(0).getJSONArray("dicas").getString(0);
    }

    StartGame() {
        do {
            indexCategoria = jogo.Sorteio();
            menu.categoria = elementos.getJSONObject(indexCategoria).getString("categoria");
            menu.Categoria();
            input = scanner.nextLine();
            if (OperacaoEnter(input)) {
                continue;
            }
            for (int = i, i < 11, i++) {
                menu.i = i
                menu.dica = elementos.getJSONObject(indexCategoria).getJSONArray("dicas").getString(i);
                jogo.resposta = elementos.getJSONObject(indexCategoria).getString("resposta");
                menu.Dicas();
                input = scanner.nextLine();
                if ((input != resposta) {
                    menu.Incorreto();
                    input = scanner.nextLine();
                    if (OperacaoEnter(input)) {
                        continue;
                    }
                } else {
                    menu.Correto();
                }
            }
        }
    }
     */
}
