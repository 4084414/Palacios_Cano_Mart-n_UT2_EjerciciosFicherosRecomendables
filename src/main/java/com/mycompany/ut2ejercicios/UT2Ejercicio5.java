/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author maste
 */
public class UT2Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String rutaFichero = "quijote.txt";

        int c = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                c++;
            }
            if (c == 0) {
                System.out.println("No hay ninguna linea");
            } else {
                System.out.println("Lineas: " + c);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }

    }

}
