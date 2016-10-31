/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class UtilidadesVarias {
    
    public static int calcularEdad(Date fechaHasta, Date fechaNacimiento) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaHasta);
        int mayAnio = cal.get(Calendar.YEAR);
        int mayMes = cal.get(Calendar.MONTH);
        int mayDia = cal.get(Calendar.DAY_OF_MONTH);
        
        cal.setTime(fechaNacimiento);
        int anios = mayAnio - cal.get(Calendar.YEAR);
        int menMes = cal.get(Calendar.MONTH);
        if (menMes == mayMes) {
            return cal.get(Calendar.DAY_OF_MONTH) <= mayDia ? anios: anios - 1;
        } else {
            return menMes < mayMes ? anios - 1 : anios;
        }
    }
}
