/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algeo01;



/**
 *
 * @author mrxlo
 */
public class MATRIKS {

    static void Gauss(double[][] augmented){
        static void swipe(int R1, int R2){
            
            for (int kol=0; kol<kolom; kol++ ){
                double temp=this.matriks[R1][kol];
                this.matriks[R1][kol]=this.matriks[R2][kol];
                this.matriks[R2][kol]=temp;
            }
        }
        for (int bar=0; bar<augmented.length; bar++){
            if (bar==0){
                double temp=augmented[0][0];
                if (temp<0){
                    temp*=(-1);
                } else if (temp==0){
                    
                }
                for (int kol=0; kol<augmented[bar].length; kol++){
                    augmented[bar][kol]/=temp;
                }
            }else {
                for (int nol=0; nol<bar; nol++){
                    for (int kol=0; kol<augmented[bar].length; kol++){
                        augmented[bar][kol]-=
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("wow");
        System.out.println("");
    }
    
}

