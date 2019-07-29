/*
 * Define el formulario para que el usuario puede ver los 
 * polinomios almacenados en memoria.
 */
package main.view;


import java.util.Scanner;
import main.model.Polinomio;
import main.controller.ControllerPolinomio;

/**
 *
 * @author we
 */
public class Show {

    static Scanner read = new Scanner (System.in);

    public static final String OPTIONS =
          "\n" + "[~] Seleccione alguna opcion!"       + "\n"
        + "[!] n = [1,2,3,4....)"                      + "\n\n"

        +  "[0] - Mostrar todos los polinomio."  + "\n"
        +  "[n] - Mostrar el n-esimo polinomio." + "\n"
        +  "[.] - Inicio."                       + "\n";

    public static final String CHOICE =
        "\n" + "choice: ";
   
    /**
     * Formulario para mostrar polinomios
     */
    public static void index() {
        System.out.print(OPTIONS);
        char select;

        do {
            System.out.print(CHOICE);
            select = read.next().charAt(0);
            options(select);

        } while (select != '.');
    }

    /**
     * Opciones disponibles para que 
     * el usuario eliga el 
     * polinomio deseado.
     * @param select opcion a ejecutar
     */
    public static void options(char select) {
        switch (select) {
            case '0':
                ControllerPolinomio.index();
                break;
            case '.':
                break;
            default:
                int id = Character.getNumericValue(select);
                try {
                    Polinomio polinomio = ControllerPolinomio.show(id);
                    System.out.print("\n" + "ID: " + id + " >>> " + polinomio.mostrar() + "\n");
                } catch (IndexOutOfBoundsException e) {
                    System.out.print("\n" + "[!] Este polinomio no existe!" + "\n");
                }
            break;
        }
    }
}