package ejercicio1;
public class Main {
    static void main(String[] args) {
        Participante participante1 = new Participante("juan" , 17,"Venezuela");
        Participante participante2 = new Participante("Mar Antonia" , 18,"Bolivia");
        Participante participante3 = new Participante("Paloma" , 17,"Peru");
        Participante[] participantes = {participante1,participante2,participante3};

        Juegoruleta juegoruleta = new Juegoruleta(participantes,3);

    }
}
