/*
 * Define la vista principal del programa con el cual el usario interactúa.
 */
package main.view;


import java.util.Scanner;
import main.controller.ControllerPolinomio;

/**
 *
 * @author we
 */
public class Index {

    static Scanner read = new Scanner (System.in);

    public static final String LOGO = 
          "\n                     /$$ /$$                                   /$$          "      + "\n" 
        + "                    | $$|__/                                  |__/          "        + "\n" 
        + "  /$$$$$$   /$$$$$$ | $$ /$$ /$$$$$$$   /$$$$$$  /$$$$$$/$$$$  /$$  /$$$$$$ "        + "\n" 
        + " /$$__  $$ /$$__  $$| $$| $$| $$__  $$ /$$__  $$| $$_  $$_  $$| $$ /$$__  $$"        + "\n" 
        + "| $$  \\ $$| $$  \\ $$| $$| $$| $$  \\ $$| $$  \\ $$| $$ \\ $$ \\ $$| $$| $$  \\ $$" + "\n" 
        + "| $$  | $$| $$  | $$| $$| $$| $$  | $$| $$  | $$| $$ | $$ | $$| $$| $$  | $$"        + "\n" 
        + "| $$$$$$$/|  $$$$$$/| $$| $$| $$  | $$|  $$$$$$/| $$ | $$ | $$| $$|  $$$$$$/"        + "\n" 
        + "| $$____/  \\______/ |__/|__/|__/  |__/ \\______/ |__/ |__/ |__/|__/ \\______/ "     + "\n" 
        + "| $$                                                                        "        + "\n" 
        + "| $$                                                                        "        + "\n" 
        + "|__/                                                                        "        + "\n";

    public static final String AUTHORS =
        "\t" + "- AUTHORS:" + "\n" +
        "\t" + "- Brian | Cristian | Juan | Leonardo | Laura | Maria" + "\n" +
        "============================================================" ;

    public static final String OPTIONS =
          "\n" + "[~] Seleccione alguna opcion!" + "\n\n"

        +  "[1] - Crear polinomio."        + "\n"
        +  "[2] - Mostrar polinomio."      + "\n"
        +  "[3] - Multiplicar polinomio."  + "\n"
        +  "[4] - Dividir polinomio."      + "\n"
        +  "[5] - Derivar polinomio."      + "\n"
        +  "[.] - Salir."                  + "\n"
        + "\n" + "choice: ";
        
    public static final String ERROR = 
          "\n" + "[!] Ingrese una opcion correcta!" + "\n"
        + "\n" + "choice: ";
    
    /**
     * Formulario principal de interacción.
     */
    public static void index() {
        System.out.print(LOGO);
        System.out.print(AUTHORS);
        char select;

        do {
            System.out.print(OPTIONS);
            select = read.next().charAt(0);
            options(select);

        } while (select != '.');
    }
    
    /**
     * Opciones disponibles para la 
     * elección del usuario.
     */
    public static void options(char select) {
        switch (select) {
            case '1':
                ControllerPolinomio.crear();
                break;
            case '2':
                ControllerPolinomio.mostrar();
                break;
            case '3':
                ControllerPolinomio.multiplicar();
                break;
            case '4':
                ControllerPolinomio.dividir();
                break;
            case '5':
                ControllerPolinomio.derivar();
                break;
            case '.':
                break;
            default:
                System.out.print(ERROR);
                break;
        }
    }
}