package com.codepath.android.booksearch.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.android.booksearch.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Book> mBooks;

    public BookAdapter() {
        this.mBooks = new ArrayList<>();
    }

    public void setBooks(List<Book> books) {
        // TODO: Insert your code here
    }

    public void addBooks(List<Book> books) {
        // TODO: Insert your code here
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // TODO: Insert your code here
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // TODO: Insert your code here
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder {
        public ImageView ivCover;
        public TextView tvTitle;
        public TextView tvAuthor;
    }
}
