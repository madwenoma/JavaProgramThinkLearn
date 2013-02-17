package learn.collections.map;

import java.util.*;

public class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry(K key, V value) {
		this.key = key;
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
		V result = this.value;
		this.value = value;
		return result;
	}

	@Override
	public int hashCode() {
		return (key == null ? 0 : key.hashCode())
				^ (this.value == null ? 0 : value.hashCode());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MapEntry))
			return false;
		MapEntry<?, ?> m = (MapEntry<?, ?>) o;
		return (key == null ? m.getKey() == null : key.equals(m.getKey()))
				&& (value == null ? m.getValue() == null : value.equals(m
						.getValue()));
	}

	@Override
	public String toString() {
		return key + "=" + value;
	}

}
