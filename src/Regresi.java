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
        double [] xk=new double[nvar];
            for (int x=0; x<nvar;x++){
                xk[x]=0;
            }
        System.out.println("Masukkan nilai-nilai x yang ingin dicari: ");
        for (int i=0; i<nvar;i++){
            System.out.print("x" + (i+1) + ": ");
            xk[i]=scan.nextDouble();
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
        double [] nilai=new double[h.kolom-1];
        for (int x=0; x<h.kolom-1;x++){
            nilai[x]=0;
        }
        for (int R=h.kolom-2;R>=0;R--){
                nilai[R]=h.matriks[R][(h.kolom-1)];
                if (R<h.kolom-2){
                    for (int k=h.getLead(R)+1;k<h.kolom-1;k++){
                        nilai[R]=nilai[R] - (h.matriks[R][k]*nilai[k]);
                    }
                }    
        }
        double hasil=nilai[0];
        for (int i=1; i<=nvar; i++){
            hasil+=nilai[i]*xk[i-1];
        }
        System.out.println("Persamaan regresi: ");
        System.out.print("y = ");
        for (int i=0; i<=nvar;i++){
            if (i==0){
                System.out.printf("%.4f",nilai[i]);
            } else if (i>0){
                if (nilai[i]>=0){
                    System.out.print(" + ");
                } else {
                    System.out.print(" ");
                }
                System.out.printf("%.4f",nilai[i]);
                System.out.print("(x" + (i) + ")");
            }
        }
        System.out.println(" ");
        System.out.println("sehingga");
        System.out.print(" y = ");
        System.out.printf("%.4f",hasil);
        System.out.println(" ");
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
