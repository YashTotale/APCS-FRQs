package Y2015;

public class HiddenWord {
    private final String word;

    public HiddenWord(String word) {
        this.word = word;
    }

    public String getHint(String guess) {
        String hint = "";

        for (int i = 0; i < guess.length(); i++) {
            String guessedChar = guess.substring(i, i + 1);

            if (word.substring(i, i + 1).equals(guessedChar)) hint += guessedChar;
            else {
                int indexOfChar = word.indexOf(guessedChar);
                if (indexOfChar == -1) hint += "*";
                else hint += "+";
            }
        }

        return hint;
    }

    /**
     * Used for testing
     */
    public static void main(String[] args) throws Exception {
        HiddenWord puzzle = new HiddenWord("HARPS");

        boolean[] tests = {
                puzzle.getHint("AAAAA").equals("+A+++"),
                puzzle.getHint("HELLO").equals( "H****"),
                puzzle.getHint("HEART").equals("H*++*"),
                puzzle.getHint("HARMS").equals("HAR*S"),
                puzzle.getHint("HARPS").equals("HARPS")
        };

        for(int i = 0; i < tests.length; i++) {
            boolean works = tests[i];
            if(!works) {
                throw new Exception("Test #" + (i + 1) + " does not work!");
            }
        }
    }
}
