package Opa;

import java.util.ArrayList;
import java.util.Scanner;

public class Arreglos {
    public static ArrayList<Integer> num= new ArrayList<>();
    public static ArrayList<Integer> range= new ArrayList<>();
    public static void main(String[] args) {
        num.add(929123);
        num.add(929059);
        num.add(929058);
        num.add(4);
        num.add(3);
        num.add(1);
        num.add(0);
        num.add(929129);
        num.add(92905);
        num.add(931639);
        num.add(931633);
        num.add(931637);
        num.add(931623);
        num.add(931611);
        showMenu();

    }
//    public static ArrayList<Integer> GetRange (ArrayList<Integer> list, int x, int z) {
//        ArrayList<Integer> temp = new ArrayList<> ();
//        for (int y = x ; y <= z; x++){
//            temp.add(list.get(x)) ;
//        }
//        return temp;
//    }
//    public static void inRange(int m,int n){
//        int intervalo=(m-n)+1;
//        int
//    }


    public static void showMenu(){
        System.out.println("Menu");
        System.out.println("1)Mostrar codigo");
        System.out.println("2)Mostrar pares e impares");
        System.out.println("3)Mostrar primos");
        System.out.println("4)Cambiar limites");
        System.out.println("0)SALIR ");
        getOption();
    }

    private static void getOption() {
    Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        switch (a){
            case 0 -> System.out.println("chau");
            case 1 -> System.out.println(num);
            case 2 -> showArrays();
            case 3 -> System.out.println(collect(num));
        }
    }

    private static void showArrays() {
        System.out.println(pair(num));
        System.out.println(odd(num));
    }

    public static ArrayList<Integer> odd(ArrayList<Integer> x){
        ArrayList<Integer> odd = new ArrayList<>();
        for (Integer number : x){
            if (number %2 == 1){
                odd.add(number);
            }
        }
        return odd;
    }

    public static ArrayList<Integer> pair(ArrayList<Integer> x){
        ArrayList<Integer> pairList = new ArrayList<>();
        for (Integer number : x){
            if (number %2 == 0){
                pairList.add(number);
            }
        }
        return pairList;
    }

    public static ArrayList<Integer> collect(ArrayList<Integer> x){
        ArrayList<Integer> primeList = new ArrayList<>();
        int counter=0;
        for (Integer number : x){
            if (number > 1){
                for (int i = 2; i < number; ++i){
                    if (number % i == 0){
                        counter++;
                        break;
                    }
                }
                if (counter == 0){
                    primeList.add(number);
                }
                counter=0;
            }
        }
        return primeList;
    }
}
