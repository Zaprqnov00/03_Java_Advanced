package GenericsExercices.GenericSwapMethodInteger_04;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> listIntegers;

    public Box(){
        this.listIntegers = new ArrayList<>();
    }

    public void add(T number){
        this.listIntegers.add(number);
    }

    public void swap(int firstIndex, int secondIndex) {

        T elementOne = listIntegers.get(firstIndex);
        T elementTwo = listIntegers.get(secondIndex);

        listIntegers.set(firstIndex,elementTwo);
        listIntegers.set(secondIndex,elementOne);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (T number :listIntegers) {
            stringBuilder.append(number.getClass().getName()).append(": ").append(number).append("\n");
        }
        return stringBuilder.toString();
    }
}
