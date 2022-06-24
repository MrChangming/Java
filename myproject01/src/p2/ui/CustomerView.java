
package p2.ui;

import javax.swing.text.AbstractDocument;

import p2.bean.Customer;
import p2.servicce.CustomerList;
import p2.util.CMUtility;

/**
* @Description CoustomerViewΪ��ģ�飬����˵�����ʾ�ʹ����û��Ĳ���
* @author MrChangMing
* @version 
* @data 2022��6��23��
*
*/
public class CustomerView {
	private CustomerList customerList = new CustomerList(10);
	public CustomerView(){
		Customer customer = new Customer("С��", '��', 23, "123456", "email123163.com");
		customerList.addCustomer(customer);
	}
	//��ʾ���ͻ���Ϣ�����Ž�������ķ���
	public void enterMsinMenu(){
		boolean isFlag = true;
		while(isFlag) {
			System.out.println("------------------�ͻ���Ϣ����ϵͳ-----------------");
			System.out.println("                   1 ��ӿͻ�                      ");
			System.out.println("                   2 �޸Ŀͻ�                      ");
			System.out.println("                   3 ɾ���ͻ�                      ");
			System.out.println("                   4 �ͻ��б�                      ");
			System.out.print("                     ��ѡ��1 - 5����               ");
			char menu = CMUtility.readMenuSelection();
			switch(menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				//System.out.println("�˳���");
				System.out.print("ȷ���Ƿ��˳���");
				char isExit = CMUtility.readConfirmSelection();
				if(isExit == 'Y'){
					isFlag = false;	
				}
				break;
				
			}
//			isFlag = false;
		}
	}
	//��ӿͻ��Ĳ���
	private void addNewCustomer() {
		//System.out.println("��ӿͻ��Ĳ���");
		System.out.println("---------------------��ӿͻ�--------------------");
		System.out.print("������");
		String name = CMUtility.readString(10);
		System.out.print("�Ա�");
		char gender = CMUtility.readChar();
		System.out.print("���䣺");
		int age = CMUtility.readInt();
		System.out.print("�绰��");
		String phone = CMUtility.readString(13);
		System.out.print("���䣺");
		String email = CMUtility.readString(30);
		//���������ݷ�װ��������
		Customer customer = new Customer(name, gender, age, phone, email);
		boolean ifSuccess = customerList.addCustomer(customer);
		if(ifSuccess) {
			System.out.println("---------------------������--------------------");
		}else {
			System.out.println("---------------------���ʧ��--------------------");
		}
	}
	//�޸Ŀͻ��Ĳ���
	private void modifyCustomer() {
//		System.out.println("�޸Ŀͻ��Ĳ���");
		System.out.println("---------------------�޸Ŀͻ�--------------------");
		Customer cust;
		int number;
		for(;;) {
			System.out.print("��ͻ��޸Ŀͻ��˱�ţ�-1�˳�����");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			cust = customerList.getCustomer(number - 1);
			if(cust == null) {				
				System.out.println("�޷��ҵ��ƶ��û���");
			}else {//�ҵ�����Ӧ�Ŀͻ�
				break;
			}
		}
		//�޸Ŀͻ���Ϣ
		System.out.print("����(" + cust.getName() + ")��");
		String name = CMUtility.readString(10, cust.getName());
		System.out.print("�Ա�(" + cust.getGender() + ")��");
		char gender = CMUtility.readChar(cust.getGender());
		System.out.print("����(" + cust.getAge() + ")��");
		int age = CMUtility.readInt(cust.getAge());
		System.out.print("�绰(" + cust.getPhone() + ")��");
		String phone = CMUtility.readString(13, cust.getPhone());
		System.out.print("����(" + cust.getEmail() + ")��");
		String email = CMUtility.readString(30, cust.getEmail());
		Customer newCust = new Customer(name, gender, age, phone, email);
		boolean isReplaced = customerList.replaceCustomer(number - 1, newCust);
		if(isReplaced) {
			System.out.println("---------------------�޸����--------------------");
		}else {
			System.out.println("---------------------�޸�ʧ��--------------------");
		}
	}
	//ɾ���ͻ��Ĳ���
	private void deleteCustomer() {
		//System.out.println("ɾ���ͻ��Ĳ���");
		System.out.println("---------------------ɾ���ͻ�--------------------");
		int number;
		for(;;) {
			System.out.print("��ͻ��޸Ŀͻ��˱�ţ�-1�˳�����");
			number = CMUtility.readInt();
			if(number == -1) {
				return;
			}
			Customer customer = customerList.getCustomer(number - 1);
			if(customer == null) {				
				System.out.println("�޷��ҵ��ƶ��û���");
			}else {//�ҵ�����Ӧ�Ŀͻ�
				break;
			}
		}
		//�ҵ���ָ���ͻ�
		System.out.print("ȷ���Ƿ�ɾ����Y/N)��");
		char isDelete = CMUtility.readConfirmSelection();
		if(isDelete == 'Y') {
			boolean deleteSuccess = customerList.deleteCustomer(number - 1);
			if(deleteSuccess) {
				System.out.println("---------------------ɾ�����--------------------");
			}else {
				System.out.println("---------------------ɾ��ʧ��--------------------");			
			}
		}else {
			return;
		}
	}
	//��ʾ�ͻ��б�Ĳ���
	private void listAllCustomers() {
		//System.out.println("��ʾ�ͻ��б�Ĳ���");
		System.out.println("---------------------�ͻ��б�--------------------");
		int total = customerList.getTotal();
		if(total == 0) {
			System.out.println("û�пͻ���¼��");
		}else{
			System.out.println("����\t����\t�Ա�\t����\t�绰\t����");
			Customer[] custs = customerList.getAllCustomers();
			for(int i = 0;i < custs.length;i++) {
				Customer cust = custs[i];
				System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge()
				+ "\t" + cust.getPhone() + "\t" + cust.getEmail() + "\t");
			}
		}
		System.out.println("-------------------�ͻ��б����------------------");
	}
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMsinMenu();
	}
}
