package org.awamo;

/**
 * Created by Administrator on 1/21/20.
 */
public class Card {
    // value between 1 and 20

    private int value;

    public Card(int value) {
        this.value = value;
    }

    public Card() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // When comparing 2 arrayLists of user defined List, hashCode and & equals has to be overwritten, otherwise test will never pass
    public boolean equals(Object obj) {
        Card card = (Card) obj;
        boolean status = false;
        if (this.value == card.value) {
            status = true;
        }
        return status;
    }

    public int hashCode() {
        return this.value;
    }
}
