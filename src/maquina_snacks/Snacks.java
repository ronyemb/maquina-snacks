package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {

    private static final List<Snack> snacks;

    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 70.0));
        snacks.add(new Snack("Refresco", 50.0));
        snacks.add(new Snack("Sandwich", 120.0));
    }

    public static void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public static void mostrarSnacks() {
        String inventarioSnacks = "";
        for(var snack: snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el Inventario ---");
        System.out.printf(inventarioSnacks);
    }

    public static List<Snack> listarSnacks(){
        return snacks;
    }

}

