package com.example.Phim1.repo;

import com.example.Phim1.model.VeDat;
import com.example.Phim1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class VeDatRepository {
    Session session = null;
    public VeDatRepository() {session = HibernateConfig.getFACTORY().openSession();
    }
    public List<VeDat> getAll() {
        return session.createQuery("select vd from VeDat vd").list();
    }
    public VeDat getById(Integer id) {
        return session.find(VeDat.class,id);
    }
    public void ThemVeDat(VeDat vd) {
        try {
            session.getTransaction().begin();
            session.save(vd);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void SuaVeDat(VeDat vd) {
        try {
            session.getTransaction().begin();
            session.merge(vd);
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void XoaVeDat(Integer id) {
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
