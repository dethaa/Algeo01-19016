package tubes1algeo;

import java.util.Scanner;

public class Interpolasi {
    public static void interpol(){
        int jml;
        double xk;
        Scanner scan = new Scanner(System.in);
        System.out.print("Jumlah titik: ");
        jml = scan.nextInt();
        MATRIKS m = new MATRIKS();
        MATRIKS m2 = new MATRIKS();
        m.makeMATRIKS(jml, 2);
        for (int i=0;i<jml;i++){
            System.out.println("Masukkan titik ke-" + (i+1) + ": ");
            for (int j=0; j<2; j++){
                m.matriks[i][j]=scan.nextDouble();
            }
        }
        System.out.println("Masukkan nilai x yang ingin dicari: ");
        xk = scan.nextDouble();
        m2.makeMATRIKS(jml, jml+1);
        for (int k =0; k<jml;k++){
            for (int l=0; l<jml; l++){
                m2.matriks[k][l]= StrictMath.pow(m.matriks[k][0], l);
            }
        }
        for (int a =0; a<jml; a++){
            m2.matriks[a][jml]=m.matriks[a][1];
        }
        m2.gaussJordan();
        double [] nilai=new double[m2.kolom-1];
        for (int x=0; x<m2.kolom-1;x++){
            nilai[x]=0;
        }
        for (int R=m2.kolom-2;R>=0;R--){
                nilai[R]=m2.matriks[R][(m2.kolom-1)];
                if (R<m2.kolom-2){
                    for (int k=m2.getLead(R)+1;k<m2.kolom-1;k++){
                        nilai[R]=nilai[R] - (m2.matriks[R][k]*nilai[k]);
                    }
                }    
        }
        double hasil=0;
        for (int i=0; i<jml; i++){
            hasil+=nilai[i]*StrictMath.pow(xk, i);
        }
        System.out.println("Persamaan polinom: ");
        System.out.print("p(x) = ");
        for (int i=0; i<jml;i++){
            if (i==0){
                System.out.printf("%.4f",nilai[i]);
                System.out.print("(x)");
            } else if (i>0){
                if (nilai[i]>=0){
                    System.out.print(" + ");
                } else {
                    System.out.print(" ");
                }
                System.out.printf("%.4f",nilai[i]);
                System.out.print("(x^" + (i+1) + ")");
            }
        }
        System.out.println(" ");
        System.out.println("sehingga");
        System.out.print("p(" + xk + ") = ");
        System.out.printf("%.4f",hasil);
        System.out.println(" ");
    }
}
