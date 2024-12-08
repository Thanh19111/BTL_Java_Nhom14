package Model;

import java.util.Scanner;

public class Position {
    private int positionID;
    private String positionName;
    private double positionSalary;

    public Position() {}

    public Position(int positionID, String positionName, double positionSalary) {
        this.positionID = positionID;
        this.positionName = positionName;
        this.positionSalary = positionSalary;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public double getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(double positionSalary) {
        this.positionSalary = positionSalary;
    }

    @Override
    public String toString() {
        return positionID + "," + positionName + "," + positionSalary;
    }

    public void input(Scanner sc) {
    	System.out.println("Nhap ID chuc vu: ");
    	this.setPositionID(sc.nextInt());
    	sc.nextLine();
    	System.out.println("Nhap ten chuc vu: ");
    	this.setPositionName(sc.nextLine());
    	System.out.println("Nhap luong chuc vu (Trieu dong): ");
    	this.setPositionSalary(sc.nextDouble());
    }

}