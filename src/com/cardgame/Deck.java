package com.cardgame;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    ArrayList<Card> deck = new ArrayList();
    private String[] suit = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private String[] rank = {"Club", "Diamond", "Heart", "Spade"};
    //make deck

    // made in constructor
    public void makeDeck(){
        for (int i=0; i<rank.length; i++){
            for (int j=0; j< suit.length; j++){
                deck.add(new Card(rank[i], suit[j]));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void draw(Player player){
        Card newCard = deck.remove(deck.size()-1); //>>
        player.drawCard(newCard);
        //deck.remove(deck.size()-1);

    }


}
