 package learn.enumdemo;
/**
 * P597 实现统一接口的enum和对外服务的enum 分开写法
 * 也可以也在一起，代码结构更清晰
 * @author Administrator
 *
 */
interface Food { 
	enum Appetizer implements Food{
		SALAD, SOUP, SPRING_ROLLS;
	}
	
	enum MainCourse implements Food{
		LASAGNE,  BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
	}
	
	enum Dessert implements Food{
		TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
	}
	
	enum Coffee implements Food{ 
		BLACK_COFFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
	}
	
}
