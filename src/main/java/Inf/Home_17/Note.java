package Inf.Home_17;

public class Note {
    private int channel = 0;
    private int duration = 300;
    private int volume = 80;
    private int note;
    private boolean singleThread = true;

    public Note(int note) {
        this.note = note;
    }

    public Note(int note, boolean singleThread) {
        this.note = note;
        this.singleThread = singleThread;
    }

    public Note(int duration, int volume, int note){
        this.duration = duration;
        this.volume = volume;
        this.note = note;
    }

    public Note(int duration, int volume, int note, boolean singleThread){
        this.duration = duration;
        this.volume = volume;
        this.note = note;
        this.singleThread = singleThread;
    }

    public int getChannel() {
        return channel;
    }

    public int getDuration() {
        return duration;
    }

    public int getVolume() {
        return volume;
    }

    public int getNote() {
        return note;
    }

    public boolean isSingleThread() {
        return singleThread;
    }

    @Override
    public String toString() {
        return "" + channel +
                " " + duration +
                " " + volume +
                " " + note +
                " " + singleThread;
    }
}
