/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.asgsoria.exceptions;

/**
 *
 * @author Rubén
 */
public class SaldoInsuficiente extends Exception{
    
    SaldoInsuficiente(){
        super("El saldo de la cuenta es insuficiente para realizar la transsaccón");
    }
}
