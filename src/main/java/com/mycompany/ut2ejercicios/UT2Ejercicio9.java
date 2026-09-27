/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Martín PC
 */
public class UT2Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rutaFichero = "datos_notas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                try {
                    // Intentamos convertir la línea a número
                    double nota = Double.parseDouble(linea.trim());
                    System.out.println("Nota: " + nota);

                } catch (NumberFormatException e) {
                    // Si no se puede convertir, avisamos y continuamos
                    System.out.println("La línea " + linea.toString() + " no cuenta como nota. La ignoro.");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Aviso: no se ha encontrado el archivo " + rutaFichero);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }

}
