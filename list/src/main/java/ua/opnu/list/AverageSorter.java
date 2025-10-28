package ua.opnu.list;

import java.util.Comparator;

public class AverageSorter implements Comparator<Student> {
    private boolean ascending;

    public AverageSorter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Student s1, Student s2) {
        int result = Double.compare(s1.getAverageMark(), s2.getAverageMark());
        return ascending ? result : -result;
    }
}

