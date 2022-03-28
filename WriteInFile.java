package work.with.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteInFile {
    private PrintWriter printWriter;

    public WriteInFile(String fileName){
        try{
            printWriter = new PrintWriter(new FileWriter(fileName, true));
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("error: try to open the file for write");
        }
    }

    public void writeInFile(String text){
        printWriter.print(text + "\n");

    }

    public void close(){
        if(printWriter != null){
            try {
                printWriter.close();
            } catch(Exception ex){
                System.out.println("error when close file for write");
            }
        }
    }
}
