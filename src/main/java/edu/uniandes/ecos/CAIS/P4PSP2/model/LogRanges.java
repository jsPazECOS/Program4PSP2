/**
 * Programa: Programa 4 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 20/03/2017 Clase: LogRanges Descripción: Clase que almacena los
 * valores de los rangos de tamaño relativos de una serie de datos.
 *
 */
package edu.uniandes.ecos.CAIS.P4PSP2.model;

public class LogRanges {

    private double vs;
    private double s;
    private double m;
    private double l;
    private double vl;

    /**
     * Método constructor de la clase LogRanges
     *
     * @param vs
     * @param s
     * @param m
     * @param l
     * @param vl
     */
    public LogRanges(double vs, double s, double m, double l, double vl) {
        this.vs = vs;
        this.s = s;
        this.m = m;
        this.l = l;
        this.vl = vl;
    }

    /**
     * Método que permite acceder al valor de vs (Very Small).
     *
     * @return un valor <code>Double</code> del valor de vs.
     */
    public double getVs() {
        return vs;
    }

    /**
     * Método que permite acceder al valor de s (Small).
     *
     * @return un valor <code>Double</code> del valor de s.
     */
    public double getS() {
        return s;
    }

    /**
     * Método que permite acceder al valor de m (Medium).
     *
     * @return un valor <code>Double</code> del valor de m.
     */
    public double getM() {
        return m;
    }

    /**
     * Método que permite acceder al valor de l (Large).
     *
     * @return un valor <code>Double</code> del valor de l.
     */
    public double getL() {
        return l;
    }

    /**
     * Método que permite acceder al valor de vl (Very Large).
     *
     * @return un valor <code>Double</code> del valor de vl.
     */
    public double getVl() {
        return vl;
    }

}
