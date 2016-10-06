package mock.testdatasource;

import mock.domain.Human;

import java.time.LocalDate;

public class TestDataSource {
    private static Human fitnessData;

    public static void init(Human fit) {
        if (fit != null) {
            TestDataSource.fitnessData = fit;
            waterDataInit();
            stepsHoursDataInit();
            caloriesDataInit();
        }
    }

    public static void waterDataInit() {
        fitnessData.drink(LocalDate.of(2016, 11, 16), 100);
        fitnessData.drink(LocalDate.of(2016, 11, 16), 1000);
        fitnessData.drink(LocalDate.of(2016, 11, 16), 500);
        fitnessData.drink(LocalDate.of(2016, 11, 16), 700);
        fitnessData.drink(LocalDate.of(2016, 11, 16), 100);

        fitnessData.drink(LocalDate.of(2016, 11, 17), 1000);
        fitnessData.drink(LocalDate.of(2016, 11, 17), 50);
        fitnessData.drink(LocalDate.of(2016, 11, 17), 500);
        fitnessData.drink(LocalDate.of(2016, 11, 17), 250);

        fitnessData.drink(LocalDate.of(2016, 11, 18), 1000);
        fitnessData.drink(LocalDate.of(2016, 11, 18), 50);
        fitnessData.drink(LocalDate.of(2016, 11, 18), 500);
        fitnessData.drink(LocalDate.of(2016, 11, 18), 250);
        fitnessData.drink(LocalDate.of(2016, 11, 18), 250);
        fitnessData.drink(LocalDate.of(2016, 11, 18), 250);

        fitnessData.drink(LocalDate.of(2016, 11, 19), 100);
        fitnessData.drink(LocalDate.of(2016, 11, 19), 150);
        fitnessData.drink(LocalDate.of(2016, 11, 19), 500);
        fitnessData.drink(LocalDate.of(2016, 11, 19), 150);
        fitnessData.drink(LocalDate.of(2016, 11, 19), 250);
        fitnessData.drink(LocalDate.of(2016, 11, 19), 510);
        fitnessData.drink(LocalDate.of(2016, 11, 19), 1000);

        fitnessData.drink(LocalDate.of(2016, 11, 20), 1000);
        fitnessData.drink(LocalDate.of(2016, 11, 20), 150);
        fitnessData.drink(LocalDate.of(2016, 11, 20), 200);
        fitnessData.drink(LocalDate.of(2016, 11, 20), 250);
        fitnessData.drink(LocalDate.of(2016, 11, 20), 1800);
        fitnessData.drink(LocalDate.of(2016, 11, 20), 250);

        fitnessData.drink(LocalDate.of(2016, 11, 21), 1000);
        fitnessData.drink(LocalDate.of(2016, 11, 21), 550);
        fitnessData.drink(LocalDate.of(2016, 11, 21), 600);
        fitnessData.drink(LocalDate.of(2016, 11, 21), 250);
        fitnessData.drink(LocalDate.of(2016, 11, 21), 700);
        fitnessData.drink(LocalDate.of(2016, 11, 21), 250);

        fitnessData.drink(LocalDate.of(2016, 11, 22), 350);
        fitnessData.drink(LocalDate.of(2016, 11, 22), 600);
        fitnessData.drink(LocalDate.of(2016, 11, 22), 1100);
        fitnessData.drink(LocalDate.of(2016, 11, 22), 150);
        fitnessData.drink(LocalDate.of(2016, 11, 22), 400);
        fitnessData.drink(LocalDate.of(2016, 11, 22), 250);

        fitnessData.drink(LocalDate.of(2016, 11, 23), 1350);
        fitnessData.drink(LocalDate.of(2016, 11, 23), 200);
        fitnessData.drink(LocalDate.of(2016, 11, 23), 100);
        fitnessData.drink(LocalDate.of(2016, 11, 23), 150);
        fitnessData.drink(LocalDate.of(2016, 11, 23), 1400);
        fitnessData.drink(LocalDate.of(2016, 11, 23), 250);
    }

