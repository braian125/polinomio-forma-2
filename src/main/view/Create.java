/*
 * Define el formulario para la creacion de polinomios.
 */
package main.view;

import java.util.Scanner;
import main.model.Termino;
import main.model.Polinomio;
import main.controller.ControllerPolinomio;

/**
 *
 * @author we
 */
public class Create {

    static Scanner read = new Scanner (System.in);

    public static final String TITLE =
        "\n" + "[!] Creando polinomio...";

    public static final String COEFFICIENT =
        "\n" + "[~] Coeficiente: ";

    public static final String EXPONENT =
        "[~] Exponente: " ;

    public static final String QUESTION = 
        "[?] Ingresar otro termino? (y/n) : ";

    /**
     * Formulario para la creacion de polinomios.
     */
    public static void index() {
        System.out.print(TITLE);
        Polinomio polinomio = new Polinomio();
        char response;

        do {
            System.out.print(COEFFICIENT);
            double coeficiente = read.nextDouble();

            System.out.print(EXPONENT);
            int exponente = read.nextInt();

            polinomio.insertarTermino(new Termino(coeficiente, exponente));

            do {
                System.out.print(QUESTION);
                response = read.next().charAt(0);
            } while (response != 'y' && response != 'n');

        } while (response == 'y');
        ControllerPolinomio.store(polinomio);
    }
}