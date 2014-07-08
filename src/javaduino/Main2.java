package javaduino;
import javaduino.pojos.Arduino;
import jssc.SerialPort;

import jssc.SerialPortTimeoutException;

public class Main2 {

    static SerialPort serialPort;

    public static void main(String[] args) throws SerialPortTimeoutException{
        Arduino arduino = new Arduino();
        arduino.conecta();
    }
}