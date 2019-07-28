package main;

import java.util.Scanner;
import java.util.ArrayList;
import main.polinomio.Termino;
import main.polinomio.Polinomio;

public class UI {

    static Scanner read = new Scanner (System.in);

    public static final String LOGO = 
          "                     /$$ /$$                                   /$$          "        + "\n" 
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

    public static final String MAIN_OPTIONS =
          "\n" + "[~] Seleccione alguna opcion!" + "\n"

        + "\t" + "[1] - Crear polinomio."        + "\n"
        + "\t" + "[2] - Mostrar polinomio."      + "\n"
        + "\t" + "[3] - Multiplicar polinomio."  + "\n"
        + "\t" + "[4] - Dividir polinomio."      + "\n"
        + "\t" + "[5] - Derivar polinomio."      + "\n"
        + "\t" + "[.] - Salir."                  + "\n"
        + "\n" + "choice: ";

    public static final String CREATE_POLYNOMIAL_OPTIONS =
          "\n" + "[~] Seleccione alguna opcion!"       + "\n"
        + "\n" + "[!] n = [1,2,3,4....)"               + "\n"

        + "\t" + "[0] - Mostrar todos los polinomio."  + "\n"
        + "\t" + "[n] - Mostrar el n-esimo polinomio." + "\n"
        + "\t" + "[.] - Inicio."                       + "\n"
        + "\n" + "choice: ";

    public static final String ERROR = 
          "\n" + "[!] Ingrese una opcion correcta!" + "\n"
        + "\n" + "choice: ";

    public static void show(String options) {
        System.out.print(options);
    }

    public static char choice() {
        return read.next().charAt(0);
    }

    public static void selectFromMainOptions(char select) {
        switch (select) {
            case '1':
                break;
            case '2':
                show(CREATE_POLYNOMIAL_OPTIONS);
                break;
            case '3':
                break;
            case '4':
                break;
            case '5':
                break;
            case '.':
                break;
            default:
                show(ERROR);
                break;
        }
    }

    public static void selectFromCreatePolynomialOptions(char select) {
        switch (select) {
            case '0':
                break;
            case '.':
                break;
            default:
                break;
        }
    }

    public static void index() {

    }

    public static create() {

    }

    static ArrayList<Polinomio> polinomios = new ArrayList<Polinomio>();
    public static void store(Polinomio polinomio) {

    }


}
