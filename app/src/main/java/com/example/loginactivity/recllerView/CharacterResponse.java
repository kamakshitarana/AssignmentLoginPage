package com.example.loginactivity.recllerView;

import com.google.gson.annotations.SerializedName;
import com.example.loginactivity.recllerView.model.Character;


import java.util.List;

public class CharacterResponse {
    @SerializedName("data")
    private List<Character> characters;

    public List<Character> getCharacters() {
        return characters;
    }
}