package com.Thiiamas.SpringCourse.SeleniumScripts;

import com.Thiiamas.SpringCourse.Models.UserPost;

import java.util.Set;

public class SeleniumController {

    public static void handleMultiPosting(UserPost userPost){
        Set<String> fansites = userPost.getFanSites();

        for (String fansite : fansites){
            switch (fansite){
                case "swame":
                    break;
            }
        }
    }
}
