package com.example.loginactivity.recllerView.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginactivity.R;
import com.example.loginactivity.recllerView.model.Character;

import java.util.List;


public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private List<Character> characterList;

    public CharacterAdapter(List<Character> characterList) {
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.nameTextView.setText(character.getName());
        holder.bioTextView.setText(character.getColor());
        holder.imageView.setImageResource(character.getImgId());
//        holder.bind(character);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    static class CharacterViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView bioTextView;
        private ImageView imageView;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            bioTextView = itemView.findViewById(R.id.bioTextView);
            imageView = itemView.findViewById(R.id.avatarImageView);

        }

//        public void bind(Character character) {
//            nameTextView.setText(character.getName());
//            bioTextView.setText(character.getColor());
//
//        }
    }

}
