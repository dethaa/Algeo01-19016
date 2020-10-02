package tubes1algeo;

import java.util.Scanner;

import java.io.*;

public class File{
    public MATRIKS bacaMatriks (String namaFile){
        File file;
        MATRIKS M = new MATRIKS();
        int NBrs=0;
        int NKol=0;
        int NEl=0;
        try{
            file = new File(namaFile);
            Scanner baris = new Scanner(file);
            while (baris.hasNextLine()){
                NBrs++;
                String line = baris.nextLine();
                Scanner kolom = new Scanner(file);
                while (kolom.hasNextDouble()){
                    NEl++;
                    double nilai=kolom.nextDouble();
                }
            }
            NKol=NEl/NBrs;
            Scanner input = new Scanner(file);
            M.MATRIKS(NBrs, NKol);
            for (int i=0; i<NBrs; i++){
                for (int j=0; j<NKol; j++){
                    double nilai=input.nextDouble();
                    M.matriks[i][j]=nilai;
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e);
        } 
        return M;
    }
    
   
    
    public void saveFile(MATRIKS m, String namafile){
        PrintWriter writer = null;
        try{
            writer = new PrintWriter(namafile);
            for (int i = 0; i<m.baris; i++){
                for(int j = 0; j<m.kolom; j++){
                    writer.print(m.matriks[i][j] + " ");
		} 
                writer.println();
            }
	}
	catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());			
	}
        finally {
            try{
                if (writer != null){
                    writer.close(); 
                }
            } 
            catch (Exception e){
                System.out.println("Could not close writer");
            }
	}
    }
}
