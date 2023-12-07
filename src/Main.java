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
        double indexing;
        double percent = 0;   // Процент изъятия
        int i = 1;
        int s = 0;            // Обнулятор счетчика
        while (i > 0) {
            while (yaer + 1 < Constants.MOEX_RATE.length) {
                double index1 = (Constants.MOEX_RATE[yaer]);       // Индекс за текущий год
                double index2 = (Constants.MOEX_RATE[yaer + 1]);   // Индекс за следующий год
                double inflation = (Constants.INFLATION_RATE[yaer]);
                capital = capital - percent;
                indexing = index2 / index1;                        // Изменение индекса в процентах
                capital = capital * indexing;
                capital = capital * (1 - inflation / 100);
                yaer++;
                s++;
            }
            yaer = yaer - s;
            s = 0;
            percent = percent + 0.5;
            if (capital <= 0) {
                i = -1;
            }
            capital = 100;
        }
        percent = percent - 0.5;
        System.out.println(percent);
    }
}