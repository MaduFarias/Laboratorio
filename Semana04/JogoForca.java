package Semana04;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.text.Normalizer;

public class JogoForca {
    static String palavraSecreta;
    static String palavraShow;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resposta;
        Random random = new Random();


        do {
            System.out.println("""
                                  _                         _         _____                  \s
                                 | | ___   __ _  ___     __| | __ _  |  ___|__  _ __ ___ __ _\s
                              _  | |/ _ \\ / _` |/ _ \\   / _` |/ _` | | |_ / _ \\| '__/ __/ _` |
                             | |_| | (_) | (_| | (_) | | (_| | (_| | |  _| (_) | | | (_| (_| |
                              \\___/ \\___/ \\__, |\\___/   \\__,_|\\__,_| |_|  \\___/|_|  \\___\\__,_|
                                          |___/                                              \s
                    """);
            System.out.println("Escolha a categoria de palavras na qual deseja jogar ");
            System.out.println("""
                    
                    [1] Animais         [3] Objetos
                    
                    [2] Comida          [4]Países
                    """);
            System.out.print("Escreva aqui: ");
            int categoria = scanner.nextInt();
            scanner.nextLine();

            // Escolher palavra secreta com acento e sem acento
            int indice = random.nextInt(6);
            String palavraSecreta = PalavraSecreta(categoria, indice);
            String palavraShow = PalavraShow(categoria, indice);

            Forca(scanner, palavraSecreta, palavraShow);

            System.out.println("Deseja jogar mais uma vez?");
            resposta = scanner.nextLine();

        } while (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s"));
        scanner.close();
    }

    static String PalavraSecreta(int categoria, int indice) {

        //Todas as listas terão que ter o mesmo tamanho
        String[] animais = {"leao", "cachorro", "gato", "elefante", "tigre", "cavalo"};
        String[] comidas = {"pizza", "arroz", "feijão", "hamburguer", "sushi", "salada"};
        String[] objetos = {"mesa", "cadeira", "lapis", "notebook", "telefone", "relógio"};
        String[] paises = {"brasil", "canada", "japao", "franca", "alemanha", "egito"};

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

    static String PalavraShow(int categoria, int indice) {
        String[] animaisShow = {"Leão", "Cachorro", "Gato", "Elefante", "Tigre", "Cavalo"};
        String[] comidasShow = {"Pizza", "Arroz", "Feijão", "Hambúrguer", "Sushi", "Salada"};
        String[] objetosShow = {"Mesa", "Cadeira", "Lápis", "Notebook", "Telefone", "Relógio"};
        String[] paisesShow = {"Brasil", "Canadá", "Japão", "França", "Alemanha", "Egito"};


        switch (categoria) {
            case 1:
                palavraShow = animaisShow[indice];
                break;
            case 2:
                palavraShow = comidasShow[indice];
                break;
            case 3:
                palavraShow = objetosShow[indice];
                break;
            case 4:
                palavraShow = paisesShow[indice];
                break;
            default:
                break;
        }
        return palavraShow;
    }

    static void Forca (Scanner scanner, String palavraSecreta, String palavraShow) {
        ArrayList<String> palavras = new ArrayList<>();
        ArrayList<String> letras = new ArrayList<>();
        StringBuilder espacos = new StringBuilder("_".repeat(palavraSecreta.length()));

        int tentativas = 6;
        String forca = "";

        while (true) {
            switch (tentativas) {
                case 6:
                    forca = """
                                  _______
                                 |/
                                 |
                                 |
                                 |
                                 |
                                _|___
                            """;
                    break;
                case 5:
                    forca = """
                                  _______
                                 |/      |
                                 |      ( )
                                 |
                                 |
                                 |
                                _|___
                            """;
                    break;
                case 4:
                    forca = """
                                  _______
                                 |/      |
                                 |      ( )
                                 |       |
                                 |       |
                                 |
                                _|___
                            """;
                    break;
                case 3:
                    forca = """
                                  _______
                                 |/      |
                                 |      ( )
                                 |      /|
                                 |       |
                                 |
                                _|___
                            """;
                    break;
                case 2:
                    forca = """
                                  _______
                                 |/      |
                                 |      ( )
                                 |      /|\\
                                 |       |
                                 |      
                                _|___
                            """;
                    break;
                case 1:
                    forca = """
                                  _______
                                 |/      |
                                 |      ( )
                                 |      /|\\
                                 |       |
                                 |      /
                                _|___
                            """;
                    break;
                case 0:
                    forca = """
                                  _______
                                 |/      |
                                 |      ( )
                                 |      /|\\
                                 |       |
                                 |      / \\
                                _|___
                            """;
                    break;
            }

            if (tentativas > 0) {
                System.out.println(forca);
                System.out.println(espacos);
                System.out.println("Chutes: " + String.join(" , ", letras) + "\n" + String.join(" , ", palavras));
                System.out.println("Você tem " + tentativas + " tentativas. Boa sorte!");
                System.out.println("Chute uma palavra ou letra: ");
                String chute = Normalizer.normalize(scanner.nextLine().trim().toLowerCase(), Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");


                if (chute.length() > 1) {
                    if (palavraSecreta.equals(chute)) {
                        System.out.println("Parabéns você acertou! a palavra era " + palavraShow);
                        break;
                    } else {
                        if (!palavras.contains(chute)) {
                            System.out.println("Você errou!");
                            palavras.add(chute);
                            tentativas -= 1;
                        }
                    }

                } else {
                    if (palavraSecreta.contains(chute)) {
                        for (int i = 0; i < palavraSecreta.length(); i++) {
                            if (palavraSecreta.charAt(i) == chute.charAt(0)) {
                                espacos.setCharAt(i, chute.charAt(0));
                                if (espacos.equals(palavraSecreta)) {
                                    System.out.println("Parabéns você acertou! a palavra era " + palavraShow);
                                    break;
                                }
                            }
                        }
                    } else {
                        if (!letras.contains(chute)) {
                            System.out.println("Você errou!");
                            letras.add(chute);
                            tentativas -= 1;
                        }
                    }
                }
            } else {
                System.out.println(forca);
                System.out.println("Suas tentativas acabaram, a palavra era: " + palavraShow);
                break;
            }
        }
    }
}




