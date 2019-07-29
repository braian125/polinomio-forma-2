/*
 * Define el formulario para que el usuario opere los polinomios.
 */
package main.view;


import java.util.Scanner;
import main.model.Polinomio;
import main.controller.ControllerPolinomio;

/**
 *
 * @author we
 */
public class Operation {

    static Scanner read = new Scanner (System.in);

    public static final String SELECCION_POLINOMIO =
         "[~] Seleccione un polinomio por su ID: ";

    public static final String RESULTADO =
         "[~] Polinomio resultado: ";


    /**
     * Formulario para multiplicar polinomios.
     */
    public static void multiplicar() {
        System.out.print("\n" + SELECCION_POLINOMIO);
        int id = read.nextInt();
        Polinomio a = ControllerPolinomio.show(id);

        System.out.print(SELECCION_POLINOMIO);
        id = read.nextInt();
        Polinomio b = ControllerPolinomio.show(id);

        System.out.print(RESULTADO + Polinomio.multiplicar(a, b).mostrar() + "\n");
    }

    /**
     * Formulario para dividir polinomios.
     */
    public static void dividir() {
        System.out.print("\n" + SELECCION_POLINOMIO);
        int id = read.nextInt();
        Polinomio a = ControllerPolinomio.show(id);

        System.out.print(SELECCION_POLINOMIO);
        id = read.nextInt();
        Polinomio b = ControllerPolinomio.show(id);

        System.out.print(RESULTADO + Polinomio.dividir(a, b).mostrar() + "\n");
    }

    /**
     * Formulario para derivar polinomios.
     */
    public static void derivar() {
        System.out.print("\n" + SELECCION_POLINOMIO);
        int id = read.nextInt();
        Polinomio a = ControllerPolinomio.show(id);

        System.out.print(RESULTADO + Polinomio.derivar(a).mostrar() + "\n");
    }
}