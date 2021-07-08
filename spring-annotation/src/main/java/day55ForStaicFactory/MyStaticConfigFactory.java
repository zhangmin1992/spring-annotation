package day55ForStaicFactory;
import java.util.HashMap;
import java.util.Map;

public class MyStaticConfigFactory {
    public static Map<String,Person> persons = new HashMap<String,Person>();
    static {
        persons.put("baoma",new Person("baoma",200000));
        persons.put("benchi",new Person("benchi",300000));
    }
    public static Person getPerson(String name) {
        return persons.get(name);
    }
}
