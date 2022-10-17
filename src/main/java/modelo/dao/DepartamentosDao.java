/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.Date;
import java.util.List;
import modelo.entity.Departamentos;
import modelo.utilidades.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author ferna
 */
public class DepartamentosDao {
    
    private EntityManager em;
    
    public List<Departamentos> getAllDepartamentos(){
        List<Departamentos> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Departamentos";
        
        try{
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        }catch (Exception e){
            t.rollback();
        }
        
        return lista;
    }
    
    public void addDepartamento(Departamentos departamento){
        
        Session sesion = null;
        
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            departamento.setFechaHoraCrea(new Date());
            departamento.setFechaHoraModifica(new Date());
            sesion.save(departamento);
            sesion.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion!=null){
                sesion.close();
            }
        }
    }
    
    public void updateDepartamento(Departamentos departamento){
        
        Session sesion = null;
        
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            departamento.setFechaHoraModifica(new Date());
            sesion.update(departamento);
            sesion.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion!=null){
                sesion.close();
            }
        }
    }
    
    public void deleteDepartamento(Departamentos departamento){
        Session sesion = null;
        
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(departamento);
            sesion.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion!=null){
                sesion.close();
            }
        }
        
    }
    
    public Departamentos findByDepartamento(String departamentoNombre){
        
        Departamentos dp = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Departamentos where departamentoNombre = : departamentoNombre";
        
        sesion.setProperty("departamentoNombre", departamentoNombre);
        
        try{
            dp = (Departamentos) sesion.createQuery(hql).getSingleResult();
            t.commit();
            sesion.close();
        }catch (Exception e){
            t.rollback();
        }
        
        return dp;
        
    }
    
}
