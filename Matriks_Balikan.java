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

  
    
    
    public MATRIKS MatriksBalikanGaussJordan(MATRIKS matriks_balikan){
      
            
        
        MATRIKS i = new MATRIKS();
        i.MATRIKS(matriks_balikan.baris, matriks_balikan.baris);
        i.makeIdentitas();
	MATRIKS N = new MATRIKS();
        N.MATRIKS(matriks_balikan.baris, (matriks_balikan.kolom)+(i.kolom));
        N = N.gabungMatriks(matriks_balikan,i);
        N.gaussJordan();
        matriks_balikan = N.potongMatriks((matriks_balikan.kolom), (matriks_balikan.kolom) + (i.kolom)-1);
       
        return matriks_balikan;
        
            
        
    }
    
    
    
    public MATRIKS MatriksBalikanAdjoin(MATRIKS m){
        MATRIKS matriks_balikan = new MATRIKS();
       
        matriks_balikan.bacaMatriks1();
        
        
        int i;
        if (m.Determinan(m)==0){
            System.out.println("Matriks Singular");
            return m;
        }
        else{
            MATRIKS MAdj = m.matriksAdjoin(m);
            for (i=0;i<m.baris;i++){
                MAdj.kaliKoef(i,1/m.determinan(m));
            }
            return MAdj;
        }
    }
}