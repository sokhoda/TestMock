package mock.main;

public class DoseCalculator {
    private int height;
    private int age;
    private int sex;
    private Integer water;
    private Integer calories;
    private Double hours;
    private Integer steps;

    public DoseCalculator() {
       calcDose();
    }

    public DoseCalculator(int height, int age, int sex) {
        this.height = height;
        this.age = age;
        this.sex = sex;
        calcDose();
    }

    private void calcDose() {
        water = 3000;
        calories = 2500;
        hours = 2.;
        steps = 2000;
    }

    public Integer getWater(){
        return water;
    }

    public Integer getCalories() {
        return calories;
    }

    public Double getHours() {
        return hours;
    }

    public Integer getSteps() {
        return steps;
    }
}
