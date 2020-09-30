package tubes1algeo;

import java.util.Scanner;

public class Tubes1Algeo {
    
    public static void main(String[] args) {
        bacaMenu();
    }
    public static void menu(){
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi linier berganda");
        System.out.println("6. Keluar");
        System.out.println();
        System.out.print("Pilih angka: ");
    }
    public static void pil1(){
        System.out.println("1. Metode eliminasi Gauss ");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah Cramer ");
        System.out.println();
        System.out.print("Pilih angka: ");
    }
    public static void pil2(){
        System.out.println("1. Metode reduksi baris");
        System.out.println("2. Metode ekspansi kofaktor");
        System.out.println();
        System.out.print("Pilih angka: ");
    }
    public static void pil3(){
        System.out.println("1. Metode eliminasi Gauss-Jordan");
        System.out.println("2. Metode adjoin");
        System.out.println();
        System.out.print("Pilih angka: ");
    }
    public static void bacaMenu(){
        Scanner scan = new Scanner(System.in);
        menu();
        int pilihan = scan.nextInt();
        switch(pilihan){
            case 1: //SPL
                pil1();
                int metode1 = scan.nextInt();
                switch(metode1){
                    case 1: //Metode eliminasi Gaus
                        break;
                    case 2: //Metode eliminasi Gauss-Jordan
                        break;
                    case 3: //Metode matriks balikan
                        break;
                    case 4: //Kaidah cramer
                        break;
                }
                break;
            case 2: //Determinan
                pil2();
                Determinan deter = new Determinan();
                int metode2 = scan.nextInt();
                switch(metode2){
                    case 1: //Metode reduksi baris
                        deter.detreduksi();
                        break;
                    case 2: //Metode ekspansi kofaktor
                        MATRIKS m = new MATRIKS();
                        m.bacaMatriks1();
                        if (m.isSquare()){
                            System.out.println("Determinannya adalah " + deter.detkofaktor(m));
                        } else{
                            System.out.println("Bukan matriks persegi, determinan tidak dapat dicari.");
                        }
                        break;
                }
                break;
            case 3: //Matriks balikan
                pil3();
                int metode3 = scan.nextInt();
                switch(metode3){
                    case 1: //Metode eliminasi Gauss-Jordan
                        break;
                    case 2: //Metode adjoin
                        break;
                }
                break;
            case 4: //Interpolasi polinom
                break;
            case 5: //Regresi linier berganda
                break;
            case 6: //Keluar
                System.out.println("Terima kasih :)");
                break;
        }
    }
}
