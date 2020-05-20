package Inf.Home_15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Task 15.1 15.2 and 18

public class Main15 {
    Scanner input;
    MainLogic fileManager;

    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");
        Main15 app = new Main15();
        app.init();
        app.start();
    }

    public void init (){
        input = new Scanner(System.in);
        fileManager = new MainLogic();
    }

    public void start(){
        System.out.println("\nInput command senpai! ");
        while (true){
            System.out.print("" + fileManager.getCurrenPath() + ">\n");
            String command = (input.nextLine().trim());
            String[] buff = command.split(" ");
            if ((buff.length > 1) && (buff[1].length() > 0)){
                command = buff[0] + " ";
            }
            switch (command){
                case "exit":
                    System.exit(0);
                    break;
                case "help":
                    runHelp();
                    break;
                case "dir":
                    printDirectoryContents();
                    break;
                case "cd ":
                    fileManager.goToDirectory(buff[1]);
                    break;
                case "open ":
                    try {
                        fileManager.openfile(buff[1]);
                    }
                    catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "copy ":
                    if (buff.length == 2) {
                        fileManager.copyFile(buff[1]);
                    }
                    else if (buff.length == 3){
                        fileManager.copyFile(buff[1], buff[2]);
                    }
                    break;
                case "delete ":
                    fileManager.deleteFile(buff[1]);
                    break;
                case "cat ":
                    try {
                        ArrayList<String> arr = fileManager.catFile(buff[1]);
                        int i = 0;
                        for (String line : arr){
                            System.out.println(arr.get(i));
                            i++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Unknown command");
                    runHelp();
                    break;
            }
        }
    }

    public final String[] COMMANDS_NAMES = {
            "dir", "help", "exit", "cd [path]", "cd ..", "open file", "copy [name file]/[name file and directory]", "delete [name file]/[full path]"
    };

    private void runHelp() {
        System.out.println("My commands senpai: " + Arrays.toString(COMMANDS_NAMES) + "\n##############################\n");
    }

    private void printDirectoryContents(){
        System.out.println(fileManager.getCurrenPath() + ">");
        String bufOne = fileManager.getCurrenPath().toString();
        String[] arr = fileManager.directoryContents();
        for (String str: arr) {
            for (int i = 0; i < bufOne.length(); i++){
                System.out.print(" ");
            }
            System.out.print("| ");
            System.out.print(str + "\n");
        }
    }
}
