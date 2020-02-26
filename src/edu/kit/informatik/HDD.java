package edu.kit.informatik;

import java.util.*;

public class HDD {
    /**
     * ATA,SATA,SCSI,SAS
     *
     * ATA is a parrallel bus,The cable properties, connectors and signal protocols of this kind of
     * parallel interface show great technical bottlenecks,
     * and it is quite difficult to break through these bottlenecks technically,so we can not use it
     *
     * SATA:During multithreaded data reads, the hard disk head swings back and forth frequently,
     * making the hard disk overheat is a defect SATA needs to overcome,so we can not use it
     *
     * SAS is better: SAS is superior to SATA in disk performance.
     * This is mainly due to the powerful SCSI instruction set (including SCSI instruction queue), dual-core processors,
     * and support for hardware sequential stream processing.SAS hard drives support two-way full duplex mode,
     * providing two active channels for simultaneous read and write operations.
     */
    //example disk number
    private int diskNumber; //disk number
    //example disk
    private Disk disk;
    private String hardInteface = "SAS";  //for finding address
    //io speed
    private int IOPS;
    //HDDSize;
    private int HddSize;

    public int getHddSize() {
        return HddSize;
    }

    public void setHddSize(int hddSize) {
        HddSize = hddSize;
    }

    public int getDiskNumber() {
        return diskNumber;
    }

    public void setDiskNumber(int diskNumber) {
        HddSize=diskNumber*disk.getDiskSize();
        this.diskNumber = diskNumber;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
        HddSize=diskNumber*disk.getDiskSize();
    }

    public String getHardInteface() {
        return hardInteface;
    }

    public void setHardInteface(String hardInteface) {
        this.hardInteface = hardInteface;
    }

    /**
     * calculate HddSize
     */
    public void calculateHddSize(){
        HddSize=disk.getDiskSize()*diskNumber;
    }


    //constructor
    public HDD(int diskNumber,String hardInteface,int IOPS,Disk disk){
        this.diskNumber=diskNumber;
        this.hardInteface=hardInteface;
        //IOPS must be the multiriple of ten
        if(IOPS%10!=0){
            this.IOPS=(IOPS/10)*10+10;
        }else{
            this.IOPS=IOPS;
        }
        this.disk=disk;
        calculateHddSize();
    }

    /**
     * calculate wrong rate
     * @return
     */
    public String calculateWrongRate(){
        String result = "";
        result=result+"Bytes:"+HddSize+",WrongRate:"+1/HddSize;
        return result;
    }

    @Override
    public String toString(){
        String result ="";
        result=result+hardInteface+","+IOPS+","+disk+","+diskNumber+","+HddSize;
        return result;
    }
}
