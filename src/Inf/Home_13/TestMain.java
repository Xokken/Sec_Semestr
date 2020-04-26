package Inf.Home_13;
import Inf.Home_10.StudentOutputStream;
import Inf.Home_9.Student;

import com.google.gson.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##########");
        Student student1 = new Student("ORA-ORA-ORA!", 'm', 1984, 902);
        Student student2 = new Student("KAGUNEE", 'f', 1999, 901);
        File fileGson = new File("C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_13\\Gsonnn.json");
        File fileYaml = new File("C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_13\\Yamll.yaml");

        Gson g = new Gson();
        System.out.println(g.toJson(student1));



        try (JSONStudentOutputStream out = new JSONStudentOutputStream(new FileOutputStream(fileGson))) {
            out.writeStudent(student1);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try(JSONStudentInputStream in = new JSONStudentInputStream(new FileInputStream(fileGson))) {
            Student studentOne = in.readStudent();
            System.out.println(studentOne.toString());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (YAMLStudentOutputStream out = new YAMLStudentOutputStream(new FileOutputStream(fileYaml))) {
            out.writeStudent(student2);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try(YAMLStudentInputStream in = new YAMLStudentInputStream(new FileInputStream(fileYaml))) {
            Student studentTwo = in.readStudent();
            System.out.println(studentTwo.toString());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }




    }
}
