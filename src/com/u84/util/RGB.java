package com.u84.util;

public class RGB {
    private int rgb;

    public RGB(int rgb){
        this.rgb = rgb;
    }

    public RGB(){

    }

    private int moveByte(int b){
        return (this.rgb >> b) & 0xff;
    }

    /** Let it be**/
    public int getAlpha(){
        int alpha = moveByte(24);
        return alpha;
    }

    public int getRed(){
        int red = moveByte(16);
        return red;
    }

    public int getGreen(){
        int green = moveByte(8);
        return green;
    }

    public int getBlue(){
        int blue = this.rgb & 0xff;
        return blue;
    }


}
