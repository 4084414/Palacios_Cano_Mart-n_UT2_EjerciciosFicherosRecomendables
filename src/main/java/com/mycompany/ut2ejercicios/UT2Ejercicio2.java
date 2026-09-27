/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Martín Palacios Cano
 */
public class UT2Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Dime ruta: ");
        String rutaBase = entrada.nextLine();
        // 1. Definimos una ruta base para las prácticas del ciclo

        File directorioBase = new File(rutaBase);

        System.out.println("=== Comprobando Carpeta===");

        // Comprobamos que la ruta introducida sea un directorio
        if (directorioBase.exists()) {
            if (directorioBase.isFile()) {

                // Buscamos el archivo temp.bak dentro de la carpeta
                File archivoTemp = new File(directorioBase, "temp.bak");

                // Comprobamos si el archivo existe
                if (archivoTemp.exists()) {

                    // Intentamos eliminarlo
                    if (archivoTemp.delete()) {
                        System.out.println("El archivo 'temp.bak' ha sido aniquilado.");
                    } else {
                        System.out.println("No se ha podido borrar el archivo 'temp.bak'.");
                    }

                } else {
                    System.out.println("El archivo 'temp.bak' no existe");
                }
            } else {
                System.out.println("El archivo no es un directorio");
            }

        } else {
            System.out.println("La ruta indicada no existe");
        }

        entrada.close();
    }
}
