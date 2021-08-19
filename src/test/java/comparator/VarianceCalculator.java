package comparator;

import exception.MatcherException;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class VarianceCalculator {
    public String getVariance(Double val1, Double val2, Double variance) throws IOException, ParseException, MatcherException {

        if (Math.abs(val1-val2)<=variance){
            return "Metric Data Match";
        }
        else
            throw new MatcherException("Metrics Do not Match");
    }
}
