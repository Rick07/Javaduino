/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaduino.pojos;

import java.io.*;
import jssc.SerialPortTimeoutException;


/**
 *
 * @author ricardo
 */
public class Menu {

    public Menu() throws SerialPortTimeoutException {
        Arduino a = new Arduino();
        a.conecta();
    }
    
    
    public void control()
    {
        //Abrir canal de comunicación desde el teclado
        Video video = new Video();
        
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
                               
                                break;
			}
			case 1:
			{
				video.DetenerVideo();
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
            
        } while (x != 3);
    }
    
}
