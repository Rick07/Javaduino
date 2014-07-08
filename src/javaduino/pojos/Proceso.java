/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaduino.pojos;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author ricardo
 */
public class Proceso {
    
    private String INICIO_PROCESO = "Comienza el proceso";
    private String FIN_PROCESO = "El proceso tardó: %s:%s:%s";
    private String FORMATO_DOS_DIGITOS = "00";
    private Date fechainicio;
    
    public void comenzarProceso()
    {
        System.out.println(INICIO_PROCESO);
        this.fechainicio = new Date();
    }
    
    public String finalizaProceso()
    {
        Date fechaFin = new Date();
        Long tiempoTranscurrido = fechaFin.getTime() - fechainicio.getTime();
        Long segundos = tiempoTranscurrido / 100 % 60;
        Long miutos = tiempoTranscurrido / (60 * 1000) % 60;
        Long horas = tiempoTranscurrido / (60 * 60 * 1000) % 24;
        
        DecimalFormat df = new DecimalFormat(FORMATO_DOS_DIGITOS);
        String tiempo = String.format(FIN_PROCESO, df.format(horas), df.format(miutos), df.format(segundos));
        //System.out.println(String.format(FIN_PROCESO, df.format(horas), df.format(miutos), df.format(segundos)));
        return tiempo;
    }
}
