package Task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Engine {
    // ������������ ����� �������
    public enum FuelType{������, ������, ���};
    private double power, fuelConsumption, workload;

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getWorkload() {
        return workload;
    }

    public void setWorkload(double workload) {
        this.workload = workload;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getRegisterSign() {
        return registerSign;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    private FuelType fuelType;
    private String registerSign;
    private int numberOfCylinders;
    // ����������� ������ Engine, ������� ��������� � �������� ���������� ������ � ���������� ���������, ��������, ������� �������, ������ ������, ���� ������� � ��������������� �����
    public Engine(int numberOfCylinders, double power, double fuelConsumption, double workload, FuelType fuelType, String registerSign){
        this.numberOfCylinders = numberOfCylinders;
        this.power = power;
        this.fuelConsumption = fuelConsumption;
        this.workload = workload;
        this.fuelType = fuelType;
        setRegisterSign(registerSign);
    }

    // ����� ��� ��������� ���������������� �����, ������� ��������� � �������� ��������� ������
    public void setRegisterSign(String registerSign){
        Pattern pattern = Pattern.compile("[������������]\\d{3}[������������]{2}\\d{2,3}RUS");
        Matcher matcher = pattern.matcher(registerSign);
        if(matcher.matches()){
            this.registerSign = registerSign;
        }
        else {
            System.out.println("������! �������� ������!");
        }
    }
    // ���������������� ����� toString ��� ��������� ���������� ������������� �������
    @Override
    public String toString(){
        String s =String.format("�����: %s  ��� �������: %s ���-�� ���������: %d ��������: %f ������ �������: %f ����� ������: %f", registerSign, fuelType, numberOfCylinders, power, fuelConsumption, workload);
        return s;
    }
}
