/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaduino;

import java.io.*;
import static javaduino.Main.serialPort;
import jssc.SerialPortException;

/**
 *
 * @author ricardo
 */
public class Menu {
    
    public void control() throws SerialPortException
    {
        //Abrir canal de comunicación desde el teclado
       Conexion c = new Conexion();
        
        String texto = "";
        int x=0;
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        System.out.println("-----MENU DE OPCIONES----");
        System.out.println("Reproducir video (0)");
        System.out.println("Detener video (1)");
        System.out.println("Salir del programa (2)\n");
        
       
        do {      
                          
             try {
                System.out.print("Introduzca una opcion: ");
                texto = buffer.readLine();
		x = Integer.parseInt(texto);
               
                switch(x)
		{
			case 0:
			{
                            do{
                                c.conecta();
                            }while(serialPort.isOpened());
                                break;
			}
			
                        case 2:
			{
				System.out.println("APLICACIÓN TERMINADA");
				break;
			}
			default:
			{
				System.out.println("NO ES UNA OPCIÓN VALIDA");
                                break;
			}
			
		}
               
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
            
        } while (x != 2);
    }
    
}
