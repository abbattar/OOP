package BatleField;

import java.util.Arrays;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(Vector2 opposite) {
        if (opposite.y == y && opposite.x == x) {return true;}
        else {return false;}
    }

    public float getDistance(float x, float y) {
        float dx = x - this.x;
        float dy = y - this.y;

        return (float) Math.sqrt(dx*dx + dy*dy);
    }
}