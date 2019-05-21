/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

/**
 *
 * @author navar
 */
public class Alumno extends Persona {

    private int edad;
    private Curso curso;

    public Alumno() {
    }

    public Alumno(int edad, Curso curso, String nombre, String apellido1, String apellido2) {
        super(nombre, apellido1, apellido2);
        this.setEdad(edad);
        this.setCurso(curso);
    }

    public Alumno(Alumno p) {
        super(p);
        this.setEdad(p.edad);
        this.setCurso(p.curso);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 17) {
            this.edad = edad;
        } else {
            this.edad = 0;
        }

    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Curso: " + this.getCurso().getCurso() + " " + this.getCurso().getTitulo());
    }

}
