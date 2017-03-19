/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.entity;

import java.util.HashSet;
import java.util.Set;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Ricardo
 */
public class CardTest {
   
    @Test
    public void testConstructor(){
        System.out.println("card()");
        Card.Suit expSuit = Card.Suit.CLUB;
        Card.Rank expRank = Card.Rank.TEN;
        Card instance = new Card(expSuit,expRank);
        Card.Suit suitResult = instance.getSuit();
        Assert.assertEquals(expSuit,suitResult);
        Card.Rank rankResult = instance.getRank();
        Assert.assertEquals(expRank,rankResult);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testContructorSuitNull(){
        System.out.println("card(SuitNull)");
        Card.Suit expSuit = null;
        Card.Rank expRank = Card.Rank.TWO;
        Card instance = new Card(expSuit,expRank);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testContructorRankNull(){
        System.out.println("card(RankNull)");
        Card.Suit expSuit = Card.Suit.DIAMOND;
        Card.Rank expRank = null;
        Card instance = new Card(expSuit,expRank);
    }
    
    private static Card[] getAllCards(){
        Card[] result = new Card[Card.Suit.values().length * Card.Rank.values().length];
        int i = 0;
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values()){
                Card c = new Card(suit,rank);
                result[i] = c;
                i++;
            }
        }
        return result;
    }
    
    @Test
    public void testHasgCode(){
        System.out.println("hashcode");
        Card[] allCard = getAllCards();
        Set<Integer> hashCodes = new HashSet<>(allCard.length);
        System.out.println("hashCodes: " + hashCodes);
        for(Card card : allCard){
            Assert.assertThat(hashCodes, not(hasItem(card.hashCode())));
        }
    }
    
    @Test
    public void testEqualsOtherObjects(){
        System.out.println("equalsOtherObjects");
        Card card = new Card(Card.Suit.CLUB, Card.Rank.ACE);
        System.out.println(card);
        Assert.assertNotEquals("card: " + card + " !=null" , card,null);
        Assert.assertNotEquals("card: " + card + " != 0 " , card,0);
        Assert.assertNotEquals("card: " + card + " != \"2C\"" , card,new Card(Card.Suit.CLUB, Card.Rank.TWO));
    }
    
    @Test
    public void testEquals(){
        System.out.println("Equals");
        int i = 0;
        for (Card card0 : getAllCards()){
            int j = 0;
            for(Card card1 : getAllCards()){
                if (i == j){
                    Assert.assertEquals(card0,card1);
                }
                j++;
            }
            i++;
        }
    }
    
    @Test
    public void testNotEquals(){
        System.out.println("notEquals");
        int i = 0;
        for (Card card0 : getAllCards()){
            int j = 0;
            for(Card card1 : getAllCards()){
                if (i != j){
                    Assert.assertNotEquals(card0,card1);
                }
                j++;
            }
            i++;
        }
    }
}
