/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.entity;

import java.util.Objects;

/**
 *
 * @author Ricardo
 */
public final class Card {

    private static final String STRING_RANK_CARDS = "23456789TJQKA";

    public static enum Suit {
        SPADE('♠'), HEART('♥'), DIAMOND('♦'), CLUB('♣');

        private Suit(char c) {
            this.c = c;
        }
        private final char c;
    }

    public static enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        if (suit == null) {
            throw new IllegalArgumentException("Suit no puede tener un valor nulo");
        }
        if (rank == null) {
            throw new IllegalArgumentException("Rank no puede tener un valor nulo");
        }
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        int rankValue = rank.ordinal();
        return STRING_RANK_CARDS.substring(rankValue, rankValue + 1) + suit.c;
    }

    @Override
    public int hashCode() {
        return rank.ordinal() * Suit.values().length + suit.ordinal();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        if (this != obj) {
            result = false;
            if (obj != null && getClass() == obj.getClass()) {
                result = hashCode() == ((Card) obj).hashCode();
            }
        }
        return result;
    }

}
