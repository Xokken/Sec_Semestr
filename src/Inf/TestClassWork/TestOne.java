package Inf.TestClassWork;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestOne {

    public static void main(String[] args) throws IOException {
        String command = "\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!";
        File file = new File(command);
        if (file.isAbsolute()){
            System.out.println(file.getAbsolutePath());
        }
        else{
            System.out.println("NO!");;
        }
        Desktop desktop = Desktop.getDesktop();
        //desktop.open(new java.io.File("C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\anime-pictures.net-548687.jpg"));

        File copied = new File("\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\anime-pictures.net-548687.jpg");
        File originalPath = new File("\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\TestForFile.jpg");


        String[] buf = new String[2];
        String nameFile = "anime-pictures.net-548687.jpg";
        buf[0] = nameFile.substring(0,nameFile.lastIndexOf("."));
        buf[1] = nameFile.substring(nameFile.lastIndexOf("."));
        System.out.println();
        System.out.println(buf[0] + " " + buf[1]);
    }
}