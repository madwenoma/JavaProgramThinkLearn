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
			//һ�ݲ˵�����Food�е����е������е��漴һ��
			System.out.println(String.format("���ɵ�%s�ݲ˵�", i));
			for(Course c: Course.values()){
				System.out.println(c.randomSelection());
			}
			
		}
	}
}
