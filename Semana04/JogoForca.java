package Semana04;

import java.util.Scanner;
import java.util.Random;

public class JogoForca {
    static String palavraSecreta;

    static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resposta;
        String chute = "0";

        do {
            System.out.println("""
                          _                         _         _____                  \s
                         | | ___   __ _  ___     __| | __ _  |  ___|__  _ __ ___ __ _\s
                      _  | |/ _ \\ / _` |/ _ \\   / _` |/ _` | | |_ / _ \\| '__/ __/ _` |
                     | |_| | (_) | (_| | (_) | | (_| | (_| | |  _| (_) | | | (_| (_| |
                      \\___/ \\___/ \\__, |\\___/   \\__,_|\\__,_| |_|  \\___/|_|  \\___\\__,_|
                                  |___/                                              \s
            """);
            System.out.println("Escolha a categoria de palavras na qual deseja jogar: ");
            System.out.println("""
            [1] Animais         [3] Objetos
            
            [2] Comida          [4]Países
            """);
            int categoria = scanner.nextInt();
            scanner.nextLine();

            String palavraSecreta = PalavraSecreta(categoria);

            //Jogo da forca
            //chutes

            System.out.println("Deseja jogar mais uma vez?");
            resposta = scanner.nextLine();

        } while (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s"));
    }

    static String PalavraSecreta (int categoria) {
        Random random = new Random();
        //Todas as listas terão que ter o mesmo tamanho
        String[] animais = {"Leão", "Cachorro", "Gato", "Elefante", "Tigre", "Cavalo"};
        String[] comidas = {"Pizza", "Arroz", "Feijão", "Hambúrguer", "Sushi", "Salada"};
        String[] objetos = {"Mesa", "Cadeira", "Lápis", "Notebook", "Telefone", "Relógio"};
        String[] paises = {"Brasil", "Canadá", "Japão", "França", "Alemanha", "Egito"};


        int indice = random.nextInt(6);
        switch (categoria) {
            case 1:
                palavraSecreta = animais[indice];
                break;
            case 2:
                palavraSecreta = comidas[indice];
                break;
            case 3:
                palavraSecreta = objetos[indice];
                break;
            case 4:
                palavraSecreta = paises[indice];
                break;
            default:
                break;
        }
        return palavraSecreta;
    }

    static void JogodaForca(String palavraSecreta, String chute){
        if (chute.equals("0")) {

        }
    }
}
