/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algeo01;


import java.util.Scanner;

public class MATRIKS {
    /*Tipe Matriks*/
    protected double[][] matriks;
    protected int baris;
    protected int kolom;
    Scanner input = new Scanner(System.in);
    
    /*Konstruktor*/
    public void MATRIKS(int i, int j){
        matriks=new double[i][j];
        baris=i;
        kolom=j;
    }
    
    /*Selektor*/
    public int getBrs(){
        return this.baris;
    }
    
    public int getKol(){
        return this.kolom;
    }
    
    public double getElmt(int i, int j){
        /*Mendapatkan elemen indeks baris i dan indeks kolom j */
        return this.matriks[i][j];
    }
    
    /****Fungsi pada Matriks****/
    /*Baca dan Tulis*/
    public void bacaMatriks1(){
        /*Baca Melalui Keyboard*/
        System.out.print("Masukkan jumlah baris: ");
        this.baris=input.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        this.kolom=input.nextInt();
        this.matriks = new double[this.baris][this.kolom];
        for (int i=0; i<baris; i++){
            for (int j=0; j<kolom; j++){
                this.matriks[i][j]=input.nextDouble();
            }
        }
    }
    
    public void tulisMatriks(){
        /*Menampilkan matriks*/
        for(int i=0; i<baris; i++){
            for(int j=0; j<kolom; j++){
                System.out.printf("%.2f", this.matriks[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
            
    public void swap(int R1, int R2){
        /*Menukar baris R1 dan R2*/
        for (int kol=0; kol<kolom; kol++ ){
            double temp=this.matriks[R1][kol];
            this.matriks[R1][kol]=this.matriks[R2][kol];
            this.matriks[R2][kol]=temp;
        }
    }
    
    public void plus(int R1, int R2, double K, double L){
        /* Menambah sekalius kali: K*R1 + L*R2*/
        for (int kol=0; kol<kolom; kol++ ){
            this.matriks[R1][kol]=K*this.matriks[R1][kol] + L*this.matriks[R2][kol];
        }
    }
    
    public void minus(int R1, int R2, double K, double L){
        /* Mengurang sekalius kali: K*R1 - L*R2*/
        for (int kol=0; kol<kolom; kol++ ){
            this.matriks[R1][kol]=K*this.matriks[R1][kol] - L*this.matriks[R2][kol];
        }
    }
    
    public void kaliKoef(int R, double X){
        /*Mengalikan seluruh baris R dengan X*/
        for (int j=this.getLead(R); j<baris;j++){
            this.matriks[R][j]=this.matriks[R][j]*X;
        }
    }
    
    public boolean isBrsZero(int R){
        /*mengecek apakah baris itu 0 semua*/
        int j=0;
        while(this.matriks[R][j]==0 && j<kolom-1){
            j++;
        }
        return (this.matriks[R][j]==0);        
    }
    
    public int getLead(int R){
        /*Mengembalikan indeks pertama yang bukan 0 pada baris i*/
        boolean cek = true;
        int j = 0;
        while(j<kolom && cek){
            if(this.matriks[R][j]==0){
                j++;
            } else {
                cek=false;
            }
        }
         return j;
    }
    
    public void sortMatriks(){
        /*Mengurutkan matriks berdasarkan getLead yang mengurut membesar*/
        int temp;
        int minLead;
        for(int i=0; i<baris; i++){
            minLead = i;
            for(int j=i+1; j<baris; j++){
                temp = this.getLead(j);
                if(temp < this.getLead(minLead)){
                    minLead = j;
                }  
            }   
            this.swap(i,minLead);
        }  
    }
    
    public void gauss(){
        /*melakukan OBE dengan metode eliminasi Gauss*/
        double leadKoef;
        double L;
        this.sortMatriks();
        /*buat seperti segetiga bawah bernilai 0*/
        for(int i=0;i<baris;i++){
            if (!this.isBrsZero(i)){
                leadKoef=this.matriks[i][this.getLead(i)];
                for (int j=i+1; j<baris;j++){
                    if(!this.isBrsZero(j)){
                        L=this.matriks[j][this.getLead(i)]/leadKoef;
                        this.minus(j, i, 1, L);
                    }
                    this.matriks[j][this.getLead(i)]=0; //agar tampilan bagus
                }
            }
        }
        /*setiap elemen pertama yang bukan nol (lead) di tiap baris bernilai 1*/
        for (int i=0; i<baris; i++){
            if (!this.isBrsZero(i)){
                leadKoef=this.matriks[i][this.getLead(i)];
                double temp=1/leadKoef;
                this.kaliKoef(i, temp);
            }
        }
    }
    
    public void gaussJordan(){
        /*Melakukan OBE dengan metode eliminasi Gauss Jordan*/
        this.gauss();
        for (int i=baris-1; i>0; i--){
            if (!this.isBrsZero(i)){
                for (int j=i-1; j>=0; j--){
                    double L=this.matriks[j][this.getLead(i)];
                    this.minus(j, i, 1, L);
                }
            }
        }
    }
}

