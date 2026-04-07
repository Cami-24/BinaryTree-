class Association<K, V> implements BinarySearchTree.KeyValue {
    K key;
    V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key.toString();
    }

    public String getValue() {
        return value.toString();
    }
}