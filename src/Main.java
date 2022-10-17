import java.util.Scanner;
//import Hausaufgabeeins.Note;

public class Main {
    Note[] noten;
    int anz;

    public Main() {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Wie viele Noten?");
        n = s.nextInt();
        Note[] liste = new Note[10];

        System.out.println("Geben Sie die Noten ein:");
        for (int i = 0; i < n; i++) {
            Note x = new Note(s.nextInt());
            //x.wert=s.nextInt();
            liste[i] = x;
        }
        this.anz = n;
        this.noten = liste;

    }

    public static void main(String[] args) {
        Main example = new Main();
        System.out.println("Die nicht ausreichenden Noten sind:");
        for (int i = 1; i <= example.ubungEins()[0]; i++) {
            System.out.println(example.ubungEins()[i]);
        }
        System.out.println("Die Mittelnote ist: ");
        System.out.println(example.ubungZwei());
        System.out.println("Die aufgerundeten Noten sind:");
        for (int i = 0; i < example.anz; i++) {
            System.out.println(example.ubungDrei()[i]);
        }
        System.out.println("Die maximale abgerundete Note ist:");
        System.out.println(example.ubungVier());
    }

    public int[] ubungEins() {
        for (int i = 0; i < this.anz; i++) {
            if (noten[i].wirdAufgerundet() == true)
                noten[i].aufrunden();
        }
        int[] nichtgenug = new int[10];

        int j = 1;
        for (int i = 0; i < this.anz; i++) {
            if (noten[i].istAusreichend() == false)
                nichtgenug[j++] = noten[i].wert;
        }
        nichtgenug[0]=j-1;
        /*int k = 0;
        for (k = 0; k < j - 1; k++) {
            System.out.print(nichtgenug[k].wert);
            System.out.print(", ");
        }
        System.out.println(nichtgenug[k].wert);*/
        return nichtgenug;
    }

    public int ubungZwei() {
        int s = 0;
        for (int i = 0; i < this.anz; i++) {
            s += this.noten[i].wert;
        }
        return s / this.anz;
    }

    public int[] ubungDrei() {
        int[] array = new int[this.anz];
        for (int i = 0; i < this.anz; i++) {
            if (this.noten[i].wirdAufgerundet() == true) {
                array[i] = this.noten[i].aufrunden();
            } else {
                array[i] = this.noten[i].wert;
            }
        }
        return array;
    }

    public int ubungVier() {
        int max = 0;
        for (int i = 0; i < this.anz; i++) {
            if (noten[i].wirdAufgerundet() == true)
                if (noten[i].aufrunden() > max && noten[i].aufrunden() != noten[i].wert)
                    max = noten[i].aufrunden();
        }
        return max;
    }

}