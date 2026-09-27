/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author maste
 */
public class UT2Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File origen = new File("logo.png");
        File destino = new File("logo_copia.png");

        System.out.println("=== Copia de imagen ===");

        try (FileInputStream fis = new FileInputStream(origen); FileOutputStream fos = new FileOutputStream(destino)) {

            byte[] buffer = new byte[4096];
            int bytesLeidos;
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLeidos);
            }

            System.out.println("Copia completada correctamente.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
