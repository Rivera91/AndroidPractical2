package backend;

import java.util.List;

import model.CardShuffle;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CardApiService {

    public static final String BASE_URL = "http://deckofcardsapi.com";

    @GET("api/deck/new/shuffle/")
    Call<CardShuffle>getNewShuffle();

    @GET("api/deck/{deck_id}/draw/?count=52")
    Call<CardApiResponse> getDraw1(@Path("deck_id")String id, @Query("num_cards")int numCards);

}



//    @GET("api/deck/{deck_id}/draw/?count={num_cards}")