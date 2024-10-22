import java.util.Objects;

public class Car implements Comparable<Car>{
    private final String model;
    private final int power;
    private final int year;

    private Car(CarBuilder carBuilder) {
        this.model = carBuilder.model;
        this.power = carBuilder.horsePower;
        this.year = carBuilder.yearProduction;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Car otherObj = (Car) obj;
        return (Objects.equals(this.model, otherObj.model) && Objects.equals(this.power, otherObj.power)
                && Objects.equals(this.year, otherObj.year));
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, power, year);
    }

    @Override
    public int compareTo(Car o) {
        if (!Objects.equals(this.model, o.model))
            return this.model.compareTo(o.model);
        else if (this.power != o.power)
            return this.power - o.power;
        else
            return this.year - o.year;
    }

    @Override
    public String toString() {
        return "Модель :" + model +
                ", Мощность: " + ((power > 0) ? power + " лс" : " не указано") +
                ", Год производства: " + ((year > 0) ? power : " не указан ");
    }

    static class CarBuilder {
        private final String model;
        private int horsePower;
        private int yearProduction;

        CarBuilder(String model) {
            this.model = model;
        }

        public CarBuilder setPower(int horsePower) {
            if (horsePower <= 0)
                System.out.println("Мощность должна быть положительным числом");
            else
                this.horsePower = horsePower;
            return this;
        }

        public CarBuilder setYear(int yearProduction) {
            if (yearProduction < 1885)
                System.out.println("Первый в мире автомобиль был изобретён в 1885 году");
            else if (yearProduction > 2024)
                System.out.println("Сейчас 2024й год, будущее еще не наступило");
            else
                this.yearProduction = yearProduction;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public static void main(String[] args) {
        Car car = new CarBuilder("BMW").setPower(150).setYear(2024).build();
        Car car2 = new CarBuilder("BMW").setPower(150).setYear(2023).build();

        System.out.println(car.compareTo(car2));
    }
}