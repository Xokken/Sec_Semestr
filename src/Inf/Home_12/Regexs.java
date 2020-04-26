package Inf.Home_12;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexs {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##########");

        // first task
        String regexOne = "[0-9a-zA-Z.-]+@[a-z.]+(.)(com|ru|org)";
        Pattern patternMail = Pattern.compile(regexOne);
        String testOne1 = "anime.@onelove.com.ru. u.hentaaaaaiii.@oneeeelove.com animeOne:ooove..sdsf@h@zaa.ada.rua@o.com comcommm";
        Matcher matcher = patternMail.matcher(testOne1);
        ArrayList<String> arr = new ArrayList();
        while (matcher.find()) {
            arr.add(matcher.group());
            System.out.println(matcher.group());
        }

        while (matcher.find()) {
            System.out.println(matcher.group());
            arr.add(matcher.group());
        }
        System.out.println(arr.toString());

        Pattern patternDomenLow = Pattern.compile("@[a-z]+");
        Pattern patternDomenHigt = Pattern.compile("(com|ru|org)\\z");
        System.out.println();


        for (int i = 0; i < arr.size(); i++) {

            Matcher matcherOne = patternDomenLow.matcher(arr.get(i));
            while (matcherOne.find()) {
                System.out.print("Low = " + matcherOne.group() + " ### ");
            }

            Matcher matcherTwo = patternDomenHigt.matcher(arr.get(i));
            while (matcherTwo.find()) {
                System.out.print("Higt = " + matcherTwo.group());
            }
            System.out.println();

        }
        System.out.println();
        /*

        String reg = "(http|https)://[a-z0-9.-/]+";

        Pattern patternDomen = Pattern.compile(reg);
        Matcher matcherDomen = patternDomen.matcher("https://rurursasas");
        matcherDomen.find();
        System.out.println(matcherDomen.group());

    }


 */
    }



}
