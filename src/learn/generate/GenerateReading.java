package learn.generate;

import java.util.Arrays;
import java.util.List;

/**
 * 编程思想 P394 泛型协变 
 * 静态方法 和 类方法对于协变的处理
 */
class Fruit{};
class Apple extends Fruit{}



public class GenerateReading {
	public static <T> T readExact(List<T> list){
		return list.get(0);
	}

	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruits = Arrays.asList(new Fruit());

	static void f1(){
		Fruit f = readExact(fruits);
		Apple a = readExact(apples);
		f = readExact(apples);
	}

	static class Reader<T>{
		T readExact(List<T> list){
			return list.get(0);
		}
	}

	static void f2(){
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		Fruit f = fruitReader.readExact(fruits);
//		Fruit f2 = fruitReader.readExact(apples);
	}

	static class ExactlyReader<T>{
		T readCovariant(List<? extends T> list){
			return list.get(0);
		}
	}

	static void f3(){
		ExactlyReader<Fruit> er = new ExactlyReader<Fruit>();
		Fruit f = er.readCovariant(fruits);
		f = er.readCovariant(apples);
	}

	public static void main(String[] args){
		f1();
		f2();
		f3();
	}


}
