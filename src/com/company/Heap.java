package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    private final ArrayList<Integer> list = new ArrayList<>();
    public Heap(){
        list.add(null);
        // dobavil potomu chto nemnogo legche rabotat' kogda u tebya
        // netu elimenta u kotorogo indeks 0. (iza umnozheniya na 0).
    }

    public void add(int e){
        list.add(e);
        normaliz();
    }

    public void clear(){
        list.clear();
        list.add(null);
    }


    private int lastIndex(){
        return list.size() - 1;
    }

    private void swap(int index1, int index2){
        Collections.swap(list, index1, index2);
    }

    private int getParent(int index){
        return index % 2 == 0 ? index / 2 : (index - 1) / 2;
    }

    private boolean hasParent(int index){
        return index > 1;
    }

    private void normaliz(){
        if(list.size() == 2){
            return;
        }
        int lastInt = list.get(lastIndex());
        int lastIndex = lastIndex();
        while (hasParent(lastIndex)){
            int parentIndex = getParent(lastIndex);
            int parentInt = list.get(parentIndex);
            if(lastInt > parentInt){
                swap(lastIndex, parentIndex);
            }else{
                break;
            }
            lastIndex = parentIndex;
        }

    }

    private Integer getChildrens(int index){
        int Lindex = index * 2;
        Integer per = list.size() > Lindex ? Lindex : null;
        int Rindex = Lindex + 1;
        Integer vtor = list.size() > Rindex ? Rindex : null;
        Integer bolihey;
        if(per != null && vtor != null) {
            bolihey = list.get(per) > list.get(vtor) ? per : vtor;
        }else if(per != null){
            bolihey = per;
        }else if(vtor != null){
            bolihey = vtor;
        }else{
            bolihey = null;
        }
        return bolihey;
    }

    public Integer getMaxRm(){
        if(list.size() == 1){
            return null;
        } else if(list.size() == 2){
            return list.remove(1);
        }
        int max = list.get(1);
        swap(1, lastIndex());
        list.remove(lastIndex());
        int lastInt = list.get(1);
        int lastIndex = 1;
        while (true){
            Integer boliheyIndex = getChildrens(lastIndex);
            if(boliheyIndex == null) {
                break;
            }
            int parentInt = list.get(boliheyIndex);
            if(lastInt <  parentInt){
                swap(boliheyIndex, lastIndex);
            }else{
                break;
            }
            lastIndex = boliheyIndex;
        }
        return max;
    }

    public Integer getMax() {
        if (list.size() == 1) {
            return null;
        }
        return list.get(1);
    }

}











