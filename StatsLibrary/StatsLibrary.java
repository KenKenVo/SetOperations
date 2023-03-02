import java.awt.*;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

public class StatsLibrary
{
    public double mean(ArrayList<Integer> inputNumbers) {
        double sum = 0, result = 0;
        for (int singleElement : inputNumbers){
            sum = sum + singleElement;
        }

        result = sum / inputNumbers.size();
        return result;
    }

    public double med(ArrayList<Integer> inputNumbers)
    {
        double median = 0.0;
        Collections.sort(inputNumbers);
        int half = inputNumbers.size()/2;
        if( half % 2 != 0 )
        {
            median = inputNumbers.get(half/2);
            return median;
        }
        median = inputNumbers.get((half-1)/2) + inputNumbers.get(half)/ 2;
        return median;
    }

    public Double mode(ArrayList<Integer> inputNumbers)
    {
        int mode = 0, temp = 0;

        //hash map to keep track of counted numbers
        HashMap<Integer,Integer> count = new HashMap<>();
        for(Integer i : inputNumbers)
        {
            if(count.containsKey(i))
                count.put(i,count.get(i)+1);
            else
                count.put(i,1);
        }
        //set the starting comparison number
        //checks for the most repetitions of numbers
        temp = count.get(inputNumbers.get(0));
        for(Map.Entry<Integer,Integer> set : count.entrySet())
        {
            if(set.getValue() > temp )
            {
                temp = set.getValue();
                mode = set.getKey();
            }
        }
        //checks if there is more than 1 number with same amounts of repetitions
        for(Map.Entry<Integer,Integer>set : count.entrySet())
        {
            if(mode == set.getKey())
                continue;
            else if(set.getValue() == temp)
                mode = -1;
        }
        //-1 represents no mode found
        return (double)mode;
    }

    public double standardDeviation(ArrayList<Integer> inputNumbers)
    {
        double sum = 0, sd = 0, mean = 0;
        for(double i : inputNumbers)
        {
            sum += i;
        }
        mean = sum/inputNumbers.size();
        for(double i : inputNumbers)
        {
            sd += Math.pow(i-mean,2);
        }
        return Math.sqrt(sd/inputNumbers.size());
    }

    public void combination(ArrayList<Integer> inputNumbers, int r)
    {

        BigInteger x = BigInteger.valueOf(r);
        BigInteger n = BigInteger.valueOf(inputNumbers.size());
        BigInteger factorialn = factorialCalc(n);
        BigInteger factorialnr = factorialCalc(n.subtract(x));
        BigInteger factorialr = factorialCalc(x);
        BigInteger combonationResult= factorialn.divide(factorialr.multiply(factorialnr));
        System.out.println("Possible Combinations: " + combonationResult);
    }
    public BigInteger combination(double inputNumbers, double r)
    {

        BigInteger x = BigInteger.valueOf((long)r);
        BigInteger n = BigInteger.valueOf((long)inputNumbers);
        BigInteger factorialn = factorialCalc(n);
        BigInteger factorialnr = factorialCalc(n.subtract(x));
        BigInteger factorialr = factorialCalc(x);
        BigInteger combinationResult= factorialn.divide(factorialr.multiply(factorialnr));
        //System.out.println("Possible Combinations: " + combinationResult);
        return combinationResult;
    }

    public void permutation(ArrayList<Integer> inputNumbers , int r)
    {
        BigInteger x = BigInteger.valueOf(r);
        BigInteger n = BigInteger.valueOf(inputNumbers.size());
        BigInteger factorialn = factorialCalc(n);
        BigInteger factorialnr = factorialCalc(n.subtract(x));
        BigInteger permutaionResult = factorialn.divide(factorialnr);
        System.out.println("Possible Permutations: " + permutaionResult);
    }
    public BigInteger factorialCalc(BigInteger n)
    {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else {
            return (n.multiply(factorialCalc((n.subtract(BigInteger.valueOf(1))))));
        }
    }


    public void union(ArrayList<Integer> listA, ArrayList<Integer> listB)
    {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(listA);
        set.addAll(listB);
        System.out.println("Union of set A and B :" +set);
    }

    public void Intersection(ArrayList<Integer> listA, ArrayList<Integer> listB)
    {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(listA);
        set.retainAll(listB);
        System.out.println("Intersection of set A and B :" +set);
    }

    public void complement(ArrayList<Integer> listA, ArrayList<Integer> listB)
    {
        HashSet<Integer> set = new HashSet<>();
        set.addAll(listB);
        set.removeAll(listA);
        System.out.println("Complement of set A and B :" +set);
    }

    public void binomialDistribution(double success, double trials, double probability)
    {
        BigInteger comb = combination(trials,success);
        double pX =Math.pow(probability,success);
        double pNX = Math.pow((1-probability),(trials-success));
        double combpx = comb.intValue()*pX;
        double combpXpNX = combpx*pNX;
        System.out.println("Binomial Distribution : " + combpXpNX);
    }
    public void geometricDistributionPMF(double probability,double trials) //distribution of discrete random variable
    {
        double qXp =  Math.pow((1-probability),(trials-1))*probability;
        System.out.println("Geometric DistributionPMF : " + qXp);
    }

    public void geometricDistributionCDF(double probability, double trials) //distribution of random variable
    {
        double pX = 1-(Math.pow((1-probability),trials));
        System.out.println("Geometric DistributionCDF : " + pX);
    }
}
