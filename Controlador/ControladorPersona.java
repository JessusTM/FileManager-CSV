package Controlador;

import Modelo.Persona;
import java.util.Scanner;
import java.util.List;

public class ControladorPersona {
    public static Persona agregarPersona() {
        Scanner lector = new Scanner(System.in);

        System.out.println("\n ----- AGREGAR PERSONA ----- ");

        System.out.print("    Rut       : ");
        String rut          = lector.nextLine();

        System.out.print("    Nombre    : ");
        String nombre       = lector.nextLine();

        System.out.print("    Apellido 1: ");
        String apellido1    = lector.nextLine();

        System.out.print("    Apellido 2: ");
        String apellido2    = lector.nextLine();

        System.out.print("    Edad      : ");
        int edad            = Integer.parseInt(lector.nextLine());

        System.out.print("    Dirección : ");
        String direccion    = lector.nextLine();

        System.out.print("    Ciudad    : ");
        String ciudad       = lector.nextLine();

        System.out.print("    Teléfono  : ");
        int telefono        = Integer.parseInt(lector.nextLine());

        return new Persona(rut, nombre, apellido1, apellido2, edad, direccion, ciudad, telefono);
    }

    // ----- MOSTRAR PERSONA -----
    public static void mostrarPersona(Persona persona) {
        System.out.println(persona.toString());
    }

    // ----- ELIMINAR PERSONA -----
    public static void eliminarPersona() {
        Scanner lector = new Scanner(System.in);
        System.out.println("\n ----- ELIMINAR PERSONA ----- ");
        System.out.print("    RUT: ");
        String rut = lector.nextLine();
        Csv.eliminarPersonaPorRut(rut);
    }

    // ----- MODIFICAR PERSONA -----
    public static void modificarPersona(List<Persona> listaPersonas) {
        Scanner lector = new Scanner(System.in);
        System.out.println(" ----- MODIFICAR PERSONA ----- ");
        System.out.print("    RUT: ");
        String rut = lector.nextLine();
        boolean personaEncontrada = false;
        for (Persona persona : listaPersonas) {
            if (persona.getRut().equals(rut)) {
                System.out.println("Persona encontrada");
                mostrarPersona(persona);
                System.out.print("    [NUEVO] Nombre    : ");
                String nuevoNombre      = lector.nextLine();
                System.out.print("    [NUEVO] Apellido 1: ");
                String nuevoApellido1   = lector.nextLine();
                System.out.print("    [NUEVO] Apellido 2: ");
                String nuevoApellido2   = lector.nextLine();
                System.out.print("    [NUEVO] Edad      : ");
                int nuevaEdad           = Integer.parseInt(lector.nextLine());
                System.out.print("    [NUEVO] Dirección : ");
                String nuevaDireccion   = lector.nextLine();
                System.out.print("    [NUEVO] Ciudad    : ");
                String nuevaCiudad      =     lector.nextLine();
                System.out.print("    [NUEVO] Teléfono  : ");
                int nuevoTelefono       = Integer.parseInt(lector.nextLine());

                persona.setNombre(nuevoNombre);
                persona.setApellido1(nuevoApellido1);
                persona.setApellido2(nuevoApellido2);
                persona.setEdad(nuevaEdad);
                persona.setDireccion(nuevaDireccion);
                persona.setCiudad(nuevaCiudad);
                persona.setTelefono(nuevoTelefono);

                Csv.modificarPersona(persona);

                System.out.println("Persona modificada correctamente");
                personaEncontrada = true;
                break;
            }
        }
        if (!personaEncontrada) {
            System.out.println("No se encontró ninguna persona con el RUT " + rut);
        }
    }
}

