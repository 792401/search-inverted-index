package search.searchstrategy;

import search.Data;

import java.util.List;
import java.util.Set;

public interface SearchStrategy {

    List<Integer> getRows(String searchQuery, Data data);

}
