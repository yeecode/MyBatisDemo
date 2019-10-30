package com.github.yeecode.mybatisdemo.model;

// 外部类
public class User {
    private String name;
    private Bag bag = new Bag();

    // 成员内部类
    public class Shoes{
        private Boolean size;

        public Boolean getSize() {
            return size;
        }

        public void setSize(Boolean size) {
            this.size = size;
        }
    }

    // 静态内部类
    public static class Bag {
        private Integer width;
        private Integer length;

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
}
