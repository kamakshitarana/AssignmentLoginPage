package com.example.loginactivity.recllerView.Api;

import com.example.loginactivity.recllerView.CharacterResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterService {
    @GET("user?page=2")
    Call<CharacterResponse> getCharacters();
}