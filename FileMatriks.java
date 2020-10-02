package tubes_1algeo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMatriks {

    public static MATRIKS bacaFile(String fileName) {
        
        MATRIKS a = new MATRIKS();
        try {
            // membaca file
            File namaFile = new File(fileName);
            Scanner fileReader = new Scanner(namaFile);
            
            int baris=0;
            int kolom=0;
            
            while(fileReader.hasNextLine()){
                baris++;
                
                Scanner colReader = new Scanner(fileReader.nextLine());
                while(colReader.hasNextDouble())
                {
                    kolom++;
                    double f=colReader.nextDouble();
                }
            }
            
            a.makeMATRIKS(baris, kolom/4);

            fileReader.close();

            // read in the data
            fileReader = new Scanner (namaFile);
            for(int i = 0; i < baris; i++){
                for(int j = 0; j < kolom/4; j++){
                    if(fileReader.hasNextDouble()){
                        a.matriks[i][j] =(double) fileReader.nextDouble();
                    }
                }
            }       
        } catch (FileNotFoundException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
        return a;
    }
}