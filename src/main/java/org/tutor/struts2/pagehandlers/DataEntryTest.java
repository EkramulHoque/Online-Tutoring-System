package org.tutor.struts2.pagehandlers;

import java.sql.Time;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.tutor.struts2.model.Comment;
import org.tutor.struts2.model.Course;
import org.tutor.struts2.model.Instructor;
import org.tutor.struts2.model.Lecture;
import org.tutor.struts2.model.Media;
import org.tutor.struts2.model.Question;
import org.tutor.struts2.model.Quiz;
import org.tutor.struts2.model.Script;
import org.tutor.struts2.model.Student;
import org.tutor.struts2.model.Users;


public class DataEntryTest {

	public static void main(String[] args) {
		
		Student user = new Student("abc@gmail.com", "iamabc");
		user.setFirstname("Abc");
		user.setLastname("Def");
		user.setBio("I am Abc Def");
		user.setPhotoPath("no-photo-male.png");
		
		Instructor userI = new Instructor("xyz@gmail.com", "iamxyz");
		userI.setFirstname("Xyz");
		userI.setLastname("Uvw");
		userI.setBio("I am Xyz Uvw");
		userI.setPhotoPath("no-photo-male.png");
		
		
		Course course = new Course("CSE470");
		course.setCourseTitle("Software Engineering");
		course.setCourseDescription("Concepts of software engineering: requirements definition, modular, structure design, data specifications, functional specifications, verification, documentation, software maintenance, Software support tools.");
		course.setInstructor(userI);
		
		user.getEnrolledCourses().add(course);
		userI.getInstructedCourses().add(course);
		
		Student user2 = new Student("pqr@gmail.com", "iampqr");
		user2.setFirstname("Pqr");
		user2.setLastname("Mno");
		user2.setBio("I am Pqr Mno");
		user2.setPhotoPath("no-photo-male.png");
		
		Course course2 = new Course("CSE460");
		course2.setCourseTitle("VLSI Design");
		course2.setCourseDescription("Concepts of VLSI");
		course2.setInstructor(userI);
		
		user2.getEnrolledCourses().add(course2);
		userI.getInstructedCourses().add(course2);
		
		Lecture lecture = new Lecture ();
		lecture.setLectureTitle("UML Diagrams");
		lecture.setLectureDescription("A basic lecture on UML");
		lecture.setCourse(course);
		
		Media slide = new Media();
		slide.setMediaTitle("Use Case and Diagram");
		slide.setType(".ppt");
		slide.setPath("Usecase.ppt");
		
		Media video = new Media();
		video.setMediaTitle("Class Diagram");
		video.setType(".mp4");
		video.setPath("Classdiagram.mp4");
		
		lecture.getMaterials().add(slide);
		lecture.getMaterials().add(video);
		
		Quiz test = new Quiz();
		test.setQuizName("Quiz 1");
		test.setDuration(new Time(0,1,0));
		test.setLecture(lecture);
		
		Script s = new Script();
		s.setStudent(user);
		s.setQuiz(test);
		test.getScripts().add(s);
		
		Question question=new Question("Question 1", 1, "A", "B", "C", "D", "A");
		test.getQuestions().add(question);
		question=new Question("Question 2", 2, "A", "B", "C", "D", "C");
		test.getQuestions().add(question);
		question=new Question("Question 3", 3, "A", "B", "C", "D", "B");
		test.getQuestions().add(question);
		question=new Question("Question 4", 4, "A", "B", "C", "D", "D");
		test.getQuestions().add(question);
		question=new Question("Question 5", 5, "A", "B", "C", "D", "C");
		test.getQuestions().add(question);
		question=new Question("Question 6", 6, "A", "B", "C", "D", "A");
		test.getQuestions().add(question);
		question=new Question("Question 7", 7, "A", "B", "C", "D", "D");
		test.getQuestions().add(question);
		question=new Question("Question 8", 8, "A", "B", "C", "D", "B");
		test.getQuestions().add(question);
		question=new Question("Question 9", 9, "A", "B", "C", "D", "C");
		test.getQuestions().add(question);
		question=new Question("Question 10", 10, "A", "B", "C", "D", "B");
		test.getQuestions().add(question);
		question=new Question("Question 11", 11, "A", "B", "C", "D", "D");
		test.getQuestions().add(question);
		question=new Question("Question 12", 12, "A", "B", "C", "D", "A");
		test.getQuestions().add(question);
		question=new Question("Question 13", 13, "A", "B", "C", "D", "C");
		test.getQuestions().add(question);
		question=new Question("Question 14", 14, "A", "B", "C", "D", "A");
		test.getQuestions().add(question);
		question=new Question("Question 15", 15, "A", "B", "C", "D", "B");
		test.getQuestions().add(question);
		
		lecture.setQuiz(test);
		
		Lecture lecture1 = new Lecture ();
		lecture1.setLectureTitle("Process");
		lecture1.setLectureDescription("A basic lecture on Process");
		lecture1.setCourse(course);
		
		Media slide1 = new Media();
		slide1.setMediaTitle("Different Processes");
		slide1.setType(".ppt");
		slide1.setPath("process.ppt");
		
		Media video1 = new Media();
		video1.setMediaTitle("Spiral Process");
		video1.setType(".mp4");
		video1.setPath("spiralprocess.mp4");
		
		lecture1.getMaterials().add(slide1);
		lecture1.getMaterials().add(video1);
		
		Quiz test1 = new Quiz();
		test1.setQuizName("Quiz 2");
		test1.setDuration(new Time(0,30,0));
		test1.setLecture(lecture1);
		
		Script s1 = new Script();
		s1.setStudent(user);
		s1.setQuiz(test1);
		test1.getScripts().add(s1);
		
		Question question1=new Question();
		question1.setQuestionNum(1);
		question1.setQuestion("What is Process?");
		question1.setOption1("A");
		question1.setOption2("B");
		question1.setOption3("C");
		question1.setOption4("D");
		question1.setAnswer("B");
		
		test1.getQuestions().add(question1);
		lecture1.setQuiz(test1);
		
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setComment("This resource is helpful");
		comment.setLecture(lecture);
		lecture.getComments().add(comment);
		
		Comment comment1 = new Comment();
		comment1.setUser(userI);
		comment1.setComment("This resource will give you proper idea");
		comment1.setLecture(lecture1);
		lecture1.getComments().add(comment1);
		
		Comment comment2 = new Comment();
		comment2.setUser(userI);
		comment2.setComment("Your feedback is appriciated");
		comment2.setLecture(lecture);
		lecture.getComments().add(comment2);
		
		Comment comment3 = new Comment();
		comment3.setUser(user);
		comment3.setComment("Thank you");
		comment3.setLecture(lecture1);
		lecture1.getComments().add(comment3);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		session.persist(user);
		session.persist(userI);
		session.persist(user2);
//		session.save(course);
		session.persist(lecture);
		session.persist(lecture1); 
//		session.save(test);
//		session.save(test1);
//		session.save(comment);
//		session.save(comment1);
//		session.save(comment2);
//		session.save(comment3);
//		
		try{
			session.flush();
		} catch (Exception e){
			System.out.println("Exception");
		}
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();	
		session.beginTransaction();

		
		String email = "abc@gmail.com";
		Users userF = (Users) session.get(Users.class, email);
		System.out.println("\n\nRetrieved from User:");
		System.out.println("Name: "+userF.getFirstname()+" "+userF.getLastname());
		System.out.println("Email: "+userF.getBio());
		System.out.println("Email: "+userF.getEmail());
		System.out.println("Password: "+userF.getPassword());
		System.out.println("Photo Path: "+userF.getPhotoPath());
		
		
		if(userF.getRole().equalsIgnoreCase("student")){
			Student userS = (Student) session.get(Student.class, email);
			System.out.println("\n\nRetrieved from Student:");
			System.out.println("Name: "+userS.getFirstname()+" "+userS.getLastname());
			System.out.println("Email: "+userS.getBio());
			System.out.println("Email: "+userS.getEmail());
			System.out.println("Password: "+userS.getPassword());
			System.out.println("Photo Path: "+userS.getPhotoPath());
			System.out.print("Enrolled courses: ");
			for (int i=0; i<userS.getEnrolledCourses().size(); i++)
				System.out.print(userS.getEnrolledCourses().get(i).getCourseID());
			System.out.println();
			
			
		} else{
			Instructor userI2 = (Instructor) session.get(Instructor.class, email);
			System.out.println("\n\nRetrieved from Instructor:");
			System.out.println("Name: "+userI2.getFirstname()+" "+userI2.getLastname());
			System.out.println("Email: "+userI2.getBio());
			System.out.println("Email: "+userI2.getEmail());
			System.out.println("Password: "+userI2.getPassword());
			System.out.println("Photo Path: "+userI2.getPhotoPath());
			System.out.print("Instructed courses: ");
			for (int i=0; i<userI2.getInstructedCourses().size(); i++)
				System.out.print(userI2.getInstructedCourses().get(i).getCourseID());
			System.out.println();
		}
		
		Lecture l = (Lecture)  session.get(Lecture.class, 2);
		System.out.println(l.getLectureID()+" "+l.getLectureTitle());
		//session.delete(l);
		
//		test1 = new Quiz();
//		test1.setQuizName("Quiz 3");
//		test1.setDuration(new Time(0,30,0));
//		test1.setLecture(l);
//		
//		Script s = new Script();
//		s.setStudent(user);
//		test.getScripts().add(s);
//		
//		Question question2=new Question();
//		question2.setQuestionNum(1);
//		question2.setQuestion("What is System?");
//		question2.setOption1("A");
//		question2.setOption2("B");
//		question2.setOption3("C");
//		question2.setOption4("D");
//		question2.setAnswer("C");
//		
//		test1.getQuestions().add(question2);
//		l.setQuiz(test1);
//		System.out.println(l.getLectureTitle()+" "+l.getQuiz().getQuizName());

		session.getTransaction().commit();
		session.close();
		
//		session = sessionFactory.openSession();	
//		session.beginTransaction();
//		
//		Quiz q = (Quiz)  session.get(Quiz.class, 1);
//		session.delete(q);
//		
//		session.getTransaction().commit();
//		session.close();
	}

}