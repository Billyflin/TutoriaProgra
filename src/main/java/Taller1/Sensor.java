package Taller1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sensor {
    public static ArrayList<ArrayList<Double>> listas = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println(contarmayor5(llenarAreglo()));
        agregarDias(listas);
        System.out.println(listas);
        llenarDias(listas);
        System.out.println(listas.get(6));
        alerta(listas.get(6));
        show(listas.get(6));
        System.out.println(mayorElemento(listas.get(6)));
        showMenu();
    }
    public static void mayorSemanal(ArrayList<ArrayList<Double>> listas){
        Double mayor= (double) 0;
        for (ArrayList<Double> list:listas) {
            mayor=mayorElemento(list);
        }
        System.out.println("El mayor movimiento telurico de la semana fue "+truncar2(mayor));
    }

    public static void show(ArrayList<Double> lista){
        for (Double e: lista) {
            truncar(e);
        }
    }

    private static void llenarDias(ArrayList<ArrayList<Double>> listas) {
        for (ArrayList<Double> anList:listas) {
            anList = llenarAreglo();
        }
    }

    public static void agregarDias(ArrayList<ArrayList<Double>> listas){
        for (int i = 0; i < 7; i++) {
            listas.add(llenarAreglo());
        }
    }

    public static void showMenu(){
        System.out.println("Menu");
        System.out.println("1)Obtener datos");
        System.out.println("2)Contar sismos mayores a 5");
        System.out.println("3)SMS por mayores a 7 => (en desarrollo de momento imprime la cantidad de veces que se encontraron resultados mayores a 7)");
        System.out.println("4)Mayor día de semana");
        System.out.println("5)Mayor semana");
        System.out.println("0)SALIR ");
        getOption();
    }

    private static void getOption() {
        int a =validar(5);
        switch (a){
            case 0 -> System.out.println("chau");
            case 1 -> agregarDias(listas);
//            case 2 -> showArrays();
//            case 3 -> System.out.println(collect(num));
            case 4 -> getOption2();
            case 5 -> mayorSemanal(listas);
        }
    }
    private static void getOption2() {
        int a =validar(7);
        switch (a){
            case 0 -> System.out.println("chau");
            case 1 -> System.out.println("El mayor dato de el dia lunes es: "+truncar2(mayorElemento(listas.get(0))));
            case 2 -> System.out.println("El mayor dato de el dia martes es: "+truncar2(mayorElemento(listas.get(1))));
            case 3 -> System.out.println("El mayor dato de el dia miercoles es: "+truncar2(mayorElemento(listas.get(2))));
            case 4 -> System.out.println("El mayor dato de el dia jueves es: "+truncar2(mayorElemento(listas.get(3))));
            case 5 -> System.out.println("El mayor dato de el dia viernes es: "+truncar2(mayorElemento(listas.get(4))));
            case 6 -> System.out.println("El mayor dato de el dia sábado es: "+truncar2(mayorElemento(listas.get(5))));
            case 7 -> System.out.println("El mayor dato de el dia domingo es: "+truncar2(mayorElemento(listas.get(6))));
//            case 2 -> showArrays();
//            case 3 -> System.out.println(collect(num));
        }
    }

    private static String truncar2(Double d) {
        String pattern = "#.###";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        return decimalFormat.format(d);
    }


    public static void alerta(ArrayList<Double> list){
        for (Double anDouble:list) {
            if(anDouble>7){
            System.out.println("Alerta!!! se debe evacuar zona costera!");
            }
        }
    }

    public static int contarmayor5(ArrayList<Double> list){
        int a = 0;
        for (Double anDouble:list) {
            System.out.println(anDouble+" hola");
            if(anDouble>5){
                a++;
            }
        }
        return a;
    }

    public static ArrayList<Double> llenarAreglo(){
        Random r = new Random();
        ArrayList<Double> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double randomValue = (9.9) * r.nextDouble();
            a.add(randomValue);
        }
        return a;
    }

    public static void truncar(Double d){
        String pattern = "#.###";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        String formattedDouble = decimalFormat.format(d);
        System.out.println(formattedDouble);
    }

    public static Double mayorElemento(ArrayList<Double> list){
        Double mayorElemento= (double) 0;
        for (Double anDouble : list) {
                if (anDouble > mayorElemento) {
                    mayorElemento = anDouble;
                }
            }return mayorElemento;
    }
    public static int validar(int x) {
        int n = -1;
        do {
            //Scanner ponerlo dentro del DO, y dentro de una funcion
            Scanner teclado = new Scanner(System.in);
            //System.out.println("ingrese otro numero");
            try {
                n = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Error");
            }
            if (n < 0 || n > x) {
                System.out.println("ingrese un numero valido");
            }
        } while (n < 0 || n > x);
        return n;
    }
}