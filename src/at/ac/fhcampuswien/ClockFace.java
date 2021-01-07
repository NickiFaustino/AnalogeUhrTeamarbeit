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
        return new Dimension(600, 600);
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

        //Setting Colors of the Background (black) and the middle (white)
        Clockgraph.setColor(Color.BLACK);
        Clockgraph.fillRect(0,0,600,600);
        Clockgraph.setColor(Color.WHITE);
        Clockgraph.fillOval(0, 0, 600, 600);
        Clockgraph.setColor(Color.BLACK);
        Clockgraph.translate(300, 300);

        //Calculating rotation for outer lines that indicate ours
        for (int i = 0; i < 12; i++) {

            Clockgraph.drawLine(0, -260, 0, -300);
            Clockgraph.rotate(Math.PI / 6);

        }
        //Calculating rotations for seconds minutes and hours

        Clockgraph.rotate(seconds * Math.PI / 30);
        Clockgraph.setStroke(new BasicStroke(1));
        Clockgraph.drawLine(0, 0, 0, -290);

        Clockgraph.rotate(2 * Math.PI - seconds * Math.PI / 30);
        Clockgraph.rotate(minutes * Math.PI / 30);
        Clockgraph.setStroke(new BasicStroke(3));
        Clockgraph.drawLine(0, 0, 0, -250);

        Clockgraph.rotate(2 * Math.PI - minutes * Math.PI / 30);
        Clockgraph.rotate(hours * Math.PI / 6);
        Clockgraph.setStroke(new BasicStroke(6));
        Clockgraph.drawLine(0, 0, 0, -150);
    }
}

