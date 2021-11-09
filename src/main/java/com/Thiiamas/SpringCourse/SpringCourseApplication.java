package com.Thiiamas.SpringCourse;

import com.Thiiamas.SpringCourse.Post.Post;
import com.Thiiamas.SpringCourse.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCourseApplication implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
/*		postRepository.deleteAll();

		postRepository.save(new Post("Florian", "premier post"));
		postRepository.save(new Post("Ina", "aussi premier post"));
		postRepository.save(new Post("Florian", "Deuxieme post"));

		System.out.println("Find all : ");
		System.out.println(" ---------------------------- ");
		for (Post post : postRepository.findAll()){
			System.out.println(post);
		}

		System.out.println("Find Ina");
		System.out.println("------------------------");
		System.out.println(postRepository.findByUser("Ina"));*/
	}

}
