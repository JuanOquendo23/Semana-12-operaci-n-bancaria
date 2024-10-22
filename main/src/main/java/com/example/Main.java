package com.example;

import java.util.Scanner;

public class Main {
    static String[] nombres = { "Juan Pérez","Dashboard Salcedo" };
    static double[] saldos = { 1500.00, 800.00 };
    static Scanner opciones = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            System.out.println("Seleccione una de las opciones: ");
            int opcion = opciones.nextInt();

            switch (opcion) {
                // Deposito
                case 1:
                    int depositar = seleccionarCuenta();
                    System.out.println("Ingrese la cantidad que desea depositar: ");
                    double cantidadDeposito = opciones.nextDouble();
                    depositar (depositar, cantidadDeposito);
                    break;

                // Retiro
                case 2:
                    int retiro = seleccionarCuenta();
                    System.out.println("Ingrese cantidad que desea retirar: ");
                    double cantidadRetiro = opciones.nextDouble();
                    retirar(retiro, cantidadRetiro);
                    break;

                // Consulta Saldo
                case 3:
                    int consultarSaldo = seleccionarCuenta();
                    consultarSaldo(consultarSaldo);
                    break;

                // Salir del programa
                    case 4:
                    System.out.println("¡Gracias por utilizar banco simple!");
                   System.exit(0);
                // Mensaje de error
                default:
                    System.out.println("Opcion desconocida, intente con otra opción");

            }
        }

    }

    public static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar Saldo");
        System.out.println("4. Salir");
        System.out.println("----------------");

    }

    // Funcion para selecicionar cuenta
    public static int seleccionarCuenta() {
        System.out.println("Ingrese la cuenta que desea seleccionar");
        for (int i = 0; i < nombres.length; i++) {

            System.out.println(i + " ." + nombres[i]);

        }
        int indice;
        do {
            System.out.println("Ingrese el indice de la cuenta: ");
            indice = opciones.nextInt();
            if (indice < 0 || indice >= nombres.length) {
                System.out.println("Indice invalido, vuelve a ingresarlo");
            }
        } while (indice < 0 || indice >= nombres.length);
        return indice;
    }

    // Funcion Para Depositar

    public static void depositar(int indice, double cantidad) {
        if (cantidad > 0) {
            saldos[indice] += cantidad;
            System.out.println("Tu deposito ha sido exitoso.. Nuevo Saldo:" + saldos[indice]);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que 0 ");
        }
    }

    // Función retiro de fondos

public static void retirar (int indice, double cantidad) {
    if (cantidad > 0 ) {
        if (saldos [indice] >= cantidad) {
            saldos [indice] -= cantidad;
            System.out.println(" ¡Retiro con exito!, Su saldo actual es: " + saldos[indice]);

            } else {
                System.out.println("Saldo insuficiente para retirar. ");
                }
            } else  {
                System.out.println("La cantidad que desea retirar debe de ser mayor a 0 "); 
            }
}

    //Funcion para condultar saldo 

    public static void consultarSaldo(int indice) {
        System.out.println("El saldo de " + nombres[indice] + " es: " + saldos[indice]);

    }

}


