/**
 * Programa: Programa 4 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 20/03/2017 Clase: LogRanges Descripción: Clase que almacena los
 * valores de una parte, segun los datos.
 *
 */
package edu.uniandes.ecos.CAIS.P4PSP2.model;

public class Part {

    private String name;

    private double size;

    private Integer numberItems;

    private double relation;

    private double ln;

    /**
     * Método constructor de la clase Part
     *
     * @param name
     * @param size
     * @param numberItems
     */
    public Part(String name, double size, Integer numberItems) {
        this.name = name;
        this.size = size;
        this.numberItems = numberItems;
    }

    /**
     * Método que permite acceder al valor de relation
     *
     * @return un valor <code>Double</code> del valor de relation.
     */
    public double getRelation() {
        return relation;
    }

    /**
     * Método que permite acceder al valor de ln (Logaritmo Natural)
     *
     * @return un valor <code>Double</code> del valor de ln.
     */
    public double getLn() {
        return ln;
    }

    /**
     * Método que permite calcular la relación entre el tamaño de la parte, y el
     * número de items;
     */
    public void calculateRelation() {
        this.relation = this.size / this.numberItems;
    }

    /**
     * Método que permite calcular el logaritmo natural de la relación.
     */
    public void calculateLn() {
        this.ln = Math.log(this.relation);
    }
}
