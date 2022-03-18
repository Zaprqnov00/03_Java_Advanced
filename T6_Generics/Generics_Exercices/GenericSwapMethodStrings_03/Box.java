package GenericsExercices.GenericSwapMethodStrings_03;

import java.util.ArrayList;
import java.util.List;

public class Box<T>{
    private List<T> collectionElement;

    public Box(){
        this.collectionElement = new ArrayList<>();
    }

    public void add(T element){
        this.collectionElement.add(element);
    }
    public void swap(int firstIndex,int secondIndex){
        T firstText = collectionElement.get(firstIndex);
        T secondText = collectionElement.get(secondIndex);

        this.collectionElement.set(firstIndex,secondText);
        this.collectionElement.set(secondIndex,firstText);
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (T elements :collectionElement) {
            stringBuilder.append(elements.getClass().getName() + ": " + elements + "\n");
        }
        return stringBuilder.toString();
    }
}
