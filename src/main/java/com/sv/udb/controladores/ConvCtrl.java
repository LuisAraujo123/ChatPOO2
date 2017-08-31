/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Conversaciones;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 *
 * @author Jose Lira
 */
public class ConvCtrl {
    
    public boolean guar(Conversaciones obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
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
    
    public List<Conversaciones> cons()
    {
        List<Conversaciones> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("Conversaciones.findAll", Conversaciones.class).getResultList();
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
    
    public Conversaciones cons(Integer codiConv)
    {
        Conversaciones resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(Conversaciones.class, codiConv);
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
