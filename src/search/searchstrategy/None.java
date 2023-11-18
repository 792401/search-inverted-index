package search.searchstrategy;

import search.Data;

import java.util.*;

public class None implements SearchStrategy {
    @Override
    public List<Integer> getRows(String searchQuery, Data data) {
        String[] tokens = searchQuery.split(" ");

        Set<Integer> rows = new HashSet<>();
        for (String token : tokens) {
            if (data.getInverted().containsKey(token.toLowerCase())) {
                rows.addAll(data.getInverted().get(token.toLowerCase()));
            }
        }


        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < data.getIndex().size(); i++) {
            if (!rows.contains(i)) {
                results.add(i);
            }
        }


        return results;
    }
}
