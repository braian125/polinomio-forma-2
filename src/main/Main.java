/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

import main.polinomio.Polinomio;
import main.polinomio.Termino;

/**
 *
 * @author we
 */
public class Main {
    
    static Scanner read = new Scanner (System.in);
    static ArrayList<Polinomio> polinomios = new ArrayList<Polinomio>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        seleccionar();
    }

    public static void seleccionar() {
        int opcion;
        logo(); // mostrar logo (filet ASCII)
        
        do {
            opciones(); // mostrar opciones
            opcion = read.nextInt();
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    break;
                case 4:
                    dividir();
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("[~] Saliendo...");
                    break;
                default:
                    System.out.println("[~] Ingrese alguna de estas opciones (1, 2, 3, 4, 5, 6) ");
                    break;
            }
        } while (opcion != 6);
    }
    
    public static void logo() {
        System.out.println(
            "\n                     /$$ /$$                                   /$$          \n" +
            "                    | $$|__/                                  |__/          \n" +
            "  /$$$$$$   /$$$$$$ | $$ /$$ /$$$$$$$   /$$$$$$  /$$$$$$/$$$$  /$$  /$$$$$$ \n" +
            " /$$__  $$ /$$__  $$| $$| $$| $$__  $$ /$$__  $$| $$_  $$_  $$| $$ /$$__  $$\n" +
            "| $$  \\ $$| $$  \\ $$| $$| $$| $$  \\ $$| $$  \\ $$| $$ \\ $$ \\ $$| $$| $$  \\ $$\n" +
            "| $$  | $$| $$  | $$| $$| $$| $$  | $$| $$  | $$| $$ | $$ | $$| $$| $$  | $$\n" +
            "| $$$$$$$/|  $$$$$$/| $$| $$| $$  | $$|  $$$$$$/| $$ | $$ | $$| $$|  $$$$$$/\n" +
            "| $$____/  \\______/ |__/|__/|__/  |__/ \\______/ |__/ |__/ |__/|__/ \\______/ \n" +
            "| $$                                                                        \n" +
            "| $$                                                                        \n" +
            "|__/                                                                        "
        );
    }

    public static void opciones() {
        System.out.print(
              "\n[~] Seleccione alguna opcion!\n"
            + "======================================================================================\n"
            + "\t[1] Crear polinomio.\n"
            + "\t[2] Mostrar polinomio.\n"
            + "\t[3] Multiplicar polinomio.\n"
            + "\t[4] Dividir polinomio.\n"
            + "\t[5] Derivar polinomio.\n"
            + "\t[6] Salir.\n"
            + "======================================================================================\n"
            + "> "
        );
    }

    public static void crear() {
        System.out.print(
              "\n[~] Creando un polinomio\n"
            + "======================================================================================\n"
        );
        
        Polinomio polinomio = new Polinomio();
        double coeficiente;
        int exponente;
        char condicion;
        
        do {
            System.out.print(
                  "\t[~] Coeficiente:\n"
                + "\t> "
            );
            coeficiente = read.nextDouble();
            
            System.out.print(
                  "\t[~] Exponente:\n"
                + "\t> "
            );
            exponente = read.nextInt();
            polinomio.insertarTermino(new Termino(coeficiente, exponente));
            
            do {
                System.out.print("\t[~] Ingresar otro termino? [y/n] : ");
                condicion = read.next().charAt(0);
            } while (condicion != 'y' && condicion != 'n');
            
        } while (condicion == 'y');
        
        polinomio.ordenar();
        polinomio.simplificar();
        
        if (polinomio.length() > 0) {    
            polinomios.add(polinomio);
            
            System.out.print(
                "\n[~] Polinomio creado! : " + polinomio.mostrar()
                + "\n======================================================================================\n"
            );
        } else {
            System.out.print(
                "\n[~] Polinomio nulo! : " + 0
                + "\n======================================================================================\n"
            );
        }
    }

    public static void mostrar() {
        char opcion;
        System.out.print(
              "\n[~] Mostrar polinomio(s)"
            + "\n[~] Numero de polinomios disponibles : " + polinomios.size()
            + "\n[~] Seleccione alguna opcion!"
            + "\n======================================================================================\n"
            + "\t[.] Volver al inicio.\n"
            + "\t[0] Mostrar todos los polinomio.\n"
            + "\t[1] Mostrar el primer polinomio.\n"
            + "\t[2] Mostrar el segundo polinomio.\n"
            + "\t[3] (3,4,5...) Mostrar el n-esimo polinomio.\n"
            + "======================================================================================\n"
        );
        do {
            System.out.print("> ");
            opcion = read.next().charAt(0);
            switch (opcion) {
                case '.':
                    break;
                case '0':
                    System.out.print("\n[~] Mostrar todos los polinomios.\n");
                    mostrarPolinomios();
                    System.out.print("\n======================================================================================\n");
                    break;
                default:
                    int op = Character.getNumericValue(opcion);
                    
                    if (op > polinomios.size()) {
                        System.out.println("\n[~] Este polinomio no existe!");
                    } else {
                        System.out.print(
                          "\n[~] Mostrar polinomio : " + op
                        + "\n[" + opcion + "] " + polinomios.get(op - 1).mostrar() + "\n"
                        );
                    }
                    System.out.print("\n======================================================================================\n");
                    break;
            }
        } while (opcion != '.');
    }
    
    public static void dividir() {
        int indexPrimerPolinomio;
        int indexSegundoPolinomio;
        
        System.out.print("\n[~] Polinomios disponibles.\n");
        mostrarPolinomios();
        System.out.print("\n[~] Seleccione un polinomio por su indice!\n"
            + "\n> "
        );
        indexPrimerPolinomio = read.nextInt() - 1;
        System.out.print("\n[~] Seleccione otro polinomio por su indice!\n"
            + "\n> "
        );
        indexSegundoPolinomio = read.nextInt() - 1;
        
        Polinomio primero = polinomios.get(indexPrimerPolinomio);
        Polinomio segundo = polinomios.get(indexSegundoPolinomio);
        
        System.out.print(
            "\n[~] Polinomio resultado : " + Polinomio.dividir(primero, segundo).mostrar()
            + "\n======================================================================================\n"
        );
        
        // Polinomio dividendo = new Polinomio(new Termino[]{new Termino(1,4), new Termino(-2,3), new Termino(-11,2), new Termino(30,1), new Termino(-20,0)});
        // Polinomio dividor = new Polinomio(new Termino[]{new Termino(1,2), new Termino(3,1), new Termino(-2,0)});
        // Polinomio resultado = Polinomio.dividir(dividendo, dividor);
        // System.out.println("resultado: " + resultado.mostrar());
    }
    
    public static void mostrarPolinomios() {
        for (int i = 0; i < polinomios.size(); i++) {
            System.out.println("["+ (i+1) +"] " + polinomios.get(i).mostrar());
        }
    }
}
    