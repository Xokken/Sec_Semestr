package Inf.Home_15;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MainLogic {
    private File defoultPath = new File("src");
    private File currentPath;

    public MainLogic(){
        this.currentPath = new File(defoultPath.getAbsolutePath());
    }

    public void goToDirectory(String command){
        if (command.equals("..")){
            if (currentPath.getParentFile() != null) {
                currentPath = currentPath.getParentFile();
            }
        }

        else{
            File bufPath;
            if ((command.charAt(0) == '/') || ((command.charAt(0) == '\\'))) {
                bufPath = new File("C:" + command);
            }
            else {
                bufPath = new File(currentPath + "/" + command);
            }


            if (bufPath.isDirectory()){
                currentPath = bufPath;
            }
            else{
                System.out.println("This directory not found senpai!");
            }

        }
    }

    public String[] directoryContents(){
        return currentPath.list();
    }

    public void openfile(String nameFile) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File bufPath = new File(currentPath + "\\" + nameFile);
        if (bufPath.isFile()) {
            desktop.open(new java.io.File(bufPath.getAbsolutePath()));
        }
    }

    public void  copyFile(String nameFile){
        File copied = new File(currentPath + "\\" + nameFile);
        String[] buf = new String[2];
        buf[0] = nameFile.substring(0,nameFile.lastIndexOf("."));
        buf[1] = nameFile.substring(nameFile.lastIndexOf("."));
        File originalPath = new File(currentPath + "\\" + (Math.random() * 10000000) + buf[1]);
        try {
            Files.copy(copied.toPath(), originalPath.toPath());
        } catch (IOException e) {
            System.out.println("This file not found or already exist senpai!");
        }
    }

    public void copyFile(String nameFile, String namePath){
        File copied = new File(currentPath + "\\" + nameFile);
        String[] buf = new String[2];
        buf[0] = nameFile.substring(0,nameFile.lastIndexOf("."));
        buf[1] = nameFile.substring(nameFile.lastIndexOf("."));
        File originalPath = new File(namePath + "\\" + (Math.random() * 10000000) + "" + buf[1]);
        if (originalPath.isAbsolute()) {
            try {
                Files.copy(copied.toPath(), originalPath.toPath());
            } catch (IOException e) {
                System.out.println("This file not found or already exist senpai!");
            }
        }
    }

    public void deleteFile(String nameFile){
        //File delFile = new File(currentPath + "\\" + nameFile);
        File delFile = new File(nameFile);
        if ((delFile.isAbsolute()) && delFile.isFile()){
            delFile.delete();
        }
        else{
            delFile = new File(currentPath + "\\" + nameFile);
            if (delFile.isFile()) {
                delFile.delete();
            }
        }
    }

    public void catFile(String nameFile) throws IOException {
        File cattFile = new File(nameFile);
        String[] buf = Files.probeContentType(cattFile.toPath()).split("/");
        if ((cattFile.isAbsolute()) && buf[0].equals("text")){

        }
        else{
            cattFile = new File(currentPath + "\\" + nameFile);
            if (buf[0].equals("text")) {
            }
        }
    }

    public File getCurrenPath() {
        return currentPath;
    }
}
