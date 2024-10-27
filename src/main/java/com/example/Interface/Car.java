package Interface;

public class Car {
    private final int power;
    private final String model;
    private final int year;

    // Приватный конструктор для паттерна Builder
    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    // Статический класс Builder
    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car [Power=" + power + ", Model=" + model + ", Year=" + year + "]";
    }
}
