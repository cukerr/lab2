package ad221myroniuk;

class Item { // Класс "Товар"
    private String name; // Приватное поле с наименованием товара
    private float price; // Приватное поле с ценой товара

    public Item(String name, float price) { // Конструктор класса "Товар" с параметрами
        this.name = name; // Инициализация поля "name"
        if (price < 0) { // Проверка, если цена отрицательная
            this.price = 0; // Устанавливаем цену в 0
        } else {
            this.price = price; // Иначе устанавливаем переданную цену
        }
    }

    public void increasePrice(float percent) { // Метод для увеличения цены на определенный процент
        if (percent > 0) { // Проверка, если процент положительный
            price += price * percent / 100; // Увеличиваем цену на указанный процент
        }
    }

    public void decreasePrice(float percent) { // Метод для уменьшения цены на определенный процент
        if (percent > 0) { // Проверка, если процент положительный
            price -= price * percent / 100; // Уменьшаем цену на указанный процент
            if (price < 0) { // Проверка, если цена стала отрицательной
                price = 0; // Устанавливаем цену в 0
            }
        }
    }

    public float getPrice() { // Метод для получения текущей цены товара
        return price; // Возвращаем текущую цену
    }
}

class Cart { // Класс "Корзина"
    private Item[] stack; // Приватное поле для хранения товаров (реализация стека)
    private int top; // Приватное поле для указателя вершины стека
    private int maxSize; // Приватное поле для максимального количества элементов в стеке

    public Cart(int maxSize) { // Конструктор класса "Корзина" с параметром
        this.maxSize = maxSize; // Инициализация максимального размера корзины
        stack = new Item[maxSize]; // Создание массива для хранения товаров
        top = -1; // Установка указателя вершины стека в начальное положение (-1)
    }

    public void addItem(Item item) { // Метод для добавления товара в корзину
        if (top < maxSize - 1) { // Проверка, если корзина не переполнена
            stack[++top] = item; // Увеличиваем указатель вершины и добавляем товар
        } else {
            System.out.println("Корзина переполнена."); // Вывод сообщения о переполнении
        }
    }

    public Item removeItem() { // Метод для удаления товара из корзины
        if (top >= 0) { // Проверка, если в корзине есть товары
            return stack[top--]; // Удаляем товар и уменьшаем указатель вершины
        } else {
            System.out.println("Корзина пуста."); // Вывод сообщения о пустой корзине
            return null;
        }
    }

    public float calculateTotalPrice() { // Метод для вычисления суммы цен товаров в корзине
        float totalPrice = 0; // Инициализация общей суммы цен
        for (int i = 0; i <= top; i++) { // Перебор всех товаров в корзине
            totalPrice += stack[i].getPrice(); // Добавление цены товара к общей сумме
        }
        return totalPrice; // Возвращение общей суммы цен
    }

    public void increasePrices(float percent) { // Метод для увеличения цен всех товаров в корзине
        for (int i = 0; i <= top; i++) { // Перебор всех товаров в корзине
            stack[i].increasePrice(percent); // Увеличение цены товара на указанный процент
        }
    }

    public void decreasePrices(float percent) { // Метод для уменьшения цен всех товаров в корзине
        for (int i = 0; i <= top; i++) { // Перебор всех товаров в корзине
            stack[i].decreasePrice(percent); // Уменьшение цены товара на указанный процент
        }
    }
}

public class Main { // Основной класс программы
    public static void main(String[] args) { // Метод main, точка входа в программу
        Cart cart = new Cart(10); // Создание объекта класса "Корзина" с максимальным количеством элементов 10

        Item item1 = new Item("Товар 1", 100); // Создание объекта товара
        Item item2 = new Item("Товар 2", 50); // Создание объекта товара
        Item item3 = new Item("Товар 3", 75); // Создание объекта товара

        cart.addItem(item1); // Добавление товара в корзину
        cart.addItem(item2); // Добавление товара в корзину
        cart.addItem(item3); // Добавление товара в корзину

        System.out.println("Сумма цен в корзине: " + cart.calculateTotalPrice()); // Вывод суммы цен товаров в корзине

        cart.increasePrices(15); // Увеличение цен товаров на 15%
        System.out.println("Измененная сумма цен после повышения: " + cart.calculateTotalPrice()); // Вывод измененной суммы цен

        cart.decreasePrices(30); // Уменьшение цен товаров на 30%
        System.out.println("Измененная сумма цен после понижения: " + cart.calculateTotalPrice()); // Вывод измененной сумм
    }
}