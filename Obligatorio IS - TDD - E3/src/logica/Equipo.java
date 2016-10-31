/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import utilidades.ObligatorioException;

/**
 *
 * @author usuario
 */
public class Equipo {
    private String nombre;
    private ArrayList<Participante> integrantes = new ArrayList();
    private ArrayList<ProblemaResuelto> problemasResueltos = new ArrayList();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Participante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<Participante> integrantes) {
        this.integrantes = integrantes;
    }

    public ArrayList<ProblemaResuelto> getProblemasResueltos() {
        return problemasResueltos;
    }

    public void setProblemasResueltos(ArrayList<ProblemaResuelto> problemasResueltos) {
        this.problemasResueltos = problemasResueltos;
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean esValido() throws ObligatorioException{
        controlarCantidadIntegrantes();
        
        boolean nombreIntegrantes = controlarNombreIntegrantes();
        boolean nombreCarrerasIntegrantes = controlarNombreCarrerasIntegrantes();
        boolean integrantesIgualUniversidad = controlarIgualdadDeUniversidadEntreIntegrantes();
        boolean semestresCursadosInegrantes = controlarSemestresCursadosDeIntegrantes();
        boolean nombreEquipo = controlarNombre();
        
        return nombreIntegrantes && nombreCarrerasIntegrantes && integrantesIgualUniversidad && semestresCursadosInegrantes && nombreEquipo;
    }
    
    public int[] puntaje(){
        int[] retorno = new int[2];
        
        retorno[0] = problemasResueltos.size();
        
        int puntajeTotal = 0;
        
        for(ProblemaResuelto pr : problemasResueltos){
            puntajeTotal += pr.tiempoTotal();
        }
        
        retorno[1] = puntajeTotal;
        
        return retorno;
    }

    private void controlarCantidadIntegrantes() throws ObligatorioException{
        int contadorIntegrantesDiferentes = 0;
        
        for(Participante buscado : integrantes){
            boolean hayOcurrencia = false;
            
            for(Participante comparado : integrantes){
                if(!hayOcurrencia && buscado == comparado)
                    hayOcurrencia = true;
                else if(hayOcurrencia && buscado == comparado)
                    throw new ObligatorioException("Equipo no está formado por 3 integrantes");
            }
            
            contadorIntegrantesDiferentes++;
        }
        
        if(contadorIntegrantesDiferentes != 3)
            throw new ObligatorioException("Equipo no está formado por 3 integrantes");
    }

    private boolean controlarNombreIntegrantes() {
        boolean retorno = true;
        int i = 0;
        
        while(retorno && i < integrantes.size()){
            Participante p = integrantes.get(i);
            retorno = retorno && p.validarNombre();
            i++;
        }
            
        return retorno;
    }
    
    private boolean controlarNombreCarrerasIntegrantes() {
        boolean retorno = true;
        int i = 0;
        
        while(retorno && i < integrantes.size()){
            Participante p = integrantes.get(i);
            retorno = retorno && p.validarNombreCarrera();
            i++;
        }
            
        return retorno;
    }

    private boolean controlarIgualdadDeUniversidadEntreIntegrantes() {
        for(Participante buscado : integrantes){
            for(Participante comparado : integrantes){
                if(!buscado.compararUniversidadDeParticipante(comparado))
                    return false;
            }
        }
        
        return true;
    }

    private boolean controlarSemestresCursadosDeIntegrantes() {
        for(Participante p : integrantes){
            if(!p.validarSemestre())
                return false;
        }
        return true;
    }

    private boolean controlarNombre() {
        return nombre.length() >= 10 && nombre.length()<= 20; //Se entiende que valen los espacios
    }
}
