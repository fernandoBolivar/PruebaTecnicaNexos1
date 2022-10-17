/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.DepartamentosDao;
import modelo.entity.Departamentos;

/**
 *
 * @author ferna
 */
@ManagedBean(name = "DepartamentosBean")
@ViewScoped
public class DepartamentosBean {

    private List<Departamentos> listaDepartamentos;
    private Departamentos departamento;
    private List<Departamentos> selectedDepartamentos;

    public DepartamentosBean() {
        departamento = new Departamentos();
    }

    public List<Departamentos> getListaDepartamentos() {
        DepartamentosDao ad = new DepartamentosDao();
        listaDepartamentos = ad.getAllDepartamentos();
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<Departamentos> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public Departamentos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
    }
    
    
    public void limpiarDepartamento() {
        departamento = new Departamentos();
    }

    public void agregarDepartamento() {
        DepartamentosDao ad = new DepartamentosDao();
        ad.addDepartamento(departamento);
    }

    public void modificarDepartamento() {
        DepartamentosDao ad = new DepartamentosDao();
        ad.updateDepartamento(departamento);
        limpiarDepartamento();
    }

    public void eliminarDepartamento() {
        DepartamentosDao ad = new DepartamentosDao();
        ad.deleteDepartamento(departamento);
        limpiarDepartamento();
    }

    public List<Departamentos> getSelectedDepartamentos() {
        return selectedDepartamentos;
    }

    public void setSelectedDepartamentos(List<Departamentos> selectedDepartamentos) {
        this.selectedDepartamentos = selectedDepartamentos;
    }
    
    

}
