package org.example;

import java.text.Normalizer;

import static org.example.QuemSouEu.scanner;

public class Menu {
    String categoria, dica, resposta, input;
    int i, pontos;
    boolean desistir;

    static void Menu() {
        System.out.print("""
                +-----------------------------+
                |        QUEM SOU EU?         |
                +-----------------------------+
                | 1. Jogar                    |
                | 2. Ajuda                    |
                | 3. Ver Leaderboard          |
                | 4. Sair                     |
                +-----------------------------+
                Escolha uma opção:
                """);
    }

    static void Ajuda() {
        System.out.println("""
                +-----------------------------+
                |            AJUDA            |
                +-----------------------------+
                Regras do jogo:
                - Adivinhe quem é com até 10 dicas.
                - Cada dica: −10 pts.
                - Cada minuto: −1 pt.
                - Digite "desistir" para encerrar o desafio atual.
                
                Pressione ENTER para voltar ao menu.
                
                """);
    }

    static void Sair() {
        System.out.print("""
                +-----------------------------+
                |       DESEJA SAIR?         |
                +-----------------------------+
                Tem certeza que deseja sair?
                1. Sim
                2. Não
                
                Escolha uma opção:
                """);
    }

    void Categoria() {
        System.out.printf("""
                +-----------------------------+
                |        NOVO DESAFIO         |
                +-----------------------------+
                Categoria: %s
                
                Pressione ENTER para ver a dica 1.
                
                \n""", this.categoria);
        OperacaoEnter();
    }

    void Dicas() {
        if (i + 1 < 11) {
            System.out.printf("""
                    +-----------------------------+
                    |           DICA %s            |
                    +-----------------------------+
                    %s
                    
                    Digite sua resposta ou
                    pressione ENTER para próxima:
                    >
                    """, (i + 1), dica);
        } else {
            System.out.printf("""
                +-----------------------------+
                |         FIM DE JOGO         |
                +-----------------------------+
                Dica %s: %s
                
                Digite sua resposta final:
                >
                """, (i + 1), dica);
        }
    }

    void Incorreto() {
        if ((i + 1) == 11) {
            System.out.printf("""
                    ❌ Resposta incorreta!
                    
                    💀 Fim de jogo!
                    Resposta certa: %s
                    Você usou todas as dicas.
                    Pontuação: %s pts
                    
                    Pressione ENTER para menu.
                    """, resposta, pontos);
            OperacaoEnter();
        } else {
            System.out.printf("""
                    ❌ Resposta incorreta!
                    (ou digite "desistir" para sair)
                    
                    Pressione ENTER para dica %s.
                    """, (i + 2));
            OperacaoEnterDesistir();
        }

    }

    void Correto() {
        System.out.printf("""
                ✅ Correto!
                Resposta: %s
                
                Dicas usadas: %s
                Pontuação: %s pts
                
                Pressione ENTER para menu.
                """, resposta, i, pontos);
        OperacaoEnter();

    }

    void DesistirString() {
        System.out.printf("""
                💀 Você desistiu!
                Resposta certa: %s
                Pontuação: %s pts
                
                Pressione ENTER para menu.
                """, resposta, pontos);
        OperacaoEnter();
    }

    boolean OperacaoEnterDesistir(){
        input = scanner.nextLine();
        if (input.equals("desistir")) {
            DesistirString();
            desistir = true;
        } else {
            while (true) {
                if (input.isEmpty()) {
                    break;
                } else {
                    OperacaoInvalidaString();
                }
            }
            desistir = false;
        }
        return desistir;
    }

    void OperacaoEnter () {
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            } else {
                OperacaoInvalidaString();
            }
        }
    }

    void OperacaoInvalida() {
        OperacaoInvalidaString();
        while (true) {
            input = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            if (input.isEmpty()) {
                break;
            } else {
                OperacaoInvalidaString();
            }
        }
    }

    static void OperacaoInvalidaString() {
        System.out.print("""
                +-----------------------------+
                |         OPÇÃO INVÁLIDA      |
                +-----------------------------+
                Por favor, escolha uma opção válida.
                
                Pressione ENTER para voltar ao menu.
                """);
    }
}
