package Inf.Home_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class IniInputStream extends InputStream {
    private InputStream in;

    public IniInputStream(InputStream in){
        this.in = in;
    }

    public HashMap readIni() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            HashMap map = new HashMap();
            String str;
            while ((str = reader.readLine()) != null) {
                String[] buffer = str.split("=", 2);
                map.put(buffer[0], buffer[1]);
            }
            return map;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
