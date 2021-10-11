package com.example.coen268;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BandViewHolder> {

    String bandName[], bandDesc[];
    int bandImg[];
    String bandUrl [] = {
            "Lamb_of_God_(band)",
            "Fossils_(band)",
            "Aurthohin",
            "Tool_(band)",
            "Porcupine_Tree",
            "Dream_Theater",
            "Thaikkudam_Bridge",
            "Ne_Obliviscaris_(band)",
            "Pink_Floyd",
            "Trivium",
            "Metallica"
    };
    Context ctx;
    public MyAdapter(Context ct, String s1[], String s2[], int s3[]) {
        this.ctx = ct;
        this.bandName = s1;
        this.bandImg = s3;
        this.bandDesc = s2;
        Log.d("DEBUG","On Create "+ bandName.length +" Recycler");
    }

    @NonNull
    @Override
    public BandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.band_cell_layout, parent,false);
        Log.d("DEBUG","On Create "+ bandName.length +" Recycler2 ");
        return new BandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BandViewHolder holder, int position) {
        holder.bandText.setText(bandName[position]);
        holder.bandDescText.setText(bandDesc[position]);
        holder.bandImg.setImageResource(bandImg[position]);
        holder.mainLayout.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //CHECKING FOR INTERNET AVAILABILITY
                        ConnectivityManager connectivityManager = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
                        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                            Intent intent = new Intent(ctx, MainActivity2.class);
                            intent.putExtra("bandUrl", bandUrl[position]);
                            ctx.startActivity(intent);
                        } else {
                            Toast.makeText(ctx,"Internet Not Available", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return this.bandName.length;
    }

    public class BandViewHolder extends RecyclerView.ViewHolder {
        TextView bandText, bandDescText;
        ImageView bandImg;
        ConstraintLayout mainLayout;
        public  BandViewHolder(@NonNull View itemView) {
            super(itemView);
            bandText = itemView.findViewById(R.id.bandName);
            bandDescText = itemView.findViewById(R.id.bandDesc);
            bandImg = itemView.findViewById(R.id.bandImg);
            mainLayout = itemView.findViewById(R.id.con);
        }
    }
}
