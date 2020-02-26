package edu.kit.informatik;

public class Test {
    public static void main(String[] args) {
        Disk disk = new Disk(20);
        HDD hdd = new HDD(5,"SAS",40,disk);
        Terminal.printLine(disk);
        Terminal.printLine(hdd);
    }
}
