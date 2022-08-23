package com.cardgame;

public class cardGame {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Game game = new Game();
        //players
        Player player1 = new HumanPlayer("player1");
        Player player2 = new HumanPlayer("player2");
        Player player3 = new AIPlayer("player3");
        Player player4 = new AIPlayer("player4");

        game.addPlayers(player1); //player or player"s"
        game.addPlayers(player2);
        game.addPlayers(player3);
        game.addPlayers(player4);

        //set deck
        Deck deck = new Deck();
        deck.makeDeck();
        game.setDeck(deck);

        while (game.getTurn() <= 12){
            game.runTurn();
        }
        game.decideWinner();
        game.getWinner();

        //System.out.println(deck.deck);
        System.out.print("the winner is ");
        System.out.println(game.getWinner().getName());

        System.out.println(player1.getPoint());
        System.out.println(player2.getPoint());
        System.out.println(player3.getPoint());
        System.out.println(player4.getPoint());

    }
}
