package org.awamo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 1/21/20.
 */
public class Main {

    public static List<Card> cards = new ArrayList<Card>();

    static List<Integer> p1PointsPerRound = new ArrayList<>();
    static List<Integer> p2PointsPerRound = new ArrayList<>();

    public static void main(String[] args) {

        List<Card> cards = generateCardValues();

        int packSize = cards.size();

        System.out.println(" CARD COUNT " + packSize + "\n");

        Play play = new Play(cards);

        Boolean alpha = false;

        for (int i = 1; i <= packSize; i++) {

            Card card = play.getRandomCard();

            play.issueCardToPlayer(alpha,card);

            if(alpha == true) alpha = false; else alpha = true;

            // System.out.println(" End of Iteration " + i);

            System.out.println("======================================================================");

        }

        System.out.println();

        System.out.println("  ==== ISSUING CARDS COMPLETE! ==== \n");

        System.out.println("  ==== CHECKING PLAYERS CARDS ===== \n");


        List<Card> p1Cards = play.player1.getPlayerCards();

        int plCount = p1Cards.size();

        List<Card> p2Cards = play.player2.getPlayerCards();

        int p2Count = p2Cards.size();

        System.out.println(" NUMBER OF CARDS RECEIVED BY PLAYER 1 ->" + plCount);

        System.out.println(" NUMBER OF CARDS RECEIVED BY PLAYER 2 ->" + p2Count + "\n");

        System.out.println("  ==== CHECKING WINNER PER ROUND ===== \n");

        checkWinnerPerRound(p1Cards, p2Cards);

        System.out.println("  \n==== CHECKING SUMMARY OF SCORES PER ROUND ===== \n");

        System.out.print(" Player 1 Scores ");

        System.out.print(" [");


        int p1Points = 0;
        int p2Points = 1;

        for(int points : p1PointsPerRound){

            p1Points += points;
            System.out.print(points + " ");

        }

        System.out.println("]");

        System.out.print(" Player 2 Scores ");

        System.out.print(" [");

        for(int points : p2PointsPerRound){

            p2Points += points;
            System.out.print(points + " ");

        }

        System.out.println("]");


        checkWinner(p1Points,p2Points);

    }

    public static List<Card> generateCardValues() {

        for (int i = 1; i <= 20; i++) {

            cards.add(new Card(i));
        }
        return cards;
    }

    // 1 for win, 0 for loss
    public static void checkWinnerPerRound(List<Card> p1, List<Card> p2 ){

        if(p1.size() == p2.size()){

            int x = 1;

            for(int i = 0; i < p1.size(); i++) {

                if(p1.get(i).getValue() > p2.get(i).getValue()){

                    p1PointsPerRound.add(1);
                    p2PointsPerRound.add(0);

                    System.out.println(" Player 1 Wins Round " + x);

                } else {
                    p1PointsPerRound.add(0);
                    p2PointsPerRound.add(1);

                    System.out.println(" Player 2 Wins Round " + x);
                }

                x += 1;
            }
        } else {
            // If there's a chance a user has less
        }
    } 
    public static void checkWinner(int p1Score, int p2Score){

        if(p1Score > p2Score) System.out.println("\n CONGRATULATIONS TO PLAYER 1, HE IS THE WINNER !!!"); else System.out.println("\n CONGRATULATIONS TO PLAYER 2, HE IS THE WINNER !!!");
    }

}
