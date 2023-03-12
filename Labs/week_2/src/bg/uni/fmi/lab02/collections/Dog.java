package bg.uni.fmi.lab02.collections;


public class Dog {
    private int breed;
    private int weight;

    public Dog(int breed, int weight) {
        this.breed = breed;
        this.weight = weight;
    }

    public int getBreed() {
        return breed;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Dog{" + "breed= " + breed +
                ", weight= " + weight + '}';
    }

//    List<Dog> dogs = new ArrayList<>();
//    dogs.add(new Dog(name: "Balkan"));
//    dogs.add(new Dog(name: "Sharo"));
//    dogs.add(new Dog(name: "Pesho"));



}
