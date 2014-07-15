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
import javaduino.dao.RaspiVideoDAO;

/**
 *
 * @author ricardo
 */
public class Arduino {

    
    Video video = new Video();
    Proceso proceso = new Proceso();
    Raspberry macaddress = new Raspberry();
    RaspberryDAO raspi = new RaspberryDAO();
    RaspiVideoDAO raspivideo = new RaspiVideoDAO();
    Red red = new Red();
    Fechas f = new Fechas();
    
    String mac = red.obtenerDireccionMac();
    
    public Arduino(){    
        if (mac != null) {
            System.out.println("No existe el dispositivo");
            System.exit(0);
        }
    }
    

    public void conecta() throws SerialPortTimeoutException {
        SerialPort serialPort = new SerialPort("/dev/ttyACM0");
        String fecha = f.obtenerFecha();
        int temp = 1;
        try {
                System.out.println("Port opened: " + serialPort.openPort());
                System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
                do {
                    int[] buffer = serialPort.readIntArray(1);
                    for (int i = 0; i < 1; i++) {
                        buffer[i] = buffer[i] - 48;
                        if (buffer[i] == 0 && temp != 0) {

                            temp = buffer[i];

                            video.ReproducirVideo();
                            proceso.comenzarProceso();

                            System.out.println("dato para reproducir video: " + temp);

                        } else if (buffer[i] == 1) {
                            temp = buffer[i];
                            video.DetenerVideo();
                            System.out.println("dato para detener video: " + temp);
                            String tiempo = proceso.finalizaProceso();
                            System.out.println("Duracion: " + tiempo);

                            //Raspberry macaddress = new Raspberry("38:60:77:59:EB:EA", "nave");
                            macaddress.setMac(mac);
                            RaspiVideo vid = new RaspiVideo(tiempo, fecha, macaddress);
                            //raspi.guardaRaspi(macaddress);
                            raspivideo.guardaRaspiVideo(vid);
                        }
                    }
                    //}while(serialPort.isOpened());
                } while (temp != 1);
            //System.out.println("Port closed: " + serialPort.closePort());
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }

    }
}
