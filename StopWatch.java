package stopWatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Yuanyuan Lu
 * @create on 2022-02-10-17:33
 */
public class StopWatch implements ActionListener {
    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");//create buttons
    JButton resetButton = new JButton("Reset");
    JLabel timeLabel = new JLabel();
    int elaspedTime = 0;
    int seconds = 0;
    int minustes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d",seconds);
    String minustes_string = String.format("%02d",minustes);
    String hours_string = String.format("%02d",hours);
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elaspedTime += 1000;
            hours = (elaspedTime / 3600000);
            minustes = (elaspedTime / 60000) % 60;
            seconds = (elaspedTime / 1000) % 60;
            seconds_string = String.format("%02d",seconds);
            minustes_string = String.format("%02d",minustes);
            hours_string = String.format("%02d",hours);
            timeLabel.setText(hours_string + ":" + minustes_string + ":" + seconds_string);
        }
    });

    StopWatch(){
        timeLabel.setText(hours_string + ":" + minustes_string + ":" + seconds_string);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            if(!started){
                started = true;
                startButton.setText("Stop");
                start();
            }else {
                started = false;
                startButton.setText("Start");
                stop();
            }
        }
        if (e.getSource() == resetButton){
            started = false;
            startButton.setText("Start");
            reset();
        }
    }
    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        timer.stop();
        elaspedTime = 0;
        seconds = 0;
        minustes = 0;
        hours = 0;
        seconds_string = String.format("%02d",seconds);
        minustes_string = String.format("%02d",minustes);
        hours_string = String.format("%02d",hours);
        timeLabel.setText(hours_string + ":" + minustes_string + ":" + seconds_string);
    }
}
