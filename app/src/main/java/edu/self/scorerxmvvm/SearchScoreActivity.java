package edu.self.scorerxmvvm;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.self.scorerxmvvm.viewmodel.SearchViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * A search score screen which apply MVVM
 */
public class SearchScoreActivity extends AppCompatActivity {

    private EditText nameField;
    private Button searchButton;
    private TextView scoreView;
    private ProgressDialog progressDialog;

    private SearchViewModel searchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_score);

        searchViewModel = new SearchViewModel();

        initLayout();
    }

    private void initLayout() {
        nameField = (EditText) findViewById(R.id.name_field);

        searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchViewModel.searchScore(nameField.getText().toString());
                progressDialog = ProgressDialog.show(SearchScoreActivity.this, "Search the score", "searching...", true);
            }
        });

        scoreView = (TextView) findViewById(R.id.score_view);
    }

    @Override
    protected void onResume() {
        super.onResume();

        searchViewModel.getScoreValueObservable().observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {}

            @Override
            public void onNext(String value) {
                updateScoreView(value);
            }

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onComplete() {}
        });
    }

    private void updateScoreView(String value) {
        scoreView.setText(value);
        progressDialog.dismiss();
    }
}

