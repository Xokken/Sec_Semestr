package Inf.Home_13;
import Inf.Home_9.Student;
import java.io.*;
import com.google.gson.Gson;

public class JSONStudentOutputStream extends OutputStream{
    private OutputStream out;

    public JSONStudentOutputStream(OutputStream out) {
        this.out = out;
    }

    public void writeStudent(Student student) throws IOException {
        Gson gson = new Gson();
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))){
            writer.write(gson.toJson(student));
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void write(int b) throws IOException {
    }
}
