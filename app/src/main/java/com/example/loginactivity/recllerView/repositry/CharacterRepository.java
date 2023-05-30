package com.example.loginactivity.recllerView.repositry;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.util.Log;

import com.example.loginactivity.recllerView.Api.CharacterService;
import com.example.loginactivity.recllerView.CharacterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterRepository {
    private CharacterService characterService;

    public CharacterRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        characterService = retrofit.create(CharacterService.class);
    }

    public void fetchCharacters(CharacterCallback callback) {
        characterService.getCharacters().enqueue(new Callback<CharacterResponse>() {
            @Override
            public void onResponse(Call<CharacterResponse> call, Response<CharacterResponse> response) {
                if (response.isSuccessful()) {
                    CharacterResponse characterResponse = response.body();
                    if (characterResponse != null) {
                        Log.d(TAG, response.toString());

                        callback.onSuccess(characterResponse.getCharacters());
                    } else {
                        callback.onFailure("Failed to get character response");
                    }
                } else {
                    callback.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(Call<CharacterResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }

    public interface CharacterCallback {
        void onSuccess(List<com.example.loginactivity.recllerView.model.Character> characters);
        void onFailure(String errorMessage);
    }
}
