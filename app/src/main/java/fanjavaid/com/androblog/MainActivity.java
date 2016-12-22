package fanjavaid.com.androblog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import fanjavaid.com.androblog.client.CategoriAPIClient;
import fanjavaid.com.androblog.model.Category;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Spinner mCategoryOption;
    private Toolbar mNewsToolbar;
    private ProgressBar mProgressBar;
    private GsonBuilder gsonBuilder;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewsToolbar = (Toolbar) findViewById(R.id.news_menu);
        mNewsToolbar.inflateMenu(R.menu.card_menu);

        mCategoryOption = (Spinner) findViewById(R.id.category_option);

        // Initialize retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(CategoriAPIClient.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getCategories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = getMenuInflater();
        mMenuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    private void getCategories() {
        CategoriAPIClient clientAPI = retrofit.create(CategoriAPIClient.class);

        Call<List<Category>> categories = clientAPI.fetchAll();
        categories.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.d("RETROFIT", "onResponse: " + response.body());
                if (response.isSuccessful()) {
                    ArrayAdapter mCategoryListAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, response.body());
                    mCategoryOption.setAdapter(mCategoryListAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
