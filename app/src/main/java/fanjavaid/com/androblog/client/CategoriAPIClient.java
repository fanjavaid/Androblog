package fanjavaid.com.androblog.client;

import java.util.List;

import fanjavaid.com.androblog.model.Category;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fanjavaid on 12/21/16.
 */

public interface CategoriAPIClient {
    static final String END_POINT = "http://androblog.local";

    @GET("/categories?limit=10&offset=0")
    Call<List<Category>> fetchAll();

    @GET("/categories/{id}")
    Call<Category> fetchById(@Path("id") Integer id);
}
