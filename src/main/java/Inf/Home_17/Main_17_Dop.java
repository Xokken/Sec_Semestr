package Inf.Home_17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Inf.Home_17.Main_17.playMusic;

public class Main_17_Dop {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");
        Scanner sc = new Scanner(System.in);
        boolean a = true;
        while (a) {
            ArrayList<Note> arrNote = new ArrayList<>();

            while (sc.hasNextInt()) {
                arrNote.add(new Note(sc.nextInt()));
            }
            String namePath = "C:\\Users\\Xokken\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_17\\Song.txt";
            try (FileWriter writer = new FileWriter(namePath)) {
                for (int i = 0; i < arrNote.size(); i++) {
                    writer.write(arrNote.get(i).toString() + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList newNotes = readSong(namePath);
            //System.out.println(newNotes.toString());

            playMusic(newNotes);
            sc.close();
            sc = new Scanner(System.in);
        }
    }
    public static ArrayList<Note> readSong(String file){
        ArrayList<Note> arrNotes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] buff = line.split(" ");
                int channel = Integer.parseInt(buff[0]);
                int duration = Integer.parseInt(buff[1]);
                int volume = Integer.parseInt(buff[2]);
                int note = Integer.parseInt(buff[3]);
                boolean singleThread = Boolean.parseBoolean(buff[4]);
                arrNotes.add(new Note(duration, volume, note, singleThread));
            }
            return arrNotes;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
