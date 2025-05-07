package Semana01;

import java.util.Scanner;
//ver01
public class TarefasTempo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Digite as horas: ");
        int hora = scanner.nextInt();

        System.out.println("Digite os minutos: ");
        int minuto = scanner.nextInt();

        int horac = hora * 60;
        int horaconve = horac + minuto;

        String min5 = "Ouvir música";
        String min10 = "Revisar anotações";
        String min20 = "Videoaula";
        String min45 = "Resolver exercícios";
        String min90 = "Projeto pessoal";

        System.out.println("Tempo disponível: " + hora + ":" + minuto + " (" + horaconve + " minutos). Aqui está as atividade recomendadas: ");

        while (horaconve != 0) {
            if (horaconve >= 90) {
                horaconve = horaconve - 90;
                System.out.println(min90 + " (90 min) \n Resta: " + horaconve + " min");
            } else if (horaconve >= 45) {
                horaconve = horaconve - 45;
                System.out.println(min45 + " (45 min) \n Resta: " + horaconve + " min");
            } else if (horaconve >= 20) {
                horaconve = horaconve - 20;
                System.out.println(min20 + " (20 min) \n Resta: " + horaconve + " min");
            } else if (horaconve >= 10) {
                horaconve = horaconve - 10;
                System.out.println(min10 + "(10 min) \n Resta: " + horaconve + " min");
            }  else if (horaconve >= 5) {
                horaconve = horaconve - 5;
                System.out.println(min5 + " (5 min) \n Resta: " + horaconve + " min");
            } else {
                break;
            }
        }
    }
}
