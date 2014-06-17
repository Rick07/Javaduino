/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaduino;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;
/**
 *
 * @author ricardo
 */
public class Conexion {
    
    public int conecta() throws SerialPortTimeoutException{
        SerialPort serialPort = new SerialPort("/dev/ttyACM0");
        int dato = 0;
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            //do{
             int[] buffer = serialPort.readIntArray(1);
            for(int i=0;i<1;i++)
            {
                if(buffer[i] != 10 && buffer[i] != 13)
                {
                    buffer[i] = buffer[i] - 48;
                    System.out.println("DATOS: "+buffer[i]);
                    dato = buffer[i];
                }
            }
            //}while(serialPort.isOpened());
            //System.out.println("Port closed: " + serialPort.closePort());
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
        return dato;
    }
}
