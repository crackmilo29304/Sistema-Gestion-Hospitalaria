package sistema.gestion.hospitalaria;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;

public class CitaMedica implements Gestionable {
    private LinkedHashMap<String, Boolean> lunes = new LinkedHashMap<>();
    private LinkedHashMap<String, Boolean> martes = new LinkedHashMap<>();
    private LinkedHashMap<String, Boolean> miercoles = new LinkedHashMap<>();
    private LinkedHashMap<String, Boolean> jueves = new LinkedHashMap<>();
    private LinkedHashMap<String, Boolean> viernes = new LinkedHashMap<>();
    private LinkedHashMap<String, Boolean> sabado = new LinkedHashMap<>();
    private LinkedHashMap<String, Boolean> domingo = new LinkedHashMap<>();
    Queue<List<String>> citasPendientes = new LinkedList<>();
    // CONVENCIÓN: TRUE = Disponible, FALSE = Ocupado
    private static final Boolean DISPONIBLE = Boolean.TRUE;
    private static final Boolean OCUPADO = Boolean.FALSE;
    
    public void crearHoras(LinkedHashMap<String, Boolean> dia) {
        for(int i = 0; i < 24; i++) {
            if(i < 12) {
                String hora = (i == 0) ? "12am" : i + "am";
                dia.put(hora, DISPONIBLE);
            } else {
                int horaPM = (i == 12) ? 12 : i - 12;
                dia.put(horaPM + "pm", DISPONIBLE);
            }
        }
    }
    
    public void crearInfraestructura() {
        crearHoras(lunes);
        crearHoras(martes);
        crearHoras(miercoles);
        crearHoras(jueves);
        crearHoras(viernes);
        crearHoras(sabado);
        crearHoras(domingo);
        JOptionPane.showMessageDialog(null, "Horarios creados exitosamente");
    }
    
