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
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Yoser
 */
public class Inscripciones {
    public double valor;
    public LocalDate fecha_inscripcion;
    public int mascota;
    public int concurso;

    public Inscripciones(double valor, LocalDate fecha_inscripcion) {
        this.valor = valor;
        this.fecha_inscripcion = fecha_inscripcion;
        this.mascota = 0;
        this.concurso = 0;
    }

    public double getValor() {
        return valor;
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
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

    public int getConcurso() {
        return concurso;
    }

    public void setConcurso(int concurso) {
        this.concurso = concurso;
    }

    

    @Override
    public String toString() {
        return "Inscripciones{" + "valor=" + valor + ", fecha_inscripcion=" + fecha_inscripcion + ", mascota=" + mascota + ", concurso=" + concurso + '}';
    }

    public void saveFile(String nomFile) {
        try ( PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile), true))) {
            pw.print(valor + "|" + fecha_inscripcion + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static Inscripciones nextInscripcion(Scanner sc){
        sc.useDelimiter("\n");
        System.out.println("Ingrese el nombre de la mascota");
        int id = Util.nextID("Inscripciones.txt");
        String mascota=sc.nextLine();
        System.out.println("Ingrese el nombre del concurso");
        String concurso = sc.nextLine();
        System.out.println("Ingrese el valor a pagar");
        Double valor = sc.nextDouble();
        System.out.println("Ingrese la fecha de la inscripcion en este formato: año-mes-dia");
        String fecha = sc.next();
        LocalDate fechaFin = LocalDate.parse(fecha);
        int idConcurso = Premio.idDueño(concurso);
        int idmascota= Premio.idMascota(mascota);
        
        Inscripciones nuevo = new Inscripciones(valor,fechaFin);
        nuevo.setMascota(idmascota);
        nuevo.setConcurso(idConcurso);
        return nuevo; 
    }
    
}
