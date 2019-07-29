/*
 * Define el objeto polinomio y su persistencia en tiempo de ejecución.
 */
package main.model;


import java.util.ArrayList;

/**
 *
 * @author we
 */
public class Polinomio {

    private Termino[] polinomio;
    
    /**
     * (Constructor) crea un nuevo
     * polinomio de tamaño = 0.
     */
    public Polinomio() {
        this.polinomio = new Termino[0];
    }
    
    /**
     * (Constrcuctor) crea un nuevo
     * polinomio con un nuevo termino.
     * @param termino Termino para guardar en el polinomio
     */
    public Polinomio(Termino termino) {
        this.polinomio = new Termino[]{termino};
    }
    
    /**
     * (Constrcuctor) crea un nuevo
     * polinomio con array de terminos.
     * @param terminos Termino para guardar en el polinomio
     */
    public Polinomio(Termino[] terminos) {
        this.polinomio = terminos;
    }
    
    /**
     * Retorna el exponente del polinomio.
     * @return exponente del polinomio
     */
    public int getGrado() {
        simplificar();
        ordenar();
        return this.polinomio[0].getExponente();
    }
    
    /**
     * Retorna el polinomio completo.
     * @return polinomio
     */
    public Termino[] getPolinomio() {
        return this.polinomio;
    }

    /**
     * Retorna cantidad de terminos del polinomio
     * que son distintos de cero (0).
     * @return cantidad de terminos
     */
    public int length() {
        return this.polinomio.length;
    }

    /**
     * Modifica el termino en determinada posicion.
     * @param termino nuevo termino
     * @param index posicion
     */
    public void setTermino(Termino termino, int index) {
        this.polinomio[index] = termino;
    }

    /**
     * Obtener un termino del polinomio 
     * por su posición.
     * @param index posicion 
     * @return termino 
     */
    public Termino getTermino(int index) {
        return this.polinomio[index];
    }

    /**
     * Insertar un nuevo termino en 
     * el polinomio.
     * @param termino a insertar
     */
    public void insertarTermino(Termino termino) {
        Termino[] temporal = new Termino[length() + 1];
        for (int i = 0; i < length(); i++) {
            temporal[i] = getTermino(i);
        }
        
        temporal[length()] = termino;
        this.polinomio = temporal;
    }
    
    /**
     * Retorna un polinomio de tipo String.
     * @return String polinomio
     */
    public String mostrar() {
        StringBuilder polinomio = new StringBuilder();
        for (int i = 0; i < length(); i++) {
            if (i == 0 && getTermino(i).getCoeficiente() > 0 && getTermino(i).getExponente() != 0) {
                polinomio.append(getTermino(i).getCoeficiente()).append("X^").append(getTermino(i).getExponente());
            }
            if (i != 0 && getTermino(i).getCoeficiente() > 0 && getTermino(i).getExponente() != 0) {
                polinomio.append(" + ").append(getTermino(i).getCoeficiente()).append("X^").append(getTermino(i).getExponente());
            }
            if (getTermino(i).getCoeficiente() < 0 && getTermino(i).getExponente() != 0) {
                double coeficiente = getTermino(i).getCoeficiente() * (-1);
                polinomio.append(" - ").append(coeficiente).append("X^").append(getTermino(i).getExponente());
            }
            if (getTermino(i).getExponente() == 0 && getTermino(i).getCoeficiente() < 0) {
                polinomio.append(" - ").append(getTermino(i).getCoeficiente() * (-1));
            }
            if (getTermino(i).getExponente() == 0 && getTermino(i).getCoeficiente() > 0) {
                polinomio.append(" + ").append(getTermino(i).getCoeficiente());
            }
        }
        return polinomio.toString();
    }
    
    /**
     * Simplifica el polinomio, suma 
     * sus terminos semejantes.
     */
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
    
    /**
     * Ordena el polinomio de modo descendente.
     * (algoritmo de ordenamiento: burbuja)
     */
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

    /**
     * Suma dos polinomio.
     * @param b primer polinomio 
     * @param b segundo polinomio 
     * @return polinomio resultado
     */
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

    /**
     * Multiplica dos polinomio.
     * @param a primer polinomio
     * @param b segundo polinomio 
     * @return polinomio resultado
     */
    public static Polinomio multiplicar(Polinomio a, Polinomio b) {
        Polinomio resultado = new Polinomio();

        for (int j = 0; j < b.length(); j++) {
            for (int i = 0; i < a.length(); i++) {
                int tempExp = (a.getTermino(i).getExponente()) + (b.getTermino(j).getExponente());
                double tempCoef = a.getTermino(i).getCoeficiente() * (b.getTermino(j).getCoeficiente());
                resultado.insertarTermino(new Termino(tempCoef, tempExp));
            }
        }
        resultado.ordenar();
        resultado.simplificar();
        return resultado;
    }

    /**
     * Divide dos polinomios.
     * @param dividendo primer polinomio dividendo
     * @param divisor segundo polinomio divisor
     * @return polinomio resultado cociente
     */
    public static Polinomio dividir(Polinomio dividendo, Polinomio divisor) {
        Polinomio cociente = new Polinomio();
        while (dividendo.getGrado() >= divisor.getGrado()) {
            Termino a = dividendo.getTermino(0),
                    b = divisor.getTermino(0);
            
            Termino resultado = Termino.dividir(a, b);
            cociente.insertarTermino(resultado);
            Polinomio producto = multiplicar(new Polinomio(resultado), divisor);
            producto = multiplicar(new Polinomio(new Termino(-1, 0)), producto);
            dividendo = sumar(dividendo, producto);
        }
        return cociente;
    }

    /**
     * Deriva un polinomio.
     * @param polinomio polinomio
     * @return polinomio resultado
     */
    public static Polinomio derivar(Polinomio polinomio) {
        for (int i = 0; i < polinomio.length(); i++) {
            Termino derivada = Termino.derivar(polinomio.getTermino(i));
            polinomio.setTermino(derivada, i);
        }
        polinomio.simplificar();
        polinomio.ordenar();
        return polinomio;
    }
    

    /**
     * Persistencia en tiempo de ejecución.
     */
    private static ArrayList<Polinomio> polinomios = new ArrayList<Polinomio>();

    /**
     * Guarda un polinomio en memoria.
     * @param polinomio polinomio a guardar
     */
    public static void save(Polinomio polinomio) {
        polinomio.simplificar();
        polinomio.ordenar();
        polinomios.add(polinomio);
    }

    /**
     * Muestra todos los polinomios 
     * almacenados en memoria.
     */
    public static void all() {
        for (int index = 0; index < polinomios.size(); index++) {
            System.out.println("\nID: " + (index + 1) + " >>> " + polinomios.get(index).mostrar());  
        }
    }
    
    /**
     * Retorna un polinomio almacenado
     *  en memoria por su id.
     * @param id identificación del polinomio. 
     * @return polinomio
     */
    public static Polinomio byID(int id) {
        return polinomios.get(id-1);
    }
}