/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author usuario
 */
public class ProblemaResuelto {
    private int numeroProblema;
    private int minutos;
    private int penalizaciones;

    public int getNumeroProblema() {
        return numeroProblema;
    }

    public void setNumeroProblema(int numeroProblema) {
        this.numeroProblema = numeroProblema;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getPenalizaciones() {
        return penalizaciones;
    }

    public void setPenalizaciones(int penalizaciones) {
        this.penalizaciones = penalizaciones;
    }

    public ProblemaResuelto(int numeroProblema, int minutos, int penalizaciones) {
        this.numeroProblema = numeroProblema;
        this.minutos = minutos;
        this.penalizaciones = penalizaciones;
    }
    
    public int tiempoTotal(){
        return minutos + 20 * penalizaciones;
    }

}
