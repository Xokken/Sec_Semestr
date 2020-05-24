package Inf.Home_20;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Scanner;

public class ThreadUsers extends Thread{
    private ThreadDownload one = null;
    private Scanner sc = new Scanner(System.in);
    boolean a = true;

    public void run(){
        while(a) {
            String command = sc.nextLine();
            switch (command) {
                case "exit":
                    exit();
                    break;
                case "d":
                    command = sc.nextLine();
                    try {
                        download(command);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "w":
                    proc();
                    break;
                case "s":
                    stopp();
                    break;
                default:
                    System.out.println("Incorrected command senpai!");
            }
        }
    }

    public void download(String command) throws MalformedURLException {
        one = new ThreadDownload(new URL(command));
        one.start();
    }

    public void exit(){
        System.exit(0);
    }

    public void stopp(){
        if (one.isAlive()){
            one.interrupt();
        }
        else{
            System.out.println("Nothing is loading senpai");
        }
    }

    public void proc(){
        if(one.isAlive()) {
            try {
                int a = one.getLink().openConnection().getContentLength();
                int b = (int) Files.size(new File(one.getPath()).toPath());
                int proc = b * 100 / a;
                System.out.println(proc + "%");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Nothing is loading senpai");
        }
    }
}
