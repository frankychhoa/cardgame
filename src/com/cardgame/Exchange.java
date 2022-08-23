package com.cardgame;

import java.util.ArrayList;

public class Exchange {
    private Player playerA;
    private Player playerB;

    //should this two fields be created???
    private ArrayList<Card> oriCard;
    private ArrayList<Card> exchangedCard;

    private int turn = 1;

    public Exchange(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void exchangeCards(){
        oriCard = playerA.getHands();
        exchangedCard = playerB.getHands();
        playerA.setHands(exchangedCard);
        playerB.setHands(oriCard);
    }

    public void returnCards(){
        oriCard = playerB.getHands();
        exchangedCard = playerA.getHands();
        playerA.setHands(oriCard);
        playerB.setHands(exchangedCard);
    }

    public void nextTurn() {
        this.turn += 1;
    }



    public int getTurn() {
        return turn;
    }
}
