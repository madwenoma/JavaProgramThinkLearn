package learn.enumdemo;
/**
 * 另一种组织方式
 * @see Course.java 
 * @author Administrator
 *
 */
public enum Course2 {
	APPETIZER2(Food2.Appetizer2.class),
	MAINCOURSE2(Food2.MainCourse2.class),
	DESSERT2(Food2.Dessert2.class),
	COFFEE2(Food2.Coffee2.class);
	
	@SuppressWarnings("unused")
	private static String testEnumInitProcess = "TEST STRING";
	private Food2[] values;
	
	
	private Course2(Class<? extends Food2> foodKind){
		System.out.println("construcotr invoked..");
		values = foodKind.getEnumConstants();
	}
	
	public Food2 randomSelection(){
		return Enums.random(values);
	}
	
	public interface Food2 { 
		enum Appetizer2 implements Food2{
			SALAD, SOUP, SPRING_ROLLS;
		}
		
		enum MainCourse2 implements Food2{
			LASAGNE,  BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
		}
		
		enum Dessert2 implements Food2{
			TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
		}
		
		enum Coffee2 implements Food2{ 
			BLACK_COFFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
		}
	}
	
	public static void main(String[] args) {
		for(Course2 c: Course2.values()){
			System.out.println(c.randomSelection());
		}
		System.out.println("==============");
		for(Course2 c: Course2.values()){
			System.out.println(c.randomSelection());
		}
		System.out.println("==============");
		for(Course2 c: Course2.values()){
			System.out.println(c.randomSelection());
		}
		System.out.println("==============");
		for(Course2 c: Course2.values()){
			System.out.println(c.randomSelection());
		}
	}
}