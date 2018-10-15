package com.general.lneartao.lib.refactor.reorganize_data;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 封装集合：让这个函数返回该集合的一个只读副本，并在这个类中提供添加/移除集合元素的函数
 *
 * @author lneartao
 * @date 2018/10/12.
 */
public class EncapsulateCollection {

    class Course {
        public Course(String name, boolean isAdvanced) {

        }

        public boolean isAdvanced() {
            return false;
        }
    }

    class Person {
        private Set<Course> courses = new HashSet<>();

        public Set<Course> getCourses() {
            return Collections.unmodifiableSet(courses);
        }

        public void setCoursesUgly(Set<Course> courses) {
            this.courses = courses;
        }

        public void initializeCourses(Set<Course> courses) {
            this.courses.addAll(courses);
        }

        public void addCourse(Course course) {
            courses.add(course);
        }

        public void removeCourse(Course course) {
            courses.remove(course);
        }

        private int numberOfAdvancedCourse() {
            Iterator<Course> iter = getCourses().iterator();
            int count = 0;
            while (iter.hasNext()) {
                Course each = iter.next();
                if (each.isAdvanced()) {
                    count++;
                }
            }
            return count;
        }
    }

    void doSomethingUgly() {
        Person kent = new Person();
        Set<Course> s = new HashSet<>();
        s.add(new Course("Smalltalk Programming", false));
        s.add(new Course("Appreciating Single Malts", true));
        kent.setCoursesUgly(s);

        Course refact = new Course("Refactoring", true);
        kent.getCourses().add(refact);
        kent.getCourses().add(new Course("Brutal Sarcasm", false));

        kent.getCourses().remove(refact);

        Iterator<Course> iter = kent.getCourses().iterator();
        int count = 0;
        while (iter.hasNext()) {
            Course each = iter.next();
            if (each.isAdvanced()) {
                count++;
            }
        }
    }

    void doSomething() {
        Person kent = new Person();
        kent.addCourse(new Course("Smalltalk Programming", false));
        kent.addCourse(new Course("Appreciating Single Malts", true));

        Course refact = new Course("Refactoring", true);
        kent.addCourse(refact);
        kent.addCourse(new Course("Brutal Sarcasm", false));

        kent.removeCourse(refact);
        int count = kent.numberOfAdvancedCourse();
    }
}
