package tubes1algeo;

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
    
    public void makeMATRIKS2(int i, int j){
        /*Membuat matriks kosong dengan ukuran ixj 
        semua elemen matriks berisi nilai 1*/
        this.baris=i;
        this.kolom=j;
        this.matriks = new double[this.baris][this.kolom];
        for (int a=0; a<baris; a++){
            for (int b=0; b<kolom; b++){
                this.matriks[a][b]=1;
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
    
    public void bacaMatriks2(int i, int j){
        /*membaca matriks dengan ukuran ixj*/
        for (int brs=0; brs<i; brs++){
            for (int kol=0; kol<j; kol++){
                this.matriks[brs][kol]=input.nextDouble();
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
        for (int j=this.getLead(R); j<this.kolom;j++){
            this.matriks[R][j]=this.matriks[R][j]*X;
        }
    }
    
    public void kaliKoef2(int R, double X){
        /*Mengalikan seluruh kolom R dengan X*/
        for (int j=0; j<this.baris;j++){
            this.matriks[j][R]=this.matriks[j][R]*X;
        }
    }
    
    public boolean isBrsZero(int R){
        /*Mengecek apakah seluruh elemen baris bernilai 0*/
        int j=0;
        while(this.matriks[R][j]==0 && j<this.kolom-1){
            j++;
        }
        return (this.matriks[R][j]==0);        
    }
    
    public boolean isSquare(){
        /*Mengecek apakah matriks merupakan matriks persegi*/
        return (this.getBrs()==this.getKol());
    }
    
    public int getLead(int R){
        /*Mengembalikan indeks pertama yang bukan 0 pada baris R*/
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
    
    public void kaliMatriks(MATRIKS m1, MATRIKS m2){
        /*m1 dikali m2*/
        MATRIKS M=new MATRIKS();
        M.makeMATRIKS(m1.baris, m2.kolom);
        for (int i=0;i<M.baris; i++){
            if (M.kolom>0){
                for (int j=0;j<M.kolom;j++){
                    for (int k=0;k<m1.kolom;k++){
                        M.matriks[i][j]+=m1.matriks[i][k]*m2.matriks[k][j];
                    }
                }
            } else {
                for (int k=0;k<m1.kolom;k++){
                    M.matriks[i][0]+=m1.matriks[i][k]*m2.matriks[k][0];
                }
            }
        }
    }
    
    public void makeIdentitas(int r){   
        for (int i = 0; i < r ; i++){
            for (int j = 0; j < r ; j++){
                if (i == j){
                    this.matriks[i][j] = 1;
                }
                else{
                    this.matriks[i][j] = 0;
                }
            }
	}
    }  
    
    
     public MATRIKS gabungMatriks(MATRIKS N1, MATRIKS N2){        
        MATRIKS gabungan = new MATRIKS();
        gabungan.MATRIKS(N1.baris,(N1.kolom+N2.kolom));

        if (N1.baris == N2.baris){
            for (int i = 0; i < N1.baris; i++){
                for (int j = 0; j < N1.kolom; j++){
                    gabungan.matriks[i][j] = N1.matriks[i][j];
		}
            }
            for (int i = 0; i < N1.baris; i++){
                for (int j = N1.kolom; j < N1.kolom + N2.kolom; j++){
                    gabungan.matriks[i][j] = N2.matriks[i][j-N1.kolom];
                }
            }
            return gabungan;
                 
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
    
    public void gauss(){
        /*Melakukan OBE dengan metode eliminasi Gauss*/
        double leadKoef;
        double L;
        this.sortMatriks();
        /*Membuat seperti segitiga bawah bernilai 0*/
        for(int i=0;i<this.baris;i++){
            if (!this.isBrsZero(i)){
                leadKoef=this.matriks[i][this.getLead(i)];
                for (int j=i+1; j<this.baris;j++){
                    if(!this.isBrsZero(j)){
                        L=this.matriks[j][this.getLead(i)]/leadKoef;
                        this.minus(j, i, 1, L);
                    }
                    this.matriks[j][this.getLead(i)]=0; //agar tampilan bagus
                }
            }
        }
        /*Setiap elemen pertama yang bukan nol (lead) di tiap baris bernilai 1*/
        for (int i=0; i<this.baris; i++){
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
        for (int i=this.baris-1; i>0; i--){
            if (!this.isBrsZero(i)){
                for (int j=i-1; j>=0; j--){
                    double L=this.matriks[j][this.getLead(i)];
                    this.minus(j, i, 1, L);
                    this.matriks[j][this.getLead(i)]=0; //agar tampilan bagus
                }
            }
        }
    }
    
    public void tulisHasil(){
        boolean tidakAda=false;
        /*cek apakah ada hasil*/
        int i=0;
        while (i<this.baris && !(tidakAda)){
            if (this.getLead(i)==this.kolom-1){
                tidakAda=true;
            }
            i++;
        }
        /*cek apakah solusi banyak*/
        boolean solBnyk=false;
        for(int R=0;R<this.kolom-1;R++){
            if (this.isBrsZero(R)){
                solBnyk=true;
            }
        }
        double [] nilai=new double[this.kolom-1];
        for (int x=0; x<this.kolom-1;x++){
            nilai[x]=0;
        }
        if (tidakAda){
            System.out.println("Solusi tidak ada");
        } else if (solBnyk){
            MATRIKS var = new MATRIKS();
            var.makeIdentitas(this.kolom-1);
            for (int R=0;R<this.kolom-1;R++){
                if (!(this.isBrsZero(R))){
                    var.matriks[this.getLead(R)][this.getLead(R)]=0;
                }
            }
            char [] huruf = {'a','b','c','d','e','f','g','h','i','j','k','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','v','w','y','z'};
            for (int R=this.kolom-2;R>=0;R--){
                if(!(this.isBrsZero(R))) {
                    nilai[R]=this.matriks[R][this.kolom - 1];
                    if(R<this.kolom-2){
                        for (int k=this.getLead(R)+1;k<this.kolom-1;k++){
                            nilai[R]=nilai[R] - (this.matriks[R][k]*nilai[k]);
                            var.matriks[R][k]=var.matriks[R][k] + (this.matriks[R][k]*var.matriks[k][k]);
                        }
                    } 
                }
            }
            for(int R=0;R<this.kolom-1;R++){
                if (this.isBrsZero(R)){
                    System.out.printf("X%d = %c ;",R+1, huruf[R]);
                } else {
                    System.out.printf("X%d = ",R+1);
                    if(nilai[R]!=0){
                        System.out.printf("%.2f ", nilai[R]);
                        for (int l=0;l<this.kolom-1;l++){
                            if(var.matriks[R][l]!=0){
                                if (var.matriks[R][l]>0){
                                    System.out.printf("+ %.2f%c ", var.matriks[R][l], huruf[l]);
                                } else {
                                    double cek=var.matriks[R][l]*(-1);
                                    System.out.printf("- %.2f%c ", cek, huruf[l]);
                                }
                            }
                        }
                    } else{
                        boolean awal=true;
                        for (int l=0;l<this.kolom-1;l++){
                            if(var.matriks[R][l]!=0){
                                if (var.matriks[R][l]>0){
                                    if (awal){
                                        System.out.printf("%.2f%c ", var.matriks[R][l], huruf[l]);
                                        awal=false;
                                    } else{
                                        System.out.printf("+ %.2f%c ", var.matriks[R][l], huruf[l]);
                                    }
                                    
                                } else {
                                    if (awal){
                                        System.out.printf("%.2f%c ", var.matriks[R][l], huruf[l]);
                                        awal=false;
                                    } else{
                                        double cek=var.matriks[R][l]*(-1);
                                        System.out.printf("- %.2f%c", cek, huruf[l]);
                                    }
                                }
                            }
                        }
                    }
                    System.out.printf(";");
                }
            }
        } else{
            for (int R=this.kolom-2;R>=0;R--){
                nilai[R]=this.matriks[R][(this.kolom-1)];
                if (R<this.kolom-2){
                    for (int k=this.getLead(R)+1;k<this.kolom-1;k++){
                        nilai[R]=nilai[R] - (this.matriks[R][k]*nilai[k]);
                    }
                }    
                System.out.printf("X%d = %.2f ;", R+1, nilai[R]);
            }
        }
    }
    
    public void cramer(){
        MATRIKS A= new MATRIKS();
        MATRIKS hasil=new MATRIKS();
        System.out.println("Masukkan matriks koefisien:");
        A.bacaMatriks1();
        System.out.println("Masukkan matriks hasil:");
        hasil.bacaMatriks2(A.getBrs(), 1);
        Determinan deter = new Determinan();
        for (int k=0;k<A.kolom;k++){
            MATRIKS M = new MATRIKS();
            for (int i=0;i<A.baris;i++){
                for (int j=0;j<A.kolom;j++){
                    if (j==k){
                        M.matriks[i][j]=hasil.matriks[i][0];
                    } else {
                        M.matriks[i][j]=A.matriks[i][j];
                    }
                }
            }
            System.out.printf("x%d=%f", k+1 ,Determinan.detReduksi(A)/Determinan.detKofaktor(M) );
        }
    }
}
