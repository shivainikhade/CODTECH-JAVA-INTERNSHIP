//CODTECH-JAVA-INTERNSHIP
//Task-1 File Handling utlity

import java.io.*;

public class FileHandling{
    public static void main(String args[]){
        try{
            //1.File Create
            File file= new File("Sample.txt");

            if(file.createNewFile()){
                System.out.println("File is created successfully!");
            }
            else{
                System.out.println("File already exists!");
            }

            //2.Write file
            FileWriter writer=new FileWriter(file);
            writer.write("This is task 1-File Handling utility\n");
            writer.close();
            System.out.println("Data written to file.");

            //3.Read File
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            System.out.println("\nReading file content:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

            // 4. Modify file (append new data)
            FileWriter modifyWriter = new FileWriter(file, true);
            modifyWriter.write("File modified successfully.\n");
            modifyWriter.close();
            System.out.println("\nFile modified successfully.");
            
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

