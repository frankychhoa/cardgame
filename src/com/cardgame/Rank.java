package com.cardgame;

public enum Rank {
    CLUB(1), DIAMOND(2), HEART(3), SPADE(4);

    int order;

    Rank(int order) {
        this.order = order;
    }
}
