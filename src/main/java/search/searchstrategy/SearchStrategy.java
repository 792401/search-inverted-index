package search.searchstrategy;

import search.Data;

import java.util.List;

public interface SearchStrategy {

    List<Integer> getRows(String searchQuery, Data data);

}
