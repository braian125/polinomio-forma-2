/*
 * Define el objeto termino.
 */
package main.model;

/**
 *
 * @author we
 */
public class Termino {

    private double coeficiente;
    private int exponente;

    /**
     * (Constructor) Intancia el objeto 
     * termino.
     * @param coeficiente coeficiente del termino
     * @param exponente exponente del termino
     */
    public Termino(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
    
    /**
     * Modifica el coeficiente 
     * del termino.
     * @param coeficiente nuevo coeficiente
     */
    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    /**
     * Modifica el exponente
     * del termino.
     * @param exponente nuevo coeficiente
     */
    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    /**
     * Retorna el coeficiente 
     * del termino.
     * @return coeficiente
     */
    public double getCoeficiente() {
        return this.coeficiente;
    }

    /**
     * Retorna el exponente del 
     * termino. 
     * @return exponente
     */
    public int getExponente() {
        return this.exponente;
    }
    
    /**
     * Divide un termino por otro termino.
     * @param dividendo termino dividendo  
     * @param divisor termino divisor
     * @return termino resultado
     */
    public static Termino dividir(Termino dividendo, Termino divisor) {
        double coeficiente = dividendo.getCoeficiente() / divisor.getCoeficiente();
        int exponente = dividendo.getExponente() - divisor.getExponente();
        return new Termino(coeficiente, exponente);
    }
    
    /**
     * Deriva un termino.
     * @param termino a derivar  
     * @return termino resultado
     */
    public static Termino derivar(Termino a) {
        double coeficiente = a.getCoeficiente() * a.getExponente();
        int exponente = 0;
        if (a.getExponente() > 0) {
            exponente = a.getExponente() - 1;
        }
        return new Termino(coeficiente, exponente);
    }
}