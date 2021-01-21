package com.family.algorithm_2005.factory;

import com.family.algorithm_2005.color.Color;
import com.family.algorithm_2005.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
