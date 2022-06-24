
package p2.servicce;

import p2.bean.Customer;

/**
* @Description 
* @author MrChangMing
* @version 
* @data 2022年6月23日
*
*/ 
public class CustomerList {
	private Customer[] customers;//用來保存客戶对象的数组
	private int total = 0;// 记录已保存客户对象的数量
	/**
	 * 用来出事话customer数组的构造器
	 * @param totalCustomer，制定数组的长度 
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}	
	//将制定的客户添加到数组中
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total++] =customer;
		return true;
	}
	//修改制定索引位置的客户信息
	public boolean replaceCustomer(int index, Customer cust) {
		if(index < 0 || index >= total){
			return false;
		}
		customers[index] = cust;
		return true;
	}
	//删除制定位置上的客户
	public boolean deleteCustomer(int index) {
		if(total >= customers.length) {
			return false;
		}
		for(int i = index;i < total - 1; i++) {
			customers[i] = customers[i + 1];
		}
		//最后一行文字要置空
		customers[--total] = null;
		return true;
	}
	//获取所有的客户信息
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for(int i = 0;i < total; i++) {
			custs[i] =customers[i];
		}
		return custs;
	}
	//获取制定索引位置上的客户
	public Customer getCustomer(int index) {
		if(index < 0 || index >= total){
			return null;
		}
		return customers[index];
	}
	//获取客户的数量
	public int getTotal() {
		return total;
	}
}
