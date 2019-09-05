package com.company;

public class Pair<L, R> {

    private L left = null;
    private R right = null;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }
    public Pair() {}

    public L getLeft() { return left; }
    public R getRight() { return right; }
    public void setLeft(L left) {this.left = left;}
    public void setRight(R right) {this.right = right;}
    public String toString() {
        return String.valueOf(left) + " " + String.valueOf(right);
    }

}