package Inf.Home_16;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Home_16_2 {
    public static void main(String[] args){
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");
        Scanner sc = new Scanner(System.in);
        String nameUrl = "notExit";
        while (!(nameUrl.equals("exit"))) {
            nameUrl = sc.nextLine().trim();
            String type = null;
            boolean a = true;
            try {
                type = new URI(nameUrl).toURL().openConnection().getContentType();
            } catch (URISyntaxException | IOException | IllegalArgumentException e) {
                System.out.println("Uncorrected URL senpai!");
                a = false;
            }
            if (type != null) {
                String[] types = type.split("[/;]");
                System.out.println(type);
                String pathDownload = "C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_16\\" + (Math.random() * 10000000) + "." + types[1];
                try (InputStream in = new URL(nameUrl).openStream();) {
                    Files.copy(in, Paths.get(pathDownload), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Success senpai!!!");
                    System.out.println(pathDownload);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (a) {
                    System.out.println("Uncorrected URL senpai!");
                }
            }
        }
    }
}
