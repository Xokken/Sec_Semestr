package Inf.Home_11;

import Inf.Home_10.StudentOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class TestMain{
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##########");
        HashMap map = new HashMap();
        map.put(40, 7);
        map.put(5, 55);
        map.put(30, 332);
        map.put(3, 76);
        map.put(10, 40);
        map.put(10, 33);

        try(IniOutputStream out = new IniOutputStream(new FileOutputStream("src/Inf/Home_11/test.ini"))){
            out.writeIni(map);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


        try(IniInputStream out = new IniInputStream(new FileInputStream("src/Inf/Home_11/test.ini"))){
            System.out.println(out.readIni().toString());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
