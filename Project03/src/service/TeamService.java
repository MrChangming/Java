package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;
/**
* @Description ���ڿ����Ŷӳ�Ա�Ĺ�����ӡ�ɾ���ȡ�
* @author MrChangMing
* @version 
* @data 2022��7��20��
*
*/
public class TeamService {
	private static int counter = 1;//��memberId��ֵʹ��
	private final int MAX_MEMBER = 5;//���ƿ����Ŷӵ�����
	private Programmer[] team = new Programmer[MAX_MEMBER];//���濪���Ŷӳ�Ա
	private int total;//��¼�����Ŷ���ʵ�ʵ�����
	public TeamService() {
		super();
	}
	
	//��ȡ�����Ŷ��е����г�Ա
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i = 0;i < team.length;i ++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	//��ָ����Ա����ӵ������Ŷ���
	public void addMember(Employee e) throws TeamException {
		//��Ա�������޷����
		if(total >= MAX_MEMBER) {
			throw new TeamException("��Ա�������޷����");
		}
		//�ó�Ա���ǿ�����Ա���޷����
		if(!(e instanceof Programmer)){
			throw new TeamException("�ó�Ա���ǿ�����Ա���޷����");
		}
		//��Ա������ĳ�Ŷӳ�Ա
		if(isExist(e)){
			throw new TeamException("��Ա�����ڱ������Ŷ���");
		}
		//��Ա�����ݼ٣��޷����
		Programmer p = (Programmer)e;//һ���������ClassCastException
		if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())){
			//if(p.getStatus().getNAME().equals("BUSY")){
			throw new TeamException("��Ա������ĳ�Ŷӳ�Ա");
		}else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
			throw new TeamException("��Ա�����ݼ٣��޷����");
		}
//		�Ŷ�������ֻ����һ���ܹ�ʦ
//		�Ŷ�������ֻ�����������ʦ
//		�Ŷ�������ֻ������������Ա
		
		//��ȡteam���г�Ա�мܹ�ʦ�����ʦ������Ա������
		int numOfArch = 0,numOfDes = 0,numOfPro = 0;
		for(int i = 0;i < total;i++){
			if(team[i] instanceof Architect){
				numOfArch++;
			}else if(team[i] instanceof Designer){
				numOfDes++;
			}else if(team[i] instanceof Programmer){
				numOfPro++;
			}
		}
		if(p instanceof Architect){
			if(numOfArch >= 1){
				throw new TeamException("�Ŷ�������ֻ����һ���ܹ�ʦ");
			}
		}else if(p instanceof Designer){
			if(numOfDes >= 2){
				throw new TeamException("�Ŷ�������ֻ�����������ʦ");
			}
		}else if(p instanceof Programmer){
			if(numOfPro >= 3){
				throw new TeamException("�Ŷ�������ֻ������������Ա");
			}
		}
		//��p����e����ӵ����е�team��
		team[total++] = p;
		//p�����Ը�ֵ
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}
	
	//�ж�ָ����Ա���Ƿ��Ѿ����������еĿ����Ŷ���
	private boolean isExist(Employee e) {
			
		for(int i = 0;i < total;i++){
			return team[i].getId() == e.getId();
		}

		return false;
	}
	
	public void removeMember(int memberId) throws TeamException{
		int i = 0;
		for(;i < total;i++){
			if(team[i].getMemberId() == memberId){
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
		//δ�ҵ�ָ��memberId�����
		if(i == total){
			throw new TeamException("�Ҳ���ָ��memberId��Ա����ɾ��ʧ��");
		}
		
		
		//��һ��Ԫ�ظ���ǰһ��Ԫ�أ�ʵ��ɾ������
		for(int j = i + 1;j < total;j++){
			team[j - 1] = team[j];
		}
		
		//д��һ��
//		team[total-1] = null;
//		total--;
		//д������
		team[--total] = null;
		
		
	}
}
