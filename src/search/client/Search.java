package search.client;

import search.Data;
import search.searchstrategy.All;
import search.searchstrategy.Any;
import search.searchstrategy.None;
import search.searchstrategy.SearchStrategy;

import java.util.List;
import java.util.Scanner;

public class Search {
    SearchStrategy searchStrategy;

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void search(Data data) {
        Scanner s = new Scanner(System.in);
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategy = s.nextLine();

        System.out.println("Enter a name or email to search all suitable people.");
        String searchQuery = s.nextLine();

        if (strategy.equals("ALL")) {
            this.setSearchStrategy(new All());
        }
        if (strategy.equals("ANY")) {
            this.setSearchStrategy(new Any());
        }
        if (strategy.equals("NONE")) {
            this.setSearchStrategy(new None());
        }
        List<Integer> rows = this.searchStrategy.getRows(searchQuery, data);

        if (rows.size() > 0) {
            System.out.format("%s persons found:\n", rows.size());
            for (Integer row : rows) {
                System.out.println(data.getIndex().get(row));
            }
        } else {
            System.out.println("No matching people found.");
        }

    }


}
