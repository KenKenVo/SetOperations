import java.util.ArrayList;

public class TestStatsLibrary
{

    public static void main(String[] args){
        StatsLibrary test = new StatsLibrary();
        ArrayList<Integer> someNumbers = new ArrayList<>();
        someNumbers.add(1);
        someNumbers.add(2);
        someNumbers.add(3);
        someNumbers.add(4); // 1+2+3+4= 10/4 = expected result 2.5
        double result = test.mean(someNumbers);

        System.out.println("Average of input: " + result);
    }
}
