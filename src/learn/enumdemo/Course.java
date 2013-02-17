package learn.enumdemo;

enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	
	
	private Food[] values;
	private Course(Class<? extends Food> foodKind){
		values = foodKind.getEnumConstants();
	}
	
	public Food randomSelection(){
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		int i = 0;
		while(i++ < 10){
			//一份菜单包含Food中的所有的类型中的随即一种
			System.out.println(String.format("生成第%s份菜单", i));
			for(Course c: Course.values()){
				System.out.println(c.randomSelection());
			}
			
		}
	}
}
