package Inf.Home_17;

public class SoundThread extends Thread {
    private Note note;

    public SoundThread(Note note) {
        this.note = note;
    }

    public void run() {
        Player player = new Player();
        player.playSound(note.getChannel(), note.getDuration(), note.getVolume(), note.getNote());
    }
}
