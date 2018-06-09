package nyc.c4q.androidretake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import backend.CardApiResponse;
import backend.CardApiService;
import controller.CardAdapter;
import model.CardDrawImage;
import model.CardShuffle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JSON?";
    private CardApiService cardService;
    Button shuffle;
    Button draw;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        shuffle = (Button) findViewById(R.id.shuffle);
        draw = (Button) findViewById(R.id.draw);
        editText = (EditText) findViewById(R.id.editText);


        shuffle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CardApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cardService = retrofit.create(CardApiService.class);

        Call<CardShuffle>shuffleDeck = cardService.getNewShuffle();
        shuffleDeck.enqueue(new Callback<CardShuffle>() {
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

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.cardImage);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        final CardAdapter adapter = new CardAdapter(new ArrayList<String>());
        recyclerView.setAdapter(adapter);

        String face = "Cards";
        int num = 52;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CardApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardApiService cardApiService = retrofit.create(CardApiService.class);

        Call<CardApiResponse> call = cardApiService.getDraw1(face,num);

        call.enqueue(new Callback<CardApiResponse>() {

            @Override
            public void onResponse(Call<CardApiResponse> call, Response<CardApiResponse> response) {
                List<String> cardImageUrl = response.body().getCards();
                adapter.addAll(cardImageUrl);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CardApiResponse> call, Throwable t) {

               // Log.e(TAG, "onResponse: " + t.toString());

                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();


            }
        });





    }
}
