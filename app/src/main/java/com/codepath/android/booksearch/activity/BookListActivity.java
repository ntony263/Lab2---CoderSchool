package com.codepath.android.booksearch.activity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.adapter.BookAdapter;
import com.codepath.android.booksearch.api.BookApi;
import com.codepath.android.booksearch.model.SearchRequest;
import com.codepath.android.booksearch.model.SearchResult;
import com.codepath.android.booksearch.utils.RetrofitUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookListActivity extends AppCompatActivity {
    private SearchRequest mSearchRequest;
    private BookAdapter mBookAdapter;
    private BookApi mBookApi;
    private LinearLayoutManager mLayoutManager;

    @BindView(R.id.lvBooks)
    RecyclerView lvBooks;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        ButterKnife.bind(this);
        setUpApi();
        setUpViews();

    }

    private void setUpApi() {
        mSearchRequest = new SearchRequest();
        mBookApi = RetrofitUtils.get().create(BookApi.class);
    }

    private void setUpViews() {
        setSupportActionBar(toolbar);
        mBookAdapter = new BookAdapter();
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lvBooks.setAdapter(mBookAdapter);
        lvBooks.setLayoutManager(mLayoutManager);
    }

    MenuItem miActionProgressItem;

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // Store instance of the menu item containing progress
        miActionProgressItem = menu.findItem(R.id.miActionProgress);
        // Extract the action-view from the menu item
        ProgressBar v =  (ProgressBar) MenuItemCompat.getActionView(miActionProgressItem);
        // Return to finish
        fetchBooks();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void showProgressBar() {
        // Show progress item
        miActionProgressItem.setVisible(true);
    }

    public void hideProgressBar() {
        // Hide progress item
        miActionProgressItem.setVisible(false);
    }

    // Executes an API call to the OpenLibrary search endpoint, parses the results
    // Converts them into an array of book objects and adds them to the adapter
    private void fetchBooks() {
        showProgressBar();
        mBookApi.search(mSearchRequest.toQueryMay()).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                if (response.body() != null) {
                    handleResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    private void handleResponse(SearchResult searchResult) {
        mBookAdapter.setBooks(searchResult.getBooks(), this);
        hideProgressBar();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
