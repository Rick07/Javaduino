/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arduino;
import com.javaduino.dao.RaspberryDAO;
import com.javaduino.pojos.Raspberry;
import com.javaduino.pojos.Red;
/**
 *
 * @author ricardo
 */
public class Main {
    
    public static void main(String[] args) {
        
        RaspberryDAO raspi = new RaspberryDAO();
        Red red = new Red();
        String mac = red.obtenerDireccionMac();
        
        Raspberry dato = new Raspberry(mac, 4);
        
        raspi.guardaRaspi(dato);
        
    }
}
