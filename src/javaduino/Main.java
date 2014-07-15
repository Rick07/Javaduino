/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaduino;

import javaduino.pojos.Arduino;
import javaduino.pojos.Menu;
import jssc.SerialPortTimeoutException;

/**
 *
 * @author ricardo
 */
public class Main {
    
    public static void main(String[] args) throws SerialPortTimeoutException {
        
       /*Arduino arduino = new Arduino();
        arduino.conecta();*/
        Menu menu = new Menu();
        menu.control();
        
    }
}
