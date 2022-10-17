/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.DepartamentosDao;
import modelo.dao.EmpleadosDao;
import modelo.entity.Departamentos;
import modelo.entity.Empleados;

/**
 *
 * @author ferna
 */
@ManagedBean(name = "EmpleadosBean")
@ViewScoped
public class EmpleadosBean {
    
    private List<Empleados> listaEmpleados;
    private List<String> listaDepartamentos;
    private Empleados empleado;
    private List<Empleados> selectedEmpleados;
    private String selectedDepartamento;

    public EmpleadosBean() {
        empleado = new Empleados();
    }

    public List<Empleados> getListaEmpleados() {
        EmpleadosDao ad = new EmpleadosDao();
        listaEmpleados = ad.getAllEmpleados();
        return listaEmpleados;
    }
    
    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }
    
    public void limpiarEmpleado() {
        empleado = new Empleados();
    }

    public void agregarEmpleado() {
        DepartamentosDao depDao = new DepartamentosDao();
        
        Departamentos dep = new Departamentos();
        dep = depDao.findByDepartamento(selectedDepartamento);
        empleado.setDepartamentosId(dep);
        
        EmpleadosDao ad = new EmpleadosDao();
        ad.addEmpleado(empleado);
        limpiarEmpleado();
    }

    public void modificarEmpleado() {
        EmpleadosDao ad = new EmpleadosDao();
        ad.updateEmpleado(empleado);
        limpiarEmpleado();
    }

    public void eliminarEmpleado() {
        EmpleadosDao ad = new EmpleadosDao();
        ad.deleteEmpleado(empleado);
        limpiarEmpleado();
    }

    public List<Empleados> getSelectedEmpleados() {
        return selectedEmpleados;
    }

    public void setSelectedEmpleados(List<Empleados> selectedEmpleados) {
        this.selectedEmpleados = selectedEmpleados;
    }

    public String getSelectedDepartamento() {
        return selectedDepartamento;
    }

    public void setSelectedDepartamento(String selectedDepartamento) {
        this.selectedDepartamento = selectedDepartamento;
    }

    public List<String> getListaDepartamentos() {
        DepartamentosDao ad = new DepartamentosDao();
        
        listaDepartamentos = new ArrayList<String>();
        for(Departamentos dp : ad.getAllDepartamentos()){
            listaDepartamentos.add(dp.getDepartamentoNombre());
        }
        
        return listaDepartamentos;
    }
    
    

    public void setListaDepartamentos(List<String> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }
    
    
    
}
