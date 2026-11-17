public class Task3 {
    public static void main(String[] args) {
        String[] commaAddresses = {
                "Россия, Московская область, Москва, Тверская, 12, 1, 45",
                "Беларусь, Минская область, Минск, Независимости, 10, 2, 15"
        };

        System.out.println("Разбор с помощью split():");
        for (String source : commaAddresses) {
            Address address = new Address();
            address.parseWithSplit(source);
            System.out.println(address);
        }

        String[] mixedAddresses = {
                "Россия; Ленинградская область; Санкт-Петербург; Невский проспект; 25; 3; 8",
                "Казахстан. Алматинская область. Алматы. Абая. 5. 1. 20",
                "Россия, Свердловская область, Екатеринбург, Ленина, 1, 2, 3",
                "Армения, Араратская область, Ереван, Маштоца, 7, 2, 12"
        };

        System.out.println();
        System.out.println("Разбор с помощью StringTokenizer:");
        for (String source : mixedAddresses) {
            Address address = new Address();
            address.parseWithTokenizer(source);
            System.out.println(address);
        }
    }
}
