package models;

public class Boss {

    String name;
    int age;
    int fortune;

    public Boss()
    {
        this.name="";
        this.age=0;
        this.fortune=0;
    }
    public Boss(String name, int age, int fortune) {
        this.name = name;
        this.age = age;
        this.fortune = fortune;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFortune() {
        return fortune;
    }

    public void setFortune(int fortune) {
        this.fortune = fortune;
    }
}
