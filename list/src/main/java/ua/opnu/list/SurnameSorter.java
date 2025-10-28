package ua.opnu.list;

import java.util.Comparator;

public class SurnameSorter implements Comparator<Student> {
    private boolean ascending;

    public SurnameSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Student s1, Student s2) {
        int result = s1.getSurname().compareTo(s2.getSurname());
        return ascending ? result : -result;
    }
}

