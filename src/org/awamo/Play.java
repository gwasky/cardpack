package org.awamo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 1/21/20.
 */
public class Play {

    private List<Card> availableCards;
    private int currentIndex;
    public Player player1 = new Player();
    public Player player2 = new Player();

    private List<Card> player1Cards = new ArrayList<>();
    private List<Card> player2Cards = new ArrayList<>();

    public Play(List<Card> availableCards) {
        this.availableCards = availableCards;
    }

    public Card getRandomCard() {

        Card pickedCard = new Card();

        System.out.println(" NUMBER OF REMAINING CARDS IS : " + this.availableCards.size());

        if (this.availableCards.size() >= 0) {

            int randomCard = generateRandomNumber(0, this.availableCards.size());

            pickedCard.setValue(this.availableCards.get(randomCard).getValue());

            // System.out.println("Random Card Index " + randomCard + "- Card " + this.availableCards.get(randomCard).getValue());

            // Remove from Available Cards
            this.currentIndex = randomCard;
            // this.availableCards.remove(randomCard);

            System.out.print(" AVAILABLE CARDS [");

            for (Card card : this.availableCards) {

                System.out.print(card.getValue() + ",");
            }

            System.out.println("]");

        }

        return pickedCard;
    }

    public void issueCardToPlayer(Boolean alpha, Card card) {


        if ( this.availableCards.size() > 0) {

            if (alpha == false) {

                player1Cards.add(card);

                System.out.println(" GIVEN CARD " + card.getValue() + " TO PLAYER 1");

                player1.setPlayerCards(player1Cards);

                // Remove Card from Pack
                this.availableCards.remove(this.currentIndex);

            } else {

                player2Cards.add(card);

                System.out.println(" GIVEN CARD " + card.getValue() + " TO PLAYER 2");

                player2.setPlayerCards(player2Cards);

                // Remove Card from Pack
                this.availableCards.remove(this.currentIndex);

            }

        }
    }

    public int generateRandomNumber(int a, int b) {

        return new Random().nextInt(b) + a;
    }


}
