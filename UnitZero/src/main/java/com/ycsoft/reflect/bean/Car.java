package com.ycsoft.reflect.bean;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class Car {
    private String brand;
    private String color;
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }


    /**
     * Getter for property 'brand'.
     *
     * @return Value for property 'brand'.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter for property 'brand'.
     *
     * @param brand Value to set for property 'brand'.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter for property 'color'.
     *
     * @return Value for property 'color'.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for property 'color'.
     *
     * @param color Value to set for property 'color'.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter for property 'maxSpeed'.
     *
     * @return Value for property 'maxSpeed'.
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Setter for property 'maxSpeed'.
     *
     * @param maxSpeed Value to set for property 'maxSpeed'.
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public void introduce() {
        System.out.println("brand=" + brand + ", color=" + color + ", maxSpeed=" + maxSpeed);
    }
}
