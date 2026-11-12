import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculoLogaritmo {

    public static double logaritmo(double valor) {
        if (valor <= 0) {
            throw new ArithmeticException("El valor debe ser mayor que cero");
        }
        return Math.log(valor);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.print("Ingrese un numero: ");
            double numero = teclado.nextDouble();
            double resultado = logaritmo(numero);
            System.out.println("Logaritmo natural de " + numero + " = " + resultado);
        } catch (InputMismatchException e) {
            System.out.println("Error: debe ingresar un valor numerico");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            teclado.close();
            System.out.println("Fin del programa");
        }
    }
}
