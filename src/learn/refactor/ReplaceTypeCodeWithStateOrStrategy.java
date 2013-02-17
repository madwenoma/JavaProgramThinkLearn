package learn.refactor;

/**
 * 《重构》一书，P223，之Replace Type Code With State Or Strategy
 * 使用策略或状态模式代替类型码
 * @author Administrator
 *
 */

public class ReplaceTypeCodeWithStateOrStrategy {
	static class Employee {
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

		double payAccount() {
			switch (getType()) {
				case EmployeeType.ENGINEER:
					return this.monthlySalary;
				case EmployeeType.SALEMAN:
					return this.monthlySalary + this.commission;
				case EmployeeType.MANAGER:
					return this.monthlySalary + this.bonus;
				default:
					return 0;
			}
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
		
	}

	
	static class EmployeeType {
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
	}
	
	static class Engineer extends EmployeeType {
		public int getTypeCode() {
			return ENGINEER;
		}
	}
	static class Saleman extends EmployeeType {
		public int getTypeCode() {
			return SALEMAN;
		}
	}
	static class Manager extends EmployeeType {
		public int getTypeCode() {
			return MANAGER;
		}
	}
	
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
