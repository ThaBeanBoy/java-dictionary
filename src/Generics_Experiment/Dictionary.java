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

    public K retrieve(T key) throws InvalidKeyException{ return _values.get(KeyAtIndex(key)); }

    public boolean contains(T key){
        return _keys.contains(key);
    }
//
    public int size(){
        return _keys.size();
    }

    public void delete(T key) throws InvalidKeyException {
        //removing value of key from _value array
        _values.remove(KeyAtIndex(key));

        //removing key from _keys set
        _keys.remove(key);
    }

    public String dataToString(){
        String resultStr = "";

        Iterator<T> it = _keys.iterator();

        for(T currentKey : _keys)
            try{
                resultStr = resultStr.concat(currentKey + " | " + _values.get(KeyAtIndex(currentKey)) + "\n");
            }catch(Exception e){
                System.err.println("Dev Err: Something wrong in the dateToString Methods of the dictionary");
            }

        return resultStr;
    }

    public void loop(lambda <T, K>loopCode){
        for(T currentKey : _keys)
            try{
                loopCode.loopCode(currentKey, _values.get(KeyAtIndex(currentKey)));
            }catch(InvalidKeyException e){
                System.err.println("Dev Err: Couldn't find value");
            }
    }

    private int KeyAtIndex(T key) throws InvalidKeyException {
        Iterator<T> it = _keys.iterator();

        int indexToReturn = 0;
        while(it.hasNext()){
            T current = it.next();

            if(current == key || current.equals(key)){

                return indexToReturn;
            }

            indexToReturn++;
        }

        // The key was not found
        throw new InvalidKeyException();
    }
}
