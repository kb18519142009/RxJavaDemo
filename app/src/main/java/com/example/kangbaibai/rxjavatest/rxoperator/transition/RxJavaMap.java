package com.example.kangbaibai.rxjavatest.rxoperator.transition;

import android.util.Log;

import com.example.kangbaibai.rxjavatest.model.Course;
import com.example.kangbaibai.rxjavatest.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by kangbaibai on 2018/6/6.
 */

public class RxJavaMap {
    private static final String TAG = "RxJavaMap";
    private static List<Student> students = new ArrayList<>();

    static {
        Student student = new Student();
        student.setName("小白");
        List<Course> courses = new ArrayList<>();
        Course course = new Course();
        List<String> content = new ArrayList<>();
        content.add("皇上");
        content.add("搭讪");
        content.add("美女");
        course.setContent(content);
        course.setName("语文");
        courses.add(course);
        student.setCourses(courses);
        students.add(student);

        Student student1 = new Student();
        student1.setName("小黑");
        List<Course> courses1 = new ArrayList<>();
        Course course1 = new Course();
        List<String> content1 = new ArrayList<>();
        content1.add("大王");
        content1.add("叫我");
        content1.add("巡山");
        course1.setContent(content1);
        course1.setName("英语");
        courses1.add(course1);
        student1.setCourses(courses1);
        students.add(student1);

        Student student2 = new Student();
        student2.setName("小红");
        List<Course> courses2 = new ArrayList<>();
        Course course2 = new Course();
        List<String> content2 = new ArrayList<>();
        content2.add("吕布");
        content2.add("调戏");
        content2.add("貂蝉");
        course2.setContent(content2);
        course2.setName("数学");
        courses2.add(course2);
        student2.setCourses(courses2);
        students.add(student2);
    }

    /**
     * map()
     * <p>
     * public final <R> Observable<R> map(Function<? super T, ? extends R> mapper)
     * <p>
     * map 可以将被观察者发送的数据类型转变成其他的类型
     */
    public static void mapObservable() {
        Observable.just(1, 2, 3)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "It's " + integer;
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "mapObservable------------观察者的onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> mapper)
     * <p>
     * 现在有一个需求就是要将 Student 集合中的每个元素中的 Course 的 content 打印出来
     */
    public static void flatMapObservable() {

        Observable.fromIterable(students)
                .flatMap(new Function<Student, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(Student student) throws Exception {
                        return Observable.fromIterable(student.getCourses());
                    }
                })
                .flatMap(new Function<Course, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Course c) throws Exception {
                        return Observable.fromIterable(c.getContent());
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG, "flatMapObservable()------------观察者的onNext " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * concatMap()
     * <p>
     * public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> mapper)
     * public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> mapper, int prefetch)
     * <p>
     * concatMap() 和 flatMap() 基本上是一样的，只不过 concatMap() 转发出来的事件是有序的，而 flatMap() 是无序的。
     */
    public static void concatMapObservable() {
        Observable.fromIterable(students)
                .concatMap(new Function<Student, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(Student student) throws Exception {
                        if ("小白".equals(student.getName())){
                            return Observable.fromIterable(student.getCourses()).delay(2, TimeUnit.SECONDS);
                        }
                        return Observable.fromIterable(student.getCourses());
                    }
                })
                .subscribe(new Observer<Course>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "--------------------观察者的onSubscribe--------------------");
                    }

                    @Override
                    public void onNext(Course course) {
                        Log.e(TAG, "concatMapObservable()------------观察者的onNext " + course.getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
