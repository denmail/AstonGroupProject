package Interface;
// Заглушка для SortManager
public class SortManager {
    public void setDataType(Class<?> dataType) {
        System.out.println("Тип данных установлен: " + dataType.getSimpleName());
    }

    public void setArrayLength(int length) {
        System.out.println("Длина массива установлена: " + length);
    }

    public void fillDataManually() {
        System.out.println("Данные введены вручную.");
    }

    public void fillDataFromFile() {
        System.out.println("Данные загружены из файла.");
    }

    public void fillDataRandomly() {
        System.out.println("Данные заполнены случайным образом.");
    }

    public void sortData() {
        System.out.println("Массив отсортирован.");
    }
}