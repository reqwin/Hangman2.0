import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class LoaderWord {

    private String fileName;
    private List<String> listWord;
    private InputStream inputStream;


    LoaderWord(String filename) {
        this.fileName = filename;
        inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        listWord = new BufferedReader(new InputStreamReader(inputStream)).lines().toList();
    }

    public String loadWord(int size) {
        List<String> list = listWord.stream().filter(x -> x.length()==size).toList();
        return list.get(new Random().nextInt(list.size())).toLowerCase();
    }

}