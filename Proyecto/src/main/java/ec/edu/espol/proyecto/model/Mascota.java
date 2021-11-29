 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.model;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Yoser
 */
public class Mascota {
    private int id;
    private String nombreM;
    private String raza;
    private LocalDate fechaNacimiento;
    private String tipo;
    private int idDueño;
    private Dueño dueñoM;
    private ArrayList<Inscripciones> inscripciones;
    
    public Mascota(int id, String nombre,String raza, LocalDate fecha,String tipo, int idDueño, Dueño dueño, ArrayList<Inscripciones> ins){
        this.id= id;
        this.nombreM = nombre;
        this.raza = raza;
        this.fechaNacimiento = fecha;
        this.tipo = tipo;
        this.idDueño = idDueño;
        this.dueñoM = dueño;
        this.inscripciones = ins;
        
    }
    
    //getters
    public int getId() {
        return id;
    }

    public String getNombreM() {
        return nombreM;
    }

    public String getRaza() {
        return raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public Dueño getDueñoM() {
        return dueñoM;
    }

    public ArrayList<Inscripciones> getInscripciones() {
        return inscripciones;
    }
    
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public void setDueñoM(Dueño dueñoM) {
        this.dueñoM = dueñoM;
    }

    public void setInscripciones(ArrayList<Inscripciones> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    public static Mascota nextMascota(Scanner sc){
        System.out.println("ingrese datos de la mascota para agregar");
        System.out.println("id");
        int id = sc.nextInt();
        System.out.println("nombre");
        String nombre = sc.next();
        System.out.println("raza");
        String raza = sc.next();
        System.out.println("fecha nacimiento de la siguiente forma: año-mes-dia");
        String date = sc.next();
        LocalDate fecha = LocalDate.parse(date);
        
    }
    
    
}
