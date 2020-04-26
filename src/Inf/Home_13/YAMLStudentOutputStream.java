package Inf.Home_13;

import Inf.Home_9.Student;
import org.ho.yaml.YamlEncoder;
import java.io.IOException;
import java.io.OutputStream;


public class YAMLStudentOutputStream extends OutputStream {
    private OutputStream out;

    public YAMLStudentOutputStream(OutputStream out) {
        this.out = out;
    }

    public void writeStudent(Student student) throws IOException {
        YamlEncoder enc = new YamlEncoder(out);
        enc.writeObject(student);
        enc.close();
    }

    @Override
    public void write(int b) throws IOException {
    }
}
