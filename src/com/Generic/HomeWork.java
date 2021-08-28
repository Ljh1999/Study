package com.Generic;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("101", new User(1, 20, "jack"));
        userDAO.save("102", new User(2, 20, "King"));
        userDAO.save("103", new User(3, 33, "mary"));
        List<User> list = userDAO.list();
        System.out.println(list);
        User user = userDAO.get("101");
        System.out.println(user);
        userDAO.update("101", new User(1, 22, "tom"));
        list = userDAO.list();
        System.out.println(list);
        userDAO.delete("101");
        list = userDAO.list();
        System.out.println(list);
    }
}

class DAO<T> {
    public Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entiry) {
        map.put(id, entiry);
    }

    public List<T> list() {
        Set<Map.Entry<String, T>> entries = map.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        List<T> ts = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, T> next = iterator.next();
            T value = next.getValue();
            ts.add(value);
        }
        return ts;
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}