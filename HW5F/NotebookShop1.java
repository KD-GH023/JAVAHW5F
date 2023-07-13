 import java.util.*;
 
public class NotebookShop1 {
       
        public static void main(String[] args) {
            // Создание множества ноутбуков
            Set<Notebook> notebooks = createNotebooks();
    
            // Фильтрация и вывод ноутбуков
            filterNotebooks(notebooks);
        }
    
        public static Set<Notebook> createNotebooks() {
            Set<Notebook> notebooks = new HashSet<>();
    
            // Добавление ноутбуков 
            notebooks.add(new Notebook("HP", 8, 500, "Windows", "Серый"));
            notebooks.add(new Notebook("Dell", 16, 1000, "Windows", "Черный"));
            notebooks.add(new Notebook("Lenovo", 8, 256, "Linux", "Синий"));
            notebooks.add(new Notebook("Apple", 16, 512, "MacOS", "Серебристый"));
            notebooks.add(new Notebook("Acer", 4, 128, "Windows", "Белый"));
    
            return notebooks;
        }
    
        public static void filterNotebooks(Set<Notebook> notebooks) {
            // Запрос критериев фильтрации 
            Map<Integer, String> criteria = new HashMap<>();
            criteria.put(1, "ОЗУ");
            criteria.put(2, "Объем ЖД");
            criteria.put(3, "Операционная система");
            criteria.put(4, "Цвет");
    
            Scanner scanner = new Scanner(System.in);
            Map<String, Object> filterParams = new HashMap<>();
    
            System.out.println("Выберите критерий фильтрации:");
            for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
    
            int filterChoice = scanner.nextInt();
            scanner.nextLine();
    
            // Запрос минимальных значений для выбранного критерия
            String selectedCriterion = criteria.get(filterChoice);
            System.out.println("Введите минимальное значение для " + selectedCriterion + ":");
            Object minValue = scanner.nextLine();
            filterParams.put(selectedCriterion, minValue);
    
            // Фильтрация ноутбуков и вывод результатов
            Set<Notebook> filteredNotebooks = new HashSet<>();
            for (Notebook notebook : notebooks) {
                boolean passFilter = true;
                for (Map.Entry<String, Object> entry : filterParams.entrySet()) {
                    String criterion = entry.getKey();
                    Object value = entry.getValue();
    
                    switch (criterion) {
                        case "ОЗУ":
                            if (notebook.getRam() < (int) value) {
                                passFilter = false;
                            }
                            break;
                        case "Объем ЖД":
                            if (notebook.getHdd() < (int) value) {
                                passFilter = false;
                            }
                            break;
                        case "Операционная система":
                            if (!notebook.getOs().equals(value)) {
                                passFilter = false;
                            }
                            break;
                        case "Цвет":
                            if (!notebook.getColor().equals(value)) {
                                passFilter = false;
                            }
                            break;
                    }
                }
    
                if (passFilter) {
                    filteredNotebooks.add(notebook);
                }
            }
    
            System.out.println("Результаты фильтрации:");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook);
            }
        }
    }
    
    class Notebook {
        private String brand;
        private int ram;
        private int hdd;
        private String os;
        private String color;
    
        public Notebook(String brand, int ram, int hdd, String os, String color) {
            this.brand = brand;
            this.ram = ram;
            this.hdd = hdd;
            this.os = os;
            this.color = color;
        }
    
        public String getBrand() {
            return brand;
        }
    
        public int getRam() {
            return ram;
        }
    
        public int getHdd() {
            return hdd;
        }
    
        public String getOs() {
            return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

