import java.util.InputMismatchException;
import java.util.Scanner;
public class PracticaEvaluable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canicasHumano = 10, canicasMaquina= 10;
        int apuestaHumano =0, apuestaMaquina;
        int jugadorHumano=1,jugadorMaquina=2;
        String parOimparHumano;
        int parOimparMaquina, resultado;
        boolean ganadorJugadorHumano = false;
        int turno;
        turno = (int) (Math.random()*2);
        System.out.println("Comienza el juego");
        while (canicasHumano !=0 && canicasMaquina !=0) {
            if (turno == 0) {

                System.out.println("El Jugador " + jugadorHumano + " intenta adivinar si el Jugador " + jugadorMaquina + " tiene un número par o impar ");
                System.out.println();
                System.out.println("************************* TURNO JUGADOR "+jugadorMaquina+ " **************************");
                System.out.print("Jugador "+jugadorHumano+", ¿Cuántas canicas quieres apostar?:");
                try {
                    do {
                        apuestaHumano = sc.nextInt();
                    }while (apuestaHumano > canicasHumano);
                }catch (InputMismatchException e){
                    System.err.println("Tienes que introducir un numero entre 1 y "+canicasHumano);
                    apuestaHumano = sc.nextInt();
                }
                apuestaMaquina = (int)(Math.random()*canicasMaquina)+1;
                parOimparMaquina = (int)(Math.random()*2);
                if (parOimparMaquina == 0) {
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número par");
                    if (apuestaHumano % 2 == 1) {
                        ganadorJugadorHumano = true;
                    }
                }else if (parOimparMaquina == 1) {
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número impar");
                    if (apuestaHumano % 2 == 0) {
                       ganadorJugadorHumano = true;
                    }
                    System.out.printf("\nResultado");
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
                }
                turno = 1;
            }else{
                System.out.printf("El Jugador " + jugadorMaquina + " intenta adivinar si el Jugador " + jugadorHumano + " tiene un número par o impar \n\n");
                System.out.println("************************* TURNO JUGADOR "+jugadorHumano+ " **************************");
                System.out.print("Jugador "+jugadorHumano+", ¿Cuántas canicas quieres apostar?: ");
                try {
                    apuestaHumano = sc.nextInt();
                }catch (InputMismatchException e){
                    System.err.println("Tienes que introducir un numero entre 1 y "+canicasHumano);
                    apuestaHumano = sc.nextInt();
                }

                System.out.printf("\nJugador "+jugadorHumano+" ¿Que crees que tiene el Jugador 2? (Par / Impar:)");
                parOimparHumano = sc.next();
                parOimparHumano = parOimparHumano.toLowerCase();
                System.out.println();
                if (parOimparHumano.equals("par")||parOimparHumano.equals("impar")){
                    if (canicasMaquina % 2 == 0) {
                        ganadorJugadorHumano = true;

                    }else if (canicasMaquina % 2 == 1) {
                        ganadorJugadorHumano = false;
                    }
                }
                System.out.printf("Resultado\n");
                apuestaMaquina = (int)(Math.random()*canicasMaquina)+1;
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