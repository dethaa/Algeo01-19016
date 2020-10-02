/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_1algeo;

/**
 *
 * @author asus
 */

import java.util.Scanner;
import java.io.*;


public class Matriks_Balikan extends MATRIKS {

  
    
    
    public static  MATRIKS MatriksBalikanGaussJordan(MATRIKS m){
      
    
        

        
        //Membuat matriks identitas
        MATRIKS i = new MATRIKS ();
        i.MATRIKS(m.baris, m.kolom);
        MATRIKS j = new MATRIKS ();
        MATRIKS N = new MATRIKS(); 
        i.makeIdentitas(i.baris);
     
    
        //matriks inputan digabung matriks identitas
        N = N.gabungMatriks(m,i);
 
        
        //
        N.gaussJordan();
     
        
        MATRIKS r =new MATRIKS ();
        r.MATRIKS(m.baris, m.kolom);
        r=N.potongMatriks(N);
       
        return r;
            
        
    }
    
    
    
   
    public   MATRIKS MatriksBalikanAdjoin(MATRIKS m){
      
       
 
        MATRIKS k  = new MATRIKS();
        MATRIKS l = new MATRIKS();
        MATRIKS o = new MATRIKS();
       
        
     
      
        k=m.Mkofaktor(m);
    
        l=k.transpose(k);
    
        double r = Determinan.detKofaktor(m); 
        double s = 1/r;
       
        o=l.Kali(l,s);
        
        return o;
     
   }
   
}