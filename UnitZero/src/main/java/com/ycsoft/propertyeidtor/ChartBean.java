package com.ycsoft.propertyeidtor;

import javax.swing.*;

/**
 * Created by yong on 2016/12/23 0023.
 */
public class ChartBean extends JPanel {
    private Position titlePosition = Position.CENTER;
    //private boolean inverse;

    public Position getTitlePosition() {
        return titlePosition;
    }

    public void setTitlePosition(Position titlePosition) {
        this.titlePosition = titlePosition;
    }

    /*public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }*/
}
