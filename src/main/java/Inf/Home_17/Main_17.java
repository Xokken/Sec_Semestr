package Inf.Home_17;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_17 {


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
            playMusic(arrNote);

            String namePath = "C:\\Users\\Алексей777\\IdeaProjects\\Semestr_Second_ANIME!\\src\\Inf\\Home_17\\Song.txt";


            try(FileWriter writer = new FileWriter(namePath)) {
                for (int i = 0; i < arrNote.size(); i++){
                    writer.write(arrNote.get(i).toString() + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            //ArrayList newNotes = readSong(namePath);
            //System.out.println(newNotes.toString());

            //playMusic(newNotes);

            //break;
            sc = new Scanner(System.in);
        }
    }

    public static void playMusic(ArrayList<Note> arrNote){
        for (int i = 0; i < arrNote.size(); i++){
            if (!(arrNote.get(i).isSingleThread())) {
                SoundThread soundThread = new SoundThread(arrNote.get(i));
                soundThread.start();
            }
            else{
                Player player = new Player();
                player.playSound(arrNote.get(i).getChannel(), arrNote.get(i).getDuration(), arrNote.get(i).getVolume(), arrNote.get(i).getNote());
            }
        }

    }


}
