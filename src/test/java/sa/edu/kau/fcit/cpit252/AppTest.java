package sa.edu.kau.fcit.cpit252;


import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest 
{

    @Test
    public void shouldHaveSingleThreadPool() {
        MyThreadPool myThreadPool1 = MyThreadPool.getInstance();
        MyThreadPool myThreadPool2 = MyThreadPool.getInstance();
        assertEquals(myThreadPool1, myThreadPool2);
    }
    @Test
    public void ShouldBePrivateConstructor() {
        for (Constructor c : MyThreadPool.class.getConstructors()) {
            assertTrue(Modifier.isPrivate(c.getModifiers()));
        }
    }

    @Test
    public void shouldHavePrivateStaticField(){
        boolean hasLoggerVar = false;
        for (Field f : MyThreadPool.class.getDeclaredFields()){
            if(f.getType() == MyThreadPool.class){
                hasLoggerVar = true;
                assertTrue(Modifier.isPrivate(f.getModifiers()));
                assertTrue(Modifier.isStatic(f.getModifiers()));
            }
        }
        assertTrue(hasLoggerVar);
    }
    @Test
    public void shouldHavePublicStaticFactoryMethod(){
        boolean passed = false;
        for (Method m : MyThreadPool.class.getDeclaredMethods()){
            if(m.getName().equalsIgnoreCase("getInstance")){
                assertTrue(Modifier.isPublic(m.getModifiers()));
                assertTrue(Modifier.isStatic(m.getModifiers()));
                passed = true;
            }
        }
        assertTrue(passed);
    }
}
