package com.univates.tcc.abacate.integracao.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AutowireHelper {

    public static ApplicationContext context;

    private AutowireHelper() {
    }

    public static void autowire(Object classToAutowire) {
        context.getAutowireCapableBeanFactory().autowireBean(classToAutowire);
    }

}