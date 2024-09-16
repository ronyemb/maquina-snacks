package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeerTodo {
    public static void main(String[] args) {
        String nombreArchivo = "mi_archivo.txt";
        var archivo = new File(nombreArchivo);
        try{
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            System.out.println("Contenido del archivo: ");
            for(String linea: lineas){
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo; " + e.getMessage());
            e.printStackTrace();
        }
    }
}
