package Creditos;

public class Banco {
    public int credit;
    public int fee;

    public Banco(int credit, int fee) {
        this.credit = credit;
        this.fee = fee;
    }
    int calcularCredito(){
        if (this.credit <= 1000000 && this.credit>0){
            if (this.fee > 0 && this.fee <=12) {
                return (int) (this.credit*1.25);
            }else if(this.fee > 12 && this.fee<=23){
                return (int) (this.credit*1.30);
            }else if(this.fee >24){
                return (int) (this.credit*1.35);
            }
        }else if(this.credit > 1000000){
            if (this.fee > 0 && this.fee <=12) {
                return (int) (this.credit*1.15);
            }else if(this.fee > 12 && this.fee<=23){
                return (int) (this.credit*1.20);
            }else if(this.fee >24){
                return (int) (this.credit*1.25);
            }
        }else{
            System.out.println("error credito");
        }
        return 0;
    }

    public int calcularCuota(int cuotaFinal){
        return cuotaFinal/this.fee;
    }
    public void Calcular(){
        System.out.println("Monto total a pagar: "+calcularCredito()+ "\nCuotas mensuales de: "+calcularCuota(calcularCredito()));
    }
}
