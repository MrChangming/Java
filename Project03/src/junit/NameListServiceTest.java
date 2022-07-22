package junit;

import org.junit.Test;

import service.TeamException;

import domain.Employee;
import service.NameListService;

/**
* @Description
* @author MrChangMing
* @version 
* @data 2022Äê7ÔÂ20ÈÕ
*
*/
public class NameListServiceTest {
	
	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i < employees.length;i++){
			System.out.println(employees[i]);
		}
	}
	@Test
	public void testGetEmployee(){
		NameListService service = new NameListService();
		int id = 1;
		id = 101;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

