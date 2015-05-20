package info.yiqin.searchfeature;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.app.SearchManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class SearchResultsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            ArrayList<String> places = new ArrayList<>();
            Collections.addAll(places, getResources().getStringArray(R.array.places_array));
            if(places.contains(query)) {
                Toast.makeText(getApplicationContext(), "Found", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_LONG).show();
            }
        }
    }
}
