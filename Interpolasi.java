package tubes1algeo;

import java.util.Scanner;

public class Interpolasi {
    public static void interpol(){
        int jml;
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
        m2.makeMATRIKS(jml, jml+1);
        for (int k =0; k<jml;k++){
            for (int l=0; l<jml; l++){
                m2.matriks[k][l]= StrictMath.pow(m.matriks[k][0], l);
            }
        }
        for (int a =0; a<jml; a++){
            m2.matriks[a][jml]=m.matriks[a][1];
        }
        m2.tulisMatriks();
    }
}
