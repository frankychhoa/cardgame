package com.cardgame;

import java.util.ArrayList;

public class AIPlayer extends Player{
    private ArrayList<Card> hands = new ArrayList<>();

    private Card shownCard;

    private String name = "AI";

    public AIPlayer(String name) {
        super(name);
        this.name = name;
    }

    /*@Override
    public void showCard() {
        System.out.println(this.hands);
        Card card = hands.get(0);

        this.shownCard = card;
        hands.remove(0);
        System.out.println(shownCard.getRank());
    }*/
}
