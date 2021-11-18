package com.Thiiamas.SpringCourse.Controllers;

import com.Thiiamas.SpringCourse.Models.User;
import com.Thiiamas.SpringCourse.Models.UserAccount;
import com.Thiiamas.SpringCourse.Models.UserPost;
import com.Thiiamas.SpringCourse.Payload.Request.AccountDetailsRequest;
import com.Thiiamas.SpringCourse.Payload.Request.UserPostRequest;
import com.Thiiamas.SpringCourse.Payload.Response.MessageResponse;
import com.Thiiamas.SpringCourse.Repository.UserAccountRepository;
import com.Thiiamas.SpringCourse.Repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserPostController {

    @Autowired
    UserPostRepository userPostRepository;

    @Autowired
    UserAccountRepository userAccountRepository;

    @PostMapping("/fansites")
    public ResponseEntity<?> userAccount(@Valid @RequestBody AccountDetailsRequest accountDetailsRequest){

        if (accountDetailsRequest.getUsername().equals("")){
            ResponseEntity.badRequest().body(
                    new MessageResponse("Error : Username not set")
            );
        }

        UserAccount userAccount = new UserAccount(accountDetailsRequest);
        System.out.println(userAccount);
        String username = userAccount.getUsername();

        if (userAccountRepository.existsByUsername(username)){
            System.out.println("in If");
            List<UserAccount> listAccount = userAccountRepository.findAll();
            for (UserAccount account : listAccount){
                if (account.getUsername().equals(username)){
                    userAccountRepository.delete(account);
                }
            }
        }
        userAccountRepository.save(userAccount);

        return ResponseEntity.ok().body(
                new MessageResponse("accounts setup")
        );
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> newPost(@Valid @RequestBody UserPostRequest userPostRequest){
        if (userPostRequest.getFanSites().isEmpty()){
            return ResponseEntity.badRequest().body(
                    new MessageResponse("Error : no site selected")
            );
        }
        //create User Post
        UserPost userPost = new UserPost(
                userPostRequest.getUsername(),
                userPostRequest.getFanSites(),
                userPostRequest.getPostText(),
                userPostRequest.getImagePath()
        );
        userPost.setDate(new Date());
        userPost.setPosted(false);
        userPostRepository.save(userPost);

        return ResponseEntity.ok(new MessageResponse("Post are being posted"));
    }
}
