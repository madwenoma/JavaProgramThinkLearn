package learn.collections.map;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V>{
    //缁熶竴鍒嗗彂
    static final int SIZE = 997;
    
    @SuppressWarnings("unchecked")
	LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    
    @Override
	public V put(K key, V value){
        V oldValue = null;
        int index  = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
        
        boolean found = false;
        
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        
        while(it.hasNext()){
            MapEntry<K,V> ipair = it.next();
            if(ipair.getKey().equals(key)){
                it.set(pair);//鐢ㄦ柊鐨勫� 鍙栦唬鏃у�
                found = true;
                break;
            }
        }
        if(!found){
            buckets[index].add(pair);
            
        }
        return oldValue;
    }
    @Override
	public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> ipair: buckets[index]){
            if(ipair.getKey().equals(key)) return ipair.getValue();
        }
        return null;
    }
    
    @Override
	public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket: buckets){
            if(bucket == null) continue;
            for(MapEntry<K,V> ipair:bucket){
                set.add(ipair);
            }
        }
        return set;
    }
    
    public static void main(String[] args){
        SimpleHashMap<String, String> m = new SimpleHashMap<String ,String>();
        m.put("abc", "1");
//        m.put("bcd", "2");
        m.put("abc", "3");
        System.out.println(m);
        System.out.println(m.get("abc"));
        System.out.println(m.entrySet());
    
        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("abc", "1");
//      hm.put("bcd", "2");
        hm.put("abc", "3");
        System.out.println(hm);
        System.out.println(hm.get("abc"));
        System.out.println(hm.entrySet());
  
    }

}
