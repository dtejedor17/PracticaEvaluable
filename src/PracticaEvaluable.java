import java.util.Scanner;
public class PracticaEvaluable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canicasHumano = 10, canicasMaquina= 10;
        int apuestaHumano, apuestaMaquina;
        int jugadorHumano=1,jugadorMaquina=2;
        String parOimparHumano;
        int parOimparMaquina;
        parOimparMaquina = (int) (Math.random() * 2);
        int turno;
        turno = (int) (Math.random()*2);
        apuestaMaquina = (int)(Math.random()*canicasMaquina);
        System.out.println("Comienza el juego");
        while (canicasHumano !=0 && canicasMaquina !=0) {
            if (turno == 1) {

                System.out.println("El Jugador " + jugadorHumano + " intenta adivinar si el Jugador " + jugadorMaquina + " tiene un número par o impar ");
                System.out.println();
                System.out.println("************************* TURNO JUGADOR "+jugadorMaquina+ " **************************");
                System.out.print("Jugador "+jugadorHumano+", ¿Cuántas canicas quieres apostar?: ");
                apuestaHumano = sc.nextInt();
                System.out.println();
                if (apuestaHumano % 2 == 0 && apuestaMaquina == 1){
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número par");
                    System.out.println();
                    System.out.println("Resultado");
                    System.out.println("Jugador "+jugadorHumano+" GANAS "+apuestaHumano+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");
                }else {
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número impar");
                    System.out.println();
                    System.out.println("Resultado");
                    System.out.println("Jugador " + jugadorHumano + " PIERDES " + apuestaHumano + " canicas ya que el Jugador " + jugadorMaquina + " tenía " + apuestaMaquina + " canicas.");
                }


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
                if (parOimparHumano.equals("par")) {
                    System.out.println();
                    System.out.println("Resultado");
                    System.out.println("Jugador "+jugadorHumano+" GANAS "+apuestaHumano+ " canicas ya que el Jugador "+jugadorMaquina+" tenía "+apuestaMaquina+" canicas.");

                }else if (parOimparHumano.equals("impar")){
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número impar");
                    System.out.println();
                    System.out.println("Resultado");
                    System.out.println("Jugador " + jugadorHumano + " PIERDES " + apuestaHumano + " canicas ya que el Jugador " + jugadorMaquina + " tenía " + apuestaMaquina + " canicas.");

                }else {
                    System.out.println("Has de elegir entre par o impar");
                }
            }




        }
    }
}