package com.jyothi;

public class HashMap<K, V> {
    private Entry<K, V>[] buckets;
    private Integer capacity = 5;

    @SuppressWarnings("unchecked")
    public HashMap() {
        buckets = new Entry[capacity];
    }

    @SuppressWarnings("unchecked")
    public HashMap(Integer capacity) {
        this.capacity = capacity;
        buckets = new Entry[capacity];
    }

    private Integer hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        Integer hash = hash(key);
        Entry<K, V> entry = new Entry<K, V>(key, value);
        Entry<K, V> temp = buckets[hash];
        if(temp == null){
            buckets[hash] = entry;
        }else{
            while(temp != null){
                if(temp.key.equals(key)){
                    //System.out.println(temp.key + "-" + temp.value);
                    temp.value = value;
                    break;
                }
                if(temp.next != null){
                    temp = temp.next;
                }else{
                    temp.next = entry;
                }
            }
        }
    }

    public V get(K key){
        Integer hash = hash(key);
        Entry<K, V> temp = buckets[hash];
        while(temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public void remove(K key){
        Integer hash = hash(key);
        Entry<K, V> temp = buckets[hash];
        Entry<K, V> prev = null;
        while(temp != null){
            if(temp.key.equals(key)){
                if(prev != null){
                    prev.next = temp.next;
                }else{
                    prev = temp.next;
                    buckets[hash] = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void display() {
        System.out.println("^^^^^^^^^^^^^^^^");
        for(Integer i = 0; i < capacity; i++){
            Entry<K, V> temp = buckets[i];
            while(temp != null){
                System.out.println(temp.key + " -> " + temp.value);
                temp = temp.next;
            }
        }
        System.out.println("^^^^^^^^^^^^^^^^");
    }


}
