import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int yaer = console.nextInt();
        if (yaer > 2021 | yaer < 2002) {
            System.err.println("Введите дату в диапазоне 2002-2021 включительно");
            return;
        }
        yaer = yaer - 2002;   // Это чтобы считывать массив с 0
        double capital = 100;
        double indexing;      // Изменение индекса в процентах
        double percent = 0.5;   // Процент изъятия
        int i = 1;
        int s = 0;            // Обнулятор счетчика
        while (i > 0) {
            double expenses = percent;                             // Расход
            while (yaer + 1 < Constants.MOEX_RATE.length) {
                double index1 = (Constants.MOEX_RATE[yaer]);       // Индекс за текущий год
                double index2 = (Constants.MOEX_RATE[yaer + 1]);   // Индекс за следующий год
                double inflation = (Constants.INFLATION_RATE[yaer]);
                capital = capital - expenses;
                indexing = index2 / index1;
                capital = capital * indexing;
                expenses = expenses * (1 + inflation / 100);       // Увеличение расхода инфляцией
                yaer++;
                s++;
            }
            yaer = yaer - s;
            s = 0;
            percent = percent + 0.5;
            if (capital < 0) {
                i = -1;
            }
            capital = 100;
        }
        percent = percent - 1;
        System.out.println(percent);
    }
}