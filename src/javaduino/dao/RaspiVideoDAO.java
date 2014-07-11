package javaduino.dao;

import javaduino.pojos.RaspiVideo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Alex
 * @version 1.0
 * @author-mail programadorjavablog@gmail.com
 * @date 26-ago-2010
 */
public class RaspiVideoDAO {

    private Session sesion;
    private Transaction tx;

    public long guardaRaspiVideo(RaspiVideo raspivideo) throws HibernateException {
        long id = 0;

        try {
            iniciaOperacion();
            id = (long) sesion.save(raspivideo);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void actualizaRaspiVideo(RaspiVideo raspivideo) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(raspivideo);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminaRaspiVideo(RaspiVideo raspivideo) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(raspivideo);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public RaspiVideo obtenRaspiVideo(long idRaspiVideo) throws HibernateException {
        RaspiVideo raspivideo = null;
        try {
            iniciaOperacion();
            raspivideo = (RaspiVideo) sesion.get(RaspiVideo.class, idRaspiVideo);
        } finally {
            sesion.close();
        }

        return raspivideo;
    }

    public List<RaspiVideo> obtenListaRaspiVideos() throws HibernateException {
        List<RaspiVideo> listaRaspiVideos = null;

        try {
            iniciaOperacion();
            listaRaspiVideos = sesion.createQuery("from RaspiVideo").list();
        } finally {
            sesion.close();
        }

        return listaRaspiVideos;
    }

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}
