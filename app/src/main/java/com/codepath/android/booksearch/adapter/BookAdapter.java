package com.codepath.android.booksearch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.model.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Book> mBooks;
    private Context mContext;
    public BookAdapter() {
        this.mBooks = new ArrayList<>();
    }

    public void setBooks(List<Book> books, Context context) {
        mBooks = books;
        mContext = context;
        notifyDataSetChanged();
    }

    public void addBooks(List<Book> books) {
        mBooks.addAll(books);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View bookView = inflater.inflate(R.layout.item_book, parent, false);

        ViewHolder viewHolder = new ViewHolder(bookView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // TODO: Insert your code here
        Book book = mBooks.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.getTvTitle().setText(book.getTitle());
        viewHolder.getTvAuthor().setText(book.getAuthor());
        Picasso.with(mContext)
                .load(book.getCoverUrl())
                .into(viewHolder.getIvCover());
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivCover)
        ImageView ivCover;

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvAuthor)
        TextView tvAuthor;

        public ImageView getIvCover() {
            return ivCover;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvAuthor() {
            return tvAuthor;
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
