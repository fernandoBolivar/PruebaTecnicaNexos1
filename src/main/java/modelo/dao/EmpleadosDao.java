/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.util.Date;
import java.util.List;
import modelo.entity.Empleados;
import modelo.utilidades.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ferna
 */
public class EmpleadosDao {
    
    public List<Empleados> getAllEmpleados(){
        List<Empleados> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        String hql = "FROM Empleados";
        
        try{
            lista = sesion.createQuery(hql).list();
            t.commit();
            sesion.close();
        }catch (Exception e){
            t.rollback();
        }
        
        return lista;
    }
    
    public void addEmpleado(Empleados empleado){
        
        Session sesion = null;
        
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            empleado.setFechaHoraCrea(new Date());
            empleado.setFechaHoraModifica(new Date());
            sesion.save(empleado);
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
    
    public void updateEmpleado(Empleados empleado){
        
        Session sesion = null;
        
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            empleado.setFechaHoraModifica(new Date());
            sesion.update(empleado);
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
    
    public void deleteEmpleado(Empleados empleado){
        Session sesion = null;
        
        try{
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(empleado);
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
    
}
