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
public class Concurso {

    private int id;
    private String nombre;
    private LocalDate fechaActual;
    private LocalDate fechaInicioIns;
    private LocalDate fechaFinIns;
    private String tematica;
    private double costo;
    private ArrayList<Inscripciones> inscripciones;
    private ArrayList<Premio> premios;
    private ArrayList<Criterio> criterio;

    public Concurso(int id, String nombre, LocalDate fechaA, LocalDate fechaInicio, LocalDate fechaFin, String tematica, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaActual = fechaA;
        this.fechaInicioIns = fechaInicio;
        this.fechaFinIns = fechaFin;
        this.tematica = tematica;
        this.costo = costo;
        this.inscripciones = new ArrayList<Inscripciones>();
        this.premios = new ArrayList<Premio>();
        this.criterio = new ArrayList<Criterio>();
    }

    //getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaActual() {
        return fechaActual;
    }

    public LocalDate getFechaInicioIns() {
        return fechaInicioIns;
    }

    public LocalDate getFechaFinIns() {
        return fechaFinIns;
    }

    public String getTematica() {
        return tematica;
    }

    public double getCosto() {
        return costo;
    }

    public ArrayList<Inscripciones> getInscripciones() {
        return inscripciones;
    }

    public ArrayList<Premio> getPremios() {
        return premios;
    }

    public ArrayList<Criterio> getCriterio() {
        return criterio;
    }
    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaActual(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }

    public void setFechaInicioIns(LocalDate fechaInicioIns) {
        this.fechaInicioIns = fechaInicioIns;
    }

    public void setFechaFinIns(LocalDate fechaFinIns) {
        this.fechaFinIns = fechaFinIns;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setInscripciones(ArrayList<Inscripciones> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void setPremios(ArrayList<Premio> premios) {
        this.premios = premios;
    }

    public void setCriterio(ArrayList<Criterio> criterio) {
        this.criterio = criterio;
    }

    @Override
    public String toString() {
        return "Concurso{" + "id=" + id + ", nombre=" + nombre + ", fechaActual=" + fechaActual + ", fechaInicioIns=" + fechaInicioIns + ", fechaFinIns=" + fechaFinIns + ", tematica=" + tematica + ", costo=" + costo + '}';
    }
    
    
    public static Concurso nextConcuurso(Scanner sc){
        System.out.println("ingrese datos del concurso");
        sc.useDelimiter("\n");
        System.out.println("");
    }

}