    public static void stepsHoursDataInit() {
        fitnessData.move(LocalDate.of(2016, 11, 16), 0.1, 100);
        fitnessData.move(LocalDate.of(2016, 11, 16), 0.4, 1000);
        fitnessData.move(LocalDate.of(2016, 11, 16), 0.5, 500);
        fitnessData.move(LocalDate.of(2016, 11, 16), 0.8, 700);
        fitnessData.move(LocalDate.of(2016, 11, 16), 0.9, 100);

        fitnessData.move(LocalDate.of(2016, 11, 17), 0.4, 100);
        fitnessData.move(LocalDate.of(2016, 11, 17), 0.7, 50);
        fitnessData.move(LocalDate.of(2016, 11, 17), 1.1, 500);
        fitnessData.move(LocalDate.of(2016, 11, 17), 0.1, 250);

        fitnessData.move(LocalDate.of(2016, 11, 18), 0.7, 100);
        fitnessData.move(LocalDate.of(2016, 11, 18), 0.1, 50);
        fitnessData.move(LocalDate.of(2016, 11, 18), 0.7, 150);
        fitnessData.move(LocalDate.of(2016, 11, 18), 0.1, 250);
        fitnessData.move(LocalDate.of(2016, 11, 18), 0.1, 250);
        fitnessData.move(LocalDate.of(2016, 11, 18), 0.3, 250);

        fitnessData.move(LocalDate.of(2016, 11, 19), 0.1, 100);
        fitnessData.move(LocalDate.of(2016, 11, 19), 0.3, 150);
        fitnessData.move(LocalDate.of(2016, 11, 19), 0.1, 500);
        fitnessData.move(LocalDate.of(2016, 11, 19), 0.7, 150);
        fitnessData.move(LocalDate.of(2016, 11, 19), 1.0, 250);
        fitnessData.move(LocalDate.of(2016, 11, 19), 0.1, 510);
        fitnessData.move(LocalDate.of(2016, 11, 19), 0.5, 1000);

        fitnessData.move(LocalDate.of(2016, 11, 20), 0.9, 1000);
        fitnessData.move(LocalDate.of(2016, 11, 20), 0.9, 150);
        fitnessData.move(LocalDate.of(2016, 11, 20), 0.1, 200);
        fitnessData.move(LocalDate.of(2016, 11, 20), 0.1, 250);
        fitnessData.move(LocalDate.of(2016, 11, 20), 1.1, 1800);
        fitnessData.move(LocalDate.of(2016, 11, 20), 0.1, 250);

        fitnessData.move(LocalDate.of(2016, 11, 21), 0.1, 1000);
        fitnessData.move(LocalDate.of(2016, 11, 21), 0.2, 550);
        fitnessData.move(LocalDate.of(2016, 11, 21), 0.5, 600);
        fitnessData.move(LocalDate.of(2016, 11, 21), 0.6, 250);
        fitnessData.move(LocalDate.of(2016, 11, 21), 0.1, 700);
        fitnessData.move(LocalDate.of(2016, 11, 21), 0.1, 250);

        fitnessData.move(LocalDate.of(2016, 11, 22), 0.1, 350);
        fitnessData.move(LocalDate.of(2016, 11, 22), 0.8, 600);
        fitnessData.move(LocalDate.of(2016, 11, 22), 0.1, 1100);
        fitnessData.move(LocalDate.of(2016, 11, 22), 0.7, 150);
        fitnessData.move(LocalDate.of(2016, 11, 22), 0.2, 400);
        fitnessData.move(LocalDate.of(2016, 11, 22), 0.1, 250);

        fitnessData.move(LocalDate.of(2016, 11, 23), 0.1, 1350);
        fitnessData.move(LocalDate.of(2016, 11, 23), 0.6, 200);
        fitnessData.move(LocalDate.of(2016, 11, 23), 0.1, 100);
        fitnessData.move(LocalDate.of(2016, 11, 23), 0.5, 150);
        fitnessData.move(LocalDate.of(2016, 11, 23), 0.4, 1400);
        fitnessData.move(LocalDate.of(2016, 11, 23), 0.2, 250);
    }

