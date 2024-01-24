package com.WorkersDataBase.view.interfaces;

public interface ComponentCreator {
    void configureComponents();
    void configureFront();
    default void configure(){
        configureComponents();
        configureFront();
    }
}
