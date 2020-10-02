package tubes_1algeo;


import java.util.Scanner;
import java.io.*;

public class Matriks_Balikan extends MATRIKS {

  
    public static  MATRIKS MatriksBalikanGaussJordan(MATRIKS N){
        //Melakukan gaussJordan
        N.gaussJordan();
        //Pemotongan matriks menjadi 2, sebelah kanan matriks balikkannya
        //  A.I=I.A^(-1)
        MATRIKS r =new MATRIKS ();
        r.MATRIKS(N.baris, N.baris);
        r=N.potongMatriks(N);
       
        return r;
    }
    
    
    public static MATRIKS MatriksBalikanAdjoin(MATRIKS m){
      
        MATRIKS k  = new MATRIKS();
        MATRIKS l = new MATRIKS();
        MATRIKS o = new MATRIKS();
        
        k=Mkofaktor(m);
        l=k.transpose(k);
    
        double r = Determinan.detKofaktor(m); 
        double s = 1/r;
       
        o=l.Kali(l,s);
        return o;
    }
}