package Inf.TestClassWork;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class TestOne {

    public static void main(String[] args) throws IOException {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");
        String command = "\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\TestForFilemanag.txt";
        File file = new File(command);
        String[] buf = Files.probeContentType(file.toPath()).split("/");
        System.out.println(buf[0]);

    }

}