package Inf.Home_13;

import Inf.Home_9.Student;
import org.ho.yaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class YAMLStudentInputStream extends InputStream {
    private InputStream in;

    public YAMLStudentInputStream(InputStream in) {
        this.in = in;
    }

    public Student readStudent() throws IOException {
        try {
            return (Student) Yaml.load(new File("src/Inf/Home_13/Yamll.yaml"));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


    @Override
    public int read() throws IOException {
        return 0;
    }
}
