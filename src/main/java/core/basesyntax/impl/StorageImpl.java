package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static int MAX_ARRAY_VALUE = 10;
    private K[] keys = (K[]) new Object[MAX_ARRAY_VALUE];
    private V[] values = (V[]) new Object[MAX_ARRAY_VALUE];
    private int storageValue = 0;

    public StorageImpl() {
    }

    private void storageAdd(int currentCell, K key, V value) {
        keys[currentCell] = key;
        values[currentCell] = value;
        storageValue++;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < storageValue; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }
        storageAdd(storageValue, key, value);
    }

    @Override
    public V get(K key) {
        for (int k = 0; k < MAX_ARRAY_VALUE - 1; k++) {
            if (Objects.equals(key, keys[k])) {
                return values[k];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageValue;
    }
}
