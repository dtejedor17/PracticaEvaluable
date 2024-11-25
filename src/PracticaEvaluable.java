import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class PracticaEvaluable {
    public static void main(String[] args) {

        // Introducimos las variables y el Scanner
        Scanner sc = new Scanner(System.in);
        int canicasHumano = 10, canicasMaquina= 10, apuestaHumano =0, apuestaMaquina, jugadorHumano=1,jugadorMaquina=2, turno, resultado;
        String parOimparHumano;
        boolean ganadorJugadorHumano = false, parOimparMaquina;
        Random rand  = new Random();
        turno = (int) (Math.random()*2);

        // Comenzamos el juego
        System.out.println("Comienza el juego");

        // Mientras que las canicas de ninguno de los 2 jugadores llegue a cero, el juego continua.
        while (canicasHumano !=0 && canicasMaquina !=0) {

            // Se elige el turno con el random de la varible turno
            if (turno == 0) {
                System.out.printf("\nEl Jugador " + jugadorHumano + " intenta adivinar si el Jugador " + jugadorMaquina + " tiene un número par o impar \n");
                System.out.println();
                System.out.println("************************* TURNO JUGADOR "+jugadorMaquina+ " **************************");

                // El jugador humano tiene que apostar un número de canicas entre 1 y el máximo de las que tenga, si hace otra cosa volverá a pedirlo
                // Si introduce algo que no sea un número entero saltará un error y se lo volverá a pedir
                do {
                    System.out.print("Jugador " + jugadorHumano + ", ¿Cuántas canicas quieres apostar?:");
                    try {
                        apuestaHumano = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.err.printf("\nERRROR: Has de elegir un número entre 1 y "+canicasHumano+"\n");
                        sc.nextLine();
                    }
                }while (apuestaHumano > canicasHumano || apuestaHumano <= 0);

                //La maquina también hace su apuesta, siendo el mínimo 1 y el máximo las canicas que tiene, pudiendo ser todas
                apuestaMaquina = (int)(Math.random()*canicasMaquina)+1;

                // Con este random boolean la máquina elige si "true == par" o "false == impar"
                parOimparMaquina = rand.nextBoolean();

                // Dependiendo de la elección de la máquina se imprimira un resultado u otro.
                if (parOimparMaquina) {
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número par");
                }else{
                    System.out.println("Jugador 2 cree que el Jugador 1 tiene un número impar");
                }

                // Cuando la maquina ha hecho su elección, se compara con las canicas del jugador humano
                // si elige par y humano tiene impar o elige impar y humano tiene par, la máqina pierde, en caso contrario gana
                if (parOimparMaquina && apuestaHumano % 2 == 1 || !parOimparMaquina && apuestaHumano % 2 == 0) {
                    ganadorJugadorHumano = true;
                }else {
                    ganadorJugadorHumano = false;
                }

                // Se imprime el resultado eligiendo la menor de las apuestas
                    System.out.printf("\nResultado:\n\n");
                    resultado = (Math.min(apuestaHumano, apuestaMaquina));

                    // Dependiendo de si jugador humano ganó o perdió se hará el reparto de canicas correspondiente.
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
                // Como el turno era 0, ahora cambiamos el turno para que juegue el otro jugador.
                turno = 1;
            }else{

                // Ahora es tueno del otro jugador, el humano
                System.out.printf("El Jugador " + jugadorMaquina + " intenta adivinar si el Jugador " + jugadorHumano + " tiene un número par o impar \n\n");
                System.out.println("************************* TURNO JUGADOR "+jugadorHumano+ " **************************");

                // mientras que el jugador humano introduzca otra cosa que no sea un número entero,
                // saldrá un mensaje de error y tendrá que seguir introduciendo datos hasta que el número coindida con lo solicitado
                do {
                    System.out.print("Jugador " + jugadorHumano + ", ¿Cuántas canicas quieres apostar?:");
                    try {
                        apuestaHumano = sc.nextInt();
                    }catch (InputMismatchException e){
                        System.err.print("\nERRROR: Has de elegir un número entre 1 y "+canicasHumano+"\n");
                        sc.nextLine();
                    }
                }while (apuestaHumano > canicasHumano || apuestaHumano <= 0);

                // ahora el jugador humano tiene que adivinar si la máquina tiene número par o impar de canicas
                // si jugador humano introduce cualquier cosa que no sea par o impar (Da igual que contenga mayúsculas) se lo volverá a solicitar
                do{
                    System.out.printf("\nJugador "+jugadorHumano+" ¿Que crees que tiene el Jugador 2? (Par / Impar):");
                    parOimparHumano = sc.next();
                    parOimparHumano = parOimparHumano.toLowerCase();
                }while (!parOimparHumano.equals("par") && !parOimparHumano.equals("impar") );

                //ahora la maquina hace su propia apuesta y al igual que en el turno anterior solo podrá elegir entre 1 y su máximo de canicas
            apuestaMaquina = (int)(Math.random()*canicasMaquina)+1;
                System.out.println();

                // ahora que hemos salido del bucle porque se ha introducido par o impar, es hora de comparar con la elección de la máquina.
                // Si elegimos par y la maquina tiene par o si elegimos impar y la maquina tiene impar, el jugador humano gana, sino pierde.
                if (parOimparHumano.equals("par") && apuestaMaquina % 2 == 0 || parOimparHumano.equals("impar") && apuestaMaquina % 2 == 1) {
                    ganadorJugadorHumano = true;
                }else{
                    ganadorJugadorHumano = false;
                }

                // imprimimos resultado como en el turno anterior
                System.out.printf("Resultado:\n\n");
                resultado = (Math.min(apuestaHumano, apuestaMaquina));

                // Dependiendo de si jugador humano ganó o perdió se hará el reparto de canicas correspondiente
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
                // Como el turno era en 1, ahora cambiamos el turno para que juegue el otro jugador.
                turno = 0;
            }
        }
        // una vez que uno de los jugadores ha llegado a cero canicas salimos del bucle while y es hora de observar el veredicto
        // si la maquina tiene cero canicas hemos ganado, si es al contrario hemos perdido.
        if (canicasMaquina == 0) {
            System.out.printf("\nEnhorabuena. ¡Has ganado!\n");
        }else {
            System.out.printf("\nLo lamento. ¡Has perdido!\n");
        }
    }
}