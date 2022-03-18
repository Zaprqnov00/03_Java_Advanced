package GenericsExercices.GenericBox_01;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elementsList;

    public Box(){
        this.elementsList = new ArrayList<>();
    }

    public void add(T text) {
        elementsList.add(text);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (T element :elementsList) {
            stringBuilder.append(element.getClass().getName() + ": " + element + "\n");
        }
        return stringBuilder.toString();
    }
}
