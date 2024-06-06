package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modelo.Persona;

public class Csv {
    // ----- ATRIBUTO -----
    public static final String ARCHIVO_CSV = "Formulario.csv";

    // ----- CREAR ARCHIVO SI NO EXISTE -----
    public static void crearArchivo() {
        try {
            File archivo = new File(ARCHIVO_CSV);

            if (!archivo.exists()) {
                FileWriter fileWriter = new FileWriter(ARCHIVO_CSV, true);
                BufferedWriter escritor = new BufferedWriter(fileWriter);

                escritor.write("Rut,Nombres,Apellido 1,Apellido 2,Edad,Fecha Nacimiento,Ciudad,Teléfono,Dirección");
                escritor.newLine();
                escritor.close();
            }
        } catch (IOException e) {
            System.out.println("El archivo Formulario.csv, aún no ha sido creado: " + e.getMessage());
        }
    }

    // ----- VERIFICAR EXISTENCIA DE RUT -----
    private static boolean existePersonaConRut(String rut) {
        try {
            FileReader fileReader = new FileReader(ARCHIVO_CSV);
            BufferedReader lector = new BufferedReader(fileReader);
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");

                if (campos.length >= 1) {
                    String rutPersona = campos[0].trim();
                    if (rutPersona.equals(rut.trim())) {
                        lector.close();
                        return true; // Ya existe una persona con el mismo RUT
                    }
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println();
        }
        return false; // No existe una persona con el mismo RUT
    }

    // ----- AGREGAR PERSONA CSV -----
    public static void agregarPersonaCsv(Persona nuevaPersona) {
        if (existePersonaConRut(nuevaPersona.getRut())) {
            System.out.println("Ya hay una persona registrada con el mismo rut: " + nuevaPersona.getRut());
            return;
        }

        // -→ Si el archivo no existe
        crearArchivo();

        // -→ Si el archivo ya existe
        try {
            File archivo = new File(ARCHIVO_CSV);
            String atributosPersona = String.format("%s,%s,%s,%s,%d,%s,%s,%d",
                    nuevaPersona.getRut(),
                    nuevaPersona.getNombre(),
                    nuevaPersona.getApellido1(),
                    nuevaPersona.getApellido2(),
                    nuevaPersona.getEdad(),
                    nuevaPersona.getDireccion(),
                    nuevaPersona.getCiudad(),
                    nuevaPersona.getTelefono());

            // ----- Agregar datos al archivo en modo append -----
            FileWriter fileWriter = new FileWriter(ARCHIVO_CSV, true);
            BufferedWriter escritor = new BufferedWriter(fileWriter);
            escritor.write(atributosPersona);
            escritor.newLine();
            escritor.close();
            System.out.println("Persona agregada correctamente");
        } catch (IOException e) {
            System.out.println("Error al agregar la persona: " + e.getMessage());
        }
    }

    // ----- LISTADO DE PERSONAS -----
    public static List<Persona> listadoPersonas() {
        List<Persona> personasData = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(ARCHIVO_CSV);
            BufferedReader lector = new BufferedReader(fileReader);
            String linea;

            // Leer la primera línea para omitir los encabezados
            lector.readLine();

            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");

                if (campos.length >= 8) {
                    String rutPersona           = campos[0].trim();
                    String nombrePersona        = campos[1].trim();
                    String apellido1Persona     = campos[2].trim();
                    String apellido2Persona     = campos[3].trim();
                    int edadPersona             = Integer.parseInt(campos[4].trim());
                    String direccionPersona     = campos[5].trim();
                    String ciudadPersona        = campos[6].trim();
                    int telefonoPersona         = Integer.parseInt(campos[7].trim());

                    Persona persona             = new Persona(  rutPersona  , nombrePersona     , apellido1Persona  , apellido2Persona,
                            edadPersona , direccionPersona  , ciudadPersona     , telefonoPersona);
                    personasData.add(persona);
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Hubo un error al leer Formulario.csv: " + e.getMessage());
        }
        return personasData;
    }

    // ----- ELIMINAR PERSONA POR RUT -----
    public static void eliminarPersonaPorRut(String rut) {
        File archivo        = new File(ARCHIVO_CSV);
        File archivoTemp    = new File("FormularioTemp.csv");

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemp))) {

            String linea;
            boolean personaEncontrada = false;

            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                if (!campos[0].trim().equals(rut.trim())) {
                    escritor.write(linea);
                    escritor.newLine();
                } else {
                    personaEncontrada = true;
                }
            }

            if (personaEncontrada) {
                System.out.println("Persona con RUT " + rut + " eliminada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna persona con el RUT " + rut);
            }

        } catch (IOException e) {
            System.out.println("Error al eliminar la persona: " + e.getMessage());
        }

        archivo.delete();
        archivoTemp.renameTo(archivo);
    }

    // ----- MODIFICAR PERSONA CSV -----
    public static void modificarPersona(Persona personaModificada) {
        File archivo        = new File(ARCHIVO_CSV);
        File archivoTemp    = new File(ARCHIVO_CSV + ".temp");
        try (Scanner lector = new Scanner(archivo);
             BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemp, true))) {

            boolean personaEncontrada = false;
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] campos = linea.split(",");
                if (campos.length >= 1) {
                    String rutPersonaSinEspacios    = campos[0].trim();
                    String rutModificadoSinEspacios = personaModificada.getRut().trim();
                    if (rutPersonaSinEspacios.equals(rutModificadoSinEspacios)) {
                        String nuevaLinea           = String.format("%s,%s,%s,%s,%d,%s,%s,%d",
                                personaModificada.getRut(),
                                personaModificada.getNombre(),
                                personaModificada.getApellido1(),
                                personaModificada.getApellido2(),
                                personaModificada.getEdad(),
                                personaModificada.getDireccion(),
                                personaModificada.getCiudad(),
                                personaModificada.getTelefono());
                        escritor.write(nuevaLinea);
                        escritor.newLine();
                        personaEncontrada = true;
                    } else {
                        escritor.write(linea);
                        escritor.newLine();
                    }
                }
            }
            if (!personaEncontrada) {
                System.out.println("No hay una persona registrada con ese RUT " + personaModificada.getRut());
            }
        } catch (IOException e) {
            System.out.println("No se pudo modificar la persona: " + e.getMessage());
        }
        archivo.delete();
        archivoTemp.renameTo(new File(ARCHIVO_CSV));
    }
}
