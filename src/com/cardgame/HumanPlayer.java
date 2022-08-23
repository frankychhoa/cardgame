package com.cardgame;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private String name;
    //private ArrayList<Card> hands = new ArrayList<>();
    //private Card shownCard;

    public HumanPlayer(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void showCard(){
        ArrayList<String> showHands = new ArrayList<>();
        for (Card c: hands){
            showHands.add(c.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(showHands);
        System.out.println("which card will you show?");
        //ArrayList<Card> hands = getHands();
        int index = scanner.nextInt();
        //scanner.close();
        //System.out.println(hands);
        Card card = hands.get(index);
        this.shownCard = card;

        hands.remove(index);

        //return shownCard;

    }

    @Override
    public int exchangeCard(){
        int playerB_index = 0;
        boolean exchangeUsed = isExchangeUsed();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Will you use the exchange(yes:1, no:any) > ");
        if (scanner.nextInt() == 1){
            setExchangeUsed(true);
            System.out.println("use exchange");
            System.out.println(isExchangeUsed());
            Scanner playerB = new Scanner(System.in);
            System.out.print("with whom?");
            playerB_index = playerB.nextInt();
            /*if (exchangeUsed == true){
                System.out.println("exchange has been used");
            }
            else{

            }*/
        }
        //need to amend

        return playerB_index;

        //System.out.println("yes");

    }
}
