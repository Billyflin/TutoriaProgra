package Taller1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sensor {
    public static ArrayList<ArrayList<Double>> listas = new ArrayList<>();

    public static void main(String[] args) {
        int x;
        do{
            showMenu();
            System.out.println("Desea realizar otra acción (No (0) / Si (1))");
            x=validar(1);
        }while (x!=0);
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
    public boolean noEmptyList(ArrayList<ArrayList<Double>> listas){
        if (listas.isEmpty()){
            agregarDias(listas);
            return true;
        }
        return false;
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
        System.out.println("6)Mostrar dia");
        System.out.println("0)SALIR ");
        getOption();
    }
    public static void showMenu2(){
        System.out.println("INGRESE EL DIA A BUSCAR");
        System.out.println("1) LUNES");
        System.out.println("2) MARTES");
        System.out.println("3) MIERCOLES");
        System.out.println("4) JUEVES");
        System.out.println("5) VIERNES");
        System.out.println("6) SABADO");
        System.out.println("7) DOMINGO");
    }

    private static void getOption() {
        try{
        int a =validar(6);
        switch (a){
            case 0 -> System.out.println("chau");
            case 1 -> agregarDias(listas);
            case 2 -> System.out.println("Movimientos mayores a 5: "+contarMayor5semanal(listas));
            case 3 -> alertaSemanal(listas);
            case 4 -> getOption2();
            case 5 -> mayorSemanal(listas);
            case 6 -> mostrarDia(listas);
            }
        }catch(Exception e){
            if (listas.isEmpty()){
                llenarDias(listas);
            }
        }
    }

    private static void mostrarDia(ArrayList<ArrayList<Double>> listas) {
        showMenu2();
        int a= validar(7);
        if(a==0) {
            System.out.println(listas.get(a));
        }
        else if(a>0){
            System.out.println(listas.get(a-1));
        }
    }


    private static void getOption2() {
        showMenu2();
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
    public static void alertaSemanal(ArrayList<ArrayList<Double>> listas){
        for (ArrayList<Double> anDoubleList:listas) {
            alerta(anDoubleList);
        }
    }
    public static int contarMayor5semanal(ArrayList<ArrayList<Double>> listas){
        int totalSemanal=0;
        for (ArrayList<Double> anDoubleList:listas) {
            totalSemanal+=contarmayor5(anDoubleList);
        }
        return totalSemanal;
    }

    public static int contarmayor5(ArrayList<Double> list){
        int a = 0;
        for (Double anDouble:list) {
            System.out.println(anDouble);
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