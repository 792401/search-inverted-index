package search.searchstrategy;

import search.Data;

import java.util.*;

public class All implements SearchStrategy {

    @Override
    public List<Integer> getRows(String searchQuery, Data data) {
        String[] tokens = searchQuery.split(" ");

        boolean hasAll = true;

        Map<String, List<Integer>> results = new HashMap<>();
        for (String token : tokens) {
            if (data.getInverted().containsKey(token.toLowerCase())) {
                results.put(token, data.getInverted().get(token.toLowerCase()));
            } else {
                hasAll = false;
                break;
            }
        }

        if (hasAll) {
            List<List<Integer>> l = new ArrayList<>(results.values());

            Set<Integer> rows = new HashSet<>(l.get(0));

            for(List<Integer> ls: l){
                rows.retainAll(ls);
            }
            return rows.stream().toList();



        }

        return new ArrayList<>();
    }
}
