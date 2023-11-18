package search.searchstrategy;

import search.Data;

import java.util.*;

public class Any implements SearchStrategy {

    @Override
    public List<Integer> getRows(String searchQuery, Data data) {
        String[] tokens = searchQuery.split(" ");

        Set<Integer> rows = new HashSet<>();
        for (String token : tokens) {
            if (data.getInverted().containsKey(token.toLowerCase())) {
                rows.addAll(data.getInverted().get(token.toLowerCase()));
            }
        }

        return rows.stream().toList();
    }
}
