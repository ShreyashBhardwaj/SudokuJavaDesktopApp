package com.example.sudokudesktopapp.problemdomain;

import java.util.Objects;

public class Cooridnates {
    private final int x,y;

    public Cooridnates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cooridnates that = (Cooridnates) o;
        return x==that.x && y==that.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
}
