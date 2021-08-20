package comparator;

import exception.MatcherException;

public class VarianceCalculator {
    public String getVariance(Double uiDataValue, Double apiDataValue, Double variance) throws MatcherException {

        if (Math.abs(uiDataValue-apiDataValue)<=variance){
            return "Metric Data Match";
        }
        else
            throw new MatcherException("Metrics Do not Match");
    }
}
