/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author ferna
 */
public class Departamentos implements java.io.Serializable{
    
    private long id;
    private long departamentoCodigo;
    private String departamentoNombre;
    private Date fechaHoraCrea;
    private Date fechaHoraModifica;
    private Set empleados = new HashSet();
    
    public Departamentos(){
        
    }
    
    public Departamentos(long departamentoCodigo, String departamentoNombre, Date fechaHoraCrea, Date fechaHoraModifica, Set empleados){
        this.departamentoCodigo = departamentoCodigo;
        this.departamentoNombre = departamentoNombre;
        this.fechaHoraCrea = fechaHoraCrea;
        this.fechaHoraModifica = fechaHoraModifica;
        this.empleados = empleados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartamentoCodigo() {
        return departamentoCodigo;
    }

    public void setDepartamentoCodigo(long departamentoCodigo) {
        this.departamentoCodigo = departamentoCodigo;
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }

    public Date getFechaHoraCrea() {
        return fechaHoraCrea;
    }

    public void setFechaHoraCrea(Date fechaHoraCrea) {
        this.fechaHoraCrea = fechaHoraCrea;
    }

    public Date getFechaHoraModifica() {
        return fechaHoraModifica;
    }

    public void setFechaHoraModifica(Date fechaHoraModifica) {
        this.fechaHoraModifica = fechaHoraModifica;
    }

    public Set getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set empleados) {
        this.empleados = empleados;
    }
 
    
}

