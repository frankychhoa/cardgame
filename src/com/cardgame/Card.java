package com.cardgame;

public class Card {

    String rank;
    String suit;

    Card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + suit;
    }
}
