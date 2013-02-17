package learn.reflection.synchronizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
	
	private Map<String, IStrategy> maps = new HashMap<String, IStrategy>();
	public static ArrayList<IStrategy> getStrategy(Class<? extends ProcessBase> proClass){
		
		return null;
	}
}
