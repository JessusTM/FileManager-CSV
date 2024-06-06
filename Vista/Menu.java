package Vista;

import java.util.List;
import java.util.Scanner;
import Controlador.ControladorPersona;
import Controlador.Csv;
import Modelo.Persona;

public class Menu {
    public void menuCsv() {
        Scanner lector = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("==========================");
            System.out.println("        Formulario        ");
            System.out.println("           CSV            ");
            System.out.println("==========================");
            System.out.println("  [1] Agregar persona     ");
            System.out.println("  [2] Mostrar personas    ");
            System.out.println("  [3] Eliminar persona    ");
            System.out.println("  [4] Modificar persona   ");
            System.out.println("  [5] Salir               ");
            System.out.println("==========================");
            System.out.print("  Opción  : ");
            opcion = lector.nextLine();
            System.out.println("==========================");

            switch (opcion) {
                case "1" -> {
                    Persona nuevaPersona = ControladorPersona.agregarPersona();
                    Csv.agregarPersonaCsv(nuevaPersona);
                }
                case "2" -> {
                    List<Persona> personas = Csv.listadoPersonas();
                    for (Persona persona : personas) {
                        ControladorPersona.mostrarPersona(persona);
                    }
                }
                case "3" -> {
                    List<Persona> personas = Csv.listadoPersonas();
                    for (Persona persona : personas) {
                        ControladorPersona.mostrarPersona(persona);
                    }
                    ControladorPersona.eliminarPersona();
                }
                case "4" -> {
                    List<Persona> listaPersonasMod = Csv.listadoPersonas();
                    for (Persona persona : listaPersonasMod) {
                        ControladorPersona.mostrarPersona(persona);
                    }
                    ControladorPersona.modificarPersona(listaPersonasMod);
                }
                case "5" -> {
                    System.out.println("Hasta luego...");
                    System.exit(0);
                }
                default -> System.out.println("Ingrese una opción válida...");
            }
        } while (!opcion.equals("5"));
    }
}

