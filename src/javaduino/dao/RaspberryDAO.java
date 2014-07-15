package javaduino.dao;

import javaduino.pojos.Raspberry;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RaspberryDAO {

    private Session sesion;
    private Transaction tx;

    public void guardaRaspi(Raspberry raspberry) throws HibernateException {

        try {
            iniciaOperacion();
            sesion.save(raspberry);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

    }

    public void actualizaRaspi(Raspberry raspberry) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(raspberry);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void eliminaRaspi(Raspberry raspberry) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(raspberry);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Raspberry obtenRaspi(String mac) throws HibernateException {
        Raspberry raspberry = null;
        try {
            iniciaOperacion();
            raspberry = (Raspberry) sesion.get(Raspberry.class, mac);
        } finally {
            sesion.close();
        }

        return raspberry;
    }

    public List<Raspberry> obtenListaRaspis() throws HibernateException {
        List<Raspberry> listaRaspis = null;

        try {
            iniciaOperacion();
            listaRaspis = sesion.createQuery("from raspberry").list();
        } finally {
            sesion.close();
        }

        return listaRaspis;
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
