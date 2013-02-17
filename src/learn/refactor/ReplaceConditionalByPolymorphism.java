package learn.refactor;



/**
 * 《重构》p255 用多态取代条件表达式
 * @author Administrator
 *
 */

class Employee {
	private double monthlySalary;
	private double commission;
	private double bonus;
	
	private EmployeeType type;
	public void setType(int type) {
		this.type = EmployeeType.newType(type);
	}

	public int getType() {
		return type.getTypeCode();
	}

	
	public double getName() {
		return this.monthlySalary;
	}
	public void setName(double name) {
		this.monthlySalary = name;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double payAccount() {
		return type.payAccount(this);
	}
	
	
}

abstract class EmployeeType {
	public static final int ENGINEER = 0;
	public static final int SALEMAN  = 1;
	public static final int MANAGER  = 2;
	
	static EmployeeType newType(int type) {
		switch(type) {
		case ENGINEER:
			return new Engineer();
		case SALEMAN:
			return new Saleman();
		case MANAGER:
			return new Manager();
		default: throw new IllegalArgumentException("incorrect argument value!");
		}
	}
	
	public int getTypeCode(){return 0;};
	abstract double payAccount(Employee e);
}

class Engineer extends EmployeeType {
	public int getTypeCode() {
		return ENGINEER;
	}
	
	@Override
	double payAccount(Employee e) {
		return e.getMonthlySalary();
	}
}
class Saleman extends EmployeeType {
	public int getTypeCode() {
		return SALEMAN;
	}
	
	@Override
	double payAccount(Employee e) {
		return e.getMonthlySalary() + e.getCommission();
	}
}
class Manager extends EmployeeType {
	public int getTypeCode() {
		return MANAGER;
	}
	
	@Override
	double payAccount(Employee e) {
		return e.getMonthlySalary() + e.getBonus();
	}
}



public class ReplaceConditionalByPolymorphism {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setMonthlySalary(200.0);
		e.setCommission(100.0);
		e.setBonus(300.9);
		e.setType(EmployeeType.ENGINEER);
		System.out.println(e.payAccount());
		e.setType(EmployeeType.SALEMAN);
		System.out.println(e.payAccount());
		e.setType(EmployeeType.MANAGER);
		System.out.println(e.payAccount());
	}
}
