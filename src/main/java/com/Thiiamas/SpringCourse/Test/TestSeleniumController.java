package com.Thiiamas.SpringCourse.Test;

import com.Thiiamas.SpringCourse.Post.IkoshPost;
import com.Thiiamas.SpringCourse.Utils.Utils;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@RestController
@RequestMapping(path = "api/testSelenium")
public class TestSeleniumController {
    private TestService testService;

    @Autowired
    public TestSeleniumController(TestService testService){
        this.testService = testService;
    }

    @PostMapping(path="post")
    public void runPost(@RequestBody IkoshPost post){
        System.out.println("Body : ");
        System.out.println("------------------------------");
        System.out.println(post);

        //Creation of logging file in case of fucked up
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy-HH-mm-ss");
        Date date = new Date();
        File ErrorLog = new File(Utils.FILE_ERROR_FOLDER + dateFormat.format(date));
        PrintWriter printWriter = null;
        try{
            ErrorLog.createNewFile();
           printWriter = new PrintWriter(ErrorLog);
        } catch (Exception e){
            e.printStackTrace();
        }


        for (String fansite : post.getMedia()){
            switch (fansite){
                case "fansly": {
                    testService.runFansly(printWriter, post.getText());
                }
                case "swame": {
                    testService.runSwame(printWriter,post.getText());
                }
                case "mym" : {
                    testService.runMym(printWriter, post.getText());
                }
            }
        }


    }

    /*public void TestFansly(@RequestParam String text) throws InterruptedException, AWTException {
        testService.runFansly(text);
    }

    public void TestSwame(@RequestParam String text) throws InterruptedException, AWTException {
        testService.runSwame(text);
        testService.runMym(text);
    }*/

/*    public void TestMym(@RequestParam String text) throws InterruptedException, AWTException, FileNotFoundException {
        int counter = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy-HH-mm-ss");
        Date date = new Date();
        File ErrorLog = new File(Utils.FILE_ERROR_FOLDER + dateFormat.format(date));
        PrintWriter printWriter = new PrintWriter(ErrorLog);
        while(counter < 5){
            try{
                testService.runMym(text);
                counter = 5;
            } catch(Exception e) {
                e.printStackTrace(printWriter);
                counter++;
            }
        }
    }*/


}
