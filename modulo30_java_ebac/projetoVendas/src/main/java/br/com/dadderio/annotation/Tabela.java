package br.com.dadderio.annotation;

import java.lang.annotation.*;


    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Tabela {

        String value();

    }
