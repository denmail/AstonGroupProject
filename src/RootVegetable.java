import java.util.*;

public class RootVegetable implements Comparable<RootVegetable> {
    private final rootVegetableType type;
    private final double weight;
    private final String color;

    private RootVegetable(RootVegetableBuilder rootVegetableBuilder) {
        this.type = rootVegetableBuilder.type;
        this.weight = rootVegetableBuilder.weight;
        this.color = rootVegetableBuilder.color;
    }

    public rootVegetableType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public static rootVegetableType getType(String type) {
        return switch (type.toUpperCase()) {
            case "ASTER" -> rootVegetableType.ASTER;
            case "CABBAGE" -> rootVegetableType.CABBAGE;
            case "GOOSEFOOT" -> rootVegetableType.GOOSEFOOT;
            case "UMBRELLA" -> rootVegetableType.UMBRELLA;
            default -> null;
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        RootVegetable otherObj = (RootVegetable) obj;
        return (Objects.equals(this.type, otherObj.type) && Objects.equals(this.weight, otherObj.weight)
                && Objects.equals(this.color, otherObj.color));
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
    }

    @Override
    public int compareTo(RootVegetable o) {
        if (!Objects.equals(this.type, o.type))
            return this.type.compareTo(o.type);
        else if (this.weight != o.weight)
            return (int) ((this.weight * 10) - (o.weight * 10));
        else
            return this.color.compareTo(o.color);
    }

    @Override
    public String toString() {
        return "Тип: " + type +
                ", Вес: " + ((weight > 0) ? weight : "не указан") +
                ", Цвет: " + ((color == null) ? "не указан" : color);
    }

    static class RootVegetableBuilder {
        private final rootVegetableType type;
        private double weight;
        private String color;

        RootVegetableBuilder(rootVegetableType type) {
            this.type = type;
        }

        public RootVegetableBuilder setWeight(double weight) {
            if (weight <= 0)
                System.out.println("Вес не может быть 0 гр. и менее");
            else
                this.weight =weight;
            return this;
        }

        public RootVegetableBuilder setColor(String color) {
            if (color.isEmpty())
                System.out.println("Вы не указали цвет корнеплода");
            else
                this.color = color;
            return this;
        }

        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }

    public static void main(String[] args) {
        RootVegetable rootVegetable = new RootVegetableBuilder(rootVegetableType.ASTER).setWeight(22)
                .setColor("Синий").build();
        RootVegetable rootVegetable1 = new RootVegetableBuilder(rootVegetableType.ASTER).setWeight(22)
                .setColor("").build();


        System.out.println(rootVegetable1);


        for (int i = 0; i < 100; i++)
            System.out.println((int)(Math.random() * 4));

        //System.out.println(rootVegetable.compareTo(rootVegetable1));
    }
}