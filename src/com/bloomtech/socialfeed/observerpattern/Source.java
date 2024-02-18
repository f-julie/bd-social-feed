package com.bloomtech.socialfeed.observerpattern;

import com.bloomtech.socialfeed.observerpattern.Observer;

public interface Source {
    void attach(Observer observer);
    void detach(Observer observer);
    void updateAll();
}
