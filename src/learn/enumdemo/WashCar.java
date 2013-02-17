package learn.enumdemo;

import java.util.EnumSet;

public class WashCar {
	 public enum Cycle{
		 BASIC{
			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("����ϴ��");
			}
			 
		 },
		 DALA{
			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("ϴ������");
			}
			 
		 },
		 CACHUANG{

			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("������");
			}
			 
		 },
		 CLEAN{
			@Override
			void action() {
				// TODO Auto-generated method stub
				System.out.println("��ϴ");
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
