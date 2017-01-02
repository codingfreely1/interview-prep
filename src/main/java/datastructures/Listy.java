package datastructures;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yael on 02/01/17.
 */
public class Listy {

    private ArrayList<Integer> arrayList;

    public Listy(Collection<Integer> c) {
        arrayList = new ArrayList<>(c);
    }

    public int elementAt(int i){
        if(i < 0 || i >= arrayList.size()){
            return -1;
        }
        return arrayList.get(i);
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }
}
