package Semana01;

import java.util.Scanner; // Sempre importar a biblioteca ao fazer um input //

public class Senhas {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in); // sempre declarar o input //

        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine(); // cada tipo primitivo terá seu tipo de scanner //

        // Senha invertida //
        String senha_invertida = "";
        for (int i = senha.length() - 1; i >= 0; i--) {
            senha_invertida += senha.charAt(i);
        }

        // Senha sem vogais //
        String senha_no_vogal = "";
        for (int i = 0; i < senha.length(); i++) {
            if (Character.toUpperCase(senha.charAt(i)) == 'A' ||
                    Character.toUpperCase(senha.charAt(i)) == 'E' ||
                    Character.toUpperCase(senha.charAt(i)) == 'I' ||
                    Character.toUpperCase(senha.charAt(i)) == 'O' ||
                    Character.toUpperCase(senha.charAt(i)) == 'U') {
                continue;
            } else {
                senha_no_vogal += senha.charAt(i);
            }
        }

        //letras para simbolos //
        // a= @; e = 3; i = !; o = 0; s = $, l = 1, t = 7 //
        String senha_simbolo = "";
        for (int i = 0; i < senha.length(); i++) {
            if (Character.toUpperCase(senha.charAt(i)) == 'A') {
                senha_simbolo += '@';
            } else if (Character.toUpperCase(senha.charAt(i)) == 'E') {
                senha_simbolo += '3';
            } else if (Character.toUpperCase(senha.charAt(i)) == 'I') {
                senha_simbolo += '!';
            } else if (Character.toUpperCase(senha.charAt(i)) == 'O') {
                senha_simbolo += '0';
            } else if (Character.toUpperCase(senha.charAt(i)) == 'S') {
                senha_simbolo += '$';
            } else if (Character.toUpperCase(senha.charAt(i)) == 'L') {
                senha_simbolo += '1';
            } else if (Character.toUpperCase(senha.charAt(i)) == 'T') {
                senha_simbolo += '7';
            } else {
                senha_simbolo += senha.charAt(i);
            }
        }

        // Resultados //
        System.out.println("Senha orginal: " + senha);
        System.out.println("Senha invertida: " + senha_invertida);
        System.out.println("Senha em maiusculo: " + senha.toUpperCase());
        System.out.println("Senha sem vogais: " + senha_no_vogal);
        System.out.println("Senha com simbolos: " + senha_simbolo);
    }
}