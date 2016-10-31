/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import logica.Equipo;
import logica.Pais;
import logica.Participante;
import logica.Universidad;
import logica.sedeRegional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilidades.ObligatorioException;

/**
 *
 * @author usuario
 */
public class CasosDePrueba {
    //Paises
    private Pais p1;
    private Pais p2;
    private Pais p3;
    //Universidades
    private Universidad u1;
    private Universidad u2;
    private Universidad u3;
    //Participantes
    private Participante part1;
    private Participante part2;
    private Participante part3;
    private Participante part4;
    private Participante part5;
    private Participante part6;
    private Participante part7;
    private Participante part8;
    private Participante part9;
    private Participante part10;
    private Participante part11;
    private Participante part12;
    private Participante part13;
    private Participante part14;
    private Participante part15;
    private Participante part16;
    private Participante part17;
    //Equipos
    private Equipo e1;
    private Equipo e2;
    private Equipo e3;
    private Equipo e4;
    private Equipo e5;
    private Equipo e6;
    private Equipo e7;
    private Equipo e8;
    private Equipo e9;
    private Equipo e10;
    private Equipo e11;
    //Sedes Regionales
    private sedeRegional s1;
    private sedeRegional s2;
    private sedeRegional s3;
    
    @Before
    public void limpiarMemoria(){
        //Paises
        p1 = new Pais("Uruguay");
        p2 = new Pais("Argentina");
        p3 = new Pais("Brasil");
        
        //Universidades
        u1 = new Universidad("Universidad Uruguaya", p1);
        u2 = new Universidad("Universidad Argentina", p2);
        u3 = new Universidad("Universidad Brasilera", p3);
        
        //Fechas para los estudiantes
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate1 = null;
        Date fechaDate2 = null;
        Date fechaDate3 = null;
        Date fechaDate4 = null;
        Date fechaDate5 = null;
        Date fechaDate6 = null;
        Date fechaDate7 = null;
        Date fechaDate8 = null;
        Date fechaDate9 = null;
        Date fechaDate10 = null;
        Date fechaDate11 = null;
        Date fechaDate12 = null;
        Date fechaDate13 = null;
        Date fechaDate14 = null;
        Date fechaDate15 = null;
        Date fechaDate16 = null;
        Date fechaDate17 = null;
        
        try{
            //Para Estudiantes
            fechaDate1 = df.parse("01/01/1997");
            fechaDate2 = df.parse("01/02/1997");
            fechaDate3 = df.parse("01/01/1998");
            fechaDate4 = df.parse("01/02/1998");
            fechaDate5 = df.parse("01/01/1999");
            fechaDate6 = df.parse("01/02/1999");
            fechaDate7 = df.parse("01/01/2000");
            fechaDate8 = df.parse("01/02/2000");
            fechaDate9 = df.parse("01/01/1996");
            fechaDate11 = df.parse("01/01/1988");
            
            //Para Competencias
            fechaDate10 = df.parse("01/01/2015");
        }
        catch(Exception ex){
            
        }
        
        //Estudiantes válidos
        part1 = new Participante("Bruno Esteban Díaz", fechaDate1, "Carrera 1", 1, u1); //Estudiante válido
        part2 = new Participante("Emiliano Gastón Díaz García", fechaDate2, "Carrera 1", 2, u1); //Estudiante válido
        part3 = new Participante("Ernesto Mauro", fechaDate3, "Carrera 2", 3, u1); //Estudiante válido
        part4 = new Participante("Marcos Hugo Díaz Ferri", fechaDate4, "Carrera 2", 4, u2); //Estudiante válido
        part5 = new Participante("Valeria Tabárez", fechaDate5, "Carrera 3", 5, u2); //Estudiante válido
        part6 = new Participante("Manuela Bentura", fechaDate6, "Carrera 3", 6, u2); //Estudiante válido
        part7 = new Participante("Laura Varela", fechaDate7, "Carrera 3", 7, u1); //Estudiante válido
        part8 = new Participante("Tamara Nieto", fechaDate3, "Carrera 2", 3, u1); //Estudiante válido
        part17 = new Participante("Laura Varela", fechaDate11, "Carrera 3", 7, u1); //Estudiante válido
        
        //Estudiantes no válidos
        //Por el Nombre
        part9 = new Participante("", fechaDate9, "Carrera 4", 2, u1); //Nombre no válido (Vacío)
        part10 = new Participante("Ana Liz Díaz", fechaDate9, "Carrera 4", 2, u1); //Nombre no válido (Más de 2 palabras pero todas con menos de 5 caracteres)
        part11 = new Participante("Estephania Liz Díaz", fechaDate9, "Carrera 4", 2, u1); //Nombre no válido (Más de 2 palabras pero solo una con más de 4 caracteres)
        part12 = new Participante("Estephania", fechaDate9, "Carrera 4", 2, u1); //Nombre no válido (Menos de 2 palabras)
        //Por la Carrera
        part13 = new Participante("Bruno Esteban", fechaDate9, "", 2, u1); //Nombre de la carrera vacío
        part14 = new Participante("Bruno Esteban", fechaDate9, "C1", 2, u1); //Nombre de la carrera con menos de 5 caracteres
        //Por el ultimo Semestre Cursado
        part15 = new Participante("Bruno Esteban", fechaDate9, "Carrera 4", 0, u1); //Ultimo semestre cursado menor a 1
        part16 = new Participante("Bruno Esteban", fechaDate9, "Carrera 4", 8, u1); //Ultimo semestre cursado mayor a 7
        
        //Equipos válidos
        e1 = new Equipo("Equipo Uno");
        e1.getIntegrantes().add(part1);
        e1.getIntegrantes().add(part2);
        e1.getIntegrantes().add(part3);
        e2 = new Equipo("Equipo Dos");
        e2.getIntegrantes().add(part4);
        e2.getIntegrantes().add(part5);
        e2.getIntegrantes().add(part6);
        
        //Equipos inválidos
        //Por el nombre
        e3 = new Equipo(""); //Nombre vacío
        e3.getIntegrantes().add(part1);
        e3.getIntegrantes().add(part2);
        e3.getIntegrantes().add(part3);
        e4 = new Equipo("Equipo"); //Nombre con menos de 10 caracteres
        e4.getIntegrantes().add(part1);
        e4.getIntegrantes().add(part2);
        e4.getIntegrantes().add(part3);
        e5 = new Equipo("Equipo con más de veinte carateres en el nombre"); //Nombre con más de 20 caracteres
        e5.getIntegrantes().add(part1);
        e5.getIntegrantes().add(part2);
        e5.getIntegrantes().add(part3);
        //Por los participantes
        e6 = new Equipo("Equipo Seis"); //No tiene integrantes
        e7 = new Equipo("Equipo Siete"); //Tiene un solo integrante
        e7.getIntegrantes().add(part1);
        e8 = new Equipo("Equipo Ocho"); //Tiene más de 3 integrantes
        e8.getIntegrantes().add(part1);
        e8.getIntegrantes().add(part2);
        e8.getIntegrantes().add(part3);
        e8.getIntegrantes().add(part8);
        e9 = new Equipo("Equipo Nueve"); //Dos integrantes iguales
        e9.getIntegrantes().add(part1);
        e9.getIntegrantes().add(part2);
        e9.getIntegrantes().add(part2);
        e10 = new Equipo("Equipo Diez"); //No todos los integrantes pertenecen a la misma Universidad
        e10.getIntegrantes().add(part1);
        e10.getIntegrantes().add(part2);
        e10.getIntegrantes().add(part4);
        e11 = new Equipo("Equipo Once"); //Uno de los estudiantes no es válido por algún motivo (En este caso, el nombre vacío)
        e11.getIntegrantes().add(part1);
        e11.getIntegrantes().add(part2);
        e11.getIntegrantes().add(part9);
        
        s1 = new sedeRegional(fechaDate10, 3, 10, "Sede Regional 1");
        s1.getPaisesHabilitados().add(p1);
        s1.getPaisesHabilitados().add(p2);
        s1.getPaisesHabilitados().add(p3);
        s2 = new sedeRegional(fechaDate10, 1, 10, "Sede Regional 2");
        s2.getPaisesHabilitados().add(p1);
        s2.getPaisesHabilitados().add(p2);
        s2.getPaisesHabilitados().add(p3);
        s3 = new sedeRegional(fechaDate10, 10, 10, "Sede Regional 3");
        s3.getPaisesHabilitados().add(p2);
        s3.getPaisesHabilitados().add(p3);
    }
    
