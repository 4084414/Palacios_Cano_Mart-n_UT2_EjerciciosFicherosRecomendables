/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ut2ejercicios;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author maste
 */
public class UT2Ejercicios1 {

    public static void main(String[] args) {
        // 1. Definimos una ruta base para las prácticas del ciclo
        String rutaBase = "C:/ficheros_dam";
        File directorioBase = new File(rutaBase);

        System.out.println("=== Comprobando Carpeta===");

        // 2. Creación de directorios
        if (!directorioBase.exists()) {
            if (directorioBase.isDirectory()) {
                System.out.println("Directorio '" + rutaBase + "' creado con éxito.");

                
            }
        } else {
            System.out.println("ℹ El directorio '" + rutaBase + "' ya existía.");
            //Obtenemos los archivos
                File[] archivos = directorioBase.listFiles();

                int cArchivos = 0;
                //Los contamos
                if (archivos != null) {
                    for (File archivo : archivos) {
                        if (archivo.isFile()) {
                            cArchivos++;
                        }
                    }
                }

                System.out.println("La carpeta '" + rutaBase + "' existe y es un directorio.");
                System.out.println("Contiene " + cArchivos + " archivo(s).");
        }

        // 3. Creación de un fichero dentro del directorio recién validado
        File nuevoFichero = new File(directorioBase, "setup.log");
        if (directorioBase.mkdir()) {

            try {
                if (nuevoFichero.createNewFile()) {
                    System.out.println("Fichero '" + nuevoFichero.getName() + "' creado correctamente.");
                } else {
                    System.out.println("ℹ El fichero '" + nuevoFichero.getName() + "' ya existe en el disco.");
                }

            } catch (IOException e) {
                System.err.println("Error al crear el archivo físico: " + e.getMessage());
            }
        }
    }
}
