/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.gestion.hospitalaria.personas;

import javax.swing.JOptionPane;
import sistema.gestion.hospitalaria.personas.Persona;

/**
 *
 * @author juank
 */
public class Paciente extends Persona{
    String historialMedico;
    String alergias;
    String tipoSangre;
    int edad;
    
    public Paciente(String historialMedico, String alergias, String tipoSangre, String id, String nombre, String email, int telefono, int edad) {
        super(id, nombre, email, telefono);
        this.historialMedico = historialMedico;
        this.alergias = alergias;
        this.tipoSangre = tipoSangre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public String getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    
    public static Paciente registrarPaciente(){
        String historialMedico = JOptionPane.showInputDialog("Ingrese el historial medico del paciente");
        String alergias = JOptionPane.showInputDialog("Ingrese las alergias del paciente");
        String tipoSangre = JOptionPane.showInputDialog("Ingrese el tipo de sangre del paciente");
        String id = JOptionPane.showInputDialog("Ingrese el numero de documento del paciente");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
        String email = JOptionPane.showInputDialog("Ingrese el email del paciente");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telofono del paciente"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente"));
        
        
        return new Paciente(historialMedico, alergias, tipoSangre, id, nombre, email, telefono, edad);
        
    }
    
    
    
    
}
