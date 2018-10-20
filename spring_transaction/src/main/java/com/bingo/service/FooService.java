package com.bingo.service;

import com.bingo.beans.Foo;

public interface FooService {
     Foo getFoo(String name);

     Foo getFoo(String name, String barname);
     void insertFoo(Foo foo);
     void updateFoo(Foo foo);
}