    @Test
    public void controloEstudianteNoValidoPorNombre1(){ //Nombre vacío
        boolean obtenido = part9.validarNombre();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEstudianteNoValidoPorNombre2(){ //Nombre con más de 2 palabras pero todas con menos de 5 caracteres
        boolean obtenido = part10.validarNombre();
        Assert.assertEquals(false, obtenido);
    }
    
    @Test
    public void controloEstudianteNoValidoPorNombre3(){ //Nombre con más de 2 palabras pero solo una con más de 4 caracteres
        boolean obtenido = part11.validarNombre();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEstudianteNoValidoPorNombre4(){ //Nombre con menos de 2 palabras
        boolean obtenido = part12.validarNombre();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEstudianteNoValidoPorNombreCarrera1(){ //Nombre de la carrera vacío
        boolean obtenido = part13.validarNombreCarrera();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEstudianteNoValidoPorNombreCarrera2(){ //Nombre de la carrera con menos de 5 caracteres
        boolean obtenido = part14.validarNombreCarrera();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEstudianteNoValidoPorUltimoSemestreCursado1(){ //Ultimo semestre cursado menor a 1
        boolean obtenido = part15.validarSemestre();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEstudianteNoValidoPorUltimoSemestreCursado2(){ //Ultimo semestre cursado mayor a 7
        boolean obtenido = part16.validarSemestre();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEstudianteValidoPorNombre(){ //El estudiante cumple con todos las requisitos del nombre
        boolean obtenido = part1.validarNombre();
        Assert.assertTrue(obtenido);
    }
    
    @Test
    public void controloEstudianteValidoPorNombreCarrera(){ //El estudiante cumple con todos las requisitos nombre de la carrera que cursa
        boolean obtenido = part1.validarNombreCarrera();
        Assert.assertTrue(obtenido);
    }
    
    @Test
    public void controloEstudianteValidoPorUltimoSemestreCursado(){ //El estudiante cumple con todos las requisitos del último semestre cursado
        boolean obtenido = part1.validarSemestre();
        Assert.assertTrue(obtenido);
    }
    
    @Test
    public void controloEquipoNoValidoPorNombre1() throws ObligatorioException{ //Nombre vacío
        boolean obtenido = e3.esValido();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEquipoNoValidoPorNombre2() throws ObligatorioException{ //Nombre con menos de 10 caracteres
        boolean obtenido = e4.esValido();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEquipoNoValidoPorNombre3() throws ObligatorioException{ //Nombre con más de 20 caracteres
        boolean obtenido = e5.esValido();
        Assert.assertFalse(obtenido);
    }
    
    //Para los casos en los que se controla la excepcion, podría haber utilizado: @Test(expected = ObligatorioException.class)
    //Pero en caso de utilizarlo, el test me daba passed sólo por le hecho de haberme tirado la excepción,
    //sin saber cual es el mensaje. Pudiendo haber sido la misma excepción con otro mensaje cualquiera.
    @Test
    public void controloEquipoNoValidoPorIntegrantes1(){ //No tiene integrantes
        try{
            e6.esValido();
        }
        catch(ObligatorioException ex){
            System.out.println("Catch 1");
            String esperado = "Equipo no está formado por 3 integrantes";
            String obtenido = ex.getMessage();
            Assert.assertEquals(esperado, obtenido);
        }
    }
    
    @Test
    public void controloEquipoNoValidoPorIntegrantes2(){ //Tiene un solo integrante
        try{
            e7.esValido();
        }
        catch(ObligatorioException ex){
            System.out.println("Catch 2");
            String esperado = "Equipo no está formado por 3 integrantes";
            String obtenido = ex.getMessage();
            Assert.assertEquals(esperado, obtenido);
        }
    }
    
    @Test
    public void controloEquipoNoValidoPorIntegrantes3(){ //Tiene más de 3 integrantes
        try{
            e8.esValido();
        }
        catch(ObligatorioException ex){
            System.out.println("Catch 3");
            String esperado = "Equipo no está formado por 3 integrantes";
            String obtenido = ex.getMessage();
            Assert.assertEquals(esperado, obtenido);
        }
    }
    
    @Test
    public void controloEquipoNoValidoPorIntegrantes4(){ //Dos integrantes iguales
        try{
            e9.esValido();
        }
        catch(ObligatorioException ex){
            System.out.println("Catch 4");
            String esperado = "Equipo no está formado por 3 integrantes";
            String obtenido = ex.getMessage();
            Assert.assertEquals(esperado, obtenido);
        }
    }
    
    @Test
    public void controloEquipoNoValidoPorIntegrantes5()  throws ObligatorioException{ //No todos los integrantes pertenecen a la misma Universidad
        boolean obtenido = e10.esValido();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEquipoNoValidoPorIntegrantes6() throws ObligatorioException{ //Uno de los estudiantes no es válido por algún motivo (En este caso, el nombre vacío)
        boolean obtenido = e11.esValido();
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controloEquipoValido() throws ObligatorioException{ //Cumple con todos los requisitos solicitados
        boolean obtenido = e1.esValido();
        Assert.assertTrue(obtenido);
    }
    
    @Test
    public void controlRegistrarEquipoInvalido() throws ObligatorioException{ //Equipo de una universidad preteneciente a un país no habilitado para esa sede
        boolean obtenido = s3.registrarEquipo(e1);
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controlRegistrarEquipoInvalido2() throws ObligatorioException{ //La sede admite solo un equipo en la competencia y se intentan insertar dos
        s2.registrarEquipo(e1);
        boolean obtenido = s2.registrarEquipo(e2);
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controlRegistrarEquipoInvalido3() throws ObligatorioException{ //Uno de los integrantes del equipo posee menos de 16 años a la fecha de la competencia
        e1.getIntegrantes().set(2, part7);
        
        boolean obtenido = s1.registrarEquipo(e1);
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controlRegistrarEquipoInvalido4() throws ObligatorioException{ //Uno de los integrantes del equipo posee más de 20 años a la fecha de la competencia
        e1.getIntegrantes().set(2, part17);
        
        boolean obtenido = s1.registrarEquipo(e1);
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controlRegistrarEquipoInvalido5() throws ObligatorioException{ //El equipo ya no es válido por algún motivo que no tira excepción (En este caso, el nombre es vacío)
        boolean obtenido = s1.registrarEquipo(e3);
        Assert.assertFalse(obtenido);
    }
    
    @Test
    public void controlRegistrarEquipoInvalido6(){ //El equipo ya no es válido por algún motivo que tira excepción (En este caso, 2 integrantes son iguales)
        try{
            s1.registrarEquipo(e9);
        }
        catch(ObligatorioException ex){
            System.out.println("Catch 5");
            String esperado = "Equipo no está formado por 3 integrantes";
            String obtenido = ex.getMessage();
            Assert.assertEquals(esperado, obtenido);
        }
    }
    
    @Test
    public void controlRegistrarEquipoValido() throws ObligatorioException{ //El equipo cumple con todos los requisitos necesarios para ser registrado
        boolean obtenido = s2.registrarEquipo(e1);
        Assert.assertTrue(obtenido);
    }
}
