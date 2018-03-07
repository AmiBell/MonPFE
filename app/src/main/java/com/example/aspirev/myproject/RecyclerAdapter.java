package com.example.aspirev.myproject;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lenovo on 07/03/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] noms={"BELLILI","HASSOUNA","BOUDAB","ADDALA","BOUBEKRI","HACHEMI"};
    private String[] prenoms={"amira","sonia","hania","Amel","Soumia","Asma"};
    private int[] images={R.drawable.petite,R.drawable.petite,R.drawable.petite,R.drawable.petite,R.drawable.petite,R.drawable.petite};


    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemNom;
        public TextView itemPrenom;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage=(ImageView)itemView.findViewById(R.id.image_profil);
            itemNom=(TextView) itemView.findViewById(R.id.text_nom);
            itemPrenom=(TextView) itemView.findViewById(R.id.text_prenom);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                int position = getAdapterPosition();
                Snackbar.make(v,"click detected on item "+position,Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout,viewGroup,false);
        ViewHolder viewHolder= new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int i){
        viewHolder.itemNom.setText(noms[i]);
        viewHolder.itemPrenom.setText(prenoms[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount(){return noms.length;}
}
