package Inf.Home_10;

import Inf.Home_9.Student;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentInputStream extends InputStream {

    private DataInputStream in;

    public StudentInputStream(InputStream in){
        this.in = new DataInputStream(in);
    }

    public Student readStudent(){
        try {
            String name = in.readUTF();
            char gender = in.readChar();
            int date = in.readInt();
            int group = in.readInt();
            Student student = new Student(name, gender, date, group);
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

    public void readFully(byte[] b) throws IOException {
        in.readFully(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        in.readFully(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        return in.skipBytes(n);
    }

    public boolean readBoolean() throws IOException {
        return in.readBoolean();
    }

    public byte readByte() throws IOException {
        return in.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return in.readUnsignedByte();
    }

    public short readShort() throws IOException {
        return in.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return in.readUnsignedShort();
    }

    public char readChar() throws IOException {
        return in.readChar();
    }

    public int readInt() throws IOException {
        return in.readInt();
    }

    public long readLong() throws IOException {
        return in.readLong();
    }

    public float readFloat() throws IOException {
        return in.readFloat();
    }

    public double readDouble() throws IOException {
        return in.readDouble();
    }

    @Deprecated
    public String readLine() throws IOException {
        return in.readLine();
    }

    public String readUTF() throws IOException {
        return in.readUTF();
    }

    public static String readUTF(DataInput in) throws IOException {
        return DataInputStream.readUTF(in);
    }
}
