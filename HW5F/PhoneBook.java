import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создание телефонной книги
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавление записей в телефонную книгу
        addEntry(phoneBook, "Иванов", "1234567890");
        addEntry(phoneBook, "Петров", "9876543210");
        addEntry(phoneBook, "Васильев", "5555555555");
        addEntry(phoneBook, "Сидоров", "1111111111");
        addEntry(phoneBook, "Юров", "2222222222");

        
        printPhoneBook(phoneBook);
    }

    public static void addEntry(Map<String, List<String>> phoneBook, String name, String phone) {
        List<String> phones = phoneBook.getOrDefault(name, new ArrayList<>());
        phones.add(phone);
        phoneBook.put(name, phones);
    }

    public static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создание списка записей телефонной книги
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортировка списка по убыванию числа телефонов
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        // Вывод отсортированной телефонной книги
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }
}