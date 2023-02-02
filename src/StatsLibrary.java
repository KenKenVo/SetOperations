import java.util.ArrayList;

public class StatsLibrary
{
    public double mean(ArrayList<Integer> inputNumbers) {
        double sum = 0;
        for (int singleElement : inputNumbers){
            sum = sum + singleElement;
        }

        double result = sum / inputNumbers.size();

        return result;
    }
}
