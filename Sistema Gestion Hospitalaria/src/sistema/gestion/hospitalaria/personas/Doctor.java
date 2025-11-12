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
public class Doctor extends Persona {
        String especialidad;
        int añosExperiencia;
        String tipoSangre;

    public Doctor(String especialidad, int añosExperiencia, String tipoSangre, String id, String nombre, String email, int telefono) {
        super(id, nombre, email, telefono);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.tipoSangre = tipoSangre;
    }
    public static Doctor registrarDoctor(){
        String especialidad = JOptionPane.showInputDialog("Ingresa la especialidad del doctor");
        int añosExperiencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los años de experiencia del doctor"));
        String tipoSangre = JOptionPane.showInputDialog("Ingrese el tipo de sangre del doctor");
        String id = JOptionPane.showInputDialog("Ingrese el numero de documento del doctor");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del doctor");
        String email = JOptionPane.showInputDialog("Ingrese el email del doctor");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de telofono del doctor"));
        
        return new Doctor(especialidad, añosExperiencia, tipoSangre, id, nombre, email, telefono);
    }
    @Override
    public String toString() {
        return "Nombre del doctor " + nombre + ", Años de experiencia: " + añosExperiencia + ", email: " + email ;
    }
}
