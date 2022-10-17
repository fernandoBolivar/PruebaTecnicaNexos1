/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ferna
 */
@ManagedBean(name = "NavigationBean")
@ViewScoped
public class NavigationBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public String goDepartamentos() {
        return "/departamentos.xhtml";
    }

    public String goEmpleados() {
        return "/empleados.xhtml";
    }

}
