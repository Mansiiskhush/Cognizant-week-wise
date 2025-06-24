public class Forecast {

    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double predictWithMemo(double currentValue, double growthRate, int years, double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = predictWithMemo(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;
        double growthRate = 0.10; 
        int years = 5;

        double futureValue = predictFutureValue(currentValue, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f\n", years, futureValue);
    }
}
