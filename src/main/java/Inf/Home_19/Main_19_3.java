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
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Main_19_3 {
    public static int forName = 1;
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        String url = "https://kpfu.ru/";
        downloadSite(url);
    }

    public static void downloadSite(String name){
        String url = name;
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (int i = 0; i < links.size(); i++){
                if (forName > 10){
                    break;
                }
                Pattern pattern = Pattern.compile("https://kpfu[a-z.\\-A-Z0-9]+");
                String currentLink = links.get(i).attr("abs:href");
                if (pattern.matcher(currentLink).find()) {
                    try {
                        Thread.sleep(10);
                        downloadLink(currentLink);
                    } catch (Exception ex) {
                        System.out.println("Uncorrected link senpai!");
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Problems with internet senpai!.");
        }
    }




    public static void downloadLink(String name) throws Exception {
        if(set.add(name)) {
            URL url = new URL(name);
            try (InputStream in = url.openStream()) {
                Files.copy(in, Paths.get("C:\\Users\\Xokken\\IdeaProjects\\Semestr_Second_ANIME!\\src\\main\\java\\Inf\\Home_19\\" + forName + ".html"), StandardCopyOption.REPLACE_EXISTING);
                forName++;
                downloadSite(name);
            }
        }
    }




}
