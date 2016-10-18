package com.codepath.android.booksearch.api;

import com.codepath.android.booksearch.model.BookSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nongdenchet on 10/18/16.
 */

public interface BookApi {

    @GET("search.json")
    Call<BookSearch> search(@Query("q") String query, @Query("page") int page);
}
