package nyc.c4q.androidretake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import backend.CardService;
import model.CardShuffle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JSON?";
    private CardService cardService;
    Button shuffle;
    Button draw;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // RecyclerView imageRecyclerView = (RecyclerView) findViewById(R.id.cardImage);

        shuffle = (Button) findViewById(R.id.shuffle);
        draw = (Button) findViewById(R.id.draw);
        editText = (EditText) findViewById(R.id.editText);


        shuffle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://deckofcardsapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cardService = retrofit.create(CardService.class);

        Call<CardShuffle>shuffledeck = cardService.getNewShuffle();
        shuffledeck.enqueue(new Callback<CardShuffle>() {
            @Override
            public void onResponse(Call<CardShuffle> call, Response<CardShuffle> response) {
                Log.e(TAG, "onResponse: " + response.body().getDeck_id());
                Log.e(TAG, "onResponse: " + response.body().getRemaining());
            }

            @Override
            public void onFailure(Call<CardShuffle> call, Throwable t) {
                Log.e(TAG, "onResponse: " + t.toString());
            }
        });

            }
        });

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty()) {
                    editText.setError("You must draw at least 1 card");
                    editText.requestFocus();
                }

        }});

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.cardImage);





    }
}
