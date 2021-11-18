package com.Thiiamas.SpringCourse.Test;

import com.Thiiamas.SpringCourse.SeleniumScripts.FanslyDriver;
import com.Thiiamas.SpringCourse.SeleniumScripts.MymDriver;
import com.Thiiamas.SpringCourse.SeleniumScripts.SwameDriver;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;

@Service
public class TestService {
    public static String picturePath = "C:\\Users\\fkuhl\\Workflow\\Ikosh\\Fluffy\\MarquisFluffy.png";

    public void runFansly(PrintWriter pw, String text){
        int counter = 0;
        while (counter < 5 ) {
            try {
                FanslyDriver.postWithPicture("fluffycheum@gmail.com", "ghwscn4715FY!", text, picturePath);
                counter = 5;
            } catch (Exception exception) {
                counter++;
                exception.printStackTrace();
                exception.printStackTrace(pw);
            }
        }

    }

    public void runSwame(PrintWriter pw, String text){
        int counter = 5;
        while (counter < 5){
            try {
                SwameDriver.postWithPicture("fluffycheum@gmail.com", "ghwscnSE!", text, picturePath);
            } catch(Exception exception){
                counter++;
                exception.printStackTrace();
                exception.printStackTrace(pw);
            }
        }
    }

    public void runMym(PrintWriter pw, String text){
        int counter = 5;
        while (counter < 5){
            try{
                MymDriver.postWithPicture("floarctic332@gmail.com", "ghwscn4715MM!", text, picturePath);
            } catch(Exception exception){
                counter++;
                exception.printStackTrace();
                exception.printStackTrace(pw);
            }
        }
    }
}
