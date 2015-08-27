package com.park;

public class Token {
    private int tokenNumber;

    public Token(){
    }

    public Token(int tokenNumber){
        this.tokenNumber = tokenNumber;
    }

    @Override
    public String toString() {
        return ""+tokenNumber;
    }
}