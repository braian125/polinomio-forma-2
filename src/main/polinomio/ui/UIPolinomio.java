package main.polinomio.ui;


public class UIPolinomio extends Polinomio {
    
    public static final String TERMINO_COEFFICIENT =
          "\t" + "[~] Coeficiente:" + "\n"
        + "\n" + "choice: ";
        
    public static final String TERMINO_EXPONENT =
          "\t" + "[~] Exponente:" + "\n"

        + "\n" + "choice: ";

    public static final String QUESTION = 
        "\t[?] Ingresar otro termino? (y/n) : "

        + "\n" + "choice: ";

    public static void create() {
        Polinomio polinomio = new Polinomio();
        char response;

        do {
            show(TERMINO_COEFFICIENT);
            double coeficiente = read.nextDouble();

            show(TERMINO_EXPONENT);
            int exponente = read.nextInt();

            polinomio.insertarTermino(new Termino(coeficiente, exponente));
            response = question();

        } while (response == 'y');
        
        return polinomio;
    }

    private static char question() {
        char response;
        do {
            show(QUESTION);
            response = choice();
            if (response != 'y' && response != 'n') show(ERR);
        } while (response != 'y' && response != 'n');
        return response;
    }
}