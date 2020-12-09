package com.oryshchak.businesslogic.transformer;

import com.oryshchak.businesslogic.model.annotations.Column;
import com.oryshchak.businesslogic.model.annotations.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transformer<T> {
  private final Class<T> clazz;

  public Transformer(Class<T> clazz) {
    this.clazz = clazz;
  }

  public Object extractDataToModel(ResultSet rs) throws SQLException {
    Object entity = null;
    try {
      entity = clazz.getConstructor().newInstance();
      if (clazz.isAnnotationPresent(Table.class)) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
          if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            String name = column.name();
            String type = column.type();
            field.setAccessible(true);
            switch (type) {
              case "string":
                field.set(entity, rs.getString(name));
                break;
              case "int":
                field.set(entity, rs.getInt(name));
                break;
              case "bool":
                field.set(entity, rs.getBoolean(name));
                break;
              case "bigDecimal":
                field.set(entity, rs.getBigDecimal(name));
                break;
              case "double":
                field.set(entity, rs.getDouble(name));
                break;
              default:
                break;
            }
          }
        }
      }

    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
            | InvocationTargetException ignored) {
      System.out.println("can't transform object");
    }

    return entity;
  }
}