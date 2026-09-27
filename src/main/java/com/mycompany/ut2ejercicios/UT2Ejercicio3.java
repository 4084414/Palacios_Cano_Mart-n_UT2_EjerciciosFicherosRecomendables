/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import java.io.File;

/**
 *
 * @author maste
 */
public class UT2Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File carpeta = new File("MurciaFP/2026/AccesoDatos");
        
        if (carpeta.mkdirs()) {
            System.out.println("Estructura de carpetas creada");
        } else if (carpeta.exists()) {
            System.out.println("La estructura de carpetas ya existe.");
        } else {
            System.out.println("Error, ha fallado por algún motivo");
            return;
        }
        
        File nuevaCarpeta = new File("MurciaFP/2026/AD_Backup");
        
        if (carpeta.renameTo(nuevaCarpeta)) {
            System.out.println("La renombración ha ocurrido correctamente");
        } else {
            System.out.println("Fallo: No se ha podido renombrar la carpeta.");
        }
    }
    
}
