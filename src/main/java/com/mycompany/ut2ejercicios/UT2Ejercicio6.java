/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Martín Palacios Cano
 */
public class UT2Ejercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner entrada = new Scanner(System.in);
        ArrayList<String> listaCalificados = new ArrayList();
        ArrayList<Integer> listaNotas = new ArrayList();

        //Contador
        int i = 1;

        while (i <= 3) {

            System.out.println("Nombre del alumno " + i);
            String nombre = entrada.nextLine();
            int nota = 0;
            boolean notaValida = false;

            while (!notaValida) {
                System.out.println("Nota del alumno " + i);

                try {
                    nota = entrada.nextInt();

                    if (nota < 0) {
                        System.out.println("Error: la nota debe estar entre 0 y 10.");
                    } else {
                        notaValida = true;
                    }

                } catch (Exception e) {
                    System.out.println("Error: debes introducir un número.");
                    entrada.nextLine(); // Limpia la entrada incorrecta
                }
            }

            entrada.nextLine(); // Limpia el buffer

            System.out.println("Alumno: " + nombre);
            System.out.println("Nota: " + nota);

            i++;

            listaCalificados.add(nombre);
            listaNotas.add(nota);

        }
        Guardado listas = new Guardado(listaCalificados, listaNotas);

        // Compruebo si ya existe información guardada
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("calificaciones.txt"));
            Guardado viejo = (Guardado) ois.readObject();
            ois.close();

            // Añado los nuevos alumnos a las listas anteriores
            viejo.getNombres().addAll(listas.getNombres());
            viejo.getNotas().addAll(listas.getNotas());

            // Actualizo el objeto que voy a guardar
            listas = viejo;

        } catch (IOException | ClassNotFoundException e) {
            // Si el archivo no existe o está vacío, simplemente guardamos los datos nuevos
        }

        // Guardo toda la información
        System.out.println("Guardando objeto en archivo binario...");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("calificaciones.txt"))) {

            oos.writeObject(listas);
            System.out.println("Objeto guardado con éxito.");

        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }

    }

    //Creo una clase donde se guarda todo
    public static class Guardado implements Serializable {

        private ArrayList<String> nombres = new ArrayList();
        private ArrayList<Integer> notas = new ArrayList();

        public Guardado(ArrayList<String> nombres, ArrayList<Integer> notas) {
            this.nombres = nombres;
            this.notas = notas;
        }

        public ArrayList<String> getNombres() {
            return nombres;
        }

        public void setNombres(ArrayList<String> nombres) {
            this.nombres = nombres;
        }

        public ArrayList<Integer> getNotas() {
            return notas;
        }

        public void setNotas(ArrayList<Integer> notas) {
            this.notas = notas;
        }
    }

}
