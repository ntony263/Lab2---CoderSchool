package com.codepath.android.booksearch.api;

import com.codepath.android.booksearch.model.SearchResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by nongdenchet on 10/18/16.
 */

public interface BookApi {

    @GET("search.json")
    Call<SearchResult> search(@QueryMap(encoded = true) Map<String, String> options);
}
