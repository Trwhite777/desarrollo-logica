package ejercicio1;
import static ejercicio1.ValidarDatos.*;


public class Participante {
    private String nombre;
    private int edad;
    private String pais;


    public Participante(String nombre , int edad , String pais) {
        setNombre(nombre);
        setEdad(edad);
        setPais(pais);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarCadenasVacias(nombre);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = validarNumeroNegativos(edad);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }




}
