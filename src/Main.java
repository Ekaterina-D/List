import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] animalList = new String[]{"Pen", "Book", "Glass"};
        Stock stock = new Stock(Arrays.toString(animalList));
        for (String stocks : stock) {
            System.out.println(stocks);
        }
    }
}
