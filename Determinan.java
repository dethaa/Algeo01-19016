package tubes1algeo;
import java.util.Scanner;
import java.io.*;

public class Determinan extends MATRIKS {
    Scanner scan = new Scanner(System.in);
    
    public static double detReduksi(MATRIKS m){
        double det=0;
        if (m.getBrs()==2){
            det=((m.getElmt(0, 0)*m.getElmt(1, 1)) - (m.getElmt(1, 0)*m.getElmt(0, 1)));
        } else {
            int nSwap=1;
            double leadKoef;
            for(int i=0;i<m.getBrs();i++){
                if(!m.isBrsZero(i)){
                    int k=i+1;
                    while ((m.getLead(i)!=i) && k<m.getBrs()){
                        m.swap(i, k);
                        nSwap*=(-1);
                        k++;
                    } 
                    if(!(k == m.getBrs())){
                        leadKoef = m.matriks[i][m.getLead(i)];
                        for (int j=i+1; j<m.getBrs();j++){
                            if(!m.isBrsZero(j)){
                                if (m.getElmt(j, i)!=0){
                                    m.minus(j, i, 1, (m.getElmt(j, i)/leadKoef));
                                }
                            }
                        }
                    }
                } 
                
                det++;
                for (int a=0;a<m.getBrs();a++){
                    det*=m.getElmt(a, a);
                }
                det*=nSwap;
            }
        
        }
        return (det);
    }
    public static double detKofaktor(MATRIKS m){
        MATRIKS temp = new MATRIKS();
        double det = 0;
        if (m.getBrs()==2){
            det=((m.getElmt(0, 0)*m.getElmt(1, 1)) - (m.getElmt(1, 0)*m.getElmt(0, 1)));
        }else {
            int i,j,k;
            temp.makeMATRIKS(m.getBrs(), m.getKol());
            for(k=0;k<m.getKol();k++){
                for (i=1;i<m.getBrs();i++){
                    for (j=0;j<m.getKol();j++){
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
