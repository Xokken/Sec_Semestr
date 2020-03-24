package Inf.Home_9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Kurogi", 'M', 1984, 902));
        students.add(new Student("SUZUKE", 'F', 2002, 902));
        students.add(new Student("ANIMEEE", 'M', 2001, 902));
        students.add(new Student("ANIMEEETWOOOO", 'M', 2001, 902));


        File file1 = new File("C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_9\\test2");


        WorkingByteBuffer.write(file1, students);
        ArrayList<Student> studs = WorkingByteBuffer.read(file1);
        for (Student student : studs) {
            System.out.println(student.toString());
        }


    }


}
