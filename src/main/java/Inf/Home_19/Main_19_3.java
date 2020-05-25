package Inf.Home_19;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_19_3 {

    public static void main(String[] args) {
        String url = "http://istamendil.info/";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            Elements media = doc.select("[src]");
            Elements imports = doc.select("link[href]");
            int count = 0;
            for (Element link : links) {
                if (count > 5) break;
                count++;
                Pattern pattern = Pattern.compile("http://istamendil[a-z.\\-A-Z0-9]+");
                String currentLink = link.attr("abs:href");
                System.out.println(currentLink);
                if (pattern.matcher(currentLink).find()) {
                    try {
                        Thread.sleep(10);
                        downloadFile(currentLink);
                    } catch (Exception ex) {
                        System.out.println("Maybe something wrong with a file-link.");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Problems with connection.");
        }
    }



    public static void downloadFile(String url) throws Exception {
        URL urla = new URL(url);
        try (InputStream in = urla.openStream()) {
            Files.copy(in, Paths.get("C:\\Users\\Xokken\\IdeaProjects\\Semestr_Second_ANIME!\\src\\main\\java\\Inf\\Home_19\\" + (int)(Math.random()*1000000) + ".html"));
        }
    }




}
