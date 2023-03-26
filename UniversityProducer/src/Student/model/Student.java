package Student.model;

public class Student {
	public String Name;
	public String NIC;
	public int Age;
	public String Gender;
	
	
	public Student (String Name, String NIC, int Age, String Gender) {
		
		this.Name= Name;
		this.NIC= NIC;
		this.Age= Age;
		this.Gender= Gender;
		
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String NIC) {
		this.NIC = NIC;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int Age) {
		this.Age = Age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender = Gender;
	}

}
