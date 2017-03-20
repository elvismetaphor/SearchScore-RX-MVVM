package edu.self.scoredbmvvm.viewmodel;


import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;

import edu.self.scoredbmvvm.model.SearchScoreManager;

public class SearchViewModel extends BaseObservable{

    public  ObservableField<String> userScore = new ObservableField<>();

    private Context context;
    private ProgressDialog progressDialog;

    private String userName;

    public SearchViewModel(Context context) {
        this.context = context;
    }

    public void searchScore() {
        new AsyncTask<String, Void, Long>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(context, "Search the score", "searching...", true);
            }

            @Override
            protected Long doInBackground(String... strings) {
                return SearchScoreManager.getInstance().searchScoreForLongTime(strings[0]);
            }

            @Override
            protected void onPostExecute(Long score) {
                super.onPostExecute(score);
                progressDialog.dismiss();
                userScore.set(score == null ? "not exist" : score.toString());
            }

        }.execute(userName);

    }

    public TextWatcher getUserNameEditTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                userName = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };
    }

}