    @Override
    public void registrar() {
        boolean control = true;
        
        
        
        while (control) {
            // Usar JOptionPane en lugar de Scanner
            String dia = JOptionPane.showInputDialog(
                "¿Qué día desea asignar su cita?\n" +
                "Opciones: lunes, martes, miércoles, jueves, viernes, sábado, domingo"
            );
            
            if (dia == null) { // Si el usuario presiona Cancelar
                return;
            }
            
            dia = dia.toLowerCase();
            
            String hora = JOptionPane.showInputDialog(
                "¿A qué hora desea asignar su cita?\n" +
                "Ejemplos: 1am, 2am, 12pm, 3pm, etc.\n"             
            );
            
            if (hora == null) { // Si el usuario presiona Cancelar
                return;
            }
            
            hora = hora.toLowerCase();
            
            boolean diaValido = true;
            boolean operacionExitosa = false;
           
            
            switch (dia) {
                case "lunes":
                    if (lunes.containsKey(hora) && lunes.get(hora) == DISPONIBLE) {
                        lunes.put(hora, OCUPADO);
                        operacionExitosa = true;
                        
                    }
                    break;
                case "martes":
                    if (martes.containsKey(hora) && martes.get(hora) == DISPONIBLE) {
                        martes.put(hora, OCUPADO);
                        operacionExitosa = true;
                    }
                    break;
               
                case "miércoles":
                    if (miercoles.containsKey(hora) && miercoles.get(hora) == DISPONIBLE) {
                        miercoles.put(hora, OCUPADO);
                        operacionExitosa = true;
                    }
                    break;
                case "jueves":
                    if (jueves.containsKey(hora) && jueves.get(hora) == DISPONIBLE) {
                        jueves.put(hora, OCUPADO);
                        operacionExitosa = true;
                    }
                    break;
                case "viernes":
                    if (viernes.containsKey(hora) && viernes.get(hora) == DISPONIBLE) {
                        viernes.put(hora, OCUPADO);
                        operacionExitosa = true;
                    }
                    break;
                case "sabado":
                case "sábado":
                    if (sabado.containsKey(hora) && sabado.get(hora) == DISPONIBLE) {
                        sabado.put(hora, OCUPADO);
                        operacionExitosa = true;
                    }
                    break;
                case "domingo":
                    if (domingo.containsKey(hora) && domingo.get(hora) == DISPONIBLE) {
                        domingo.put(hora, OCUPADO);
                        operacionExitosa = true;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La información ingresada es incorrecta");
                    diaValido = false;
            }
            
            if (operacionExitosa) {
                control = false;
                JOptionPane.showMessageDialog(null, 
                    "La cita fue asignada satisfactoriamente\n" +
                    "Día: " + dia + "\n" +
                    "Hora: " + hora
                );
                citasPendientes.offer(Arrays.asList(dia, hora));
            } else if (diaValido) {
                JOptionPane.showMessageDialog(null, 
                    "La hora " + hora + " no existe o no está disponible para el día " + dia
                );
            }
        }
    }
    
    @Override
    public void actualizar() {
        JOptionPane.showMessageDialog(null, "=== REPROGRAMAR CITA ===");
        eliminar();
        registrar();
        JOptionPane.showMessageDialog(null, "La cita fue reprogramada satisfactoriamente");
    }
    
    @Override
    public void eliminar() {
        boolean control = true;
        
        while (control) {
            String diaAtc = JOptionPane.showInputDialog(
                "¿Qué día es la cita que desea eliminar?\n" +
                "Opciones: lunes, martes, miércoles, jueves, viernes, sábado, domingo"
            );
            
            if (diaAtc == null) { // Si el usuario presiona Cancelar
                return;
            }
            
            diaAtc = diaAtc.toLowerCase();
            
            String horaAct = JOptionPane.showInputDialog(
                "¿A qué hora es la cita que desea eliminar?\n" +
                "Ejemplos: 1am, 2am, 12pm, 3pm, etc."
            );
            
            if (horaAct == null) { // Si el usuario presiona Cancelar
                return;
            }
            
            horaAct = horaAct.toLowerCase();
            
            boolean operacionExitosa = false;
            
            switch (diaAtc) {
                case "lunes":
                    if (lunes.containsKey(horaAct) && lunes.get(horaAct) == OCUPADO) {
                        lunes.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "martes":
                    if (martes.containsKey(horaAct) && martes.get(horaAct) == OCUPADO) {
                        martes.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "miercoles":
                case "miércoles":
                    if (miercoles.containsKey(horaAct) && miercoles.get(horaAct) == OCUPADO) {
                        miercoles.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "jueves":
                    if (jueves.containsKey(horaAct) && jueves.get(horaAct) == OCUPADO) {
                        jueves.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "viernes":
                    if (viernes.containsKey(horaAct) && viernes.get(horaAct) == OCUPADO) {
                        viernes.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "sabado":
                case "sábado":
                    if (sabado.containsKey(horaAct) && sabado.get(horaAct) == OCUPADO) {
                        sabado.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "domingo":
                    if (domingo.containsKey(horaAct) && domingo.get(horaAct) == OCUPADO) {
                        domingo.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La información ingresada es incorrecta");
            }
            
            if (operacionExitosa) {
                control = false;
                JOptionPane.showMessageDialog(null, 
                    "Cita eliminada exitosamente\n" +
                    "Día: " + diaAtc + "\n" +
                    "Hora: " + horaAct
                );
            } else {
                JOptionPane.showMessageDialog(null, 
                    "No se encontró la cita ocupada. Verifique los datos.\n" +
                    "Día: " + diaAtc + "\n" +
                    "Hora: " + horaAct
                );
            }
        }
    }
    public void eliminar(String diaAtc , String horaAct ) {
        boolean control = true;
        
        while (control) {
            
            if ( diaAtc == null) { // Si el usuario presiona Cancelar
                return;
            }
            
            diaAtc = diaAtc.toLowerCase();
            
            
            
            if (horaAct == null) { // Si el usuario presiona Cancelar
                return;
            }
            
            horaAct = horaAct.toLowerCase();
            
            boolean operacionExitosa = false;
            
            switch (diaAtc) {
                case "lunes":
                    if (lunes.containsKey(horaAct) && lunes.get(horaAct) == OCUPADO) {
                        lunes.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "martes":
                    if (martes.containsKey(horaAct) && martes.get(horaAct) == OCUPADO) {
                        martes.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "miercoles":
                case "miércoles":
                    if (miercoles.containsKey(horaAct) && miercoles.get(horaAct) == OCUPADO) {
                        miercoles.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "jueves":
                    if (jueves.containsKey(horaAct) && jueves.get(horaAct) == OCUPADO) {
                        jueves.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "viernes":
                    if (viernes.containsKey(horaAct) && viernes.get(horaAct) == OCUPADO) {
                        viernes.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "sabado":
                case "sábado":
                    if (sabado.containsKey(horaAct) && sabado.get(horaAct) == OCUPADO) {
                        sabado.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                case "domingo":
                    if (domingo.containsKey(horaAct) && domingo.get(horaAct) == OCUPADO) {
                        domingo.put(horaAct, DISPONIBLE);
                        operacionExitosa = true;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La información ingresada es incorrecta");
            }
            
            if (operacionExitosa) {
                control = false;
                
             
            }
        }
    }
    public void atenderProximaCita() {
         
        var cita = citasPendientes.peek();
        JOptionPane.showMessageDialog(null, "Se atendió correctamente la cita el dia "+cita.getFirst()+ " a la hora " + cita.getLast() );
        citasPendientes.poll();
        eliminar(cita.getFirst(), cita.getLast());
        
     } // de la cola
}