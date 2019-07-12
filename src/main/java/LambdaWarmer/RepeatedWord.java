package LambdaWarmer;

import java.util.Arrays;

public class RepeatedWord {

    public static String repeatedWord(String statement) {
        //all characters to lowercase
        String morphString = statement.toLowerCase();

        //eliminates all punctuation("apple..." then "apple."
        morphString = morphString.replaceAll("[^a-z ]","");

        //splits up string into individual array parts
        String[] splitString = morphString.split(" ");
        System.out.println(Arrays.toString(splitString));

        Hashtable wb = new Hashtable(statement.length());
        for (String string : splitString) {
            if (wb.contains(string)) {
                System.out.println("Match!");
                return string;
            } else {
                wb.add(string,"0");
                System.out.println(string);
            }
        }
        return "no repeats, nice vocabulary!";
    }
}
