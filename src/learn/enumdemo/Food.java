 package learn.enumdemo;
/**
 * P597 ʵ��ͳһ�ӿڵ�enum�Ͷ�������enum �ֿ�д��
 * Ҳ����Ҳ��һ�𣬴���ṹ������
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
