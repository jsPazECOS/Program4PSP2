/**
 * Programa: Programa 4 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 20/03/2017 Clase: Data Descripción: Clase que representa cada grupo de
 * datos, a los cuales se les calcula su logarithmic ranges.
 *
 */
package edu.uniandes.ecos.CAIS.P4PSP2.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data {

    private String name;
    private LinkedList<Part> parts;
    private double avg;
    private double variance;
    private double stdDeviation;
    private BufferedReader content;
    private LogRanges ranges;

    /**
     * Método constructor de la clase Data.
     *
     * @param name nombre del archivo
     * @param content contenido del archivo
     */
    public Data(String name, BufferedReader content) {
        this.name = name;
        this.content = content;
        this.parts = new LinkedList<Part>();
    }

    /**
     * Método que permite acceder al nombre de los datos
     *
     * @return un valor <code>String</code> que representa el nombre de los
     * datos
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite acceder a los rangos de logaritmos
     *
     * @return un valor <code>String</code> que representa el nombre de los
     * datos
     */
    public LogRanges getRanges() {
        return ranges;
    }

    /**
     * Método que toma el contenido del archivo para instanciar las partes.
     */
    public void createParts() {
        try {
            String sCurrentLine;
            while ((sCurrentLine = this.content.readLine()) != null) {
                sCurrentLine = sCurrentLine.trim();
                String data[] = sCurrentLine.split(";");
                String name = data[0];
                double size = Double.parseDouble(data[1]);
                int numberItems = (data.length > 2 ? Integer.parseInt(data[2]) : 1);

                Part part = new Part(name, size, numberItems);
                part.calculateRelation();
                part.calculateLn();
                this.parts.add(part);
            }

        } catch (IOException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que calcula el average de los valores de Ln
     */
    private void calculateAvg() {
        double sumatory = 0.0;
        Iterator it = this.parts.iterator();

        while (it.hasNext()) {
            Part part = (Part) it.next();
            sumatory += part.getLn();
        }

        this.avg = sumatory / this.parts.size();
    }

    /**
     * Método que calcula la varianza de los datos.
     */
    private void calculateVariance() {

        double denominator = this.parts.size() - 1;
        double sumatory = 0.0;

        Iterator it = this.parts.iterator();

        while (it.hasNext()) {
            Part part = (Part) it.next();
            sumatory += Math.pow(part.getLn() - this.avg, 2);
        }
        this.variance = sumatory / denominator;
    }

    /**
     * Método que calcula la desviación estandar de los datos.
     */
    private void calculateStdDeviation() {
        this.stdDeviation = Math.sqrt(this.variance);
    }

    /**
     * Método que calcula los rangos logaritmicos de los datos
     */
    private void calculateLogRanges() {
        double vs = this.avg - (2 * this.stdDeviation);
        vs = this.calculateLogRange(vs);
        double s = this.avg - (1 * this.stdDeviation);
        s = this.calculateLogRange(s);
        double m = this.avg;
        m = this.calculateLogRange(m);
        double l = this.avg + (1 * this.stdDeviation);
        l = this.calculateLogRange(l);
        double vl = this.avg + (2 * this.stdDeviation);
        vl = this.calculateLogRange(vl);

        this.ranges = new LogRanges(vs, s, m, l, vl);
    }

    /**
     * Método que calcula el logaritmo natural, y el exponencial de un valor.
     */
    private double calculateLogRange(double range) {
        double result;
        result = Math.exp(range);

        return result;
    }

    /**
     * Método que realiza el calculo de todos los datos.
     */
    public void calculateResult() {
        this.calculateAvg();
        this.calculateVariance();
        this.calculateStdDeviation();
        this.calculateLogRanges();
    }
}
