package service;

import domain.*;
import static service.Data.*;


/**
* @Description
* @author MrChangMing
* @version 
* @data 2022��7��20��
*
*/
public class NameListService {
	private Employee[] employees;
	/*
	 * ��employees������Ԫ�ؽ��г�ʼ��
	 */
	public NameListService() {
//		1.������Ŀ�ṩ��Data�๹����Ӧ��С��employees����
//		2.�ٸ���Data���е����ݹ�����ͬ�Ķ��󣬰���Employee��Programmer��Designer��Architect�����Լ��������Equipment����Ķ���
//		3.���������������
		employees = new Employee[EMPLOYEES.length];
		for(int i = 0;i < employees.length;i++){
			//��ȡԱ��������
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type){
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}
	
	private Equipment createEquipment(int index) {
		int key = Integer.parseInt(EQUIPMENTS[index][0]);
		String modelOrName = EQUIPMENTS[index][1];
		
		switch(key){
		case PC://21
			String display = EQUIPMENTS[index][2];
			return new PC(modelOrName, display);
		case NOTEBOOK://22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName, price);
		case PRINTER://23
			String type = EQUIPMENTS[index][2];
			return new Printer(modelOrName, type);
		}
		
		return null;
	}

	public Employee[] getAllEmployees(){
		return employees;
	}
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0;i < employees.length;i++) {
			if(employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("�Ҳ���ָ��Ա��");
	}
}
