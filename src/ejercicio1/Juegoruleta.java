package ejercicio1;

import java.util.ArrayList;
import java.util.Random;


public class Juegoruleta {
    // El primer juego monolimpico del planeta
    // consta el saber si el mono miente o no
    // si acierta el mono mentiroso jugara ruleta rusa
    // y si el mono cantante falla el jugara la ruleta rusa

    private ArrayList<JugadorRuleta> listJugadores = new ArrayList<>();
    private int participantesActivos;
    private boolean isPlaying;
    private String[] clasificacion;


    public Juegoruleta(Participante[] participantes, int cantidadParticipantes) {
        int contTurnos = 1;
        System.out.println("cargando jugadores....");
        procesadorDeParticipantes(participantes);
        setisPlaying(true);
        setParticipantesActivos(cantidadParticipantes);
        System.out.println("Inicia Simulacion 0/  0?");
        while (getisPlaying()) {
            System.out.println("Turno " + contTurnos);
            for (JugadorRuleta jugadorRuleta : listJugadores ) {
                jugadorRuleta.jugadorDispara();
                if (jugadorRuleta.getIsDead()) {
                    resetJugadores(jugadorRuleta);
                    break;
                }
            }
            contTurnos++;
        }
        printClasificacion();
    }



    //getter and setter


    public boolean getisPlaying() {
        return isPlaying;
    }

    public void iniciarSimulacion(Participante[] participantes, int cantidadParticipantes) {
        int contTurnos = 1;
        System.out.println("cargando jugadores....");
        procesadorDeParticipantes(participantes);
        setParticipantesActivos(cantidadParticipantes);
        this.participantesActivos=cantidadParticipantes;
        System.out.println("Inicia Simulacion 0/  0?");
        while (isPlaying) {
            System.out.println("Turno " + contTurnos);


            for (JugadorRuleta jugadorRuleta : listJugadores ) {
                jugadorRuleta.jugadorDispara();
                if (jugadorRuleta.getIsDead()) {
                    resetJugadores(jugadorRuleta);
                }
            }
            contTurnos++;
        }
    }

    public int getParticipantesActivos() {
        return participantesActivos;
    }

    public String[] getClasificacion() {
        return clasificacion;
    }

    public void setParticipantesActivos(int participantesActivos) {
        this.participantesActivos = participantesActivos;
        this.clasificacion = new String[participantesActivos];
    }





    // clases revolver
    public class Revolver {
        private int posicionBala;
        private int cabina ;

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








        public void procesadorDeParticipantes (Participante[] participantes) {
            ArrayList<JugadorRuleta> listParticipante = new ArrayList<>();
            for (Participante participante : participantes) {
                JugadorRuleta jugadorRuleta= new JugadorRuleta(participante);
                listParticipante.add(jugadorRuleta);
            }
            this.listJugadores = listParticipante;
        }

        // su funcion es que cuando muere un jugador  que los jugadores vuelvan a sortear sus revolver
        public void resetJugadores (JugadorRuleta jugadorEliminado) {
            this.clasificacion[participantesActivos-1] = jugadorEliminado.participante.getNombre();
            this.listJugadores.remove(jugadorEliminado);
            for (JugadorRuleta jugadorRuleta : listJugadores ) {
                jugadorRuleta.sortearNuevamenteRevolvers();
            }
            this.participantesActivos--;
            if (participantesActivos==1) {
                setisPlaying(false);
                this.clasificacion[0] = listJugadores.get(0).participante.getNombre();
            }
        }


    public void setisPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public void printClasificacion () {
            int contPosicion = 1;
            for (String nombreParticipantesClasificados : getClasificacion()) {
                System.out.println("Participante " + nombreParticipantesClasificados + " OCUPO LA POSICION " + contPosicion);
                contPosicion++;
            }
        }


    public class JugadorRuleta{
        private Participante participante;
        private boolean isDead = false;
        private Revolver revolver;

        public JugadorRuleta(Participante participante) {
            this.participante = participante;
            this.revolver = new Revolver();
        }


        public void jugadorDispara() {
            System.out.println(participante.getNombre() + " APRIETA NUEVAMENTE EL GATILLO");
            if (this.revolver.apretarGatillo()) {
                System.out.println(participante.getNombre() + " HA MUERTO");
                this.isDead = true;
            } else {
                this.isDead = false;
            }
        }


        public void sortearNuevamenteRevolvers() {
            this.revolver = new Revolver();
        }

        public boolean getIsDead() {
            return isDead;
        }
    } // fin jugador Ruleta







}//fin clase juego

    // El primer juego monolimpico del planeta
    // consta el saber si el mono miente o no
    // si acierta el mono mentiroso jugara ruleta rusa
    // y si el mono cantante falla el jugara la ruleta rusa

