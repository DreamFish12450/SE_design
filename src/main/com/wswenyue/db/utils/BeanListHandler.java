package main.com.wswenyue.db.utils;
import org.apache.commons.dbutils.ResultSetHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BeanListHandler
 * @Description: 将结果集转换成bean对象的list集合的处理器
 *
 */
public class BeanListHandler implements ResultSetHandler {
    private Class<?> clazz;
    public BeanListHandler(Class<?> clazz){
        this.clazz = clazz;
    }

    public Object handler(ResultSet rs) {
        try{
            List<Object> list = new ArrayList<Object>();
            while(rs.next()){
                Object bean = clazz.newInstance();

                ResultSetMetaData  metadata = rs.getMetaData();
                int count = metadata.getColumnCount();
                for(int i=0;i<count;i++){
                    String name = metadata.getColumnName(i+1);
                    Object value = rs.getObject(name);

                    Field f = bean.getClass().getDeclaredField(name);
                    f.setAccessible(true);
                    f.set(bean, value);
                }
                list.add(bean);
            }
            return list.size()>0?list:null;

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object handle(ResultSet resultSet) throws SQLException {
        return null;
    }
}