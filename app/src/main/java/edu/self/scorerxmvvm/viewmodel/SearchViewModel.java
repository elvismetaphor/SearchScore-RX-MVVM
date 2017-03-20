package edu.self.scorerxmvvm.viewmodel;

import edu.self.scorerxmvvm.model.SearchScoreManager;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class SearchViewModel {

    private BehaviorSubject<String> scoreValue;

    public SearchViewModel() {
        scoreValue = BehaviorSubject.create();
    }

    public void searchScore(final String userName) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Long score = getScoreManager().searchScoreForLongTime(userName);
                scoreValue.onNext(score == null ? "Not Exist!" : String.valueOf(score));
            }
        }).start();

    }

    public Observable<String> getScoreValueObservable() {
        return scoreValue;
    }

    protected SearchScoreManager getScoreManager() {
        return SearchScoreManager.getInstance();
    }
}
