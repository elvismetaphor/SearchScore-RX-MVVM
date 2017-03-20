package edu.self.scoredbmvvm.model;


import android.os.SystemClock;

import java.util.HashMap;
import java.util.Map;

public class SearchScoreManager {

    private static final Long WAITING_TIME = 2000L;
    private static final SearchScoreManager manager = new SearchScoreManager();

    private Map<String, Long> scores = new HashMap<>();

    public static SearchScoreManager getInstance() {
        return manager;
    }

    private SearchScoreManager() {
        scores.put("Allan", 100L);
        scores.put("Elvis", 1001L);
        scores.put("Mary", 90L);
        scores.put("Jennifer", 88L);
    }

    public Long searchScoreForLongTime(String name) {
        SystemClock.sleep(WAITING_TIME);
        return scores.get(name);
    }

}
