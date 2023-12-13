import java.util.Scanner;

public class FireCalculator {

    public static void main(String[] args) throws Exception {
        calculation();
    }

    public static void calculation() throws Exception {
        int year = inputData();
        checkingData(year);
        double percent = calculationPercent(year);
        outputResult(percent);
    }

    public static int inputData() {
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }

    public static void checkingData(int year) throws Exception {
        if (year > Constants.FINAL_YEAR | year < Constants.START_YEAR) {
            throw new Exception("Введите дату в диапазоне 2002-2021 включительно");
        }
    }

    public static double calculationPercent(int year) {
        double percent = 0.5;
        double capital = 100;
        boolean positiveCapital = true;
        year = year - Constants.START_YEAR;
        while (positiveCapital) {
            capital = calculatingCapital(year, percent, capital);
            percent = percent + Constants.PERCENTAGE_CHANGE;
            if (capital < 0) {
                positiveCapital = false;
            }
            capital = 100;
        }
        return percent - Constants.PERCENTAGE_CHANGE - Constants.PERCENTAGE_CHANGE;
    }

    public static double calculatingCapital(int year, double percent, double capital) {
        double indexing;
        while (year + 1 < Constants.MOEX_RATE.length) {
            capital = capital - percent;
            indexing = (Constants.MOEX_RATE[year + 1]) / (Constants.MOEX_RATE[year]);
            capital = capital * indexing;
            percent = percent * (1 + (Constants.INFLATION_RATE[year]) / 100);
            year++;
        }
        return capital;
    }

    public static void outputResult(double percent) {
        System.out.println(percent);
    }

}
