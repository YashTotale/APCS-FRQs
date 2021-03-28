package Y2016.FRQ1;

public class RandomLetterChooser extends RandomStringChooser {
    public RandomLetterChooser(String str) {
        super(getSingleLetters(str));
    }

    public static String[] getSingleLetters(String str) {
        return str.split("");
    }

    public static void main(String[] args) throws Exception {
        String str = "cat";
        RandomLetterChooser chooser = new RandomLetterChooser(str);

        for(int i = 0; i < str.length(); i ++) {
            String next = chooser.getNext();
            if(!str.contains(next)) {
                throw new Exception("Method getNext does not work! Expected one of: " + str + ", Actual: " + next);
            }
        }

        String next = chooser.getNext();
        if(!next.equals("NONE")) {
            throw new Exception("Method getNext does not work! Expected: NONE, Actual: " + next);
        }
    }
}
