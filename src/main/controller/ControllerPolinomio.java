/*
 * Define los metodos para responder a eventos (acciones del usuario).
 */
package main.controller;


import main.view.Create;
import main.view.Operation;
import main.view.Show;
import main.model.Polinomio;

/**
 *
 * @author we
 */
public class ControllerPolinomio {

    /**
     * Muestra todos los polinomios 
     * guardados en memoria.
     */
    public static void index() {
        Polinomio.all();
    }

    /**
     * Retorna un polinomio en especifico 
     * desde memoria por su id.
     * @param identifier identificación del polinomio
     * @return polinomio por identificación
     */
    public static Polinomio show(int identifier) {
        return Polinomio.byID(identifier);
    }

    /**
     * Guarda un polinomio en memoria.
     * @param polinomio Polinomio a guardar en memoria
     */
    public static void store(Polinomio polinomio) {
        Polinomio.save(polinomio);
    }

    /**
     * Muestra el formulario para
     * crear un polinomio.
     */
    public static void crear() {
        Create.index();
    }

    /**
     * Muestra el formulario para
     * mostrar polinomios.
     */
    public static void mostrar() {
        Show.index();
    }

    /**
     * Muestra el formulario para
     * operar (multiplicar) polinomios.
     */
    public static void multiplicar() {
        Operation.multiplicar();
    }

    /**
     * Muestra el formulario para
     * operar (dividir) polinomios.
     */
    public static void dividir() {
        Operation.dividir();
    }

    /**
     * Muestra el formulario para
     * operar (derivar) un polinomio.
     */
    public static void derivar() {
        Operation.derivar();
    }
}
