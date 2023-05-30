package com.example.loginactivity.recllerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.loginactivity.R;

import com.example.loginactivity.recllerView.adapter.CharacterAdapter;
import com.example.loginactivity.recllerView.model.Character;
import com.example.loginactivity.recllerView.repositry.CharacterRepository;

import java.util.ArrayList;
import java.util.List;
public class NextActivity extends AppCompatActivity{
    private List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

//        Character[] character = new Character[] {
//                new Character(android.R.drawable.ic_dialog_email),
//                new Character(android.R.drawable.ic_dialog_info),
//                new Character(android.R.drawable.ic_delete),
//                new Character(android.R.drawable.ic_dialog_dialer),
//        };

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        characterList = new ArrayList<>(); // Initialize the characterList with your data
        CharacterAdapter characterAdapter = new CharacterAdapter(characterList);
        recyclerView.setAdapter(characterAdapter);

        CharacterRepository characterRepository = new CharacterRepository();
        characterRepository.fetchCharacters(new CharacterRepository.CharacterCallback() {
            @Override
            public void onSuccess(List<Character> characters) {
                characterList.clear(); // Clear the existing list
                characterList.addAll(characters); // Add the fetched characters to the list
                characterAdapter.notifyDataSetChanged(); // Notify the adapter about the data change
            }

            @Override
            public void onFailure(String errorMessage) {
            }
        });

    }
}