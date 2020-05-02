package Inf.Home_17;

public class Note {
    private int channel = 0;
    private int duration = 700;
    private int volume = 80;
    private int note;

    public Note(int note) {
        this.note = note;
    }

    public Note(int duration, int volume, int note){
        this.duration = duration;
        this.volume = volume;
        this.note = note;
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
}
