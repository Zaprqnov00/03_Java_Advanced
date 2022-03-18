package ClassesExercices.OpinionPoll_01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Person {
    private Map<String,Integer> peopleInformation;

    public Person(){
        this.peopleInformation = new TreeMap<>();
    }

    public void put(String name,int age){
        this.peopleInformation.put(name,age);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : peopleInformation.entrySet()) {
            stringBuilder.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
