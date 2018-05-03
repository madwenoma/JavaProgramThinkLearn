package learn.collections.map;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 模拟一个简单的map 由两个arraylist 构成
 * @author biGpython
 *
 * @param <K>
 * @param <V>
 */
class SlowMap<K,V> extends AbstractMap<K,V>{
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	Set<java.util.Map.Entry<K, V>> entrySet = new HashSet<Map.Entry<K,V>>();
	@Override
	public V put(K key, V value){
		V oldValue = get(key);
		if(!keys.contains(key)){
			keys.add(key);
			values.add(value);
		}else{
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
		
	}
	@Override
	public V get(Object key){
		if (keys.contains(key)){
			return values.get(keys.indexOf(key));
		}else{
			return null;
		}
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		
		
		Iterator<K> ik = keys.iterator();
		Iterator<V> iv = values.iterator();
		while(ik.hasNext()){
			entrySet.add(new MyMapEntry<K,V>(ik.next(), iv.next()));
		}
		
		return entrySet;
	}
	
}
/**
 * 实现了map的entry接口
 * @author biGpython
 *
 * @param <K>
 * @param <V>
 */
class MyMapEntry<K,V> implements Map.Entry<K,V>{
	K key;
	V value;
	
	
	public MyMapEntry(K key, V value) {
		super();
		this.key   = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V result = value;
		this.value = value;
		return result;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		MyMapEntry other = (MyMapEntry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return key + "-" + value;
	}
}
/**
 * 测试类
 * @author biGpython
 *
 */
public class TestMySlowMap {
	public static void main(String[] args) {
		Map<Integer,String> slowMap = new SlowMap<Integer, String>();
		
		slowMap.put(1, "aa");
		slowMap.put(2, "bb");
	
		System.out.println(slowMap.entrySet().iterator().next().getKey());
		String n1 = slowMap.entrySet().iterator().next().getValue();
		System.out.println(n1);
		String n2 = slowMap.entrySet().iterator().next().setValue("cc");
		System.out.println(n2);
		
		System.out.println(slowMap.entrySet().iterator().next().getValue());
		System.out.println(slowMap.entrySet().iterator().next().getKey());
		
		
	}
}
