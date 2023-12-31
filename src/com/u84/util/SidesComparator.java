package com.u84.util;

import java.awt.image.BufferedImage;
import java.util.Comparator;

public class SidesComparator implements Comparator<BufferedImage> {

    /**
     * I'll use it comparator in future versions.
     * It is utility for image searching and comparing.
     **/

    @Override
    public int compare(BufferedImage o1, BufferedImage o2) {
        float ratio1 = (float)o1.getHeight()/o1.getWidth();
        float ratio2 = (float)o2.getHeight()/o2.getWidth();
        if (ratio1 == ratio2){
            return 1;
        }
        else if (ratio1 < ratio2){
            return -1;
        }
        else{
            return 0;
        }

    }
}
