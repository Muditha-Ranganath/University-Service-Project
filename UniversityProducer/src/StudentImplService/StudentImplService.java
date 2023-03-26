package StudentImplService;

import java.util.List;

import Student.model.Student;
import StudentService.StudentService;
import StudentStore.StudentStore;

public class StudentImplService implements StudentService {
	
	@Override
	public int RegisterStudent(String Name, String NIC, int Age, String Gender) {
		Student newStudent = new Student(Name,NIC,Age,Gender);
		StudentStore.studentList.add(newStudent);
		return 1;
	}

	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return StudentStore.studentList;
	}
	
	@Override
    public int updateStudent(String studentName, String studentNIC, int studentAge, String studentGender) {
		Student studentToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Student tempStudent : StudentStore.studentList) {
			count++;
			if (tempStudent.getName().equalsIgnoreCase(studentName)) {
				
				studentToBeUpdated = tempStudent;
			       invalid = false;
				   break;
				}
			
			}
		    if (!invalid) {
				
		    studentToBeUpdated.setName(studentName);
		    studentToBeUpdated.setNIC(studentNIC);
		    studentToBeUpdated.setAge(studentAge);
		    studentToBeUpdated.setGender(studentGender);
			
			StudentStore.studentList.set(count, studentToBeUpdated);
			return 1;
			
			} 
			else 
			{
				return -1;
				
			}
	}
		    @Override
		    public synchronized int removeStudent(String studentName) 
		    {
		    	boolean invalid = true;
		    	int count = -1;
		    	for (Student tempItem :StudentStore.studentList) 
		    	{
		    		count++;
		    	if (tempItem.getName().equalsIgnoreCase(studentName)) 
		    	{
		    		invalid = false;
		    	    break;
		    	 }
		    	}
		    	if (!invalid)
		    	{
		    		StudentStore.studentList.remove(count);
		    	     return 1;
		    	} else 
		    	{
		    		
		    		return -1;
		    		}
		    	
}
		    @Override
		    public int searchStudnet(String Name) 
		    	{
		    		boolean valid = false;
		    		for (Student tempItem : StudentStore.studentList) 
		    		{
		    			if (tempItem.getName().equalsIgnoreCase(Name)) 
		    			{
		    				valid = true;
		    			break;
		    			
		    			}
		    			}
		    		if(valid) 
		    		{
		    			return 1;

		    		}
		    		else {
		    			return -1;
		    		}
		    	}
}
