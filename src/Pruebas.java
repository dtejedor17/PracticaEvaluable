import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int canicasJugadorUno = 10, canicasJugadorDos = 10;
        int turnoJugadorUno = 1, turnoJugadorDos = 2;
        int apuestaJugadorUno, apuestaJugadorDos, manoJugadorDos;
        int parOimpar, maquina;
        int turno;
        turno = (int)(Math.random()*2);
        maquina = (int)(Math.random()*2);
        manoJugadorDos = (int)(Math.random()*canicasJugadorDos);
        System.out.println("Comienza el juego");
        do{
            if (turno==1){
                System.out.println("El jugador 2 intenta adivinar si el jugador 1 tiene un número par o impar de canicas. ");
                System.out.println();
                System.out.println("************************* TURNO JUGADOR 2 **************************");
                System.out.println("Jugador 1, ¿Cuántas canicas quieres apostar?: ");
                apuestaJugadorUno = sc.nextInt();
                manoJugadorDos = (int)(Math.random()*canicasJugadorDos);
                if (apuestaJugadorUno <= canicasJugadorUno){
                    if (apuestaJugadorUno % 2 == maquina && manoJugadorDos !=0){

                        System.out.println("Resultado");
                        System.out.println("Jugador 1 GANAS "+apuestaJugadorUno+ " canicas ya que el Jugador 2 tenía "+manoJugadorDos+" canicas.");
                        System.out.println("Jugador 2 cree que el Jugador 1 tiene un número par");
                        if (apuestaJugadorUno >= manoJugadorDos) {
                            canicasJugadorUno = canicasJugadorUno + manoJugadorDos;
                            canicasJugadorDos = canicasJugadorDos - manoJugadorDos;
                        }else{
                            canicasJugadorUno = canicasJugadorUno + apuestaJugadorUno;
                            canicasJugadorDos = canicasJugadorDos - apuestaJugadorUno;
                        }

                        System.out.println("Jugador 1 tiene "+ canicasJugadorUno+ " canicas");
                        System.out.println("Jugador 2 tiene "+ canicasJugadorDos+ " canicas");

                    }else{

                        System.out.println("Resultado");
                        System.out.println("Jugador 1 PIERDES "+apuestaJugadorUno+ " canicas ya que el jugador 2 tenía "+manoJugadorDos+" canicas");
                        canicasJugadorUno = canicasJugadorUno + manoJugadorDos;
                        canicasJugadorDos = canicasJugadorDos - manoJugadorDos;
                        System.out.println("Jugador 1 tiene "+ canicasJugadorUno+ " canicas");
                        System.out.println("Jugador 2 tiene "+ canicasJugadorDos+ " canicas");

                    }
                }


            }else{
                System.out.println();
                System.out.println("************************* TURNO JUGADOR 1 **************************");
                System.out.println("Jugador 1, ¿Cuántas canicas quieres apostar?: ");
                apuestaJugadorUno = sc.nextInt();
                System.out.println("Jugador 1, ¿Que crees que tiene el Jugador 2 (Par/Impar?");
                parOimpar = sc.nextInt();

            }



        }while (canicasJugadorUno != 0 || canicasJugadorDos != 0);


    }
}


