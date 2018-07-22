package com.rapidrepair;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder>{
    private ServiceReview[] reviews;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView description;
        public TextView reviewer;
        public RatingBar rating;

        public ViewHolder(View v) {
            super(v);
            description =  v.findViewById(R.id.description);
            reviewer =  v.findViewById(R.id.reviewer);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ReviewsAdapter(ServiceReview[] posts, Context context) {
        this.reviews = posts;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ReviewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review, parent, false);
        ReviewsAdapter.ViewHolder vh = new ReviewsAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ReviewsAdapter.ViewHolder holder, int position) {
        holder.description.setText(reviews[position].getReview());
        holder.reviewer.setText(reviews[position].getReviewer());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return reviews.length;
    }
}