package com.family.algorithm_2005.factory;

import com.family.algorithm_2005.color.Blue;
import com.family.algorithm_2005.color.Color;
import com.family.algorithm_2005.color.Green;
import com.family.algorithm_2005.color.Red;
import com.family.algorithm_2005.shape.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
