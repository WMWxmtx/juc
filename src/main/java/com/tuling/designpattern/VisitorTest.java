package com.tuling.designpattern;

public class VisitorTest {
    public static void main(String[] args) {
        EggRobot eggRobot =new EggRobot();
        eggRobot.cale();
        Visitor visitor = new UpdataVisitor();
        eggRobot.accpet(visitor);
        eggRobot.cale();
    }
}

//机器人类
class EggRobot{
    private HardDisk disk;
    private CPU cpu;

    public EggRobot() {
        this.disk = new HardDisk("记住:1+1=1");
        this.cpu = new CPU("1+1=1");
    }
    public void cale(){
        this.cpu.run();
        this.disk.run();
    }
    //升级操作
    public  void accpet(Visitor visitor){
        this.cpu.accept(visitor);
        this.disk.accept(visitor);

    }
}

//抽象硬件类
abstract class Hardware{
    String command;
    public Hardware(String command){
        this.command =command;

    }
    public void  run(){
        System.out.println(command);
    }
    public abstract void accept(Visitor visitor);
}

//硬件具体实现类
class CPU extends Hardware{

    public CPU(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCPU(this);
    }
}

//具体硬件 accept访问器
//让软件包 Visitor 可以访问CPU
class HardDisk extends Hardware{

    public HardDisk(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitHardDisk(this);
    }
}

//软件包
interface Visitor{
    void visitCPU(CPU cpu);
    void visitHardDisk(HardDisk disk);
}

//升级包
class UpdataVisitor implements Visitor{

    @Override
    public void visitCPU(CPU cpu) {
        cpu.command+=",1+1=2";
    }

    @Override
    public void visitHardDisk(HardDisk disk) {
        disk.command+=",记住:1+1=2";
    }
}
