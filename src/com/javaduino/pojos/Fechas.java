
package com.javaduino.pojos;

import java.util.*;

public class Fechas {
    
    public String obtenerFecha()
    {
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
       
        String f =  año + "-" + (mes+1) + "-" + dia;
        
        return f;
    }
}
