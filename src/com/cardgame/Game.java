package com.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private int turn = 0;
    private Deck deck = new Deck();
    private ArrayList<Player> players = new ArrayList<>(); //List
    private ArrayList<Card> shownCard = new ArrayList<>();
    //compare
    private Map<String,Integer> rankLogic = new HashMap<>();
    private Map<String,Integer> suitLogic = new HashMap();
    //exchange
    private Map<Player, Exchange> exchangeList = new HashMap<>();
    private Player winner ;

    public void runTurn() {
        if (turn == 0){
            //set logic
            setPokerLogic();
            //deck shuffle
            deck.shuffle();
            //draw card while
            for (int i=0; i<13; i++){
                for (int j=0; j<4; j++){
                    deck.draw(players.get(j));
                }
            }

        }
        //
        //show cards
        System.out.println("START");
        for (int i=0; i<4; i++){
            Player currentPlayer = players.get(i);
            //check exchange
            //System.out.println(exchangeList);
            if (exchangeList.containsKey(currentPlayer)){
                exchangeList.get(currentPlayer).nextTurn();
                if (exchangeList.get(currentPlayer).getTurn() > 3){
                    exchangeList.get(currentPlayer).returnCards();
                    exchangeList.remove(currentPlayer);
                }
            }
            //System.out.println(currentPlayer);
            if (currentPlayer.isExchangeUsed() == false){
                int exchangePlayerNum = currentPlayer.exchangeCard(); //name is bad

                if (currentPlayer.isExchangeUsed()){
                    Exchange exchange = new Exchange(currentPlayer, players.get(exchangePlayerNum));
                    exchange.exchangeCards();
                    exchangeList.put(currentPlayer, exchange);
                }
            }
            //System.out.println(currentPlayer.getHands());
            currentPlayer.showCard();

        }

        //compare
        //System.out.println("compare");
        compareAndAddPoint();
        this.turn += 1;



    }

    public void addPlayers(Player player){
        players.add(player);

    }
    public void setPokerLogic (){
        //{"Club", "Diamond", "Heart", "Spade"}
        rankLogic.put("Club",1);
        rankLogic.put("Diamond",2);
        rankLogic.put("Heart",3);
        rankLogic.put("Spade",4);

        //suit logic
        suitLogic.put("2",2);
        suitLogic.put("3",3);
        suitLogic.put("4",4);
        suitLogic.put("5",5);
        suitLogic.put("6",6);
        suitLogic.put("7",7);
        suitLogic.put("8",8);
        suitLogic.put("9",9);
        suitLogic.put("10",10);
        suitLogic.put("J",11);
        suitLogic.put("Q",12);
        suitLogic.put("K",13);
        suitLogic.put("A",14);

    }

    //player showCard should be abstract (is it necessary in game?)
    public void showCard(Player player) {
        player.showCard();
    }

    public void compareAndAddPoint(){
        Player turnWinner = players.get(0);
        String maxRank = players.get(0).getShownCard().rank;
        String maxSuit = players.get(0).getShownCard().suit;
        for (int i=1; i<4; i++){
            //current card value
            String currentRank = players.get(i).getShownCard().rank;
            String currentSuit = players.get(i).getShownCard().suit;
            //suit comparison
            if (suitLogic.get(currentSuit)>suitLogic.get(maxSuit)){
                turnWinner = players.get(i);
            }
            //rank comparison
            else if(suitLogic.get(currentSuit) == suitLogic.get(maxSuit)){
                if (rankLogic.get(currentRank) > rankLogic.get(maxRank)){
                    turnWinner = players.get(i);
                }
            }
        }
        turnWinner.addPoint();
    }
    public void decideWinner(){
        Player winner = players.get(0);
        for (int i=1; i<4; i++){
            if (players.get(i).getPoint()>winner.getPoint()){
                winner = players.get(i);
            }
        }
        this.winner = winner;

    }

    public int getTurn() {
        return turn;
    }

    public Player getWinner() {
        return winner;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
