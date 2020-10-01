package tubes1algeo;

import java.util.Scanner;

public class Regresi extends MATRIKS{
    public static void regresi(){
        int jml;
        int nvar;
        Scanner scan = new Scanner(System.in);
        System.out.print("Jumlah data: ");
        jml = scan.nextInt();
        System.out.print("Jumlah variabel bebas: ");
        nvar = scan.nextInt();
        MATRIKS m = new MATRIKS();
        MATRIKS h = new MATRIKS();
        m.makeMATRIKS(jml,nvar+1);
        
        for (int i=0;i<jml;i++){
            System.out.println("Masukkan data ke-" + (i+1) + ": ");
            for (int j=0; j<=nvar; j++){
                m.matriks[i][j]=scan.nextDouble();      
            }
        }
        h.makeMATRIKS(nvar+1, nvar+2);
        h.matriks[0][0]=jml;
        for (int j=1;j<=nvar;j++){
            h.matriks[0][j]=sumkolom(m,j-1);
        }
        for (int i=1;i<=nvar;i++){
            h.matriks[i][0]=sumkolom(m,i-1);
        }
        for (int i=1;i<=nvar;i++){
            for (int j=1;j<=nvar;j++){
                h.matriks[i][j]=sumkali(m,i-1,j-1);
            }
        }
        h.matriks[0][nvar+1]=sumkolom(m,nvar);
        for (int i=1;i<=nvar;i++){
            h.matriks[i][nvar+1]= sumkali(m,i-1,nvar);
        }
        h.gaussJordan();
    }
    public static double sumkali(MATRIKS m, int a, int b){
        /*Menjumlahkan hasil kali elemen kolom a dan kolom b dari MATRIKS m*/
        double sum=0;
        for (int i=0;i<m.getBrs();i++){
            sum+= m.matriks[i][a]*m.matriks[i][b];
        }
        return (sum);
    }
    public static double sumkolom(MATRIKS m, int a){
        /*Menghasilkan hasil jumlah elemen kolom a pada MATRIKS m*/
        double sum=0;
        for (int i=0;i<m.getBrs();i++){
            sum+=m.matriks[i][a];
        }
        return (sum);
    }
}
