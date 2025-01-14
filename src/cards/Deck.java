package cards;

import java.security.SecureRandom;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

public class Deck{

    public static final String[] SUIT = {
        "Diamond", "Spade", "Hearts", "Clubs"
    };

    public static final String[] NAMES = {
        "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "King", "Queen"
    };

    public static final int[] VALUES = {
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };

    protected Cards[] cards;

    public Deck(){
        int idx = 0;
        cards = new Cards[52]; // create an array of type Cards with 52 Cards
        for (int s = 0; s < SUIT.length; s+=1){
            String suit = SUIT[s];
            for (int n = 0; n < NAMES.length; n+=1){
                String name = NAMES[n];
                int value = VALUES[n];
                Cards card = new Cards(suit, name, value);
                cards[idx] = card;
                idx += 1;
            }
        }
    }

    public Deck Shuffle(){
        Deck shuffledDeck = new Deck();
        Deck deck = new Deck();

        Random rand = new SecureRandom();

        for (int i = 0; i < cards.length; i += 1){
            int r = i + rand.nextInt(52-i);
            Cards temp = deck.get(r);
            shuffledDeck.set(temp, i);
        }
        return shuffledDeck;
    }

    public Cards get(){
        return this.get(0);
    }

    public Cards get(int pos){
        return this.cards[pos];
    }

    public void set(Cards card, int pos){
        this.cards[pos] = card;
    }

    @Override
    public String toString(){
        return "Number of cards: %d".formatted(cards.length);
    }

}