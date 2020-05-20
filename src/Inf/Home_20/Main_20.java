package Inf.Home_20;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Scanner;


public class Main_20 {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");

        Scanner sc = new Scanner(System.in);
        String command;
        boolean aaa = true;
        while (aaa) {
            command = sc.nextLine();
            if (command.equals("exit")){
                System.exit(0);
            }
            if (command.equals("download")) {
                String mayURL = sc.nextLine();
                ThreadDownload one = new ThreadDownload(mayURL);
                one.start();
                while(one.isAlive()){
                    command = sc.nextLine();
                    if(command.equals("stop")){
                        one.interrupt();
                    }
                    else if (command.equals("weight")){
                        URL link = one.getLink();
                        String path = one.getPath();
                        try {
                            int a = link.openConnection().getContentLength();
                            int b = (int) Files.size(new File(path).toPath());
                            int proc = b * 100 / a;
                            System.out.println(proc + "%");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("Whaaaaat?!");
                    }
                }
            }
            else{
                System.out.println("Incorrected command senpai!");
            }
        }
    }


}
