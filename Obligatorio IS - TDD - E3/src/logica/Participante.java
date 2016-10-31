/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class Participante {
    private String nombre;
    private Date fechaNacimiento;
    private String carreraQueCursa;
    private int ultimoSemestreCursado;
    private Universidad universidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCarreraQueCursa() {
        return carreraQueCursa;
    }

    public void setCarreraQueCursa(String carreraQueCursa) {
        this.carreraQueCursa = carreraQueCursa;
    }

    public int getUltimoSemestreCursado() {
        return ultimoSemestreCursado;
    }

    public void setUltimoSemestreCursado(int ultimoSemestreCursado) {
        this.ultimoSemestreCursado = ultimoSemestreCursado;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public Participante(String nombre, Date fechaNacimiento, String carreraQueCursa, int ultimoSemestreCursado, Universidad universidad) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.carreraQueCursa = carreraQueCursa;
        this.ultimoSemestreCursado = ultimoSemestreCursado;
        this.universidad = universidad;
    }

    public boolean validarNombre() {
        int contadorValidas = 0;
        String[] nombreSeparado = nombre.split(" ");
        
        for(String s : nombreSeparado){
            if(s.length() > 4)
                contadorValidas++;
        }
        
        return contadorValidas >= 2;
    }

    public boolean validarNombreCarrera() {
        return carreraQueCursa.length() >= 5;
    }
    
    public boolean compararUniversidadDeParticipante(Participante p){
        return this.getUniversidad() == p.getUniversidad();
    }

    public boolean validarSemestre() {
        return this.ultimoSemestreCursado >= 1 && this.ultimoSemestreCursado < 8;
    }
}
