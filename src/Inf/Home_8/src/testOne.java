import java.io.*;


// NUMBER 8


public class testOne {
    public static void main(String[] args) {

            try (OutputStream out = new FileOutputStream("src/test");) {
                int v = 1124;
                char c = 'ф';
                out.write(v >> 24);
                out.write(v >> 16);
                out.write(v >> 8);
                out.write(v >> 0);
                out.write(c >> 8);
                out.write(c >> 0);
                out.flush();
            } catch (IOException e) {
                System.out.println("File not found!");
            }

            try (InputStream in = new FileInputStream("src/test")) {
                byte[] data = new byte[256];
                int i = 0;
                int b;
                while ((b = in.read()) != -1) {
                    data[i++] = (byte) b;
                }

                System.out.println("Integer = " + ((data[0] << 24) + (data[1] << 16) + (data[2] << 8) + (data[3])) + " senpai!");
                System.out.println("Char = " + (char) ((data[4] << 8) + data[5]) + " senpai!");

            } catch (IOException e) {
                System.out.println("File not found senpai!");
            }

    }
}