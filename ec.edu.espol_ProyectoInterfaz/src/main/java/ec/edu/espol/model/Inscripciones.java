/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Yoser
 */
public class Inscripciones {

    private int id;
    private double valor;
    private LocalDate fecha_inscripcion;
    private int idmascota;
    private int idconcurso;

    public Inscripciones(int id, int idM, int idC, double valor, LocalDate fecha_inscripcion) {
        this.valor = valor;
        this.fecha_inscripcion = fecha_inscripcion;
        this.idmascota = idM;
        this.idconcurso = idC;
    }

    public double getValor() {
        return valor;
    }
    
    public int getId(){
        return this.id;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(LocalDate fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getMascota() {
        return idmascota;
    }

    public void setMascota(int mascota) {
        this.idmascota = mascota;
    }

    public int getConcurso() {
        return idconcurso;
    }

    public void setConcurso(int concurso) {
        this.idconcurso = concurso;
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "valor=" + valor + ", fecha_inscripcion=" + fecha_inscripcion + ", mascota=" + idmascota + ", concurso=" + idconcurso + '}';
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
        Inscripciones e = (Inscripciones) o;
        return e.getId() == this.getId();
    }

    public void saveFile(String nomFile) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomFile, true)) ) {
            br.write(id + "|" + idmascota + "|" + idconcurso + "|" + valor + "|" + fecha_inscripcion);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static Inscripciones nextInscripcion(Scanner sc) {
        sc.useDelimiter("\n");
        int id = Util.nextID("Inscripciones.txt");
        System.out.println("Ingrese el nombre de la mascota");
        String mascota = sc.next();
        System.out.println("Ingrese el nombre del concurso");
        String concurso = sc.next();
        System.out.println("Ingrese el valor a pagar");
        Double valor = sc.nextDouble();
        System.out.println("Ingrese la fecha de la inscripcion en este formato: año-mes-dia");
        String fecha = sc.next();
        LocalDate fechaFin = LocalDate.parse(fecha);
        int idConcurso = Premio.idDueño(concurso);
        int idmascota = Premio.idMascota(mascota);

        Inscripciones nuevo = new Inscripciones(id, idConcurso, idmascota, valor, fechaFin);

        return nuevo;
    }
  
}
