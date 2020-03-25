package Inf.Home_10;

import Inf.Home_9.Student;
import java.io.*

// С использованием data

public class StudentOutputStream extends OutputStream {

    private DataOutputStream out;

    public StudentOutputStream(OutputStream out) {
        this.out = new DataOutputStream(out);
    }

    public void writeStudent(Student student) {
        try {
            String name = student.getName();
            char gender = student.getGender();
            int date = student.getDate();
            int group = student.getGroup();
            out.writeUTF(name);
            out.writeChar(gender);
            out.writeInt(date);
            out.writeInt(group);
            out.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void writeBoolean(boolean v) throws IOException {
        out.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        out.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        out.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        out.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        out.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        out.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        out.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        out.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        out.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        out.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        out.writeUTF(str);
    }

    public int size() {
        return out.size();
    }

    @Override
    public void write(int b) throws IOException {

    }
}
