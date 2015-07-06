package br.com.elo7.mars.test.setup;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import br.com.elo7.mars.util.WeldContext;

public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {

    public WeldJUnit4Runner(Class<Object> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected Object createTest() {
        final Class<?> test = getTestClass().getJavaClass();
        return WeldContext.INSTANCE.getBean(test);
    }
    
}