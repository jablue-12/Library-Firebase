package com.example.libraryfirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class BookAdapter extends FirestoreRecyclerAdapter<Book, BookAdapter.BookViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BookAdapter(@NonNull FirestoreRecyclerOptions<Book> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookViewHolder holder, int position, @NonNull Book model) {
        holder.titleTextView.setText(model.getTitle());
        holder.sumTextView.setText(model.getSummary());
        holder.priceTextView.setText(String.valueOf(model.getPrice()));


    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        return new BookViewHolder(v);
    }

    class BookViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView;
        private TextView sumTextView;
        private TextView priceTextView;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView= itemView.findViewById(R.id.title_text_view);
            sumTextView = itemView.findViewById(R.id.summary_text_view);
            priceTextView = itemView.findViewById(R.id.price_text_view);

        }
    }


}//end BookAdapter class
