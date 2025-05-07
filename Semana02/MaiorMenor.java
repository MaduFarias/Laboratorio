package Semana02;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MaiorMenor {
    static int Pontos = 0;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static List<Integer> numeros = new ArrayList<>();

    static void Adivinhar() {
        numeros.add(random.nextInt(100) + 1);
        numeros.add(random.nextInt(100) + 1);

        System.out.println("""
        
        =====
        Jogo Maior ou Menor
        
        Dois números são gerados
        Um será mostrado e o segundo ficará oculto
        Você deve advinhar se o segundo número é maior ou menor que o primeiro
        A cada rodada o segundo número será o número a ser comparado
        
        Boa Sorte!
        
        Para encerrar o jogo digite: sair
        =====
        """);


        while (true) {
            int numeroatual = numeros.get(numeros.size() - 2);
            int numeroseguinte = numeros.get(numeros.size() - 1);

            System.out.println(numeros);
            System.out.println(numeroatual);
            System.out.println(numeroseguinte);
            System.out.println("O número atual: " + numeroatual);
            System.out.println("O próximo número é maior ou menor? ");
            String palpite = scanner.nextLine();

            if (palpite.equalsIgnoreCase("sair")) {
                System.out.println("Você fez " + Pontos + " pontos. O jogo será encerrado, obrigada por participar!");
                break;
            } else if ((numeroseguinte > numeroatual && palpite.equalsIgnoreCase("maior")) || (numeroseguinte < numeroatual && palpite.equalsIgnoreCase("menor"))) {
                Pontos += 1;
                System.out.println("Parabéns você acertou, o número era " + numeroseguinte + ". Outro número será gerado");
            } else if ((numeroseguinte > numeroatual && palpite.equalsIgnoreCase("menor")) || (numeroseguinte < numeroatual && palpite.equalsIgnoreCase("maior"))) {
                System.out.println("Que pena você errou, o número era " + numeroseguinte + ". Outro número será gerado!");
            } else if (numeroseguinte == numeroatual) {
                System.out.println("Números iguais, próximo número será gerado");
            }

            numeros.add(random.nextInt(100) + 1);
        }
    }

    public static void main (String[] args) {
        Adivinhar();
    }
}
