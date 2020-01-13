package com.example.libraryfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference dbCollectionRef = db.collection("BookCollection");
    private BookAdapter mAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createRecyclerView();
    }

    private void createRecyclerView() {
        Query query = dbCollectionRef.orderBy("price",Query.Direction.DESCENDING);

        //how we get our query into the adapter
        FirestoreRecyclerOptions<Book> options = new FirestoreRecyclerOptions.Builder<Book>()
                .setQuery(query,Book.class)
                .build();

        mAdapater = new BookAdapter(options);
        RecyclerView recyclerView = findViewById(R.id.recylcer_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(mAdapater);


    }//end createRecyclerView

    @Override
    protected void onStart() {
        super.onStart();
        mAdapater.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapater.stopListening();
    }
}//end main class
