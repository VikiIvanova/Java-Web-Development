package tasks_week_1;

public class Person {
    String name;
    int age;

    Person()
    {
        this.name = "No name";
        this.age = -1;
    }

    Person(String name)
    {
        this.name = name;
        this.age = -1;
    }

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setAge(int newAge)
    {
        age = newAge;
    }
    public String toString()
    {
        if(name == null)
        {
            return "I am John Doe";
        }
        else if(age == 0)
        {
            return "Hello, I am " + name + ".";
        }
        else
        {
            return "Hello, I am " + name + ". I am " + age + "years old.";
        }

    }
}
