package com.tuling.designpattern.factory.abstractfactory;

//提供一个创建一系列相关或互相依赖对象的接口，而无需指定它们具体的类


//抽象工厂模式是工厂方法模式的升级版本，他用来创建一组相关或者相互依赖的对象。
//
//它与工厂方法模式的区别就在于，工厂方法模式针对的是一个产品等级结构；而抽象工厂模式则是针对的多个产品等级结构。
//
//在编程中，通常一个产品结构，表现为一个接口或者抽象类，也就是说，工厂方法模式提供的所有产品都是衍生自同一个接口或抽象类，而抽象工厂模式所提供的产品则是衍生自不同的接口或抽象类。
//
//在抽象工厂模式中，有一个产品族的概念：所谓的产品族，是指位于不同产品等级结构中功能相关联的产品组成的家族。抽象工厂模式所提供的一系列产品就组成一个产品族；而工厂方法提供的一系列产品称为一个等级结构。
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils utils = new OracleUtils();
        IConnection connection = utils.getConnection();
        connection.connection();
        ICommand command = utils.getCommand();
        command.command();
    }
}
interface IConnection{
    void connection();
}
interface ICommand
{
    void command();
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlConnection implements IConnection{

    @Override
    public void connection() {
        System.out.println("mysql connection");
    }
}
class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command");

    }
}
class MysqlUtils implements  IDatabaseUtils {
    @Override
    public IConnection getConnection() {
       return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}


class OracleConnection implements IConnection{

    @Override
    public void connection() {
        System.out.println("Oracle Connection ");
    }
}
class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("Oracle command");

    }
}
class OracleUtils implements  IDatabaseUtils {
    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}


