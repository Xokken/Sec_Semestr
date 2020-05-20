package Inf.Home_20;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;

public class ThreadDownload extends Thread {
    private URL link;
    private String type;
    private String path = "C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_20\\";
    private boolean isInterrupted = true;

    public ThreadDownload(String name) {
        try {
            this.link = new URL(name);
            this.type = new URL(name).openConnection().getContentType();
        } catch (IOException e) {
            System.out.println("Uncorrected URL senpai!");;
        }
    }

    public void run() {
        try (InputStream in = link.openConnection().getInputStream()) {
            String[] types = type.split("[/;]");
            path = path + (Math.random() * 10000000)  + "." + types[1];
            OutputStream out = new FileOutputStream(path);
            ByteBuffer buf = ByteBuffer.allocate(5000);
            while (in.available() > 0 ){
                if (!(isInterrupted())) {
                    for (int i = 0; i < 5000; i++){
                        buf.put((byte) in.read());
                    }
                    buf.rewind();
                    out.write(buf.array());
                    buf.rewind();
                    Thread.sleep(50);
                }
                else{
                    throw new InterruptedException();
                }
            }
            System.out.println("Success senpai!!!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("This thread is died senpai!");
        }
    }


    public String getPath() {
        return path;
    }

    public URL getLink() {
        return link;
    }
}
