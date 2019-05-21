/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author navar
 */
public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Alumno(int edad, Curso curso, String nombre, String apellido1, String apellido2)
        ArrayList<Alumno> lista_alumnos = new ArrayList<>();
        lista_alumnos.add(new Alumno(15, new Curso("4º", "E.S.O"), "Pepito", "Perez", "Lopez"));
        lista_alumnos.add(new Alumno(20, new Curso("2º", "Bachiller"), "Fulanito", "Hernandez", "Gomez"));
        lista_alumnos.add(new Alumno(13, new Curso("2º", "E.S.O"), "Juanito", "Garcia", "Jimenez"));
        lista_alumnos.add(new Alumno(12, new Curso("1º", "E.S.O"), "Menganita", "Fernandez", "Gutierrez"));

        obtenerAlumnos(lista_alumnos);
    }

    public static void obtenerAlumnos(ArrayList<Alumno> lista) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el ID del alumno a buscar");
        int id = lector.nextInt();
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < lista.size()) {
            if (id == lista.get(i).getId()) {
                encontrado = true;
                lista.get(i).mostrarDatos();
            } else {
                i++;
            }
        }
        if (!encontrado){
            System.out.println("Alumno no encontrado");
        }
        

    }

}
