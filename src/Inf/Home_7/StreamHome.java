package Inf.Home_7;
import java.util.*;
import java.util.stream.Stream;


public class StreamHome {
    public static void main(String[] args){
        System.out.println("It compiles senpai!");

        //Вывести все элементы листа, которые больше самого большого элемента второго листа (с использованием Stream api)

        ArrayList<Integer> test1 = new ArrayList<>();
        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(10);
        test2.add(12);
        test2.add(4);
        test1.add(5);
        test1.add(10);
        test1.add(110);
        test1.add(306);
        test1.stream().filter(el -> el > test2.stream().max(Comparator.comparingInt(a -> a)).get()).forEach(x -> System.out.println(x + " "));
        System.out.println();


        // Посчитать количество строк в set, в которых количество гласных больше трёх.

        Set<String> set = new TreeSet<>();
        set.add("aaacavevaa");
        set.add("mccccc");
        set.add("asabco");
        set.add("Aleeeee");
        String[] letter = {"e","y","u","i","o","a"};
        Set<String> alf = new HashSet<>();

        for (int i = 0; i < letter.length ; i++) {
            alf.add(letter[i]);
        }

        set.stream().filter(str -> Arrays.stream(str.toLowerCase().split("")).filter(ch -> alf.contains(ch)).count() > 3).forEach(str -> System.out.print(str + " "));
        System.out.println();



        //Сконкотенировать все ключи map.

        Map<String,Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("ab", 2);
        map.put("ac", 3);
        map.put("case", 4);
        Stream<String> stream2 = map.keySet().stream();
        StringBuilder str = new StringBuilder();
        stream2.forEach(p -> str.append(p));
        System.out.println("Сконкoтенированные ключи = " + str.toString());;


        //Получить сумму длин строк коллекции, которые длиннее 5-ти символов.( активно использовать методы map, count, filter…)


        ArrayList<String> test = new ArrayList<String>();
        test.add("aodmofsmv");
        test.add("");
        Stream<String> stream1 = test.stream();
        System.out.println("Количество строк , с длиной > 5 = " + stream1.filter(n -> n.length() > 5).count());

    }
}
