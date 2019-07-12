
package LambdaWarmer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class LambdaFirstDuplicate {

    public String useFirstDuplicate(String input, Context c) {
        LambdaFirstDuplicate fd = new LambdaFirstDuplicate();
        String output = RepeatedWord.repeatedWord(input);
        LambdaLogger logger = c.getLogger();
        logger.log("First duplicate? " + output);

        return output;
    }
}
