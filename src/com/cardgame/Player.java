package com.cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player {
    int point = 0;
    protected ArrayList<Card> hands = new ArrayList<>(); //List

    protected Card shownCard;

    private boolean exchangeUsed = false;

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(Card card){
        hands.add(card);
    }
    //public abstract void showCard();
    //>>return card
    public void showCard() {

        Card card = hands.get(0);

        this.shownCard = card;
        hands.remove(0);

    }
    public void addPoint(){
        this.point+=1;
    }

    public int exchangeCard(){

        return 0;

        //System.out.println("yes");

    }

    public Card getShownCard() {
        return shownCard;
    }

    public ArrayList<Card> getHands() {
        return hands;
    }

    public void setHands(ArrayList<Card> hands) {
        this.hands = hands;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    public boolean isExchangeUsed() {
        return exchangeUsed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExchangeUsed(boolean exchangeUsed) {
        this.exchangeUsed = exchangeUsed;
    }
}



