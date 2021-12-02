/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyecto.uil;

import ec.edu.espol.proyecto.model.Dueño;
import java.util.Scanner;

/**
 *
 * @author Yoser
 */
public class Menu {

    private Menu() {};

    
    public static void menuOpciones() {
        int caso;
        do{
        Scanner sc = new Scanner(System.in);
        System.out.println("Eliga una opcion del siguiente menu ");
        System.out.println("1.- Dueño");
        System.out.println("2.- Mascota");
        System.out.println("3.- Concurso");
        System.out.println("4.- Premio");
        System.out.println("5.- Criterio");
        System.out.println("6.- Inscripcion");
        System.out.println("7.- MienbroJurado");
        System.out.println("8.- Evaluacion");
        System.out.println("9.- Salir");
        caso = sc.nextInt();
        
            switch (caso) {
                case 1:
                    caso = 1;
                    Scanner teclado = new Scanner(System.in);
                    Dueño n = Dueño.nextDueño(teclado);
                    n.saveFile("Dueños.txt");
                    break;
                case 2:    
            }
                
        }while (caso != 9); 
    }
}
