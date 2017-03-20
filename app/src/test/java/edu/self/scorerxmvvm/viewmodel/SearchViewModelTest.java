package edu.self.scorerxmvvm.viewmodel;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import edu.self.scorerxmvvm.model.SearchScoreManager;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by elvislin on 20/03/2017.
 */

public class SearchViewModelTest extends SearchViewModel {

    class TestableSearchViewModel extends SearchViewModel {

        @Override
        protected SearchScoreManager getScoreManager() {
            SearchScoreManager manager = Mockito.mock(SearchScoreManager.class);
            Mockito.when(manager.searchScoreForLongTime("one")).thenReturn(100L);
            return  manager;
        }
    }

    @Test
    public void testSearchScore() {
        SearchViewModel testee = new TestableSearchViewModel();

        testee.getScoreValueObservable().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {}

            @Override
            public void onNext(String value) {
                Assert.assertEquals("100", value);
            }

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onComplete() {}
        });

        testee.searchScore("one");
    }


}
