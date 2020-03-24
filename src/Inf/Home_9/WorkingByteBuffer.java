package Inf.Home_9;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class WorkingByteBuffer {

    public static void write(File path, ArrayList<Student> students){
        try (FileOutputStream out = new FileOutputStream(path)) {

            ByteBuffer bInt = ByteBuffer.allocate(4);
            bInt.putInt(students.size());
            out.write(bInt.array());
            bInt.rewind();

            for (int i = 0; i < students.size(); i++) {

                Student stud = students.get(i);
                String name = stud.getName();
                int sizeN = name.length();
                char gender = stud.getGender();
                int date = stud.getDate();
                int group = stud.getGroup();

                ByteBuffer bChar = ByteBuffer.allocate(name.length() * 2);
                bInt.putInt(sizeN);
                out.write(bInt.array());
                bInt.rewind();

                for (int j = 0; j < sizeN; j++) {
                    bChar.putChar(name.charAt(j));
                }
                bChar.rewind();
                out.write(bChar.array());
                bChar.rewind();

                bChar.putChar(gender);
                out.write(bChar.array()[0]);
                out.write(bChar.array()[1]);
                bChar.rewind();

                bInt.putInt(date);
                out.write(bInt.array());
                bInt.rewind();

                bInt.putInt(group);
                out.write(bInt.array());
                bInt.rewind();

                out.flush();
            }
            out.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static ArrayList<Student> read(File path){
        ArrayList<Student> students = new ArrayList<>();
        int sizeN;
        int sizeArr;
        char gender;
        int date;
        int group;

        try (FileInputStream in = new FileInputStream(path)){
            ByteBuffer bInt = ByteBuffer.allocate(4);
            for (int i = 0; i < 4; i++){
                bInt.put((byte) in.read());
            }
            bInt.rewind();
            sizeArr = bInt.getInt();
            bInt.rewind();
            //System.out.println(sizeArr);

            for (int i = 0; i < sizeArr; i++){
                StringBuilder name = new StringBuilder();

                for (int j = 0; j < 4; j++){
                    bInt.put((byte) in.read());
                }
                bInt.rewind();
                sizeN = bInt.getInt();
                bInt.rewind();
                ByteBuffer bChar = ByteBuffer.allocate(2);
                for (int j = 0; j < sizeN; j++){
                    bChar.rewind();
                    bChar.put((byte) in.read());
                    bChar.put((byte) in.read());
                    bChar.rewind();
                    char let = bChar.getChar();
                    bChar.rewind();
                    name.append(let);
                }


                bChar.put((byte) in.read());
                bChar.put((byte) in.read());
                bChar.rewind();
                gender = bChar.getChar();
                bChar.rewind();

                for(int j = 0; j < 4; j++) {
                    bInt.put((byte) in.read());
                }
                bInt.rewind();
                date = bInt.getInt();
                bInt.rewind();

                for(int j = 0; j < 4; j++) {
                    bInt.put((byte) in.read());
                }
                bInt.rewind();
                group = bInt.getInt();
                bInt.rewind();
                bChar.rewind();

                Student stud = new Student(name.toString(), gender, date, group);
                students.add(stud);
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return students;
    }
}
