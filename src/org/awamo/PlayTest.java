package org.awamo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 1/21/20.
 */
public class PlayTest {

    Object[] expCards = new Object[20];
    Optional<List<Card>> cards = null;

    Play play = new Play(cards.get());

    @Before
    public void initializeCards() {
        Integer x = 0;
        for (int i = 0; i < 20; i++) {
            x += 1;
            expCards[i] = new Card(x);
        }
    }

    @Before
    public void setUp() throws Exception {
        cards = Optional.ofNullable(Main.generateCardValues());
        Boolean alpha = false;
    }

    @Test
    public void testGenerateCardValues() throws Exception {
        Object[] cardObj = cards.get().toArray();
        assertArrayEquals(expCards, cardObj);
    }

//    @Test
//    public void testShuffleCards() throws Exception {
//
//    }
//
    @Test
    public void testGetRandomCard() throws Exception {
        Card card = play.getRandomCard();
        // assertEquals(card.getValue());

    }
//
//    @Test
//    public void testIssueCardToPlayer() throws Exception {
//
//    }
//
//    @Test
//    public void testGenerateRandomNumber() throws Exception {
//
//    }


}
