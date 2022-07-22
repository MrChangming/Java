package domain;

/**
* @Description
* @author MrChangMing
* @version 
* @data 2022��7��20��
*
*/
public class Architect extends Designer{
	private int stock;//��Ʊ

    public Architect() {
    }

    

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
	public String toString() {
		return getDetails() + "\t�ܹ�ʦ\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
	}
    
 // 1/2	����	32	18000.0	�ܹ�ʦ	15000.0	2000
 	public String getDetailsForTeam() {
 		return getTeamBaseDetails() + "\t�ܹ�ʦ\t" + getBonus() + "\t" + getStock();
 	}
}
