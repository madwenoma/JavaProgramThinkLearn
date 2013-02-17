package learn.annotation.dbtable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constains {
	boolean allowNull() default true;
	boolean primaryKey() default false;
	boolean unique() default false;
}
