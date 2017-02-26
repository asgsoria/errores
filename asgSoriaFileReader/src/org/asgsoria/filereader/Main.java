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
import java.util.Scanner;
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
    public static void main(String[] args) throws SaldoInsuficiente {
        boolean salir = false;
        String saldoEnCuenta = leerSaldoDesdeFichero("src/org/asgsoria/filereader/cuentaBancaria.txt");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--------------------------------------");
            System.out.println("|         EL BANCO DE ALVARO         |");
            System.out.println("--------------------------------------");
            System.out.println("1. Sacar dinero");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción del menu: ");
            String seleccion = sc.nextLine();
            switch (seleccion) {
                case "1":
                    System.out.println("Introduce la cantidad de dinero que quieres sacar: ");
                    String cantidadDemandada = sc.nextLine();
                    try {
                        if (Integer.parseInt(saldoEnCuenta) < Integer.parseInt(cantidadDemandada)) {
                            throw new SaldoInsuficiente();
                        } else {
                            saldoEnCuenta = (Integer.parseInt(saldoEnCuenta) - Integer.parseInt(cantidadDemandada)) + "";
                            escribirSaldoEnFichero(saldoEnCuenta, "src/org/asgsoria/filereader/cuentaBancaria.txt");
                            System.out.println("Tenga su dinero:");
                            System.out.println("----------------------------------");
                            System.out.println("|                                  |");
                            System.out.println("|             " + cantidadDemandada + "       |");
                            System.out.println("|                                    |");
                            System.out.println("----------------------------------------");
                        }
                    } catch (SaldoInsuficiente ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Su saldo es: " + saldoEnCuenta);
                  
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    salir = true;
                    break;
            }
        } while (salir == false);

    }

    public static void escribirSaldoEnFichero(String saldo, String ruta) {
        try {
            PrintWriter writer = new PrintWriter(ruta, "UTF-8");
            writer.println(saldo);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
        }
    }

    public static String leerSaldoDesdeFichero(String ruta) {
        File cuentaBancaria = new File(ruta);
        String saldo = null;
        String linea;
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
        return saldo;
    }

}
