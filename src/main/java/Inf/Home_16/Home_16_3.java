package Inf.Home_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home_16_3 {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");
        Scanner sc = new Scanner(System.in);
        String nameUrl = sc.nextLine().trim();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new URI(nameUrl).toURL().openConnection().getInputStream()))) {
            int divCount = 0;
            String line;
            while ((line = in.readLine()) != null) {
                Matcher matcher = Pattern.compile("(<div)").matcher(line);
                while (matcher.find()) {
                    divCount++;
                }
            }
            System.out.println(divCount);

        } catch (URISyntaxException | IOException e) {
            System.out.println("Incorrect URI senpai");
        }
    }
}
