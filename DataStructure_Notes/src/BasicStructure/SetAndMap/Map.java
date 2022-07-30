package BasicStructure.SetAndMap;

public interface Map<K, V> {
    void set(K key, V val);
    V get(K key);
    void remove(K key);
    boolean contains(K key);
    boolean isEmpty();
    int getSize();
}
