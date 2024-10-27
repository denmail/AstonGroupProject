package Interface;

public class RootVegetable {
    private final String type;
    private final double weight;
    private final String color;

    // Приватный конструктор для паттерна Builder
    private RootVegetable(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    // Статический класс Builder
    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }

    @Override
    public String toString() {
        return "RootVegetable [Type=" + type + ", Weight=" + weight + "kg, Color=" + color + "]";
    }
}
