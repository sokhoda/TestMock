package mock.domain;


import mock.main.DoseCalculator;
import mock.report.Report;
import mock.report.ReportLogic;
import org.omg.PortableInterceptor.ServerRequestInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private final LocalDate now = LocalDate.now();
    private final List<Record<Integer>> water = new ArrayList<>();
    private final List<Record<Integer>> calories = new ArrayList<>();
    private final List<Record<Double>> hours = new ArrayList<>();
    private final List<Record<Integer>> steps = new ArrayList<>();
    private final ReportLogic rl = new ReportLogic(Report.getDigits());
    private DoseCalculator dc;

    public Human() {
        init();
        dc = new DoseCalculator();
    }

    public int gettAgeOfMe(int a){
        return a + 1;
    }

    private void init() {
        water.add(new Record<>(LocalDate.MIN, 0));
        calories.add(new Record<>(LocalDate.MIN, 0));
        hours.add(new Record<>(LocalDate.MIN, 0.));
        steps.add(new Record<>(LocalDate.MIN, 0));
    }

    public void drink(LocalDate date, int volume) {
        water.add(new Record<Integer>(date, volume));
    }

    public void eat(LocalDate date, int volume) {
        calories.add(new Record<Integer>(date, volume));
    }

    public void move(LocalDate date, double hours, int steps) {
        this.hours.add(new Record<Double>(date, hours));
        this.steps.add(new Record<Integer>(date, steps));
    }


    public boolean dayZeroWater(LocalDate date) {
        return (Integer.valueOf(0)).equals(rl.getSum(water, date));
    }

    public boolean dayZeroSteps(LocalDate date) {
        return (Integer.valueOf(0)).equals(rl.getSum(steps, date));
    }

    public boolean dayZeroHours(LocalDate date) {
        return (Double.valueOf(0)).equals(rl.getSum(hours, date));
    }

    public boolean dayZeroCalories(LocalDate date) {
        return (Integer.valueOf(0)).equals(rl.getSum(calories, date));
    }

    public boolean dayTooMuchWater(LocalDate date) {
        return (rl.getSum(water, date) - dc.getWater()) > 0;
    }

    public boolean dayTooMuchCalories(LocalDate date) {
        return (rl.getSum(calories, date) - dc.getCalories()) > 0;
    }

    public boolean dayTooMuchSteps(LocalDate date) {
        return (rl.getSum(steps, date) - dc.getSteps()) > 0;
    }

    public boolean dayTooMuchHours(LocalDate date) {
        return (rl.getSum(hours, date) - dc.getHours()) > 0;
    }

    public boolean surnameContainsName(String name, String surname){
        if (surname != null && name != null){
            return surname.matches(".*" + name + ".*");
        }
        return false;
    }

    public List<Record<Integer>> getWater() {
        return water;
    }

    public List<Record<Integer>> getCalories() {
        return calories;
    }

    public List<Record<Double>> getHours() {
        return hours;
    }

    public List<Record<Integer>> getSteps() {
        return steps;
    }

}
