package com.javaduino.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Alex
 * @version 1.0
 * @author-mail programadorjavablog@gmail.com
 * @date 26-ago-2010
 */
@Entity
@Table(name="raspberry")
public class Raspberry implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="mac")
    private String mac;
    
    @Column(name="tiempo")
    private int tiempo;
    
    @Column(name="fecha")
    private String fecha;
    

    public Raspberry()
    {
    }

    public Raspberry(String mac, int tiempo, String fecha)
    {
        this.mac = mac;
        this.tiempo = tiempo;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }   
}