import java.util.Scanner;
public class PracticaEvaluable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canicasHumano = 10, canicasMaquina= 10;
        int apuestaHumano, apuestaMaquina;
        int jugadorHumano=1,jugadorMaquina=2;
        String parOimparHumano;
        int parOimparMaquina, resultado;
        boolean ganadorJugadorHumano = false, ganadorJugadorMaquina = false;
        int turno;
        turno = (int) (Math.random()*2);
        apuestaMaquina = (int)(Math.random()*canicasMaquina);
        System.out.println("Comienza el juego");
        while (canicasHumano !=0 && canicasMaquina !=0) {
            if (turno == 0) {

                System.out.println("El Jugador " + jugadorHumano + " intenta adivinar si el Jugador " + jugadorMaquina + " tiene un número par o impar ");
                System.out.println();
                System.out.println("************************* TURNO JUGADOR "+jugadorMaquina+ " **************************");
                System.out.print("Jugador "+jugadorHumano+", ¿Cuántas canicas quieres apostar?: ");
                apuestaHumano = sc.nextInt();
                apuestaMaquina = (int)(Math.random()*canicasMaquina);
                parOimparMaquina = (int)(Math.random()*1);
                System.out.println();
                if (parOimparMaquina == 0) {
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número par");;
                    if (apuestaHumano % 2 == 0) {
                        ganadorJugadorMaquina = true;
                    }else if (apuestaHumano % 2 == 1) {
                        ganadorJugadorHumano = true;
                    }
                }else {
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número impar");
                    if (apuestaHumano % 2 == 1) {
                        ganadorJugadorMaquina = true;
                    }else if (apuestaHumano % 2 == 0) {
                       ganadorJugadorHumano = true;
                    }
                    System.out.println();
                    System.out.println("Resultado");
                    resultado = (Math.min(apuestaHumano, apuestaMaquina));
                    if (ganadorJugadorHumano) {
                        System.out.println("Jugador "+jugadorHumano+" GANAS "+resultado+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                        canicasHumano = canicasHumano+resultado;
                        canicasMaquina = canicasMaquina-resultado;
                        System.out.println("Jugador "+jugadorHumano+ " tiene "+canicasHumano+" canicas.");
                        System.out.println("Jugador "+jugadorMaquina+ " tiene "+canicasMaquina+" canicas.");
                    }
                    if (ganadorJugadorMaquina) {
                        System.out.println("Jugador "+jugadorHumano+" PIERDES "+resultado+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                        canicasHumano = canicasHumano-resultado;
                        canicasMaquina = canicasMaquina+resultado;
                        System.out.println("Jugador "+jugadorHumano+ " tiene "+canicasHumano+" canicas.");
                        System.out.println("Jugador "+jugadorMaquina+ " tiene "+canicasMaquina+" canicas.");
                    }

                }
                turno = 1;
            }else{
                System.out.println("El Jugador " + jugadorMaquina + " intenta adivinar si el Jugador " + jugadorHumano + " tiene un número par o impar ");
                System.out.println();
                System.out.println("************************* TURNO JUGADOR "+jugadorHumano+ " **************************");
                System.out.print("Jugador "+jugadorHumano+", ¿Cuántas canicas quieres apostar?: ");
                apuestaHumano = sc.nextInt();
                System.out.println();
                System.out.print("Jugador "+jugadorHumano+" ¿Que crees que tiene el Jugador 2? (Par / Impar:)");
                parOimparHumano = sc.next();
                parOimparHumano = parOimparHumano.toLowerCase();
                System.out.println();
                if (parOimparHumano.equals("par")){
                    if (canicasMaquina % 2 == 0) {
                        ganadorJugadorHumano = true;

                    }else if (canicasMaquina % 2 == 1) {
                        ganadorJugadorMaquina = true;
                    }
                }
                if (parOimparHumano.equals("impar")){
                    if (canicasMaquina % 2 == 0) {
                        ganadorJugadorMaquina= true;
                    }
                    if  (canicasMaquina % 2 == 1) {
                        ganadorJugadorHumano = true;
                    }
                }
                System.out.println();
                System.out.println("Resultado");
                resultado = (Math.min(apuestaHumano, apuestaMaquina));
                if (ganadorJugadorHumano) {
                    System.out.println("Jugador "+jugadorHumano+" GANAS "+resultado+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                    canicasHumano = canicasHumano+resultado;
                    canicasMaquina = canicasMaquina-resultado;
                    System.out.println("Jugador "+jugadorHumano+ " tiene "+canicasHumano+" canicas.");
                    System.out.println("Jugador "+jugadorMaquina+ " tiene "+canicasMaquina+" canicas.");
                }
                if (ganadorJugadorMaquina) {
                    System.out.println("Jugador "+jugadorHumano+" PIERDES "+resultado+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                    canicasHumano = canicasHumano-resultado;
                    canicasMaquina = canicasMaquina+resultado;
                    System.out.println("Jugador "+jugadorHumano+ " tiene "+canicasHumano+" canicas.");
                    System.out.println("Jugador "+jugadorMaquina+ " tiene "+canicasMaquina+" canicas.");
                }
                turno = 0;
            }
        }
    }
}