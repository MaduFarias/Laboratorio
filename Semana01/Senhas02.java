package Semana01;

import java.util.Scanner;

public class Senhas02 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        StringBuilder snh = new StringBuilder(senha);

        //Senha invertida com StringBuilder //
        System.out.println("Senha invertida: " + snh.reverse());

        //Senha caixa Alta//
        System.out.println("Senha em maiusculo: " + senha.toUpperCase());

        //Senha sem vogais//
        System.out.println("Senha sem vogais: " + senha.replaceAll("(?i)[aeiou]", "")); //(?i) ativa o case sensitive//

        //Senha com simbolos//
        System.out.println("Senha com simbolos: " + senha
                .replaceAll("(?i)a", "@") //case sensitive, substitui a por @//
                .replaceAll("(?i)e", "3")
                .replaceAll("(?i)i", "!")
                .replaceAll("(?i)o", "0")
                .replaceAll("(?i)u", "#")
                .replaceAll("(?i)s", "$")
                .replaceAll("(?i)l", "1")
                .replaceAll("(?i)t", "7"));
    }
}
