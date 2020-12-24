package com.company.polygon;

import com.company.IFigure.IFigure;
import com.company.ScreenConverter;
import com.company.line.LineDrawer;
import com.company.point.RealPoint;

import java.awt.*;
import java.util.List;

public class DrawPolygon implements PolygonDrawer {
    private LineDrawer ld;
    private ScreenConverter sc;

    public DrawPolygon(LineDrawer ld, ScreenConverter sc) {
        this.ld = ld;
        this.sc = sc;
    }

    @Override
    public void drawPolygon(IFigure f, Color c) {
        List<RealPoint> realPoints = f.getMarkers();
        int n = realPoints.size();
        for (int i = 0; i < n - 1; i++) {
            ld.drawLine(sc.r2s(realPoints.get(i)), sc.r2s(realPoints.get(i + 1)), c);
        }
        ld.drawLine(sc.r2s(realPoints.get(n - 1)), sc.r2s(realPoints.get(0)), c);
    }

//    @Override
//    public void drawPolygon(ScreenPoint center, double r, int n, LineDrawer ld, Color c) {
//
//        //double r = Math.sqrt(Math.pow((radius.getX() - center.getX()), 2) + Math.pow((radius.getY() - center.getY()), 2));
//
//        double da = 2 * Math.PI / n;
//
//
//        for (int i = 0; i < n; i++) {
//            double dx1 = r * Math.cos(da * i) + center.getX();
//            double dy1 = r * Math.sin(da * i) + center.getY();
//            double dx2 = r * Math.cos(da * (i + 1)) + center.getX();
//            double dy2 = r * Math.sin(da * (i + 1)) + center.getY();
//            ld.drawLine(new ScreenPoint((int)dx1, (int)dy1), new ScreenPoint((int)dx2, (int)dy2), c);
//        }
//    }
}