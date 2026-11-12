import java.util.ArrayList;

public class EquipoMaratonProgramacion {

    private static final int MINIMO = 2;
    private static final int MAXIMO = 3;
    private static final int LONGITUD_MAXIMA = 20;

    private String nombre;
    private String universidad;
    private String lenguaje;
    private int tamano;
    private ArrayList<Programador> programadores;

    public EquipoMaratonProgramacion(String nombre, String universidad, String lenguaje, int tamano) {
        if (tamano < MINIMO || tamano > MAXIMO) {
            throw new IllegalArgumentException("El equipo debe tener entre " + MINIMO + " y " + MAXIMO + " programadores");
        }
        this.nombre = nombre;
        this.universidad = universidad;
        this.lenguaje = lenguaje;
        this.tamano = tamano;
        this.programadores = new ArrayList<>();
    }

    public boolean estaCompleto() {
        return programadores.size() == tamano;
    }

    public void anadirProgramador(Programador programador) {
        if (estaCompleto()) {
            throw new IllegalStateException("El equipo esta lleno, no se pueden anadir mas programadores");
        }
        programadores.add(programador);
    }

    public static void validarProgramador(String nombre, String apellidos) {
        validarTexto(nombre, "nombre");
        validarTexto(apellidos, "apellidos");
    }

    private static void validarTexto(String texto, String campo) {
        if (texto.length() >= LONGITUD_MAXIMA) {
            throw new IllegalArgumentException("El campo " + campo + " debe tener menos de " + LONGITUD_MAXIMA + " caracteres");
        }
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                throw new IllegalArgumentException("El campo " + campo + " solo debe contener texto");
            }
        }
    }

    public void imprimir() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Universidad: " + universidad);
        System.out.println("Lenguaje: " + lenguaje);
        System.out.println("Tamano: " + tamano);
        System.out.println("Programadores:");
        for (Programador p : programadores) {
            System.out.println("  " + p);
        }
    }
}
