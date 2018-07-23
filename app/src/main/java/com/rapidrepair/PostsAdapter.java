package com.rapidrepair;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private ServicePost[] posts;
    private Context context;
    private Drawable drawable;

    public PostsAdapter(){}

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView description;
        public TextView host;
        public TextView numRatings;
        public ImageView photo;
        public RatingBar rating;
        private final Context ct;


        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            description = v.findViewById(R.id.description);
            host = v.findViewById(R.id.host);
            numRatings = v.findViewById(R.id.numRatings);
            photo = v.findViewById(R.id.photo);
            ct = v.getContext();
            photo.setOnClickListener(this);
            Drawable myDrawable = ct.getDrawable(R.drawable.plumber);
            photo.setImageDrawable(myDrawable);
        }

        @Override
        public void onClick(View v) {
            final Intent intent = new Intent(ct, ServiceActivity.class);
            ct.startActivity(intent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PostsAdapter(ServicePost[] posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);
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
        Picasso.with(context).load(posts[position].getPhoto()).into(holder.photo);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return posts.length;
    }
}