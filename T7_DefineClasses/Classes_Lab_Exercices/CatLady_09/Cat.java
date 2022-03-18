package ClassesExercices.CatLady_09;
public class Cat {
    private String breed;
    private String name;
    private double characteristic;

    public Cat(String breed, String name, double characteristic) {
        this.breed = breed;
        this.name = name;
        this.characteristic = characteristic;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f",breed,name,characteristic);
    }
}
