package Inf.Home_17;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            for (int i = 0; i < arrNote.size(); i++){
                SoundThread soundThread = new SoundThread(arrNote.get(i));
                soundThread.start();
            }
            break;
        }
        /*

        int notes[][] = {{470, 81}, {230, 80}, {470, 81},
                {250, -1}, {230, 80}, {470, 81}, {230, 69}, {230, 76}, {470, 81},
                {230, 69}, {470, 74}, {470, 73}, {470, 74}, {470, 76}, {470, 73},
                {470, 71}, {970, -1}, {230, 69}, {230, 68}, {470, 69}, {730, -1},
                {230, 64}, {230, 69}, {230, 71}, {470, 73}, {970, -1}, {230, 73},
                {230, 74}, {470, 76}, {730, -1}, {230, 69}, {230, 74}, {230, 73},
                {470, 71}, {1450, -1}, {470, 81}, {230, 80}, {470, 81}, {250, -1},
                {230, 80}, {470, 81}, {230, 69}, {230, 76}, {470, 81}, {230, 69},
                {470, 74}, {470, 73}, {470, 74}, {470, 76}, {470, 73}, {470, 71},
                {970, -1}, {230, 69}, {230, 68}, {470, 69}, {730, -1}, {230, 64},
                {230, 69}, {230, 71}, {470, 73}, {970, -1}, {230, 73}, {230, 74},
                {470, 76}, {730, -1}, {230, 69}, {230, 74}, {230, 73}, {470, 71}, {250, -1}};
        Main_17 player2 = new Main_17();
        for (int[] note : notes) {
            if (note[1] != -1) {
                player2.playSound(0, note[0], 80, note[1]);
            }
            else {
                try {
                    Thread.sleep(note[0]);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main_17.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        player2.close();

         */
    }
}
