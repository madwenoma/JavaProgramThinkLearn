package learn.enumdemo;

import java.util.EnumSet;

public class WashCar {
	 public enum Cycle{
		 BASIC{
			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("基本洗车");
			}
			 
		 },
		 DALA{
			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("洗车打蜡");
			}
			 
		 },
		 CACHUANG{

			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("擦窗户");
			}
			 
		 },
		 CLEAN{
			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("清洗");
			}
			 
		 };
		 abstract void action();
	}
	 
	 EnumSet<Cycle> es = EnumSet.of(Cycle.BASIC,Cycle.CLEAN);
	 
	 public void add(Cycle cc){
		 es.add(cc);
	 }
	 public void seeResult(){
		 for (Cycle cc : es) {
			cc.action();
		}
	 }
	 
	 public static void main(String[] args) {
		WashCar wc = new WashCar();
		wc.seeResult();
		wc.add(Cycle.DALA);
		wc.add(Cycle.DALA);
		wc.add(Cycle.CACHUANG);
		wc.seeResult();
		
		
		
	}
}
