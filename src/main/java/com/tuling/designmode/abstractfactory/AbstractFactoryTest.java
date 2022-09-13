package com.tuling.designmode.abstractfactory;

/**
 * @Author zhangChen
 * @Date 2022/9/12 22:10
 */
//抽象工厂模式
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlDataBaseUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();
    }
}

interface IConnection {
    void connect();
}
class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("Mysql Connection");
    }
}
interface ICommand {
    void command();
}
class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("Mysql Command");
    }
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}
class MysqlDataBaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}