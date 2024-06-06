package Modelo;

import java.time.LocalDate;

public class Persona {
    // ----- ATRIBUTOS -----
    private String      rut, nombre, apellido1, apellido2, ciudad, direccion;
    private int         edad, telefono;
    private LocalDate   fechaNacimiento;

    // ----- CONSTRUCTOR -----
    public Persona( String rut, String nombre, String apellido1, String apellido2,
                    int edad, String direccion, String ciudad, int telefono) {
        this.rut                = rut;
        this.nombre             = nombre;
        this.apellido1          = apellido1;
        this.apellido2          = apellido2;
        this.edad               = edad;
        this.direccion          = direccion;
        this.ciudad             = ciudad;
        this.telefono           = telefono;
        this.fechaNacimiento    = LocalDate.now(); // Fecha de nacimiento actual
    }

    // ----- GETTERS -----
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // ----- SETTERS -----111
    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // ----- TO STRING -----
    @Override
    public String toString() {
        return "\n ----- LISTADO ----- "            +
                "\n    Nombre    : " + nombre       +
                "\n    Apellidos : " + apellido1    + " " + apellido2 +
                "\n    Edad      : " + edad         +
                "\n    Rut       : " + rut          +
                "\n    Dirección : " + direccion    +
                "\n    Ciudad    : " + ciudad       +
                "\n    Teléfono  : " + telefono;
    }
}

