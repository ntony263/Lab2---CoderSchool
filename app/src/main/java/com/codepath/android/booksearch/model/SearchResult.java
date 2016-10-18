package com.codepath.android.booksearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nongdenchet on 10/18/16.
 */

public class SearchResult {

    @SerializedName("docs")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }
}
