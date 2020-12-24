package com.company.polygon;

import com.company.IFigure.IFigure;
import com.company.point.RealPoint;

import java.util.ArrayList;
import java.util.List;

public class Polygon implements IFigure {
    private RealPoint o;    //центр окружности
    private int n;          //кол-во граней
    private double radius;
    private double angle;
    List<RealPoint> markers = new ArrayList<>();

    @Override
    public double getRotatedAngle() {
        return angle;
    }

    @Override
    public void setNumOfAngle(int n) {
        this.n = n;
        points(o, radius);
    }

    @Override
    public void rotate(double radian){
        this.angle = radian;
        points(o, radius);
        //newPoints(o, radius, angle);
    }

    private void newPoints(RealPoint center, double radius, double angle){
        List<RealPoint> newMarkers = new ArrayList<>();
        for (RealPoint rp:markers) {
            rp = new RealPoint(center.getX() + (rp.getX() - center.getX()) * Math.cos(angle) - (rp.getY() - center.getY())*Math.sin(angle),
                    center.getY() + (rp.getY() - center.getY()) * Math.cos(angle) + (rp.getX() - center.getX())*Math.sin(angle));
            newMarkers.add(rp);
        }
        markers.clear();
        markers = newMarkers;

    }


//    public void rotate(RealPoint from, RealPoint to) {
//        RealPoint vectorFrom = new RealPoint(from.getX() - o.getX(), from.getY() - o.getY());
//        RealPoint vectorTo = new RealPoint(to.getX() - o.getX(), to.getY() - o.getY());
//        double dFrom = Math.sqrt( Math.pow(vectorFrom.getX(),2) + Math.pow(vectorFrom.getY(), 2));
//        double dTo = Math.sqrt( Math.pow(vectorTo.getX(),2) + Math.pow(vectorTo.getY(), 2));
//
//        double cosA = (vectorFrom.getX()*vectorTo.getX() + vectorFrom.getY()*vectorTo.getY()) /
//                dFrom * dTo;
//
//
//        if (Math.abs(cosA) <= 1){
//            this.angle = Math.acos(cosA);
//        }
////        if (Math.toDegrees(Math.acos(cosA)) < 180 && Math.toDegrees(Math.acos(cosA)) > 0){
////            this.angle = Math.acos(-cosA);
////        } else {
////            this.angle = Math.acos(cosA) + Math.PI;
////        }
//
//
//        //System.out.println(Math.toDegrees(angle));
//        points(o, radius, angle);
//
//
//
//    }

    @Override
    public void setP2(RealPoint p2) {
        this.radius = Math.sqrt(Math.pow((p2.getX() - o.getX()), 2) + Math.pow((p2.getY() - o.getY()), 2));
        points(o, radius);
    }


    public Polygon(RealPoint o, double radius, int n, double angle) {
        this.o = o;
        this.n = n;
        this.radius = radius;
        this.angle = angle;
        points(o, radius);
    }



    @Override
    public RealPoint getCenter() {
        return o;
    }

    @Override
    public void transfer(RealPoint newO){

        points(newO, radius);
        this.o = newO;
    }

    @Override
    public void scale(double r){
        points(o, r);
        this.radius = r;

    }

    private void points(RealPoint center, double radius){


        markers.clear();
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {

            double dx1 = radius * Math.cos(da * i + angle) + center.getX();
            double dy1 = radius * Math.sin(da * i + angle) + center.getY();
            markers.add(new RealPoint(dx1, dy1));
        }

    }

    @Override
    public boolean checkIfClicked(RealPoint rp){
        double x = rp.getX();
        double y = rp.getY();

        return x >= o.getX() - radius && x <= o.getX() + radius && y >= o.getY() - radius && y <= o.getY() + radius; //вернет true, если клик внутри фигуры
    }


    @Override
    public List<RealPoint> getMarkers() {
        return new ArrayList<>(this.markers);

    }
}