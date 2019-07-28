package main.polinomio;

public class Termino {

    private double coeficiente;
    private int exponente;

    public Termino(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
    
    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public double getCoeficiente() {
        return this.coeficiente;
    }

    public int getExponente() {
        return this.exponente;
    }
    
    public static Termino multiplicar(Termino a, Termino b) {
        double coeficiente = a.getCoeficiente() * b.getCoeficiente();
        int exponente = a.getExponente() + b.getExponente();
        
        return new Termino(coeficiente, exponente);
    }
    
    public static Termino dividir(Termino dividendo, Termino divisor) {
        double coeficiente = dividendo.getCoeficiente() / divisor.getCoeficiente();
        int exponente = dividendo.getExponente() - divisor.getExponente();
        
        return new Termino(coeficiente, exponente);
    }
    
    public static Termino derivar(Termino a) {
        double coeficiente = a.getCoeficiente() * a.getExponente();
        int exponente = 0;
        
        if (a.getExponente() > 0) {
            exponente = a.getExponente() - 1;
        }
        
        return new Termino(coeficiente, exponente);
    }
}