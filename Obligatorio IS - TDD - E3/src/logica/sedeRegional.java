/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import utilidades.ObligatorioException;
import utilidades.UtilidadesVarias;

/**
 *
 * @author usuario
 */
public class sedeRegional {
    private Date fechaCompetencia;
    private int maximoDeEquipos;
    private int cantidadProblemas;
    private String nombreSede; //Si bien en el UML de la letra dice que es Int, se entiende que al ser un nombre debe ser String
    private ArrayList<Equipo> listaEquipos = new ArrayList();
    private ArrayList<Pais> paisesHabilitados = new ArrayList();

    public Date getFechaCompetencia() {
        return fechaCompetencia;
    }

    public void setFechaCompetencia(Date fechaCompetencia) {
        this.fechaCompetencia = fechaCompetencia;
    }

    public int getMaximoDeEquipos() {
        return maximoDeEquipos;
    }

    public void setMaximoDeEquipos(int maximoDeEquipos) {
        this.maximoDeEquipos = maximoDeEquipos;
    }

    public int getCantidadProblemas() {
        return cantidadProblemas;
    }

    public void setCantidadProblemas(int cantidadProblemas) {
        this.cantidadProblemas = cantidadProblemas;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public ArrayList<Pais> getPaisesHabilitados() {
        return paisesHabilitados;
    }

    public void setPaisesHabilitados(ArrayList<Pais> paisesHabilitados) {
        this.paisesHabilitados = paisesHabilitados;
    }

    public sedeRegional(Date fechaCompetencia, int maximoDeEquipos, int cantidadProblemas, String nombreSede) {
        this.fechaCompetencia = fechaCompetencia;
        this.maximoDeEquipos = maximoDeEquipos;
        this.cantidadProblemas = cantidadProblemas;
        this.nombreSede = nombreSede;
    }
    
    public boolean registrarEquipo(Equipo unEquipo) throws ObligatorioException{
        boolean equipoValido = unEquipo.esValido();
        
        if(equipoValido){
            if(edadesValidas(unEquipo) && paisValido(unEquipo) && listaEquipos.size() < maximoDeEquipos){
                listaEquipos.add(unEquipo);
                return true;
            }
        }
        
        return false;
    }
    
    public ArrayList<String> generarScoreboard(){
        ArrayList<String> retorno = new ArrayList<>();
        
        String linea1 = "Scoreboard de la Competencia - Sede " + nombreSede;
        String linea2 = "Fecha y hora de la competencia: " + fechaCompetencia.toString();
        String linea3 = "Posiciones";
        
        retorno.add(linea1);
        retorno.add(linea2);
        retorno.add(linea3);
        
        ArrayList<Equipo> equiposOrdenados = obtenerEquiposOrdenados();
        
        for(Equipo e : equiposOrdenados){
            int[] puntajeEquipo = e.puntaje();
            
            String linea = "<" + e.getNombre() + "><"+ puntajeEquipo[0] + "><" + puntajeEquipo[1] + ">";
            
            retorno.add(linea);
        }
        
        String lineaFinal = "Ultima Actualización: " + new Date().toString();
        
        retorno.add(lineaFinal);
        
        return retorno;
    }

    private boolean edadesValidas(Equipo unEquipo) {
        for(Participante p : unEquipo.getIntegrantes()){
            int edadEnCompetencia = UtilidadesVarias.calcularEdad(fechaCompetencia, p.getFechaNacimiento());
            if(edadEnCompetencia < 16 || edadEnCompetencia > 20)
                return false;
        }
        return true;
    }

    private boolean paisValido(Equipo unEquipo) {
        for(Pais p : paisesHabilitados){
            if(unEquipo.getIntegrantes().get(0).getUniversidad().getPais() == p)
                return true;
        }
        
        return false;
    }

    private ArrayList<Equipo> obtenerEquiposOrdenados() {
        ArrayList<Equipo> retorno = new ArrayList<Equipo>();
        ArrayList<Equipo> equipos = (ArrayList<Equipo>)listaEquipos.clone();
        
        while(equipos.size() > 0){
            int posMayor = 0;
            
            for(int i = 1; i < equipos.size() ; i++){
                posMayor = 0;
                
                int[] equiMayor = equipos.get(posMayor).puntaje();
                int[] equiComparando = equipos.get(i).puntaje();
                
                if(equiMayor[0] < equiComparando[0])
                    posMayor = i;
                else if(equiMayor[0] == equiComparando[0]){
                    if(equiMayor[1] > equiComparando[1])
                        posMayor = i;
                    //A continuación se controlaría cual es el equipo que se registró antes en la competencia, pero
                    //esto se puede omitir, ya que se asume que el equipo que está antes en el ArrayList es el que se registró antes
                    // y nunca posMayor sería mayor a i
                    //else if(equiMayor[1] == equiComparando[1]){
                    //    if(posMayor > i)
                    //        posMayor = i; 
                    //}
                }
            }
            
            retorno.add(equipos.get(posMayor));
            equipos.remove(equipos.get(posMayor));
        }
        
        return retorno;
    }
}
