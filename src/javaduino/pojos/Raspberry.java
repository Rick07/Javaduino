package javaduino.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "raspberry")
public class Raspberry implements Serializable {

    @Id
    @Column(name = "mac", length = 17)
    private String mac;

    @Column(name = "ubicacion", length = 50)
    private String ubicacion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "raspimac")
    private List<RaspiVideo> raspiVideo;

    public Raspberry() {
    }

    public Raspberry(String mac, String ubicacion) {
        this.mac = mac;
        this.ubicacion = ubicacion;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<RaspiVideo> getRaspiVideo() {
        return raspiVideo;
    }

    public void setRaspiVideo(List<RaspiVideo> raspiVideo) {
        this.raspiVideo = raspiVideo;
    }
}
