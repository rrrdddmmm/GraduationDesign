package edu.xust.db;

import java.beans.PropertyVetoException;    
import java.sql.Connection;    
import java.sql.SQLException;    
import com.mchange.v2.c3p0.ComboPooledDataSource;    
/**  
 * DbPool.java  
 * 功能：使用C3P0连接池获取数据库连接对象  

 */    
public class DbPool {    
        
    private static final DbPool instance=new DbPool();    
    private static ComboPooledDataSource cpds=new ComboPooledDataSource(true);     
        
    /**  
     * 此处可以不配置，采用默认也行  
     */    
    static{    
        cpds.setDataSourceName("mydatasource");    
        cpds.setJdbcUrl(DbConfig.getInstance().getProperty("c3p0.jdbcUrl").toString());    
        try {    
            cpds.setDriverClass(DbConfig.getInstance().getProperty("c3p0.driverClass").toString());    
        } catch (PropertyVetoException e) {    
            e.printStackTrace();    
        }    
        cpds.setUser(DbConfig.getInstance().getProperty("c3p0.user").toString());    
        cpds.setPassword(DbConfig.getInstance().getProperty("c3p0.password").toString());    
        cpds.setMaxPoolSize(Integer.valueOf(DbConfig.getInstance().getProperty("c3p0.maxPoolSize").toString()));    
        cpds.setMinPoolSize(Integer.valueOf(DbConfig.getInstance().getProperty("c3p0.minPoolSize").toString()));    
        cpds.setAcquireIncrement(Integer.valueOf(DbConfig.getInstance().getProperty("c3p0.acquireIncrement").toString()));    
        cpds.setInitialPoolSize(Integer.valueOf(DbConfig.getInstance().getProperty("c3p0.initialPoolSize").toString()));    
        cpds.setMaxIdleTime(Integer.valueOf(DbConfig.getInstance().getProperty("c3p0.maxIdleTime").toString()));    
    }    
        
    private DbPool(){}    
        
    public static DbPool getInstance(){    
        return instance;    
    }    
        
    public static Connection  getConnection(){    
        try {    
            return cpds.getConnection();    
        } catch (SQLException e) {    
            e.printStackTrace();    
        }    
        return null;    
    }    
    
}