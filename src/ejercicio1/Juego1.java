package ejercicio1;

import java.util.ArrayList;
import java.util.Random;

public class Juego1 extends Juego{

    // El primer juego monolimpico del planeta
    // consta el saber si el mono miente o no
    // si acierta el mono mentiroso jugara ruleta rusa
    // y si el mono cantante falla el jugara la ruleta rusa


    // clases revolver
    public class Revolver {
        int posicionBala;
        int cabina = 0;

        public Revolver() {
            Random random = new Random();
            this.posicionBala = random.nextInt(6);
        }

        public boolean apretarGatillo() {
            if (cabina==posicionBala) {
                System.out.println("BOOMMMM!!!!!!!!!!!");
                return true;
            }
            System.out.println("SE SALVO POR AHORA .....");
            this.cabina++;
            return false;
        }
    }//fin clase revolver



    public class JugadorRuleta{
        private Participante participante;
        private boolean isDead = false;
        private Revolver revolver;

        public JugadorRuleta(Participante participantes) {
                this.participante = participante;
                this.revolver = new Revolver();
        }



        public boolean jugadorDispara() {
            if (this.revolver.apretarGatillo()) {
                System.out.println(participante.getNombre() + "HA MUERTO");
            } else {
                isDead = false;
            }
            return isDead;
        }
    } // fin jugador Ruleta

    public class Juegoruleta {

        ArrayList<JugadorRuleta> jugadores = new ArrayList<>();

        public void iniciarSimulacion(Participante[] participantes, int cantidadParticipantes) {
            boolean juego = true;
            int contTurnos = 1;
            System.out.println("cargando jugadores....");

            System.out.println("Inicia Simulacion 0/  0?");
            while (juego) {
                System.out.println("Turno " + contTurnos);
                System.out.println();
                contTurnos++;
            }
        }






    }


}//fin clase juego

    // El primer juego monolimpico del planeta
    // consta el saber si el mono miente o no
    // si acierta el mono mentiroso jugara ruleta rusa
    // y si el mono cantante falla el jugara la ruleta rusa

