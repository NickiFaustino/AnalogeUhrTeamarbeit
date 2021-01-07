package at.ac.fhcampuswien;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Clock {

    public static void main(String[] args) {
        new Clock();
    }

    public Clock() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Analog Clock");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new at.ac.fhcampuswien.ClockFace());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
