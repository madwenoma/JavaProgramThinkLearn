package learn.refactor;
/**
 * 《重构》一书，P223，之Replace Type Code With Subclass
 * 使用子类代替类型码
 * @author Administrator
 *
 */

public class ReplaceTypeCodeWithSubclass {

	static class Employee {
		private int type;
		private String name;
		
		public static final int ENGINEER = 0;
		public static final int SALEMAN  = 1;
		public static final int MANAGER  = 2;

		static Employee create(int type) {
			switch(type) {
				case ENGINEER:
					return new Engineer();
				case SALEMAN:
					return new Saleman();
				case MANAGER:
					return new Manager();
				default:
					throw new IllegalArgumentException("incorrect type code value!");
			}
		}

		public void setType(int type) {
			this.type = type;
		}

		public int getType() {
			return type;
		}

		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}

	static class Engineer extends Employee {
		public int getType() {
			return Employee.ENGINEER;
		}
	}

	static class Saleman extends Employee {
		public int getType() {
			return Employee.SALEMAN;
		}
	}
	static class Manager extends Employee {
		public int getType() {
			return Employee.MANAGER;
		}
	}

	public static void main(String[] args) {
		Employee engineer = Employee.create(Employee.ENGINEER);
		Employee saleman  = Employee.create(Employee.SALEMAN);
		Employee manager  = Employee.create(Employee.MANAGER);
		System.out.println(engineer.getType() == Employee.ENGINEER);
		System.out.println(saleman.getType() == Employee.SALEMAN);
		System.out.println(manager.getType() == Employee.MANAGER);
	}

}
