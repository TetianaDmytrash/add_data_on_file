package work.with.file;

import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {
    private BufferedReader fileReader;

    public ReadFromFile(String fileName) {
        try{
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("error: try to open the file for read");
        }
    }

    public ArrayList readFromFile(){
        String line = null;
        ArrayList<String> workWithString = new ArrayList<>();
        try{
            while(fileReader.ready()){
                //получаем новые слова
                line = fileReader.readLine();
                workWithString.add(line);
            }
        }catch(NullPointerException | IOException e){
            System.err.print(e);
        }
        return workWithString;
    }

    public void close() throws Exception{
        if(fileReader != null){
            try {
                fileReader.close();
            } catch(Exception ex){
                System.out.println("error when close file for read");
            }
        }
    }
}
