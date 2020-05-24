package Inf.Home_13;

import Inf.Home_9.Student;
import com.google.gson.Gson;

import java.io.*;

public class JSONStudentInputStream extends InputStream{
    private InputStream in;

    public JSONStudentInputStream(InputStream in) {
        this.in = in;
    }

    public Student readStudent() throws IOException {
        Gson gson = new Gson();
        Student student = new Student();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
            String str = reader.readLine();
            student = gson.fromJson(str, Student.class);
            return student;
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
