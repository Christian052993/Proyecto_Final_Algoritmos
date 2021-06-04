/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author 
 */

   public class ProyectoFinal {
    File fichero;
    String ruta = "fichero.csv";
    boolean texto;
     
    public void guardar(String[] datos){
        fichero = new File(ruta);//Creacion del Archivo
        BufferedWriter bw;
        try {
            if (fichero.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");
                bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write("Comuna " + datos[0] + ", " + datos[1] + ", " + datos[2] + ", "
                        + datos[3] + ", " + datos[4]);
            } else {
                System.out.println("El fichero ya existe");
                bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write("\r\n");
                bw.write("Comuna " + datos[0] + ", " + datos[1] + ", " + datos[2] + ", "
                        + datos[3] + ", " + datos[4]);
            }
            bw.close();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public ArrayList aire(){
        ArrayList aire = new ArrayList();
        ArrayList comuna = new ArrayList();
        ArrayList datoFinal = new ArrayList();
        try {
            FileReader f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while ((cadena = b.readLine()) != null) {
            String palabras[] = cadena.split(",");
                for (int i = 2; i < palabras.length; i+=5) {
                    aire.add(palabras[i]);
                }
                for (int i = 0; i < palabras.length; i+=5) {
                    comuna.add(palabras[i]);
                }
            }
            b.close();
            for (int i = 0; i < aire.size(); i++) {
                String nivel = (String) aire.get(i);
                nivel = nivel.replace(" ","");//Para quitar los espacios que hay en el String para poder convertirlo a entero
                
                if(Integer.parseInt(nivel) >= 151){
                    int control = 1;
                    String condicion="";
                    if(Integer.parseInt(nivel) >= 151){
                        condicion = "Dañino para la mayoría de la poblacín";
                    }
                    if(Integer.parseInt(nivel) >= 201){
                        condicion = "Muy dañino";
                    }
                    if(Integer.parseInt(nivel) > 300){
                        condicion = "Peligroso";
                    }
                    datoFinal.add("Nivel del aire es" + aire.get(i) + " "+condicion +" => La " + comuna.get(i));
                    
                    control++;
                    if(control %2==0){
                        datoFinal.add("\n");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de analisis aire " + e);
        }
        return datoFinal;
    }
    public ArrayList audio(){
        ArrayList audicio = new ArrayList();
        ArrayList habitantes = new ArrayList();
        ArrayList datoFinal = new ArrayList();
        try {
            FileReader f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while ((cadena = b.readLine()) != null) {
            String palabras[] = cadena.split(",");
                for (int i = 3; i < palabras.length; i+=5) {
                    audicio.add(palabras[i]);
                }
                for (int i = 1; i < palabras.length; i+=5) {
                    habitantes.add(palabras[i]);
                }
            }
            
            b.close();
            
            for (int i = 0; i < audicio.size(); i++) {
                String nivel = (String) audicio.get(i);
                nivel = nivel.replace(" ","");//Para quitar el espacio de un String para poder convertirlo a entero
                if(Integer.parseInt(nivel) >= 75){
                    int control = 1;
                    String condicion="";
                    if(Integer.parseInt(nivel) >= 75){
                        condicion = "ruido alto";
                    }
                    if(Integer.parseInt(nivel) > 100){
                        condicion = "discotecas y concierto";
                    }
                    if(Integer.parseInt(nivel) >= 120){
                        condicion = "umbral de dolor, daño irrereversible";
                    }
                    datoFinal.add("Nivel del audicio es" + audicio.get(i) +"db "+condicion +" => Los habitantes son " + habitantes.get(i) );
                    control++;
                    if(control %2==0){
                        datoFinal.add("\n");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error de analisis audio " + e);
        }
        return datoFinal;
    }
    
}
    
