package GenericsExercices.GenericBoxOfInteger_02;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elementInteger;

    public Box() {
        this.elementInteger = new ArrayList<>();
    }

    public void add(T numbers){
        this.elementInteger.add(numbers);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (T element :elementInteger) {
            stringBuilder.append(String.format("%s: ",element.getClass().getName()) + element + "\n");
        }
        return stringBuilder.toString();
    }
}
