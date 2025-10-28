package ua.opnu.list;

public class Student {
    private String name;
    private String surname;
    private double averageMark;

    public Student(String name, String surname, double averageMark) {
        this.name = name;
        this.surname = surname;
        this.averageMark = averageMark;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public double getAverageMark() { return averageMark; }

    @Override
    public String toString() {
        return name + " " + surname + " (" + averageMark + ")";
    }
}

