package example.com;

import java.util.List;

import javax.ejb.Remote;

import entity.Student;
@Remote
public interface CalculatorBeanRemote {
	public String demoHello();
	public List<Student> getAll();
}
