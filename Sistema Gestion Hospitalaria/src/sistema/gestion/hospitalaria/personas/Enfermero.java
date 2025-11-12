/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.gestion.hospitalaria.personas;

import javax.swing.JOptionPane;

/**
 *
 * @author juank
 */
public class Enfermero extends Persona {
   String turno;
   String areaAsignada;
   String tipoSangre;

    public Enfermero(String turno, String areaAsignada, String tipSangre ,String id, String nombre, String email, int telefono) {
        super(id, nombre, email, telefono);
        this.turno = turno;
        this.areaAsignada = areaAsignada;
        this.tipoSangre = tipoSangre;
    }

    
    
    public static Enfermero registrarEnfermero(){
        String turno = JOptionPane.showInputDialog("Ingrese el turno asignado al enfermero (diurno/nocturno)");
        String areaAsignada = JOptionPane.showInputDialog("Ingrese el area asignada del enfermero");
        String tipoSangre = JOptionPane.showInputDialog("Ingrese el tipo de sangre del enfermero");
        String id = JOptionPane.showInputDialog("Ingrese el numero de documento del enfermero");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del enfermero");
        String email = JOptionPane.showInputDialog("Ingrese el email del enfermero");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telofono del enfermero"));
        
        return new Enfermero(turno, areaAsignada, tipoSangre, id, nombre, email, telefono);
        
    }
    @Override
    public String toString() {
        return "Nombre del enfermero " + nombre + ", Turno: " + turno + ", Area asignada: "+ areaAsignada + ", email: " + email ;
    }
}
