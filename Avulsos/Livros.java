package Avulsos;

import java.util.Scanner;
import java.util.ArrayList;

public class Livros {
    static ArrayList<String> livros = new ArrayList<String>();
    static Scanner scanner = new Scanner(System.in);

    static String Operacao() {
        return """
                
                ===================
                Escolha a Operação:
                
                Adicionar Livro [1]
                Listar Livros [2]
                Editar Livro [3]
                Remover Livro [4]
                Sair [5]
                
                ===================
                """;
    }

    static void Lista() {
        System.out.println("Livros arquivados: \n");
        for (int i = 0; i < livros.size(); i++) {
            System.out.print((i + 1) + ". " + livros.get(i) + "\n");
        }
    }

    static void Execucao() {
        while (true) {
            System.out.println(Operacao());
            System.out.print("Digite um número: ");
            int operacaoi = scanner.nextInt();
            scanner.nextLine();

            if (operacaoi == 1) {
                System.out.print("Digite o nome do livro: ");
                String livro = scanner.nextLine();

                System.out.print("Digite o nome do autor: ");
                String autor = scanner.nextLine();

                livros.add((livro + " - " + autor));
            }
            else if (operacaoi == 2) {
                Lista();
            }

            else if (operacaoi == 3) {
                Lista();
                System.out.print("Digite o número do livro que quer editar: ");
                int edicaonumero = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite o nome do livro: ");
                String edicaolivro = scanner.nextLine();

                System.out.print("Digite o nome do autor: ");
                String edicaoautor = scanner.nextLine();

                livros.set((edicaonumero - 1), (edicaolivro + " - " + edicaoautor));
                System.out.print("Livro editado com sucesso!");
            }

            else if (operacaoi == 4) {
                Lista();
                System.out.print("Digite o número do livro que quer remover: ");
                int removernumero = scanner.nextInt();

                livros.remove((removernumero - 1));
                System.out.println("Livro removido com sucesso!");
            }

            else if (operacaoi == 5){
                System.out.println("Operação finalizada, Obrigado por usar nosso sistema!");
                break;
            }
            else {
                System.out.println("Número inválido, tente outra operação");
            }
        }
    }

    public static void main (String[] args) {
        Execucao();
    }
}
