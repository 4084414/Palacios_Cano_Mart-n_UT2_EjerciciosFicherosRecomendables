/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ut2ejercicios;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Martín Palacios Cano
 */
public class UT2Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (RandomAccessFile fichero = new RandomAccessFile("datos.dat", "rw")) {

            // Escribo 3 nº enteros consecutivos; nunca antes he usado el writeInt
            fichero.writeInt(1);
            fichero.writeInt(2);
            fichero.writeInt(3);

            System.out.println("Números escritos.");
            
            
            // Salto directamente a la posición del segundo número
            // Cada int ocupa 4 bytes, por lo que el segundo empieza en la posición 4
            //Sinceramente, de esto no tenía ni idea y he tenido que investigarlo
            fichero.seek(4);

            // Modificamos el segundo número
            fichero.writeInt(999);

            System.out.println("El número 2 cambiado a 999 (espero).");

            // vuelvo al principio del archivo
            fichero.seek(0);

            // Lee los 3 nºs para comprobar
            System.out.println("\nContenido del archivo:");
            
            //los mete en variables
            int numero1 = fichero.readInt();
            int numero2 = fichero.readInt();
            int numero3 = fichero.readInt();
            //Muestra las variables
            System.out.println("Número 1: " + numero1);
            System.out.println("Número 2: " + numero2);
            System.out.println("Número 3: " + numero3);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
