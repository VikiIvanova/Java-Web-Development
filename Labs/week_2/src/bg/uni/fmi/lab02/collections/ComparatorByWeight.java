package bg.uni.fmi.lab02.collections;

import java.util.Comparator;

public class ComparatorByWeight implements Comparator<Dog> {
    @Override
    public int compare(Dog dog1, Dog dog2){
        return Integer.compare(dog1.getWeight(), dog2.getWeight());
    }
}
