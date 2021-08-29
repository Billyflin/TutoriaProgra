package Vendedores;

public class Matriz {
    static int[][] ventas=new int[15][12];
    public static void main(String[] args) {
        llenar(ventas);
        mostrar(ventas);
        cadauno(ventas);
    }

    public static void cadauno(int[][] x){
        for (int j = 0; j < 15; j++) {
            int ventatotal = 0;
            for (int i = 0; i <= 11; i++) {
                ventatotal = ventatotal + x[j][i];
            }
            System.out.println(ventatotal);
        }
    }

    public static void llenar(int[][] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j]= (int)(Math.random()*10);
            }
        }
    }
    public static void mostrar(int[][] x){
        for (int[] ints : x) {
            for (int anInt : ints) {
                System.out.print("[" + anInt + "]");
            }
            System.out.println();
        }
    }
}
