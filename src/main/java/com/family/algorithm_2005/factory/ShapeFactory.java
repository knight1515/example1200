package com.family.algorithm_2005.factory;

import com.family.algorithm_2005.color.Color;
import com.family.algorithm_2005.shape.Circle;
import com.family.algorithm_2005.shape.Rectangle;
import com.family.algorithm_2005.shape.Shape;
import com.family.algorithm_2005.shape.Square;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
