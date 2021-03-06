package Inf.Home_10;

import Inf.Home_9.Student;
import java.io.*;

// С использованием Object

public class StudentObjOutputStream extends OutputStream {

    private ObjectOutputStream out;

    public StudentObjOutputStream(DataOutputStream out) throws IOException {
        this.out = new ObjectOutputStream(out);
    }


    public void writeStudent(Student student) {
        try {
            out.writeObject(student);
            out.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void useProtocolVersion(int version) throws IOException {
        out.useProtocolVersion(version);
    }

    public void writeObject(Object obj) throws IOException {
        out.writeObject(obj);
    }

    public void writeUnshared(Object obj) throws IOException {
        out.writeUnshared(obj);
    }

    public void defaultWriteObject() throws IOException {
        out.defaultWriteObject();
    }

    public ObjectOutputStream.PutField putFields() throws IOException {
        return out.putFields();
    }

    public void writeFields() throws IOException {
        out.writeFields();
    }

    public void reset() throws IOException {
        out.reset();
    }

    public void writeBoolean(boolean val) throws IOException {
        out.writeBoolean(val);
    }

    public void writeByte(int val) throws IOException {
        out.writeByte(val);
    }

    public void writeShort(int val) throws IOException {
        out.writeShort(val);
    }

    public void writeChar(int val) throws IOException {
        out.writeChar(val);
    }

    public void writeInt(int val) throws IOException {
        out.writeInt(val);
    }

    public void writeLong(long val) throws IOException {
        out.writeLong(val);
    }

    public void writeFloat(float val) throws IOException {
        out.writeFloat(val);
    }

    public void writeDouble(double val) throws IOException {
        out.writeDouble(val);
    }

    public void writeBytes(String str) throws IOException {
        out.writeBytes(str);
    }

    public void writeChars(String str) throws IOException {
        out.writeChars(str);
    }

    public void writeUTF(String str) throws IOException {
        out.writeUTF(str);
    }

    @Override
    public void write(int b) throws IOException {
    }
}
