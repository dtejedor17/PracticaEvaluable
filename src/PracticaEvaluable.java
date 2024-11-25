import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class PracticaEvaluable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canicasHumano = 10, canicasMaquina= 10, apuestaHumano =0, apuestaMaquina, jugadorHumano=1,jugadorMaquina=2, turno, resultado;
        String parOimparHumano;
        boolean ganadorJugadorHumano = false, parOimparMaquina;
        Random rand  = new Random();
        turno = (int) (Math.random()*2);
        System.out.println("Comienza el juego");
        while (canicasHumano !=0 && canicasMaquina !=0) {
            if (turno == 0) {
                System.out.printf("\nEl Jugador " + jugadorHumano + " intenta adivinar si el Jugador " + jugadorMaquina + " tiene un número par o impar \n");
                System.out.println();
                System.out.println("************************* TURNO JUGADOR "+jugadorMaquina+ " **************************");
                do {
                    System.out.print("Jugador " + jugadorHumano + ", ¿Cuántas canicas quieres apostar?:");
                    try {
                        apuestaHumano = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.err.printf("\nERRROR: Has de elegir un número entre 1 y "+canicasHumano+"\n");
                        sc.nextLine();
                    }
                }while (apuestaHumano > canicasHumano || apuestaHumano <= 0);
                apuestaMaquina = (int)(Math.random()*canicasMaquina)+1;
                parOimparMaquina = rand.nextBoolean();
                if (parOimparMaquina) {
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número par");
                }else{
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número impar");
                }
                if (parOimparMaquina && apuestaHumano % 2 == 1 || !parOimparMaquina && apuestaHumano % 2 == 0) {
                    ganadorJugadorHumano = true;
                }else {
                    ganadorJugadorHumano = false;
                }
                    System.out.printf("\nResultado:\n\n");
                    resultado = (Math.min(apuestaHumano, apuestaMaquina));
                if (ganadorJugadorHumano) {
                    System.out.println("Jugador "+jugadorHumano+" GANAS "+resultado+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                    canicasHumano = canicasHumano+resultado;
                    canicasMaquina = canicasMaquina-resultado;
                    System.out.println("Jugador "+jugadorHumano+ " tiene "+canicasHumano+" canicas.");
                    System.out.println("Jugador "+jugadorMaquina+ " tiene "+canicasMaquina+" canicas.");
                }else{
                    System.out.println("Jugador "+jugadorHumano+" PIERDES "+resultado+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                    canicasHumano = canicasHumano-resultado;
                    canicasMaquina = canicasMaquina+resultado;
                    System.out.println("Jugador "+jugadorHumano+ " tiene "+canicasHumano+" canicas.");
                    System.out.println("Jugador "+jugadorMaquina+ " tiene "+canicasMaquina+" canicas.");
                }
                turno = 1;
            }else{
                System.out.printf("El Jugador " + jugadorMaquina + " intenta adivinar si el Jugador " + jugadorHumano + " tiene un número par o impar \n\n");
                System.out.println("************************* TURNO JUGADOR "+jugadorHumano+ " **************************");
                do {
                    System.out.print("Jugador " + jugadorHumano + ", ¿Cuántas canicas quieres apostar?:");
                    try {
                        apuestaHumano = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.err.print("\nERRROR: Has de elegir un número entre 1 y "+canicasHumano+"\n");
                        sc.nextLine();
                    }
                }while (apuestaHumano > canicasHumano || apuestaHumano <= 0);
                do{
                    System.out.printf("\nJugador "+jugadorHumano+" ¿Que crees que tiene el Jugador 2? (Par / Impar):");
                    parOimparHumano = sc.next();
                    parOimparHumano = parOimparHumano.toLowerCase();
                }while (!parOimparHumano.equals("par") && !parOimparHumano.equals("impar") );
            apuestaMaquina = (int)(Math.random()*canicasMaquina)+1;
                System.out.println();
                if (parOimparHumano.equals("par") && apuestaMaquina % 2 == 0 || parOimparHumano.equals("impar") && apuestaMaquina % 2 == 1) {
                    ganadorJugadorHumano = true;
                }else{
                    ganadorJugadorHumano = false;
                }
                System.out.printf("Resultado:\n\n");

                resultado = (Math.min(apuestaHumano, apuestaMaquina));
                if (ganadorJugadorHumano) {
                    System.out.println("Jugador " + jugadorHumano + " GANAS " + resultado + " canicas ya que el Jugador " + jugadorMaquina + " tenía " + apuestaMaquina + " canicas.");
                    canicasHumano = canicasHumano + resultado;
                    canicasMaquina = canicasMaquina - resultado;
                    System.out.println("Jugador " + jugadorHumano + " tiene " + canicasHumano + " canicas.");
                    System.out.println("Jugador " + jugadorMaquina + " tiene " + canicasMaquina + " canicas.");
                }else {
                    System.out.println("Jugador "+jugadorHumano+" PIERDES "+resultado+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                    canicasHumano = canicasHumano-resultado;
                    canicasMaquina = canicasMaquina+resultado;
                    System.out.println("Jugador "+jugadorHumano+ " tiene "+canicasHumano+" canicas.");
                    System.out.println("Jugador "+jugadorMaquina+ " tiene "+canicasMaquina+" canicas.");
                }
                turno = 0;
            }
        }
        if (canicasMaquina == 0) {
            System.out.printf("\nEnhorabuena ¡Has ganado!\n");
        }else {
            System.out.printf("\nPerdiste\n");
        }
    }
}