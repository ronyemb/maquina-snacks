package maquina_snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {

    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        boolean salir = false;
        var consola = new Scanner(System.in);
        List<Snack> productos = new ArrayList<>();

        System.out.println("*** Máquina de Snacks ***");
        Snacks.mostrarSnacks();

        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, productos);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                Menu:
                1. Comprar Snack
                2. Mostrar Snack
                3. Agregar nuevo Snack
                4. Salir
                Elige una opción: \s""");
        return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos) {
        boolean salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Regresa Pronto!");
                salir = true;
            }
            default -> System.out.println("Opción Inválida: " + opcion);
        }
        return salir;
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        System.out.println("Que snack quieres comprar (id)?");
        var idSnack = Integer.parseInt(consola.nextLine());
        boolean snackEncontrado = false;

        for (var snack : Snacks.listarSnacks()) {
            if (idSnack == snack.getIdSnack()) {
                productos.add(snack);
                System.out.println("Ok, Snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }

        if (!snackEncontrado) {
            System.out.println("Id de snack no encontrado: " + idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos) {
        String ticket = "*** Ticket de Venta ***";
        double total = 0.0;

        for (var producto : productos) {
            ticket += "\n\t-" + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner consola) {
        System.out.println("Nombre del Snack: ");
        var nombre = consola.nextLine();
        System.out.println("Precio del Snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu Snack se ha agregado correctamente");
        Snacks.mostrarSnacks();
    }

}
