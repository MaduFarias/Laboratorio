package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import org.json.JSONArray;
import java.time.Instant;

import static org.example.QuemSouEu.scanner;
import static org.example.QuemSouEu.random;

public class Jogo {
    String dica, resposta, input;
    int elementosTamanho, indexSorteio, indexCategoria, i;
    ArrayList<Integer> elementosArray = new ArrayList<>(11);

    JSONArray elementos;

    Menu menu = new Menu();
    Pontos pontuacao = new Pontos();

    void JSON () throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("src/main/Dicas.json")));
        elementos = new JSONArray(json);
    }

    int Sortear() {
        elementosTamanho = elementos.length();
        if ((!elementosArray.isEmpty()) && elementosArray.size() <= 11) {
            do {
                indexSorteio = random.nextInt(elementosTamanho);
            } while (elementosArray.contains(indexSorteio));
        } else {
            indexSorteio = random.nextInt(elementosTamanho);
            elementosArray.add(indexSorteio);
        }
        return indexSorteio;
    }

    void IniciarJogo(int sorteio) throws Exception {
        JSON();
        indexCategoria = sorteio;
        menu.categoria = elementos.getJSONObject(indexCategoria).getString("categoria");
        menu.Categoria();
        Dicas(indexCategoria);
        pontuacao.VerificarPlacar();
    }

    void Dicas(int indexCategoria) {
        menu.pontos = pontuacao.pontos = 0;
        resposta = menu.resposta = elementos.getJSONObject(indexCategoria).getString("resposta");
        i = menu.i = 0;
        pontuacao.inicioJogo = Instant.now();

        for (; i < 11; i++) {
            dica = menu.dica = elementos.getJSONObject(indexCategoria).getJSONArray("dicas").getString(i);
            menu.i = i;
            menu.Dicas();
            input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            if (input.equals("desistir")) {
                menu.DesistirString();
                break;
            } else {
                if (input.equals(resposta)) {
                    pontuacao.fimJogo = Instant.now();
                    pontuacao.pontos = (100 - (i * 10));
                    pontuacao.pontos = menu.pontos = pontuacao.PontuacaoTratamento();
                    menu.Correto();
                    break;
                } else {
                    menu.Incorreto();
                    if (menu.desistir) {
                        break;
                    }
                }
            }
        }
    }
}
