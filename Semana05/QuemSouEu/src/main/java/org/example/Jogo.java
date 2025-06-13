package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Random;

public class Jogo {
    String categoria;
    String dica;
    String respostas;
    int elementosTamanho;
    JSONArray elementos;
    ArrayList<Integer> elementosArray = new ArrayList<>(11);
    int indexSorteio;
    int indexCategoria;
    Menu menu = new Menu();


    static Random random = new Random();

    void JSON () throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("src/main/Dicas.json")));
        elementos = new JSONArray(json);
    }

    int Sortear() throws Exception {
        elementosTamanho = elementos.length();
        if (elementosArray.size() > 0 && elementosArray.size() <= 11) {
            do {
                indexSorteio = random.nextInt(elementosTamanho);
            } while (Arrays.asList(elementosArray).contains(indexSorteio));
        } else {
            indexSorteio = random.nextInt(elementosTamanho);
            elementosArray.add(indexSorteio);
        }
        return indexSorteio;
    }

    void IniciarJogo(/*boolean operacaoEnter*/) throws Exception {
        JSON();
        //do {
            indexCategoria = Sortear();
            menu.categoria = elementos.getJSONObject(indexCategoria).getString("categoria");
            menu.Categoria();
            //if (operacaoEnter) {
            //}
        //} while ((elementosArray.size() < elementosTamanho));
    }

}
