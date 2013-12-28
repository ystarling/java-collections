package com.ystarling.collections.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Student implements Comparable<Student> {

	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}

	@Override
	public int compareTo(Student o) {
		return Comparators.NAME.compare(this, o);
	}

	public static class Comparators {

		public static Comparator<Student> NAME = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
		};

		public static Comparator<Student> AGE = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.age - o2.age;
			}
		};

		public static Comparator<Student> NAME_AGE = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int i = o1.name.compareTo(o2.name);
				if (i == 0) {
					i = o1.age - o2.age;
				}
				return i;
			}
		};
	}

	public static void main(String[] args) {
		List<Student> studentList = new LinkedList<Student>() {
			{
				add(new Student("RYAN", 25));
				add(new Student("MICHAEL", 22));
				add(new Student("JOHN", 21));
				add(new Student("BEN", 19));
				add(new Student("SARAH", 20));
				add(new Student("ALICE", 18));
			}
		};

		Collections.sort(studentList, Student.Comparators.AGE);
		System.out.println("Sorted by age: \t\t" + studentList);

		Collections.sort(studentList, Student.Comparators.NAME);
		System.out.println("Sorted by name: \t" + studentList);

		Collections.sort(studentList, Student.Comparators.NAME_AGE);
		System.out.println("Sorted by name & age: \t" + studentList);
	}
}


