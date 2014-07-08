/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaduino;
import javaduino.dao.RaspberryDAO;
import javaduino.pojos.Raspberry;
import javaduino.pojos.Fechas;
import javaduino.pojos.Red;
/**
 *
 * @author ricardo
 */
public class Main {
    
    public static void main(String[] args) {
        
        RaspberryDAO raspi = new RaspberryDAO();
        Red red = new Red();
        Fechas f = new Fechas();
        
        String mac = red.obtenerDireccionMac();
        String fecha = f.obtenerFecha();
        
        Raspberry dato = new Raspberry(mac, 4, fecha);
        
        raspi.guardaRaspi(dato);
        
    }
}
