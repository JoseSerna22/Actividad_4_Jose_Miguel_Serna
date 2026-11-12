import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerArchivo {

    public static void main(String[] args) {
        BufferedReader lector = null;

        try {
            FileInputStream flujo = new FileInputStream("prueba.txt");
            InputStreamReader entrada = new InputStreamReader(flujo, "UTF-8");
            lector = new BufferedReader(entrada);

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
