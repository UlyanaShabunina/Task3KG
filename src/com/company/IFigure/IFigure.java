package com.company.IFigure;

import com.company.point.RealPoint;

import java.util.List;

public interface IFigure {
    List<RealPoint> getMarkers();
    void setNumOfAngle(int n);
    double getRotatedAngle();
    boolean checkIfClicked(RealPoint rp);
    void setP2(RealPoint p2);
    RealPoint getCenter();
    void transfer(RealPoint to);
    void rotate(double radian);
    //void rotate(RealPoint from, RealPoint to);
    void scale(double r);


}