package studentconsumer;

import Student.model.Student;
import StudentService.StudentService;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference StudentServiceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("***********University Started*************");
		StudentServiceReference = context.getServiceReference(StudentService.class.getName());
		@SuppressWarnings("unchecked")
		StudentService studentService = (StudentService) context.getService(StudentServiceReference);
		
		do {
			int selection = 2;
			do {
				System.out.println("*************Welcome to University***************");
				
				System.out.println("Please Select an option to continue.....");
				System.out.println("Options");
				System.out.println("1.Register to the system");
				System.out.println("2.Display student");
				System.out.println("3.Update Student");
				System.out.println("4.Delete Student");
				System.out.println("5.Search Student");
				System.out.println("6.Exit");
				
				System.out.println("Enter your selection....");
				 selection = input.nextInt();
			     
				 input.nextLine();
				 if(selection == 6) {
					 exit = true;
				 }
				 if(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=5 && selection !=6) {
					 System.out.println("Please enter a valid selection");
				 }
			    }while(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection !=5 && selection !=6);
			
			     String backTohome = null;
			     if(selection == 1) {//Handles the adding process of new item to the list
			    	 do {
			    		 System.out.println("Student Name");
			    		 String studentName = input.nextLine();
			    		 
			    		 System.out.println("student NIC");
			    		 String studentNIC = input.next();
			    		 
			    		 System.out.println("Student Age");
			    		 int studentAge = input.nextInt();
			    		 
			    		 System.out.println("Student Gender");
			    		 String studentGender = input.nextLine();
			    		 
			    		 input.nextLine();
                         //AdminService adminService = new AdminServiceImpl();
			    		 int result = studentService.RegisterStudent(studentName, studentNIC, studentAge, studentGender);
			    		 String msg = (result == 1) ? "Student added!" :"Please enter name";
			    		    System.out.println(msg);
			    		 System.out.println("press 0 to navigate back to home or press any other key to continue.....");
			    		 
			    		 backTohome=input.nextLine();
			    		 
			    	     }
			    	     while(!(backTohome.equals("0")));
			     }else if(selection == 2) {
			    	            do {//StudentService adminService = new StudentServiceImpl();
			    	            List<Student>studentList = studentService.listStudent();
			    	            System.out.println("*********** List of Student **********");
			    	            System.out.println("**************************************");
			    	            for(Student man: studentList)
			    	            {
			    	            	System.out.println("student name:"+man.getName()+  " student NIC:"+man.getNIC()+  " student age:"+man.getAge()+  " student gender:"+man.getGender());
			    	            }
			    	            System.out.println("Press 0 to navigate back to home or press any other key to continue.....");
			    	            backTohome=input.nextLine();
			    	            }
			    	            while(!(backTohome.equals("0")));
			           }else if(selection == 3) {
			        	   do {
								
								System.out.println("Student Name");
								String studentName = input.nextLine();
								System.out.println("Student NIC");
								String studentNIC = input.next();
								System.out.println("Student Age");
								int studentAge = input.nextInt();
								System.out.println("Student Gender");
								String studentGender = input.nextLine();
								input.nextLine();
								
								//AdminService adminService = new AdminServiceImpl();
								int result =studentService.updateStudent(studentName, studentNIC, studentAge, studentGender);
								String msg = (result ==1) ? "updated the Student!" :"please enter a name";
								
								System.out.println(msg);System.out.println("Press 0 to navigate back to home or press any other key to continue....");
								backTohome=input.nextLine();
								
							}while(!(backTohome.equals("0")));
							
					
					}else if(selection == 4){
						do {
							System.out.println("Student Name");
							String Name = input.nextLine();
							
							int result =  studentService.removeStudent(Name);
							String msg = ( result == 1) ? "Successfully Removed the Student!" :"Please enter a valid name";
							System.out.println(msg);
							System.out.println("Press 0 to navigate back to home or press any other key to continue....");
							
							backTohome = input.nextLine();
						}while(!(backTohome.equals("0")));
					}
				 
				 
				 
						else if (selection == 5) {
							do {
								System.out.println("Enter the Student Name");
								
								String Name =  input.nextLine();
								
								int result = studentService.searchStudnet(Name);
								String msg = (result ==1) ? "Student Found! " : "Student not Found!";
								   System.out.println(msg);
								   
								   System.out.println("Press 0 to navigate back to home or press any other key to continue....");
								   
								   backTohome = input.nextLine();
							}
							
							while(!backTohome.equals("0"));
							
							
						}else if(selection == 7) {
							return ;
						}
			           
			           
			     }while(!exit);
	       }
	 
			public void stop(BundleContext context) throws Exception {
				System.out.println("***********Admin concumer consumer stopped************");
				context.ungetService(StudentServiceReference);
		
	}

}
