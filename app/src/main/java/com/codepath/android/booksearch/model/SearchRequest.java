package com.codepath.android.booksearch.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nongdenchet on 10/18/16.
 */

public class SearchRequest {
    private int page = 1;
    private String query = "Oscar Wilde";

    public void setPage(int page) {
        this.page = page;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Map<String, String> toQueryMay() {
        Map<String, String> options = new HashMap<>();
        options.put("page", String.valueOf(page));
        options.put("q", query);
        return options;
    }
}
