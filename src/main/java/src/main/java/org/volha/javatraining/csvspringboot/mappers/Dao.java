package src.main.java.org.volha.javatraining.csvspringboot.mappers;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Dao {
    static SqlSessionFactory sessionFactory;
    public static boolean init() {
        try{
            InputStream inputStream = new FileInputStream(new File("./src/main/resource/mybatis-config.xml"));
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        catch (IOException e){
            System.err.println("An error occured while initialising mybatis");
            e.printStackTrace();
            return false;
        }
        //??? Should this true be returned correctly? Shouldn't it be before catch?
        return true;
    }
}
