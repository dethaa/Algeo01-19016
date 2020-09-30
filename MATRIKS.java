/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_1algeo;


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
    public void makeMATRIKS(int i, int j){
        /*Membuat matriks kosong dengan ukuran ixj 
        semua elemen matriks berisi nilai 0*/
        this.baris=i;
        this.kolom=j;
        this.matriks = new double[this.baris][this.kolom];
        for (int a=0; a<baris; a++){
            for (int b=0; b<kolom; b++){
                this.matriks[a][b]=0;
            }
        }
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
        /* Menambah sekaligus kali: K*R1 + L*R2*/
        for (int kol=0; kol<kolom; kol++ ){
            this.matriks[R1][kol]=K*this.matriks[R1][kol] + L*this.matriks[R2][kol];
        }
    }
    
    public void minus(int R1, int R2, double K, double L){
        /* Mengurang sekaligus kali: K*R1 - L*R2*/
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
        /*Mengecek apakah seluruh elemen baris bernilai 0*/
        int j=0;
        while(this.matriks[R][j]==0 && j<kolom-1){
            j++;
        }
        return (this.matriks[R][j]==0);        
    }
    
    public boolean isSquare(){
        /*Mengecek apakah matriks merupakan matriks persegi*/
        return (this.getBrs()==this.getKol());
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
        /*Melakukan OBE dengan metode eliminasi Gauss*/
        double leadKoef;
        double L;
        this.sortMatriks();
        /*Membuat seperti segitiga bawah bernilai 0*/
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
        /*Setiap elemen pertama yang bukan nol (lead) di tiap baris bernilai 1*/
        for (int i=0; i<baris; i++){
            if (!this.isBrsZero(i)){
                leadKoef=this.matriks[i][this.getLead(i)];
                double temp=1/leadKoef;
                this.kaliKoef(i, temp);
                this.matriks[i][this.getLead(i)]=1; //agar tampilan bagus
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
                    this.matriks[j][this.getLead(i)]=0; //agar tampilan bagus
                }
            }
        }
    }
    
    public void makeIdentitas(){
         MATRIKS m = new MATRIKS();
        m.bacaMatriks1();
        
        
       
        
     
       
        if (m.kolom==m.baris){
            int i=0;
            while(i<= m.baris){
                int j=0;
                while (j<=m.kolom){
                    if(i!=j){
                        this.matriks[i][j]=0;
                      
                    }
                    else{
                        this.matriks[i][j]=1;
                        
                    }
                    j=j+1;
                }
                i=i+1;
            
            }
            
        }
    }
    
    
     public MATRIKS gabungMatriks(MATRIKS N1, MATRIKS N2){
        
        MATRIKS gabungan = new MATRIKS();
        gabungan.MATRIKS(N1.baris,(N1.kolom+N2.kolom));



        if (N1.baris == N2.baris){
            int i=0;
            while(i<= N1.baris){
                int j=0;
                while (j<=N2.kolom){
            
                    gabungan.matriks[i][j]=N1.matriks[i][j];
                    
                    j=j+1;
                }
                i=i+1;
            
            }
            i=0;
            while(i<= N1.baris){
                int j=0;
                while (j<=N2.kolom){
                    gabungan.matriks[i][j] = N2.matriks[i][j-N1.kolom];
                    j=j+1;
                }
                i=i+1;
            
            }
       
        }
        else{
            
        }
        return gabungan;

        
    }
    
    public MATRIKS potongMatriks(int a, int b){
        MATRIKS potong = new MATRIKS();
        potong.MATRIKS(this.baris ,b-a+1);
        
        if ((a >= 0 && a < this.kolom) && (b >= 0 && b < this.kolom) && (a <= b)){
            
            for (int i = 0; i < this.baris; i++){
                int Kolom = 0;
                for (int j = a; j <= b; j++){
                    potong.matriks[i][Kolom] = this.matriks[i][j];
                    Kolom++;
                }
            }
           
	}
        else{
           
	}
        return potong;
    }
    
}  

    
    



    