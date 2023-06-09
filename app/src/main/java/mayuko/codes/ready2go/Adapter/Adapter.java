package mayuko.codes.ready2go.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import mayuko.codes.ready2go.CheckList;
import mayuko.codes.ready2go.Constants.Constants;

import java.util.List;

import mayuko.codes.ready2go.R;


public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder>{

    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;
    Activity activity;

    public Adapter(Context context, List<String> titles, List<Integer> images, Activity activity) {
        this.titles = titles;
        this.images = images;
        this.activity = activity;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.img.setImageResource(images.get(position));
        holder.linearLayout.setAlpha(0.8F);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CheckList.class);
                intent.putExtra(Constants.HEADER_SMALL, titles.get(holder.getAdapterPosition()));
                if (Constants.MY_SELECTIONS.equals(titles.get(holder.getAdapterPosition()))) {
                    intent.putExtra(Constants.SHOW_SMALL, Constants.FALSE_STRING);
                } else {
                    intent.putExtra(Constants.SHOW_SMALL, Constants.TRUE_STRING);
                }
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class myViewHolder extends  RecyclerView.ViewHolder{

        TextView title;
        ImageView img;
        LinearLayout linearLayout;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.image);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }

}
