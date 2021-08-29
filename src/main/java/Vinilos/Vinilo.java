package Vinilos;

public class Vinilo {
    private final String name;
    private final String author;
    private final String date;

    public Vinilo(String name, String author, String date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }
    public void mostrar(){
        System.out.println("-------------");
        System.out.println("nombre: "+this.name);
        System.out.println("autor: "+this.author);
        System.out.println("fecha: "+this.date);
        System.out.println("-------------");

    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'';
    }
}
