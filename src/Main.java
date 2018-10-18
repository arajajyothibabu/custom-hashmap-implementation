import com.jyothi.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        HashMap<String, Integer> marks = new HashMap<String, Integer>();
        marks.put("Maths", 100);
        marks.put("Science", 99);
        marks.put("Social", 98);
        marks.put("Telugu", 94);
        marks.put("Hindi", 87);
        marks.put("English", 87);
        marks.put("English", 89);
        marks.put("Marathi", 54);
        marks.display();
        marks.remove("Marathi");
        marks.remove("English");
        marks.display();
    }

}
