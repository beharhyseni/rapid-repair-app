package com.rapidrepair;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.File;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private ServicePost[] posts;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView description;
        public TextView host;
        public TextView numRatings;
        public ImageView photo;
        public RatingBar rating;

        public ViewHolder(View v) {
            super(v);
            title =  v.findViewById(R.id.title);
            description =  v.findViewById(R.id.description);
            host =  v.findViewById(R.id.host);
            numRatings =  v.findViewById(R.id.numRatings);
            photo =  v.findViewById(R.id.photo);
        }
    }
    
    // Provide a suitable constructor (depends on the kind of dataset)
    public PostsAdapter(ServicePost[] posts) {
        this.posts = posts;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(posts[position].getTitle());
        holder.description.setText(posts[position].getDescription());
        holder.host.setText(posts[position].getHost());
        holder.numRatings.setText(posts[position].getNumRatings().toString());
        File imgFile = new File(posts[position].getPhoto());
        //if(imgFile.exists()){
        String absPath = imgFile.getAbsolutePath();
        Bitmap myBitmap = BitmapFactory.decodeFile(absPath);
        holder.photo.setImageBitmap(myBitmap);
        //}
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return posts.length;
    }
}