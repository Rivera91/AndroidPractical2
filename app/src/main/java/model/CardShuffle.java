package model;

import java.util.List;

public class CardShuffle {

    private String success;
    private String deck_id;
    private Boolean shuffled;
    private int remaining;
    private List<CardDraw> cards;

    public String getSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public Boolean getShuffled() {
        return shuffled;
    }

    public int getRemaining() {
        return remaining;
    }
}
