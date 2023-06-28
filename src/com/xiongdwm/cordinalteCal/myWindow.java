package com.xiongdwm.cordinalteCal;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.DecimalFormat;


public class myWindow {
    private static JFormattedTextField longitude1;
    private static JFormattedTextField latitude1;
    private static JFormattedTextField longitude2;
    private static JFormattedTextField latitude2;
    private static JLabel resultLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("coordinate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,300));
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        DecimalFormat decimalFormat = new DecimalFormat("#.################");
        NumberFormatter formatter = new NumberFormatter(decimalFormat);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);

        longitude1 = new JFormattedTextField(formatter);
        latitude1 = new JFormattedTextField(formatter);
        longitude2 = new JFormattedTextField(formatter);
        latitude2 = new JFormattedTextField(formatter);
        JButton calculateButton = new JButton("计算");
        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(new JLabel("经度1: "));
        panel.add(longitude1);
        panel.add(new JLabel("纬度1: "));
        panel.add(latitude1);
        panel.add(new JLabel("经度2: "));
        panel.add(longitude2);
        panel.add(new JLabel("纬度2: "));
        panel.add(latitude2);
        panel.add(new JLabel());
        panel.add(calculateButton);
        panel.add(new JLabel());
        panel.add(resultLabel);

        calculateButton.addActionListener(e -> {
            double lon1 = (Double) longitude1.getValue();
            double lat1 = (Double) latitude1.getValue();
            double lon2 = (Double) longitude2.getValue();
            double lat2 = (Double) latitude2.getValue();

            double sum = GpsUtils.getDistance(lon1,lat1,lon2,lat2);

            resultLabel.setText("距离: " + sum);
        });

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

