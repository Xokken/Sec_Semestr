package Inf.Home_11;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class IniOutputStream extends OutputStream {
    private OutputStream out;

    public IniOutputStream(OutputStream out){
        this.out = out;
    }

    public void writeIni(HashMap map) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))){
            Object[] entry = map.entrySet().toArray();
            for (int i = 0; i < map.size(); i++) {
                writer.write("" + entry[i]);
                writer.newLine();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void write(int b) throws IOException {
    }
}
