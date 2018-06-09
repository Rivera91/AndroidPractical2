package backend;

import model.CardDraw;
import model.CardDrawImage;
import model.CardShuffle;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CardService {
    @GET("api/deck/new/shuffle/")
    Call<CardShuffle>getNewShuffle();

    @GET("api/deck/{deck_id}/draw/?count={num_cards}")
    Call<CardDrawImage> getDraw1(@Path("deck_id")String id, @Query("num_cards")int numCards);

}