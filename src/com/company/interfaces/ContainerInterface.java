package com.company.interfaces;

import com.company.exceptions.OverfillException;

public interface ContainerInterface {
    void empty();
    void fill(Double mass) throws OverfillException;
}
