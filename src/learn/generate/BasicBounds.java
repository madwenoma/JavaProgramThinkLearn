package learn.generate;
/**
 * 泛型边界 编程思想 P387
 * 缺点，冗余太多，每个类都要定义T
 * 可以通过编写继承的泛型 
 * @see InheritBounds
 * @author Administrator
 *
 */


interface HasColor{
	java.awt.Color getColor();
}

class Colored<T extends HasColor>{
	T item;
	public Colored(T item){
		this.item = item;
	}
	T getItem(){
		return item;
	}
	java.awt.Color color(){
		return item.getColor();
	}
}

class Dimension{
	public int x,y,z;
}

class ColoredDimension<T extends Dimension & HasColor>{
	T item;
	public ColoredDimension(T item){
		this.item = item;
	}
	T getItem(){
		return this.item;
	}
	java.awt.Color color(){
		return item.getColor();
	}
	public int getX(){
		return item.x;
	}
	public int getY(){
		return item.y;
	}
	public int getZ(){
		return item.z;
	}
}

interface Weight{
	int weight();
}

class Solid<T extends Dimension & HasColor & Weight>{
	T item;
	public Solid(T item){
		this.item = item;
	}
	public T getItem(){
		return this.item;
	}
	java.awt.Color color(){return item.getColor();}
	public int getX(){
		return item.x;
	}
	public int getY(){
		return item.y;
	}
	public int getZ(){
		return item.z;
	}
	int weight(){
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor,Weight{
	public java.awt.Color getColor(){
		return null;
	}
	public int weight(){
		return 0;
	}
}


public class BasicBounds {
	public static void main(String[] args){
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getX();
		System.out.println(solid.weight());
		
	}

}
