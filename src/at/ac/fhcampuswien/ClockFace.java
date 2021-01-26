package at.ac.fhcampuswien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class ClockFace extends JPanel {
    //Method to start the Clock that is later used
    public void startClock() {
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }

    public ClockFace() {
        this.startClock();
    }
    //Setting size for GUI Window
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(610, 610);
    }
    //Creating 2D Graphic
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D Clockgraph = (Graphics2D) g.create();
        //Setting integer variables for each hand with "Local Time"
        LocalTime now = LocalTime.now();
        int seconds = now.getSecond();
        int minutes = now.getMinute();
        int hours = now.getHour();

        //Setting Colors of the Background (pink) and the middle (white)
        Clockgraph.setColor(Color.PINK);
        Clockgraph.fillRect(0,0,610,610);
        Clockgraph.setColor(Color.BLACK);
        Clockgraph.fillOval(1,0,603,605);
        Clockgraph.setColor(Color.WHITE);
        Clockgraph.fillOval(3, 3, 600, 600);
        Clockgraph.setColor(Color.BLACK);
        Clockgraph.translate(302, 302);

        //Calculating rotation for outer lines that indicate hours
        for (int i = 0; i < 12; i++) {

            Clockgraph.drawLine(0, -260, 0, -300);
            Clockgraph.rotate(Math.PI / 6);

        }
        //outer lines for minutes
        for (int i = 0; i < 60; i++) {

            Clockgraph.drawLine(0,-280, 0, -300);
            Clockgraph.rotate(Math.PI / 30);
        }
        //Calculating rotations for seconds minutes and hours
        Clockgraph.setColor(Color.RED);
        Clockgraph.rotate(seconds * Math.PI / 30);
        Clockgraph.setStroke(new BasicStroke(1));
        Clockgraph.drawLine(0, 0, 0, -290);

        Clockgraph.setColor(Color.BLUE);
        Clockgraph.rotate(2 * Math.PI - seconds * Math.PI / 30);
        Clockgraph.rotate(minutes * Math.PI / 30);
        Clockgraph.setStroke(new BasicStroke(3));
        Clockgraph.drawLine(0, 0, 0, -250);

        Clockgraph.setColor(Color.BLACK);
        Clockgraph.rotate(2 * Math.PI - minutes * Math.PI / 30);
        Clockgraph.rotate(hours * Math.PI / 6);
        Clockgraph.setStroke(new BasicStroke(6));
        Clockgraph.drawLine(0, 0, 0, -150);
    }
}

