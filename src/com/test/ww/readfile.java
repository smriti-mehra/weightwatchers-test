/**
 * Created by scmehra on 4/25/17.
 */
package com.test.ww;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class readfile
{

    public static void main(String[] args) throws FileNotFoundException {
        Path path = Paths.get("//DataInput//test.txt");
        File fileName = new File("DataInput/test.txt");
        doesFileExist(fileName); //function that checks if the file is available in location or not
        readFile(fileName); //reads the contents of the file
    }

    private static void readFile(File files) throws FileNotFoundException{
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(files)));
            String line = null;
            while((line = br.readLine())!= null)//this traverses through the file contents 
            {
                String [] tokens = line.split("–");//splits each word 
                String var_1 = tokens[0].trim();//removes any extra spaces if any available in file
                String[] meaning_1 = tokens[1].split(",");
                System.out.println(var_1);
                for(int i = 0; i < meaning_1.length; i++)
                {
                    System.out.println(meaning_1[i].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   private static void doesFileExist(File fileName) throws FileNotFoundException {
        try {
            
            boolean test = fileName.exists();//checks to see if the file exists at the provided location.

            if(test)
            {
                System.out.println("File is available");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
