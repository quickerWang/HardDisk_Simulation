package edu.kit.informatik;

public class Disk {
    private int number; //section number
    private int size = 512; //section size
    private int diskSize; //disk Size

    public Disk(int number) {
        this.number = number;
        this.diskSize=getDiskSize();
    }



    /**
     * get the size of disk
     * @return
     */
    public int getDiskSize(){
        return number*size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    /**
     * reduce the number of section
     * @param number
     */
    public void setBad(int number){
        if(this.number<number)
            this.number=0;
        this.number-=number;
    }
    @Override
    public String toString(){
        return number+","+size;
    }

}
