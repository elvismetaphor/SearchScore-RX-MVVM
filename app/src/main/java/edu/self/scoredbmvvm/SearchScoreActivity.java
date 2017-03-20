package edu.self.scoredbmvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.self.scoredbmvvm.databinding.ActivitySearchScoreBinding;
import edu.self.scoredbmvvm.viewmodel.SearchViewModel;

/**
 * A login screen that offers login via email/password.
 */
public class SearchScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchScoreBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_search_score);
        binding.setViewModel(new SearchViewModel(this));
    }
}

