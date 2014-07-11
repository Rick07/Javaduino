package javaduino.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name = "raspivideo")
public class RaspiVideo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idraspivideo")
    private long idraspivideo;

    @Column(name = "tiempo", length = 8)
    private String tiempo;

    @Column(name = "fecha", length = 9)
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "raspimac")
    private Raspberry raspberry;

    public RaspiVideo() {

    }

    public RaspiVideo(String tiempo, String fecha, Raspberry raspberry) {
        this.tiempo = tiempo;
        this.fecha = fecha;
        this.raspberry = raspberry;
    }

    public long getIdraspivideo() {
        return idraspivideo;
    }

    public void setIdraspivideo(long idraspivideo) {
        this.idraspivideo = idraspivideo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Raspberry getRaspberry() {
        return raspberry;
    }

    public void setRaspberry(Raspberry raspberry) {
        this.raspberry = raspberry;
    }

}
