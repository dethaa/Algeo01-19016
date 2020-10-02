package tubes1algeo;

import java.util.Scanner;
import java.io.*;

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
    public static void subMenu1(){
        System.out.println("1. Input melalui keyboard");
        System.out.println("2. Input dengan file");
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
                        subMenu1();
                        int inputan1=scan.nextInt();                  
                        switch (inputan1){
                            case 1:
                                MATRIKS m = new MATRIKS();
                                m.bacaMatriks1();
                                m.gauss();
                                m.tulisHasil();
                                break;
                            case 2:
                                System.out.println("Pastikan terdapat file matriks augmented dalam file test, dengan nama Matriks.txt");
                                File file1 = new File();
                                MATRIKS M = new MATRIKS();
                                M =file1.bacaMatriks("../test/Matriks.txt");
                                M.gauss();
                                M.tulisHasil();
                                break;
                        }
                        
                        break;
                    case 2: //Metode eliminasi Gauss-Jordan
                        subMenu1();
                        int inputan2=scan.nextInt();
                        switch(inputan2){
                            case 1:
                                MATRIKS n = new MATRIKS();
                                n.bacaMatriks1();
                                n.gaussJordan();
                                n.tulisHasil();
                                break;
                                
                            case 2:
                                System.out.println("Pastikan terdapat file matriks augmented dalam file test, dengan nama Matriks.txt");
                                File file2 = new File();
                                MATRIKS N = new MATRIKS();
                                N =file2.bacaMatriks("../test/Matriks.txt");
                                N.gaussJordan();
                                N.tulisHasil();
                                break;
                        }
                        
                        break;
                        
                    case 3: //Metode matriks balikan1
                        subMenu1();
                        int inputan3 = scan.nextInt();                        
                        switch (inputan3){
                            case 1:
                                MATRIKS a=new MATRIKS();
                                System.out.println("Masukkan matriks augmented.");
                                a.bacaMatriks1();
                                a.balikan();
                                break;
                            case 2:
                                System.out.println("Pastikan terdapat file matriks augmented dalam file test, dengan nama Matriks.txt");
                                File file3 = new File();
                                MATRIKS A = new MATRIKS();
                                A =file3.bacaMatriks("../test/Matriks.txt");
                                A.balikan();
                                break;
                        }
                    case 4: //Kaidah cramer
                        subMenu1();
                        int inputan4=scan.nextInt();                        
                        switch (inputan4){
                            case 1:
                                MATRIKS baru=new MATRIKS();
                                System.out.println("Masukkan matriks augmented.");
                                baru.bacaMatriks1();
                                baru.cramer();
                                break;
                            case 2:
                                System.out.println("Pastikan terdapat file matriks augmented dalam file test, dengan nama Matriks.txt");
                                File file4 = new File();
                                MATRIKS Baru = new MATRIKS();
                                Baru =file4.bacaMatriks("../test/Matriks.txt");
                                Baru.cramer();
                                break;
                        }
                }
                bacaMenu();
                break;
            case 2: //Determinan
                pil2();
                Determinan deter = new Determinan();
                int metode2 = scan.nextInt();
                switch(metode2){
                    case 1: //Metode reduksi baris
                        MATRIKS m = new MATRIKS();
                        m.bacaMatriks1();
                        if (m.isSquare()){
                            System.out.println("Determinannya adalah " + deter.detReduksi(m));
                        } else{
                            System.out.println("Bukan matriks persegi, determinan tidak dapat dicari.");
                        }
                        break;
                    case 2: //Metode ekspansi kofaktor
                        MATRIKS m2 = new MATRIKS();
                        m2.bacaMatriks1();
                        if (m2.isSquare()){
                            System.out.println("Determinannya adalah " + deter.detKofaktor(m2));
                        } else{
                            System.out.println("Bukan matriks persegi, determinan tidak dapat dicari.");
                        }
                        break;
                }
                bacaMenu();
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
                bacaMenu();
                break;
            case 4: //Interpolasi polinom
                Interpolasi ip = new Interpolasi();
                ip.interpol();
                bacaMenu();
                break;
            case 5: //Regresi linier berganda
                Regresi reg = new Regresi();
                reg.regresi();
                bacaMenu();
                break;
            case 6: //Keluar
                System.out.println("Terima kasih :)");
                break;
        }
    }
}
