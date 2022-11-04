package com.example.xandcompmobile.view.UML.uniritter.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.xandcompmobile.R;
import com.example.xandcompmobile.view.UML.uniritter.model.Albuns;
import com.example.xandcompmobile.view.UML.uniritter.model.User;


import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Albuns> dadosAlbuns;
    private List<User> dadosUser;

    public AlbumAdapter(List<Albuns> dadosAlbuns, List<User> dadosUser) {
        this.dadosAlbuns = dadosAlbuns;
        this.dadosUser = dadosUser;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_album_list, parent, false);
        return new AlbumViewHolder(layoutViewHolder);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Albuns objAlbuns = dadosAlbuns.get(position);
        User objUser = dadosUser.get( objAlbuns.getUserID()-1 );
        if ( objUser.getId() == objAlbuns.getUserID() ) {
            ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.uAlbum)).setText("User: "+objUser.getNome());
            ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.Album)).setText("ID: "+Integer.toString(objAlbuns.getId()));
            ((TextView)((AlbumViewHolder) holder).view.findViewById(R.id.TituloAlbum)).setText("Titulo: "+ objAlbuns.getTitle());
        }

    }



    @Override
    public int getItemCount() { return dadosAlbuns.size(); }



}
class AlbumViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public AlbumViewHolder(@NonNull View itemView){
        super(itemView);
        view = itemView;
    }
}