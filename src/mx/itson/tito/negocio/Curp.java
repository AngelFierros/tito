/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.tito.negocio;

// import javax.swing.JOptionPane;

/**
 * Esta clase da una serie de herramientas para generar de forma ágil algunos tipos de 
 * documentaciones.
 * @author Angel Fierros.
 */
public class Curp {
    
    /**
     * Genera con base a la informacion proporcionada una Clave Única de
     * Registro de Población(CURP);
     *
     * @param nombres Los nombres de la persona que se quiere generar su CURP.
     * @param apellidoP Apellido paterno de la persona que se quiere generar su
     * CURP.
     * @param apellidoM Apellido materno de la persona que se quiere generar su
     * CURP
     * @param genero El genero de la persona que se quiere generar su CURP.
     * @param dia El dia de la fehca de nacimineto de la persona que se quiere
     * generar su CURP.
     * @param mes El mes de la fehca de nacimineto de la persona que se quiere
     * generar su CURP.
     * @param anio El año de la fehca de nacimineto de la persona que se quiere
     * generar su CURP.
     * @param estado La entidad federativa en la cual nacio la persona que se
     * quiere generar su CURP.
     * @return
     */
    public String generar(String nombres, String apellidoP, String apellidoM, String genero, String dia, String mes, String anio, String estado) {
        String curpLista = "";

        //Apellidos
        String apellidoPaterno = apellidoP;
        String apellidoMaterno = apellidoM;

        //Primer letra de apellido
        char[] caracteres = apellidoP.toCharArray();
        curpLista += caracteres[0];

        String primerVocal = apellidoP.replace("b", "").replace("c", "").replace("d", "")
                .replace("f", "").replace("g", "").replace("h", "").replace("j", "").replace("k", "")
                .replace("l", "").replace("m", "").replace("n", "").replace("p", "").replace("q", "")
                .replace("r", "").replace("s", "").replace("t", "").replace("v", "").replace("w", "")
                .replace("x", "").replace("y", "").replace("z", "").replace("B", "").replace("C", "").replace("D", "")
                .replace("F", "").replace("G", "").replace("H", "").replace("J", "").replace("K", "")
                .replace("L", "").replace("M", "").replace("N", "").replace("P", "").replace("Q", "")
                .replace("R", "").replace("S", "").replace("T", "").replace("V", "").replace("W", "")
                .replace("X", "").replace("Y", "").replace("Z", "");

        //Primer vocal del primer apellido
        char[] primerVocalch = primerVocal.toCharArray();
        curpLista += primerVocalch[0];

        //Primer letra del segundo apellido
        
        if(apellidoM.equals("")){
            curpLista += "X";
        } else {
 
        char[] apellidoSegundo = apellidoM.toCharArray();
        curpLista += apellidoSegundo[0];
        }

        //Nombres
        String[] nombresSeparados = nombres.split(" ");

        //Pregunta si tiene mas de un nombre
        if (nombresSeparados.length > 1) {

            if ("Jose".equals(nombresSeparados[0]) || "Maria".equals(nombresSeparados[0])) {
                //Tiene mas de un nombre pero el primero es J o M
                String segundoNombre = nombresSeparados[1];
                char[] sNombre = segundoNombre.toCharArray();
                curpLista += sNombre[0];
            } else {
                String primerNombre = nombres;
                char[] pNombre = primerNombre.toCharArray();
                curpLista += pNombre[1];
            }
            
        } else {
            String primerNombre = nombres;
            char[] pNombre = primerNombre.toCharArray();
            curpLista += pNombre[1];

        }

        //Fecha de nacimiento
        String fecha = "";
        fecha += anio;
        fecha += mes;
        fecha += dia;

        curpLista += fecha;

        //Genero
        if ("Mujer".equals(genero)) {
            String letra = "M";
            curpLista += letra;
        } else {
            String letra = "H";
            curpLista += letra;
        }

        //Entidad federativa
        String eF = estado;
        curpLista += eF;

        //Consonantes internas
        
        //Primera consonante interna (no inicial) del primer apellido
        String consonanteApellido1 = apellidoP;
        String cA1 = consonanteApellido1.replace("a", "").replace("e", "").replace("i", "")
                .replace("o", "").replace("u", "").replace("A", "").replace("e", "")
                .replace("I", "").replace("O", "").replace("U", "");

        char[] a1C = cA1.toCharArray();

        curpLista += a1C[1];

        //Primera consonante interna (no inicial) del segundo apellido
        String consonanteApellido2 = apellidoM;
        if(!consonanteApellido2.equals("")){
            
        
        String cA2 = consonanteApellido2.replace("a", "").replace("e", "").replace("i", "")
                .replace("o", "").replace("u", "").replace("A", "").replace("e", "")
                .replace("I", "").replace("O", "").replace("U", "");

        char[] a2C = cA2.toCharArray();
        
        curpLista += a2C[1];
        } else{ 
           curpLista += "x";
        }

        //Primera consonante interna (no inicial) del nombre
        String consonanteNombre = nombresSeparados[0];
        String cN = consonanteNombre.replace("a", "").replace("e", "").replace("i", "")
                .replace("o", "").replace("u", "").replace("A", "").replace("e", "")
                .replace("I", "").replace("O", "").replace("U", "");

        char[] nC = cN.toCharArray();

        curpLista += nC[1];
        
        // Letrra al final dependiendo en que siglo nacio
        
        int annio = Integer.parseInt(anio);
        String digito;
        if(annio<2000){
            digito="0-";
            
            curpLista += digito;
        }else{
            digito = "A-";
            
            curpLista += digito;
        }
        
        //Numero 1 al final de la curp
        
        String nF= "1";
        curpLista += nF;

        //Final
        String finalCurp = curpLista.toUpperCase();

        return finalCurp;
    }

}
