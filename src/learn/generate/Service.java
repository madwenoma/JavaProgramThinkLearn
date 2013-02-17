package learn.generate;

import java.util.HashMap;
import java.util.Map;

public abstract class Service{

	protected int page;
	protected int startIndex;
	protected int total;
	protected Map<String, Object> dataMap = new HashMap<String,Object>();
	
	public Object GetSwapData(String key){
		if (dataMap.containsKey(key)){
			return dataMap.get(key);
		}else{
			return null;
		}
	}

	public void AddSwapData(String key, Object obj){
		dataMap.put(key, obj);
	}


	@SuppressWarnings("unchecked")
	public <TValue> TValue GetSwapDataG(String key){
		if (dataMap.containsKey(key)){
			return (TValue)dataMap.get(key);
		}else{
			return null;
		}
	}
	
}