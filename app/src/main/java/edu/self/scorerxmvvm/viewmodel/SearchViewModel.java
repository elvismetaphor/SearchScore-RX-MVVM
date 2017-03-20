package edu.self.scorerxmvvm.viewmodel;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import edu.self.scorerxmvvm.model.SearchScoreManager;

public class SearchViewModel {

    private Context context;
    private ProgressDialog progressDialog;

    public SearchViewModel(Context context) {
        this.context = context;
    }

    public void searchScore(String userName) {
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
            }

        }.execute(userName);

    }
}