    public static void caloriesDataInit() {
        fitnessData.eat(LocalDate.of(2016, 11, 16), 100);
        fitnessData.eat(LocalDate.of(2016, 11, 16), 100);
        fitnessData.eat(LocalDate.of(2016, 11, 16), 500);
        fitnessData.eat(LocalDate.of(2016, 11, 16), 700);
        fitnessData.eat(LocalDate.of(2016, 11, 16), 100);

        fitnessData.eat(LocalDate.of(2016, 11, 17), 100);
        fitnessData.eat(LocalDate.of(2016, 11, 17), 50);
        fitnessData.eat(LocalDate.of(2016, 11, 17), 500);
        fitnessData.eat(LocalDate.of(2016, 11, 17), 250);

        fitnessData.eat(LocalDate.of(2016, 11, 18), 100);
        fitnessData.eat(LocalDate.of(2016, 11, 18), 50);
        fitnessData.eat(LocalDate.of(2016, 11, 18), 150);
        fitnessData.eat(LocalDate.of(2016, 11, 18), 1250);
        fitnessData.eat(LocalDate.of(2016, 11, 18), 250);
        fitnessData.eat(LocalDate.of(2016, 11, 18), 250);

        fitnessData.eat(LocalDate.of(2016, 11, 19), 1000);
        fitnessData.eat(LocalDate.of(2016, 11, 19), 150);
        fitnessData.eat(LocalDate.of(2016, 11, 19), 500);
        fitnessData.eat(LocalDate.of(2016, 11, 19), 150);
        fitnessData.eat(LocalDate.of(2016, 11, 19), 250);
        fitnessData.eat(LocalDate.of(2016, 11, 19), 510);
        fitnessData.eat(LocalDate.of(2016, 11, 19), 1000);

        fitnessData.eat(LocalDate.of(2016, 11, 20), 100);
        fitnessData.eat(LocalDate.of(2016, 11, 20), 150);
        fitnessData.eat(LocalDate.of(2016, 11, 20), 200);
        fitnessData.eat(LocalDate.of(2016, 11, 20), 250);
        fitnessData.eat(LocalDate.of(2016, 11, 20), 1800);
        fitnessData.eat(LocalDate.of(2016, 11, 20), 250);

        fitnessData.eat(LocalDate.of(2016, 11, 21), 300);
        fitnessData.eat(LocalDate.of(2016, 11, 21), 550);
        fitnessData.eat(LocalDate.of(2016, 11, 21), 600);
        fitnessData.eat(LocalDate.of(2016, 11, 21), 250);
        fitnessData.eat(LocalDate.of(2016, 11, 21), 700);
        fitnessData.eat(LocalDate.of(2016, 11, 21), 250);

        fitnessData.eat(LocalDate.of(2016, 11, 22), 350);
        fitnessData.eat(LocalDate.of(2016, 11, 22), 600);
        fitnessData.eat(LocalDate.of(2016, 11, 22), 1100);
        fitnessData.eat(LocalDate.of(2016, 11, 22), 150);
        fitnessData.eat(LocalDate.of(2016, 11, 22), 400);
        fitnessData.eat(LocalDate.of(2016, 11, 22), 250);

        fitnessData.eat(LocalDate.of(2016, 11, 23), 1350);
        fitnessData.eat(LocalDate.of(2016, 11, 23), 200);
        fitnessData.eat(LocalDate.of(2016, 11, 23), 100);
        fitnessData.eat(LocalDate.of(2016, 11, 23), 150);
        fitnessData.eat(LocalDate.of(2016, 11, 23), 1400);
        fitnessData.eat(LocalDate.of(2016, 11, 23), 250);
    }
}