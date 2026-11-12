import java.util.Scanner;

public class PruebaEquipo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nombre del equipo: ");
        String nombre = teclado.nextLine();
        System.out.print("Universidad: ");
        String universidad = teclado.nextLine();
        System.out.print("Lenguaje de programacion: ");
        String lenguaje = teclado.nextLine();

        EquipoMaratonProgramacion equipo = null;
        while (equipo == null) {
            System.out.print("Tamano del equipo (2 o 3): ");
            try {
                int tamano = Integer.parseInt(teclado.nextLine());
                equipo = new EquipoMaratonProgramacion(nombre, universidad, lenguaje, tamano);
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero entero");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        while (!equipo.estaCompleto()) {
            System.out.print("Nombre del programador: ");
            String nombreProg = teclado.nextLine();
            System.out.print("Apellidos del programador: ");
            String apellidosProg = teclado.nextLine();

            try {
                EquipoMaratonProgramacion.validarProgramador(nombreProg, apellidosProg);
                equipo.anadirProgramador(new Programador(nombreProg, apellidosProg));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.print("Desea anadir otro programador? (s/n): ");
        if (teclado.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Nombre del programador: ");
            String nombreProg = teclado.nextLine();
            System.out.print("Apellidos del programador: ");
            String apellidosProg = teclado.nextLine();
            try {
                EquipoMaratonProgramacion.validarProgramador(nombreProg, apellidosProg);
                equipo.anadirProgramador(new Programador(nombreProg, apellidosProg));
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println();
        equipo.imprimir();
        teclado.close();
    }
}
