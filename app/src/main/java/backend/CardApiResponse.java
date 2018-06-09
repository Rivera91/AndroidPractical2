package backend;

import java.util.List;

public class CardApiResponse {

    private Boolean success;
    private List<String> cards;
    private String deck_id;
    private int remaining;

    public CardApiResponse(Boolean success, List<String> cards, String deck_id, int remaining) {
        this.success = success;
        this.cards = cards;
        this.deck_id = deck_id;
        this.remaining = remaining;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getCards() {
        return cards;
    }

    public void setCards(List<String> cards) {
        this.cards = cards;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
