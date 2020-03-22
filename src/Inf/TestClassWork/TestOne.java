package Inf.TestClassWork;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestOne {

    public static void main(String[] args){

        try(InputStream in2 = new FileInputStream("src/Inf/TestClassWork/Asd.txt")){
            System.out.println(in2.read());
            System.out.println(in2.read());
        }

        catch(IOException ex){
            System.err.println(ex.getMessage());
        }

    }
}