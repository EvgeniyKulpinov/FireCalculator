import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int year = console.nextInt();
        fireCalculation(year);
    }

    public static void fireCalculation(int year) {
        double percent = 0.5;
        double percentageChange = 0.5;
        int startYear = 2002;
        int finalYear = 2021;

        if (year > finalYear | year < startYear) {
            System.err.println("Введите дату в диапазоне 2002-2021 включительно");
            return;
        }
        year = year - startYear;
        percent = calculationInterest(year, percent, percentageChange);
        outputResult(percent, percentageChange);
    }

    public static double calculationInterest(int year, double percent, double percentageChange) {
        double capital = 100;
        double expenses;
        double indexing;
        int zeroingTheCounter = 0;
        boolean positiveCapital = true;

        while (positiveCapital) {
            expenses = percent;
            while (year + 1 < Constants.MOEX_RATE.length) {
                capital = capital - expenses;
                indexing = (Constants.MOEX_RATE[year + 1]) / (Constants.MOEX_RATE[year]);
                capital = capital * indexing;
                expenses = expenses * (1 + (Constants.INFLATION_RATE[year]) / 100);
                year++;
                zeroingTheCounter++;
            }
            year = year - zeroingTheCounter;
            zeroingTheCounter = 0;
            percent = percent + percentageChange;
            if (capital < 0) {
                positiveCapital = false;
            }
            capital = 100;
        }
        return percent;
    }

    public static void outputResult(double percent, double percentageChange) {
        percent = percent - percentageChange - percentageChange;
        System.out.println(percent);
    }
}