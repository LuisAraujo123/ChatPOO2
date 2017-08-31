/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Conversaciones;
import com.sv.udb.modelos.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DanielWilfredo
 */
public class UsuariosCtrl {
    
    
     public boolean guar(Usuarios obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); //en caso de error hace un rollbacj
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
     
     
    
    public Usuarios cons(Integer codiUsua)
    {
        Usuarios resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(Usuarios.class, codiUsua);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Usuarios> cons()
    {
        List<Usuarios> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("Usuarios.findAll", Usuarios.class).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public boolean edit(Usuarios obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.merge(obje);
            //em.flush();
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public boolean dele(Usuarios obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.remove(em.merge(obje));
            //em.flush();
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            if(tx.isActive())
            {
                tx.rollback();
            }
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public Usuarios login(String user)
    {
        Usuarios resp = null; 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            Query sql = em.createNamedQuery("Usuarios.findByNombUsua");
            sql.setParameter("nombUsua", user);
            resp = (Usuarios) sql.getResultList().get(0);           
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
}
