package javaduino;
import jssc.SerialPort;

import jssc.SerialPortTimeoutException;

public class Main {

    static SerialPort serialPort;

    public static void main(String[] args) throws SerialPortTimeoutException {
        Conexion c = new Conexion();
        c.conecta();
    }
}