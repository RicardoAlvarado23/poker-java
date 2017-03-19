/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.main;

import com.ricardo.entity.Card;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Ricardo
 */
public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    private static void insert(Set<Card> cards, Card card){
       if(!cards.contains(card)){
           LOGGER.info("insetamos la carta: {}" , card);
           cards.add(card);
       }else{
           LOGGER.info("la carta: {}  ya estaba en el conjunto " , card);
       }
    }
    
    public static void main(String[] args) {
        /*Card card = new Card(Card.Suit.CLUB, Card.Rank.ACE);
        LOGGER.info("Ordinal {}" , card.getRank().ordinal());
        LOGGER.info("As de Treboles: {}" ,  card);*/
        Set<Card> cards = new HashSet<>();
        Card[] cards2Insert = {
            new Card(Card.Suit.CLUB,Card.Rank.ACE),
            new Card(Card.Suit.CLUB,Card.Rank.TWO),
            new Card(Card.Suit.CLUB,Card.Rank.THREE),
            new Card(Card.Suit.CLUB,Card.Rank.ACE),
            new Card(Card.Suit.CLUB,Card.Rank.FIVE)
        };
        
        for(Card card : cards2Insert){
            insert(cards, card);
        }
    }
    
    
}
