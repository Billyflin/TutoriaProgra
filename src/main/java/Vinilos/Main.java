package Vinilos;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String rutaVinilos= "Vinilos.CSV";
    public static ArrayList<Vinilo> vinilos= new ArrayList<>();
    public static void main(String[] args) {
        llenar();
        int x;
        do{
            Scanner sc=new Scanner(System.in);
            menu();
            System.out.println("Desea realizar otra acción (No (0) / Si (1))");
            x=sc.nextInt();
        }while (x!=0);
    }
    public static void menu(){
        System.out.println("Menu");
        System.out.println("1)mostrar discos");
        System.out.println("2)agregar");
        System.out.println("3)cantidad de vinilos");
        System.out.println("0)SALIR ");
        Scanner sc = new Scanner(System.in);
        int a =sc.nextInt();
        switch (a){
            case 0 -> System.out.println("chau");
            case 1 -> mostrarDiscos();
            case 2 -> agregar();
            case 3 -> vinilosrestantes();
            case 4 -> vinilosbilly();
        }
    }

    private static void vinilosrestantes() {
        int vinilosTotales = vinilos.size();
        System.out.println("vinilosTotales = " + vinilosTotales);
        int espaciosRestantes = 100 - vinilosTotales;
        System.out.println("La cantidad de espacios restantes es " + espaciosRestantes);
    }

    public static void vinilosbilly(){
        System.out.println("vinilos totales "+vinilos.size());
        System.out.println("vinilos restantes "+(100-vinilos.size()));
    }

    public static void agregar(){
        if (vinilos.size() <= 100) {
            Scanner sc = new Scanner(System.in);
            System.out.println("autor");
            String autor = sc.nextLine();
            System.out.println("nombre");
            String nombre = sc.nextLine();
            System.out.println("fecha");
            String fecha = sc.nextLine();
            vinilos.add(new Vinilo(autor,nombre,fecha));
        }else{
            System.out.println("ya hay 100 discos");
        }
    }

    public static void mostrarDiscos(){
        for (Vinilo v:vinilos) {
            v.mostrar();
        }
    }
    public static void llenar(){
        try(CSVReader reader= new CSVReader(new FileReader(rutaVinilos))) {
            String[] nextline;
            while((nextline = reader.readNext()) != null){
                String autor= nextline[0];
                String nombre= nextline[1];
                String fecha= nextline[2];
                if(vinilos.size()<100){
                    vinilos.add(new Vinilo(nombre,autor,fecha));
                }else{
                    System.out.println("ya hay 100 discos");
                }
            }
        }catch(Exception e){
            System.out.println("error"+e);
        }
    }

}
