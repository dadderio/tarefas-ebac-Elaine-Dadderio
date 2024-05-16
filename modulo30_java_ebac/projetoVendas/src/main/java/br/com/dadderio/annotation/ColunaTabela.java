package br.com.dadderio.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ColunaTabela {


    String dbName();

    String setJavaName();
}
