package org.example.examenpoo.textBackup;

import org.example.examenpoo.DataBase.Enum_reportes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class TextFilesGenerator { //00183223 clase generadora de archivos de texto

    private static TextFilesGenerator instance = new TextFilesGenerator(); //00183223 instancia singleton de la clase

    private TextFilesGenerator(){} //00183223 metodo creador de clase

    public static TextFilesGenerator getInstance(){ //00183223 metodo para acceder a la instancia singleton
        return instance; //00183223 devolver instancia singleton
    }


    public void createBackup(Enum_reportes tipoReporte, TreeMap<Integer, ArrayList<String>> registros){ //00183223 funcion para crear archivo backup de registro

        File archivo = new File("src/main/resources/reportes", generadorNombreArchivo(tipoReporte)); //00183223 declarar nuevo archivo.txt

        try{ //00183223 intentar procedimiento de archivos
            if (!archivo.exists()){ //00183223 comprobar si el archivo aún no existe para crearlo
                archivo.createNewFile(); //00183223 crear el archivo
                escribirReporte(registros, archivo); //00183223 escribir los registros dentro del archivo

            }
        } catch (IOException e){ //00183223 atrapar error de manipulacion de archivos
            System.out.println(e); //00183223 reportar error en consola
        }
    }

    private String generadorNombreArchivo(Enum_reportes tipoReporte){ //00183223 funcion para crear el nombre del archivo txt

        String letraReporte = ""; //00183223 la letra del reporte que se pide
        switch(tipoReporte){ //00183223 selección según el tipo de reporte solicitado
            case REPORTE_A -> letraReporte = "A"; //00183223 asignacion como reporte A
            case REPORTE_B -> letraReporte = "B"; //00183223 asignacion como reporte B
            case REPORTE_C -> letraReporte = "C"; //00183223 asignacion como reporte C
            case REPORTE_D -> letraReporte = "D"; //00183223 asignacion como reporte D
        }

        Date fecha = new Date(); //00183223 fecha de creacion del archivo (dd mm yyyy hh:mm:ss)
        String[] elementosDate = fecha.toString().split(" "); //0013223 separar elementos de Date para manipularlos individualmente
        String fechaString = ""; //00183223 declarar variable donde contener los detalles de fecha

        for (int i=0; i<3; i++){ //00183223 explorar los primeros 3 elementos de la fecha
            fechaString += "-" + elementosDate[i]; //00183223 anexar cada elemento a fechaString
        }

        String[] elementosHora = elementosDate[3].split(":"); //00183223 separar la hora por cada ':' al no ser un caracter compatible con los nombres de archivos

        for (int i=0; i<elementosHora.length; i++){ //00183223 explorar cada elemento de la hora
            fechaString += "-" + elementosHora[i]; //00183223 anexar cada elemento de la hora a fechaString
        }


        return "reporte" + letraReporte + fechaString + ".txt"; //00183223 retornar el nombre unienddo todos los elementos del reporte
    }

    private void escribirReporte(TreeMap<Integer, ArrayList<String>> registros, File archivo){ //00183223 funcion para escribir dentro del archivo de reporte


        try{ //00183223 intentar procedimiento de archivos
            FileWriter writer = new FileWriter(archivo); //00183223 declarar FileWriter para el archivo especificaddo

            for (int key : registros.keySet()){ //00183223 explorar cada elemento del TreeMap de registros

                String nuevaLinea = key + ""; //00183223 iniciar la nueva linea con la key del elemento de registro

                for (String elemento : registros.get(key)){ //00183223 explorar todos los elementos del ArrayList correspondiente a la key del TreeMap
                    nuevaLinea += ", " + elemento; //00183223 anexar a la nueva linea cada elemento del ArrayList
                }
                writer.write(nuevaLinea + "\n"); //00183223 terminar agregando un salto de linea para la siguiente instancia de registro
            }

            writer.close(); //00183223 cerrar FileWriter
        } catch (IOException e){ //00183223 atrapar error de manejo de archivo
            System.out.println(e); //00183223 informar error en consola
        }
    }
}
