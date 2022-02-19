package com.sushant.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sushant"})
public class SpringBootSecurityStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityStudentApplication.class, args);
		
		
//  ConfigurableApplicationContext  configurableApplicationContext=SpringApplication.run(SpringBootSecurityStudentApplication.class, args);
		
//	StudentRepository studentRepository=configurableApplicationContext.getBean(StudentRepository.class);
//	//ProjectRepository projectRepository=configurableApplicationContext.getBean(ProjectRepository.class);
//	
//	Project project1=new Project(1,"Java",3);
//	Project project2=new Project(2,"DotNet",6);
//	List<Project> projects=Arrays.asList(project1,project2);
//	
//	Student student=new Student(101,"Sushant","Bait",9129898213l,"@gmail.com",projects);
//	studentRepository.save(student);
	}

}
