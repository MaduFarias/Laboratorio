package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.Duration;

public class Pontos {
    String nome, nomePrint;
    Instant inicioJogo, fimJogo;
    int pontos, ultimoPonto, placarPontos, pontosPrint, colocacao;
    JSONArray placar;
    JSONObject placarJSONMover, novaPontucao;

    Menu menu;

    void JSON() throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("src/main/Pontuacao.json")));
        placar = new JSONArray(json);
    }

    void SalvarJson() throws Exception {
        Files.write(Paths.get("src/main/Pontuacao.json"), placar.toString(2).getBytes());
    }

    int PontuacaoTratamento() {
        long minutos = Duration.between(inicioJogo, fimJogo).toMinutes();
        pontos -= minutos;
        if (pontos < 0) {
            pontos = 0;
        }
        return pontos;
    }

    void VerificarPlacar() throws Exception {
        JSON();
        menu = new Menu();
        ultimoPonto = placar.getJSONObject(9).getInt("pontos");
        if (pontos > ultimoPonto) {
            menu.PontuacaoNova();
            nome = menu.nome;
            MoverNomes(nome);
        }

    }

    void MoverNomes(String nome) throws Exception {
        novaPontucao = new JSONObject();
        novaPontucao.put("nome", nome);
        novaPontucao.put("pontos", pontos);
        for (int j = 0; j < 10; j++) {
            placarPontos = placar.getJSONObject(j).getInt("pontos");
            if (placarPontos <= pontos) {
                for (int g = 9; g >= j; g--) {
                    placarJSONMover = placar.getJSONObject(g);
                    placar.put((g + 1), placarJSONMover);
                }
                placar.put(j, novaPontucao);
                if (placar.length() > 10) {
                    placar.remove(10);
                }
                break;
            }
        }
        SalvarJson();
    }

    void LeaderboardPontuacao(){
        for (int i = 0; i < 10; i++) {
            nomePrint = placar.getJSONObject(i).getString("nome");
            pontosPrint = placar.getJSONObject(i).getInt("pontos");
            colocacao = i + 1;
            System.out.printf("%s. %s    – %s pts \n", colocacao, nomePrint, pontosPrint);
        }
    }
}