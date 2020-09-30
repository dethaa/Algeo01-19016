package tubes1algeo;
import java.util.Scanner;
import java.io.*;

public class Determinan extends MATRIKS {
    Scanner scan = new Scanner(System.in);
    
    public static void detreduksi(){
        MATRIKS m = new MATRIKS();
        double det=0;
        m.bacaMatriks1();
        if (m.isSquare()){
            if (m.getBrs()==2){
                det=((m.getElmt(0, 0)*m.getElmt(1, 1)) - (m.getElmt(1, 0)*m.getElmt(0, 1)));
            } 
            System.out.println("Determinannya adalah " + det);
        } else {
            System.out.println("Bukan merupakan matriks persegi, determinan tidak dapat dicari.");
        } 
    }
    public static double detkofaktor(MATRIKS m){
        MATRIKS temp = new MATRIKS();
        double det = 0;
        if (m.getBrs()==2){
            det=((m.getElmt(0, 0)*m.getElmt(1, 1)) - (m.getElmt(1, 0)*m.getElmt(0, 1)));
        }else {
            int i,j,k;
            temp.makeMATRIKS(m.getBrs(), m.getKol());
            for(k=0;k<=m.getKol()-1;k++){
                for (i=1;i<=m.getBrs()-1;i++){
                    for (j=0;j<=m.getKol()-1;j++){
                        if (j>k){
                            temp.matriks[i-1][j-1] = m.getElmt(i, j);
                        } else{
                            temp.matriks[i-1][j] = m.getElmt(i, j);
                        }
                    }
                }
                if (k%2==0){
                    det += m.getElmt(0, k)*((temp.getElmt(0, 0)*temp.getElmt(1, 1)) - (temp.getElmt(1, 0)*temp.getElmt(0, 1)));
                } else{
                    det -= m.getElmt(0, k)*((temp.getElmt(0, 0)*temp.getElmt(1, 1)) - (temp.getElmt(1, 0)*temp.getElmt(0, 1)));
                }
            }
        } 
        return(det);
    } //masih berhasil utk 2X2 dan 3X3
    
}
