package StudentService;

import java.util.List;

import Student.model.Student;

public interface StudentService {
	public int RegisterStudent(String Name, String NIC, int Age, String Gender);

	public List<Student> listStudent();
	public int updateStudent(String studentName, String studentNIC, int studentAge, String studentGender);
	public int removeStudent(String studentName);
	public int searchStudnet(String studentName);

}
