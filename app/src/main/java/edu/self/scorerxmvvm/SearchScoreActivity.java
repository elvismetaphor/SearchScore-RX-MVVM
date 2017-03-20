package edu.self.scorerxmvvm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.self.scorerxmvvm.viewmodel.SearchViewModel;

/**
 * A search score screen which apply MVVM
 */
public class SearchScoreActivity extends AppCompatActivity {

    private EditText nameField;
    private Button searchButton;
    private TextView scoreView;
    private SearchViewModel searchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_score);

        searchViewModel = new SearchViewModel(this);

        initLayout();
    }

    private void initLayout() {
        nameField = (EditText) findViewById(R.id.name_field);

        searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreView.setText("Name: " + nameField.getText().toString());
            }
        });

        scoreView = (TextView) findViewById(R.id.score_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

