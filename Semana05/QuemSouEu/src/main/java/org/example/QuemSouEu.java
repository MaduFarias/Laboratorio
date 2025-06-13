package org.example;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuemSouEu {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static Menu menu = new Menu();
    static String input;

    public static void main(String[] args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("src/main/Dicas.json")));
        JSONArray elementos = new JSONArray(json);
        //Jogo(elementos);
        IniciarMenu();
    }

    static void IniciarMenu () {
        do {
            menu.Menu();
            input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            if (SwitchMenu(input) == 1) {
                input = scanner.nextLine();
                menu.OperacaoEnter(input);
            } else if (SwitchMenu(input) == 2) {
                input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                if (!(input.equals("não") || input.equals("2") || input.equals("sim") || input.equals("1"))) {
                    menu.OperacaoInvalida(input);
                }
            }
        } while (!(input.equals("sim") || input.equals("1")));
    }

    static int SwitchMenu(String opcao) {
        switch (opcao) {
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
                menu.OperacaoInvalida(input);
                return 0;
            }
        }
    }


    static void Jogo(JSONArray elementos) throws Exception {
        Jogo jogo = new Jogo();
        jogo.IniciarJogo();
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
