package main.polinomio;

public class Polinomio {

    private Termino[] polinomio;
    
    public Polinomio() {
        this.polinomio = new Termino[0];
    }
    
    public Polinomio(Termino[] polinomio) {
        this.polinomio = polinomio;
    }
    
    public int getGrado() {
        ordenar();
        return this.polinomio[0].getExponente();
    }
    
    public Termino[] getPolinomio() {
        return this.polinomio;
    }

    public int length() {
        return this.polinomio.length;
    }

    public void setTermino(Termino termino, int index) {
        this.polinomio[index] = termino;
    }

    public Termino getTermino(int index) {
        return this.polinomio[index];
    }

    public void insertarTermino(Termino termino) {
        Termino[] temporal = new Termino[length() + 1];
        for (int i = 0; i < length(); i++) {
            temporal[i] = getTermino(i);
        }
        
        temporal[length()] = termino;
        this.polinomio = temporal;
    }
    
    public static Polinomio sumar(Polinomio a, Polinomio b) {
        Polinomio resultado = new Polinomio();
        
        for (int i = 0; i < a.length(); i++) {
            resultado.insertarTermino(a.getTermino(i));
        }
        for (int i = 0; i < b.length(); i++) {
            resultado.insertarTermino(b.getTermino(i));
        }
        
        resultado.simplificar();
        resultado.ordenar();
        return resultado;
    }
    
    public static Polinomio dividir(Polinomio dividendo, Polinomio divisor) {
        Polinomio cociente = new Polinomio();
        
        while (dividendo.getGrado() >= divisor.getGrado()) {
            Termino a = dividendo.getTermino(0),
                    b = divisor.getTermino(0);
            
            Termino resultado = Termino.dividir(a, b);
            cociente.insertarTermino(resultado);
            
            Polinomio producto = monomioXpolinomio(resultado, divisor);
            producto = monomioXpolinomio(new Termino(-1, 0), producto);
            dividendo = sumar(dividendo, producto);
        }
        return cociente;
    }
    
    public static Polinomio monomioXpolinomio(Termino monomio, Polinomio divisor) {
        Polinomio resultado = new Polinomio();
        for (int i = 0; i < divisor.length(); i++) {
            Termino tmp = Termino.multiplicar(monomio, divisor.getTermino(i));
            resultado.insertarTermino(tmp);
        }
        return resultado;
    }
    
    public static Polinomio derivar(Polinomio a) {
        for (int i = 0; i < a.length(); i++) {
            Termino derivada = Termino.derivar(a.getTermino(i));
            a.setTermino(derivada, i);
        }
        a.simplificar();
        return a;
    }
    
    public String mostrar() {
        StringBuilder polinomio = new StringBuilder();
        
        for (int i = 0; i < length(); i++) {
            if (i == 0 && getTermino(i).getCoeficiente() > 0) {
                polinomio.append(getTermino(i).getCoeficiente()).append("X^").append(getTermino(i).getExponente());
            }
            
            if (i != 0 && getTermino(i).getCoeficiente() > 0) {
                polinomio.append(" + ").append(getTermino(i).getCoeficiente()).append("X^").append(getTermino(i).getExponente());
            }
            
            if (getTermino(i).getCoeficiente() < 0) {
                double coeficiente = getTermino(i).getCoeficiente() * (-1);
                polinomio.append(" - ").append(coeficiente).append("X^").append(getTermino(i).getExponente());
            }
            
        }
        return polinomio.toString();
    }
    
    public void simplificar() {
        Polinomio temporal = new Polinomio();
        
        for (int i = 0; i < length(); i++) {
            Termino termino = getTermino(i);
            double coeficiente = termino.getCoeficiente();

            for (int j = i+1; j < length(); j++) {
                if (termino.getExponente() == getTermino(j).getExponente() && coeficiente != 0) {
                    coeficiente += getTermino(j).getCoeficiente();
                    setTermino(new Termino(0, 0), j);
                }
            }
            
            if (coeficiente != 0) {
                temporal.insertarTermino(new Termino(coeficiente, termino.getExponente()));
            }
        }
        this.polinomio = temporal.getPolinomio();
    }
    
    public void ordenar() {
        for (int x = 0; x < length(); x++) {
            for (int i = 0; i < length()-x-1; i++) {
                if(getTermino(i).getExponente() < getTermino(i+1).getExponente()){
                    int exponente = getTermino(i+1).getExponente();
                    double coeficiente = getTermino(i+1).getCoeficiente();
                    
                    getTermino(i+1).setExponente(getTermino(i).getExponente());
                    getTermino(i+1).setCoeficiente(getTermino(i).getCoeficiente());           
                    getTermino(i).setExponente(exponente);
                    getTermino(i).setCoeficiente(coeficiente);
                }
            }
        }
    }

}