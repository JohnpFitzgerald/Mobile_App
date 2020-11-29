package com.example.wildanimals;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
//Student: John Fitzgerald
//ID: R00156081
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.myViewHolder> {

    Context context;
    String data1[],data2[];
    int images[];


    public MyRecyclerViewAdapter(Context ct, String animalName[], String description[], int img[])
    {
         context = ct;
         data1 = animalName;
         data2 = description;
         images = img;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //use inflater on my row to standardise
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
         holder.animal_textView.setText(data1[position]);
         holder.my_imageView.setImageResource(images[position]);

         //set an listener to route back to mainActivity on click
         holder.mainLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view){
                 Intent intent = new Intent(context, SecondActivity.class);
                 intent.putExtra("data1", data1[position]);
                 intent.putExtra("data2", data2[position]);
                 intent.putExtra ("my_imageView", images[position]);
                 context.startActivity(intent);
             }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView animal_textView;
        ImageView my_imageView;
        ConstraintLayout mainLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            animal_textView = itemView.findViewById(R.id.animal_textView);
            my_imageView = itemView.findViewById(R.id.my_imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
