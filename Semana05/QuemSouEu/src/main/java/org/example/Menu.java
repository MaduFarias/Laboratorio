package org.example;

public class Menu {
    String categoria;
    int i;
    String dica;
    String resposta;
    String pontos;

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

    void Categoria() {
        System.out.printf("""
                +-----------------------------+
                |        NOVO DESAFIO         |
                +-----------------------------+
                Categoria: %s
                
                Pressione ENTER para ver a dica 1.
                
                \n""", this.categoria);
    }

    void Dicas() {
        System.out.printf("""
                +-----------------------------+
                |           DICA %s            |
                +-----------------------------+
                %s
                
                Digite sua resposta ou
                pressione ENTER para próxima:
                >
                """,(i + 1), dica);
    }

    void Incorreto() {
        if ((i + 1) == 11) {
            System.out.println("""
                    ❌ Resposta incorreta!
                    (ou digite "desistir" para sair)
                    
                    Pressione ENTER para continuar.
                    """);
        } else {
            System.out.printf("""
                    ❌ Resposta incorreta!
                    (ou digite "desistir" para sair)
                    
                    Pressione ENTER para dica %s.
                    """, (i + 2));
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
    }
}
