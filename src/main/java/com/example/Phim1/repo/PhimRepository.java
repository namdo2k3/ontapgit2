package com.example.Phim1.repo;

import com.example.Phim1.model.Phim;
import com.example.Phim1.model.VeDat;
import com.example.Phim1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class PhimRepository {
    Session session = null;
    public PhimRepository() {session = HibernateConfig.getFACTORY().openSession();
    }
    public List<Phim> getAll() {
        return session.createQuery("select p from Phim p").list();
    }
    public Phim getById(Integer id) {
        return session.find(Phim.class,id);
    }
    public void ThemPhim(Phim p) {
        try {
            session.getTransaction().begin();
            session.save(p);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void SuaPhim(Phim p) {
        try {
            session.getTransaction().begin();
            session.merge(p);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void XoaPhim(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
