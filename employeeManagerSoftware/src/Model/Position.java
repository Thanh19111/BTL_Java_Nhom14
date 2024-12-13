package Model;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
public class Position {
    private int positionID;
    private String positionName;
    private Double positionSalary;

   

    public Position(int positionID, String positionName, Double positionSalary) {
        this.positionID = positionID;
        this.positionName = positionName;
        this.positionSalary = positionSalary;
    }
    public Position() {}
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

    public Double getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(Double positionSalary) {
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