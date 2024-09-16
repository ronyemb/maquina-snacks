package archivos;

import java.io.*;

public class LeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);
        try{
            System.out.println("Contenido del archivo: ");
            var entrada = new BufferedReader(new FileReader(archivo));
            var linea = entrada.readLine();
            while( linea!= null){
                System.out.println(linea);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e) {
            System.out.println("Error al leer archivo; " + e.getMessage());
            e.printStackTrace();
        }
    }
}
