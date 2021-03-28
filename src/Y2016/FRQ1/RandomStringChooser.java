package Y2016.FRQ1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomStringChooser {
    private ArrayList<String> words;

    public RandomStringChooser(String[] words) {
        this.words = new ArrayList<>(Arrays.asList(words));
    }

    public String getNext() {
        if(words.size() > 0) {
            int index = (int) (Math.random() * words.size());
            return words.remove(index);
        }
        return "NONE";
    }

    public static void main(String[] args) throws Exception {
        String[] wordArray = {"wheels", "on", "the", "bus"};
        List<String> asList = Arrays.asList(wordArray);
        RandomStringChooser chooser = new RandomStringChooser(wordArray);

        for(int i = 0; i < wordArray.length; i ++) {
            String next = chooser.getNext();
            if(!asList.contains(next)) {
                throw new Exception("Method getNext does not work! Expected one of: " + asList + ", Actual: " + next);
            }
        }

        String next = chooser.getNext();
        if(!next.equals("NONE")) {
            throw new Exception("Method getNext does not work! Expected: NONE, Actual: " + next);
        }
    }
}
