/**
 * Programa: Programa 4 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 20/03/2017 Clase: Program Descripcion: Clase que lee los archivos de
 * datos de un path, para calcular los log ranges de cada uno.
 *
 */
package edu.uniandes.ecos.CAIS.P4PSP2.controller;

import edu.uniandes.ecos.CAIS.P4PSP2.model.Data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;


public class Program {

    private LinkedList<Data> data;

    /**
     * Metodo que permite acceder al valor de data
     *
     * @return un valor <code>LinkedList</code> de los datos.
     */
    public LinkedList<Data> getData() {
        return data;
    }

    /**
     * Metodo que lee los archivos localizados en path para instanciar objetos
     * de tipo Data
     *
     * @param path
     */
    public void readFiles(String path) {
        this.data = new LinkedList<Data>();

        File[] files = new File(path).listFiles();

        for (File file : files) {
            String name = file.getName();
            BufferedReader content = this.getFileContent(file.getPath());
            Data info = new Data(name, content);
            info.createParts();
            info.calculateResult();
            this.data.add(info);
        }

    }

    /**
     * Metodo que permite obtener el contenido de un archivo
     *
     * @param path
     */
    private BufferedReader getFileContent(String path) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    /**
     * Metodo que muestra los resultados de cada calculo
     */
    public void showResults() {
        
        Iterator it = this.data.iterator();

        while (it.hasNext()) {
            Data info = (Data) it.next();
            System.out.println("Name: " + info.getName());
            System.out.println("VS: " + info.getRanges().getVs());
            System.out.println("S: " + info.getRanges().getS());
            System.out.println("M: " + info.getRanges().getM());
            System.out.println("L: " + info.getRanges().getL());
            System.out.println("VL: " + info.getRanges().getVl());
        }
    }
}
