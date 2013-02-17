package learn.generate;
/** 泛型边界 编程思想 P388
*   继承的泛型边界
*/
class HoldItem<T>{
	T item;
	public HoldItem(T item){
		this.item = item;
	}
	T getItem(){
		return this.item;
	}
}

class Colored2<T extends HasColor> extends HoldItem<T>{
	public Colored2(T item){
		super(item);
	}
	public java.awt.Color color(){
		return item.getColor();
	}
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>{
	public ColoredDimension2(T item){
		super(item);
	}
	public int getX(){
		return item.x;
	}

}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>{
	public Solid2(T item){
		super(item);
	}
	public int weight(){
		return item.weight();
	}
}



public class InheritBounds {
	public static void main(String[] args) {
		Solid2<Bounded> s2 = new Solid2<Bounded>(new Bounded());
		System.out.println(s2.color());
		System.out.println(s2.getX());
		System.out.println(s2.weight());
	}
}
