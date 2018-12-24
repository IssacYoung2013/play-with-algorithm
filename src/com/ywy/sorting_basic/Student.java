package com.ywy.sorting_basic;

/**
 *
 * author:  ywy
 * date:    2018-12-21
 * desc:
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        if(this.score < o.score) {
            return -1;
        }
        else if(this.score > o.score) {
            return 1;
        }
        else {
            return this.name.compareTo(o.name);
        }
    }
}
