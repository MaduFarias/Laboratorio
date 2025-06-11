package org.example;

public class Menu {

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
