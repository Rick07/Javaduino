/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaduino.pojos;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;
import javaduino.dao.RaspberryDAO;
/**
 *
 * @author ricardo
 */
public class Arduino {
    
    Video video = new Video();
    Proceso proceso = new Proceso();
    RaspberryDAO raspi = new RaspberryDAO();
    Red red = new Red();
    Fechas f = new Fechas();
    
    public void conecta() throws SerialPortTimeoutException{
        String mac = red.obtenerDireccionMac();
        String fecha = f.obtenerFecha();
        SerialPort serialPort = new SerialPort("/dev/ttyACM0");
        int temp = 1;
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            do{
             int[] buffer = serialPort.readIntArray(1);
            for(int i=0;i<1;i++)
            {
                buffer[i] = buffer[i] - 48;
                if(buffer[i] == 0 && temp!=0)
                {   
                    
                    temp = buffer[i];
                    
                    video.ReproducirVideo();
                    proceso.comenzarProceso();
                    
                    System.out.println("dato para reproducir video: " + temp);
                    
                }
                else if(buffer[i] == 1)
                {
                    temp = buffer[i];
                    video.DetenerVideo();
                    System.out.println("dato para detener video: " + temp);
                    String tiempo = proceso.finalizaProceso();
                    System.out.println("Duracion: " + tiempo);
 
                    Raspberry dato = new Raspberry(mac, tiempo, fecha);
                    raspi.guardaRaspi(dato);
                }
            }
            //}while(serialPort.isOpened());
            }while(temp != 1);
            //System.out.println("Port closed: " + serialPort.closePort());
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
        
    }
}
