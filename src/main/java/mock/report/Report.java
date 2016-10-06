package mock.report;


import mock.domain.Human;
import mock.domain.Record;
import mock.main.DoseCalculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Report {
    private final static int DIGITS = 2;
    private Human fitData;
    private DoseCalculator dc;
    private final ReportLogic rl = new ReportLogic(DIGITS);

    public Report(Human fitData, DoseCalculator dc) {
        this.fitData = fitData;
        this.dc = dc;
    }

    public BigDecimal dayRestWater(LocalDate date) {
        return BigDecimal.valueOf(
                dc.getWater() - rl.getSum(fitData.getWater(), date));
    }

    public BigDecimal dayRestCalories(LocalDate date) {
        return BigDecimal.valueOf(
                dc.getCalories() - rl.getSum(fitData.getCalories(), date));
    }

    public BigDecimal dayRestSteps(LocalDate date) {
        return BigDecimal.valueOf(
                dc.getSteps() - rl.getSum(fitData.getSteps(), date));
    }

    public BigDecimal dayRestHours(LocalDate date) {
        return BigDecimal.valueOf(
                dc.getHours() - rl.getSum(fitData.getHours(), date));
    }



    public BigDecimal calcWaterConsumpPercent(LocalDate... date) {
        Integer dose = dc.getWater();
        List<Record<Integer>> list = fitData.getWater();
        return rl.calcConsumpPercentage(dose, list, date);
    }

    public BigDecimal calcWaterConsumpMedian(LocalDate... date) {
        return rl.getMedian(fitData.getWater(), date);
    }

    public BigDecimal calcFoodConsumpPercent(LocalDate... date) {
        Integer dose = dc.getCalories();
        List<Record<Integer>> list = fitData.getCalories();
        return rl.calcConsumpPercentage(dose, list, date);
    }

    public BigDecimal calcFoodConsumpMedian(LocalDate... date) {
        return rl.getMedian(fitData.getCalories(), date);
    }

    public BigDecimal calcStepsPercent(LocalDate... date) {
        Integer dose = dc.getSteps();
        List<Record<Integer>> list = fitData.getSteps();
        return rl.calcConsumpPercentage(dose, list, date);
    }

    public BigDecimal calcStepsMedian(LocalDate... date) {
        return rl.getMedian(fitData.getSteps(), date);
    }

    public BigDecimal calcHoursPercent(LocalDate... date) {
        Double dose = dc.getHours();
        List<Record<Double>> list = fitData.getHours();
        return rl.calcConsumpPercentage(dose, list, date);
    }

    public BigDecimal calcHoursMedian(LocalDate... date) {
        return rl.getMedian(fitData.getHours(), date);
    }

    public static int getDigits() {
        return DIGITS;
    }

    public ReportLogic getRl() {
        return rl;
    }
}
