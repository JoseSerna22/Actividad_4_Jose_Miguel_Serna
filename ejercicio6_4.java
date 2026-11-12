public class PruebaExcepciones {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            System.out.println("Dentro del try");
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Excepcion capturada: " + e.getMessage());
        } finally {
            System.out.println("Bloque finally");
        }

        System.out.println("Fin del programa");
    }
}
