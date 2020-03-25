package Inf.Home_10;

import Inf.Home_9.Student;
import java.io.*;

public class TestMain {

    // Тестирование всего написанного мною

    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##########");

        File file = new File("C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_9\\test");
        Student student1 = new Student("ORA-ORA-ORA!", 'm', 1984, 902);
        Student student2 = new Student("KAGUNEE", 'f', 1999, 901);


        try (StudentOutputStream out = new StudentOutputStream(new FileOutputStream(file))) {
            out.writeStudent(student1);
            out.writeStudent(student2);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (StudentInputStream in = new StudentInputStream(new FileInputStream(file))) {
            System.out.println(in.readStudent());
            System.out.println(in.readStudent());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("##########");

        try {
            StudentObjOutputStream out = new StudentObjOutputStream(new DataOutputStream(new FileOutputStream(file)));
            out.writeStudent(student1);
            out.writeStudent(student2);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            StudentObjInputStream in = new StudentObjInputStream(new DataInputStream(new FileInputStream(file)));
            System.out.println(in.readStudent());
            System.out.println(in.readStudent());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
