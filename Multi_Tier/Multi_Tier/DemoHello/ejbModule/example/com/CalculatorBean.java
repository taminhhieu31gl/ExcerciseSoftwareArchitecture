package example.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import entity.Student;

/**
 * Session Bean implementation class CalculatorBean
 */
@Stateless(name="MyCall", mappedName = "ejb/DemoHello")
@LocalBean
public class CalculatorBean implements CalculatorBeanRemote, CalculatorBeanLocal {
	private DataSource ds;
    /**
     * Default constructor. 
     */
    public CalculatorBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Connection getConnection() {
    	Connection con = null;
    	try {
    	
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("jdbc/SQLServer");
			con = ds.getConnection();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return con;
    }
	@Override
	public String demoHello() {
		// TODO Auto-generated method stub
		return "Demo hello EJB";
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> dssv = new ArrayList<Student>();
		Connection con = getConnection();
		String sql = "Select * from Student";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				Student s1 = new Student(id, name);
				System.out.println("co o day "+s1.toString());
				dssv.add(s1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dssv;
	}

}
