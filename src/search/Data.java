package search;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Data {

    public List<String> getIndex() {
        return index;
    }

    public void setIndex(List<String> index) {
        this.index = index;
    }

    public Map<String, List<Integer>> getInverted() {
        return inverted;
    }

    public void setInverted(Map<String, List<Integer>> inverted) {
        this.inverted = inverted;
    }

    private List<String> index = new ArrayList<>();
    private Map<String, List<Integer>> inverted = new HashMap<>();

    public void addAllToIndex(List<String> allLines){
        index.addAll(allLines);
    }

    public void loadDataFromFile(String[] args) {
//        String fileName = "E:\\Projects\\Simple Search Engine (Java)1\\Simple Search Engine (Java)\\task\\src\\search\\text.txt";
        String fileName = args[1];
        Path path = Paths.get(fileName);
        try {
            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            this.index.addAll(allLines);

            for (int i = 0; i < allLines.size(); i++) {
                List<String> tokens = Arrays.stream(allLines.get(i).split(" ")).toList();

                for (int j = 0; j < tokens.size(); j++) {
                    String token = tokens.get(j).toLowerCase();

                    if (inverted.containsKey(token)) {
                        inverted.get(token).add(i);
                    } else {
                        inverted.put(tokens.get(j).toLowerCase(), new ArrayList<>(List.of(i)));
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
