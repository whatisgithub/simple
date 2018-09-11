package cn.cpic.insurance.util.lock.anno;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {
    String key() default "";

    /**
     * @author fly
     */
    int expire() default 5;
}
