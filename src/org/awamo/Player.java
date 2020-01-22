package org.awamo;

import java.util.List;

/**
 * Created by Administrator on 1/21/20.
 */
public class Player {

    private List<Card> playerCards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    private String name;


}
