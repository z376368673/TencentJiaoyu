package com.library.common.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 *  @描述：  自定义注解  注解ID 标识 是 唯一的
 *
 * @创建时间:2019-11-19 17:29
 *
 * @更新时间： 2019-11-19 17:29
 *
 * @更新说明： 无
 *
 * @author： zh浩
 *
 * @版本号 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ID {

}

class MyClass {
   static Field getId(Class object) {
        Field[] fields = object.getFields();
        for (final Field field : fields) {
            ID fieldAnnotation = field.getAnnotation(ID.class);
            if (fieldAnnotation != null) {
                return field;
            }
        }
        return null;
    }
}