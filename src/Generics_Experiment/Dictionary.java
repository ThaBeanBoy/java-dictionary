package Generics_Experiment;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Dictionary <T, K> {
    final private HashSet<T> _keys;
    final private ArrayList<K> _values;

    //Constructors
    public Dictionary(){
        this._keys = new HashSet<>();
        this._values = new ArrayList<>();
    }

    public void add(T key, K value){
        if(!_keys.contains(key)){
            _keys.add(key);
            _values.add(value);
        }
    }

    public K retrieve(T key) throws InvalidKeyException{
        Iterator<T> it = _keys.iterator();

        int indexToReturn = 0;
        while(it.hasNext()){
            T current = it.next();

            if(current.equals(key)){
                return _values.get(indexToReturn);
            }

            indexToReturn++;
        }

        // The key was not found
        throw new InvalidKeyException();
    }

    public boolean contains(T key){
        return _keys.contains(key);
    }
//
    public int size(){
        return _keys.size();
    }
}