package com.ada.cleanarchitecture.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Service
public @interface UseCase {
}
