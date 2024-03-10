import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

class CountDownTimer{
	
	JLabel counterLabel;
	Timer timer;	
	int sec, min;
	

	public static void main(String[] args) {
		
		new CountDownTimer();		
		EventQueue.invokeLater(new Runnable() {
			public void run() {

			}
		});
	}
	
	public CountDownTimer() {

		sec =0;
		min =4;
		countdownTimer();
		timer.start();						
	}
    
	public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
				
				sec--;
	
				if(sec==-1) {
					sec = 59;
					min--;
		
				}
				if(min==1&&sec==0) {
					JOptionPane.showMessageDialog(null, "Session About to close","WARNING: SESSION EXPIRING in 1 min",JOptionPane.WARNING_MESSAGE);
				}
				if(min==0 && sec==0) {
					JOptionPane.showMessageDialog(null, "Session has ended and you have been successfully logged out","SESSION EXPIRED",JOptionPane.WARNING_MESSAGE);
					timer.stop();
					System.exit(0);
					
				}
			}
		});		
	}		
}
