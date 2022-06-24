
package p2.servicce;

import p2.bean.Customer;

/**
* @Description 
* @author MrChangMing
* @version 
* @data 2022��6��23��
*
*/ 
public class CustomerList {
	private Customer[] customers;//�Á���͑����������
	private int total = 0;// ��¼�ѱ���ͻ����������
	/**
	 * �������»�customer����Ĺ�����
	 * @param totalCustomer���ƶ�����ĳ��� 
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}	
	//���ƶ��Ŀͻ���ӵ�������
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total++] =customer;
		return true;
	}
	//�޸��ƶ�����λ�õĿͻ���Ϣ
	public boolean replaceCustomer(int index, Customer cust) {
		if(index < 0 || index >= total){
			return false;
		}
		customers[index] = cust;
		return true;
	}
	//ɾ���ƶ�λ���ϵĿͻ�
	public boolean deleteCustomer(int index) {
		if(total >= customers.length) {
			return false;
		}
		for(int i = index;i < total - 1; i++) {
			customers[i] = customers[i + 1];
		}
		//���һ������Ҫ�ÿ�
		customers[--total] = null;
		return true;
	}
	//��ȡ���еĿͻ���Ϣ
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for(int i = 0;i < total; i++) {
			custs[i] =customers[i];
		}
		return custs;
	}
	//��ȡ�ƶ�����λ���ϵĿͻ�
	public Customer getCustomer(int index) {
		if(index < 0 || index >= total){
			return null;
		}
		return customers[index];
	}
	//��ȡ�ͻ�������
	public int getTotal() {
		return total;
	}
}
