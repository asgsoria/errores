/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.asgsoria.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.asgsoria.exceptions.SaldoInsuficiente;

/**
 *
 * @author Rubén
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String saldoEnCuenta = leerSaldoDesdeFichero("src/org/asgsoria/filereader/cuentaBancaria.txt");

    }
    
    public static String leerSaldoDesdeFichero(String ruta){
      File cuentaBancaria = new File(ruta);
        String saldo = null;
        String linea;
//        try{
//          PrintWriter writer = new PrintWriter("cuentaBancaria.txt", "UTF-8");
//          writer.println("saldo:100");
//          writer.close();
//      } catch (IOException e) {
//          System.out.println("Error al crear el archivo");
//      }
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(cuentaBancaria);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer el archivo " + ex.getMessage());
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while ((linea = bufferedReader.readLine()) != null) {
               saldo = linea;
            }
        } catch (IOException ex) {
            System.out.println("Error al leer las lineas del fichero");
        }
        try {
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Error al cerrar el fichero");
        }
    return saldo;}

}
