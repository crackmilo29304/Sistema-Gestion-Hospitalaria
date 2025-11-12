/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.gestion.hospitalaria;

import java.util.ArrayList;
import sistema.gestion.hospitalaria.personas.Doctor;
import sistema.gestion.hospitalaria.personas.Enfermero;
import sistema.gestion.hospitalaria.personas.Paciente;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author juank
 */
public class SistemaHospital {
    protected List<Paciente> pacientes;      
    protected Map<String, Doctor> doctores;           // HashMap por ID
    protected Map<String, Enfermero> enfermeros;
    private Set<String> especialidades;         // HashSet

    public void registrarDoctor(){
        Doctor doctor = Doctor.registrarDoctor();
        doctores.put(doctor.getId(), doctor);
        
    }

     public void registrarEnfermero(){
        Enfermero enfermero = Enfermero.registrarEnfermero();
        enfermeros.put(enfermero.getId(), enfermero);
        
    }
        
     public void registrarPaciente(){
        Paciente paciente = Paciente.registrarPaciente();
        pacientes.add(paciente);
        
    }   
        
    
    
     
     // 1. Búsqueda por nombre
    public List<Paciente> buscarPaciente(String nombre) {
        var pacientesCoinciden = new ArrayList<Paciente>();
        for(Paciente paciente: pacientes){
            if(nombre.equals(paciente.getNombre())){
                pacientesCoinciden.add(paciente);
            }
            
        }
        return pacientesCoinciden;
    }
    
    // 2. Búsqueda por nombre Y historial médico
    public List<Paciente> buscarPaciente(String nombre, String historial) {
        var pacientesCoinciden = new ArrayList<Paciente>();
        for(Paciente paciente: pacientes){
            if(nombre.equals(paciente.getNombre())&& historial.equals(paciente.getHistorialMedico())){
                pacientesCoinciden.add(paciente);
            }
            
        }
        return pacientesCoinciden;
    }
    
    // 3. Búsqueda por rango de edad
    public List<Paciente> buscarPaciente(int edadMin, int edadMax) {
        var pacientesCoinciden = new ArrayList<Paciente>();
        for(Paciente paciente: pacientes){
            if(paciente.getEdad()>= edadMin && paciente.getEdad()<= edadMax ){
                pacientesCoinciden.add(paciente);
            }
            
        }
        return pacientesCoinciden;
    }
    
    // 4. Búsqueda por tipo de sangre
    public List<Paciente> buscarPacienteTipoSangre(String tipoSangre) {
        var pacientesCoinciden = new ArrayList<Paciente>();
        for(Paciente paciente: pacientes){
            if(tipoSangre.equals(paciente.getTipoSangre())){
                pacientesCoinciden.add(paciente);
            }
            
        }
        return pacientesCoinciden;
    }
    
    public void buscarDoctor(String id) {
        var doctoresCoinciden = new ArrayList<Doctor>();
        for(Map.Entry<String, Doctor> doctor: doctores.entrySet()){
            if(id.equals(doctor.getKey())){
                JOptionPane.showMessageDialog(null, doctor ); 
            }
            else{
                JOptionPane.showMessageDialog(null, "Ningun doctor coincide" );
            }
        }
    }
    
    public void buscarEnfermero(String id) {
        var enfermerosCoinciden = new ArrayList<Enfermero>();
        for(Map.Entry<String, Enfermero> enfermero: enfermeros.entrySet()){
            if(id.equals(enfermero.getKey())){
                JOptionPane.showMessageDialog(null, enfermero ); 
            }
            else{
                JOptionPane.showMessageDialog(null, "Ningun doctor coincide" );
            }
        }
    } 
    
     
    }
   



