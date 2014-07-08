/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaduino.pojos;

import java.io.IOException;

/**
 *
 * @author ricardo
 */

public class Video {
    
    private Process r;
    private Process d;

    public void ReproducirVideo() {
        if (ConsultarSO().indexOf("Linux") != -1) 
        {
            try 
            {  
                    String command = "vlc /home/ricardo/Vídeos/prueba.MOV";
                    r = Runtime.getRuntime().exec(command);
               
            } catch (IOException e) 
            {
                System.out.println(e.getMessage());
                ReproducirVideo();
            } // end try
        } 
        else 
        {
            System.out.println("No es un sistema operativo basado en GNU/Linux");
        } // end if
    } // end EjecutarBash
    
    public void DetenerVideo() {
        
           if (ConsultarSO().indexOf("Linux") != -1) 
        {
            try 
            {  
                    String command = "killall vlc";
                    d = Runtime.getRuntime().exec(command); 
                  
               
            } catch (IOException e) 
            {
                System.out.println(e.getMessage());
            } // end try
        } 
        else 
        {
            System.out.println("No es un sistema operativo basado en GNU/Linux");
        } // end if
    } 

    public static String ConsultarSO() {
        return System.getProperty("os.name");
    } // end ConsultarSO    
}
