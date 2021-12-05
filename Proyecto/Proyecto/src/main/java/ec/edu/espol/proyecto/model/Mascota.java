/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.model;

import ec.edu.espol.proyecto.uil.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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

    public Mascota(int id, String nombre, String raza, LocalDate fecha, String tipo, int idDueño) {
        this.id = id;
        this.nombreM = nombre;
        this.raza = raza;
        this.fechaNacimiento = fecha;
        this.tipo = tipo;
        this.idDueño = idDueño;
        this.dueñoM = null;
        this.inscripciones = new ArrayList<Inscripciones>();

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

    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", nombreM=" + nombreM + ", raza=" + raza + ", fechaNacimiento=" + fechaNacimiento + ", tipo=" + tipo + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Mascota e = (Mascota) o;
        return e.getId() == this.getId();
    }

    public void saveFile(String nomFile) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))) {
            pw.println(id + "|" + nombreM + "|" + raza + "|" + fechaNacimiento + "|" + tipo + "|" + idDueño);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Dueño> readFile(String nomFile) {
        ArrayList<Dueño> dueños = new ArrayList<>();
        try ( Scanner sc = new Scanner(new File(nomFile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                //1|joseph|carabajo|0950234459|joemcara@espol.edu.ec
                String[] datos = linea.split("\\|");
                Dueño n = new Dueño(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4]);
                dueños.add(n);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dueños;
    }

    public static int idDueño(String correo) {
        ArrayList<Dueño> lista = Mascota.readFile("Dueños.txt");
        for (Dueño unico : lista) {
            if (unico.getEmail().equals(correo)) {
                return unico.getId();
            }
        }
        return 0;
    }

    public static Mascota nextMascota(Scanner sc) {
        System.out.println("ingrese datos de la mascota para agregar");
        sc.useDelimiter("\n");
        int id = Util.nextID("Mascotas.txt");
        System.out.println("nombre");
        String nombre = sc.next();
        System.out.println("raza");
        String raza = sc.next();
        System.out.println("fecha nacimiento de la siguiente forma: año-mes-dia");
        String date = sc.next();
        LocalDate fecha = LocalDate.parse(date);
        System.out.println("El tipo de mascota");
        String tipo = sc.next();
        System.out.println("Ingrese el correo del dueño");
        String correo = sc.next();
        int idDueño = Mascota.idDueño(correo);

        Mascota nueva = new Mascota(id, nombre, raza, fecha, tipo, idDueño);
        return nueva;
    }

}
