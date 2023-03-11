package tasks_week_1;

public class Car {
    private String brand;
    private String model;
    private int horsePower;
    private int year;

    public Car(String brand, String model, int horsePower, int year) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.year = year;
    }
    public  int insuranceCategory(){
        int age = java.time.Year.now().getValue() - year;
        if(age < 8){
            return 1;
        }else if(age < 16){
            return 2;
        }else if(age < 26) {
            return 3;
        }else {
            return 4;
        }
    }

    public  double insuranceValue() {
        int category = insuranceCategory();
        double baseValue = 0;
        switch (category) {
            case 1:
                baseValue = 150;
                break;
            case 2:
                baseValue = 200;
                break;
            case 3:
                baseValue = 300;
                break;
            case 4:
                baseValue = 500;
                break;
        }
        if(horsePower < 80) {
            baseValue *= 1.2;
        } else if(horsePower > 140) {
            baseValue *= 1.45;
        }
        return baseValue;
    }
}
