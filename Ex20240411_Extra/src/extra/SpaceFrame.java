package extra;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class SpaceFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	Image backImg1, backImg2, gunship;
	int back1Y,back2Y, gunX, gunY;
	
	// 배경을 이동시켜주는 스레드
	Thread thread = new Thread() {
		// 스레드를 상속받는 이름없는 내부클래스 영역

		@Override
		public void run() {
			int spaceHeight = SpaceFrame.this.getHeight();
			// 스레드가 해야할 일들
			back2Y = spaceHeight * -1; // 양수를 음수로 변환
			while(true) {
				back1Y += 5; // y값 증가했으니 다시 그려야 한다.
				back2Y += 5; // 얘도 같이 증가해야한다.
				
				if(back1Y > spaceHeight) {
					back1Y = spaceHeight * -1;
				} else if (back2Y > spaceHeight) {
					back2Y = spaceHeight * -1;
				}
				
				panel.repaint();
				
				try {
					Thread.sleep(20);
				} catch (Exception e) {}
			}
		}
		
		
	};
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceFrame frame = new SpaceFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SpaceFrame() {
		
		gunX = 260;
		gunY = 700;
		
		
		
		// Generate Images
		backImg1 = new ImageIcon("src/images/space.jpg").getImage();
		backImg2 = new ImageIcon("src/images/space.jpg").getImage();
		gunship = new ImageIcon("src/images/gunship.png").getImage();
		
		panel = new JPanel() {
			// JPanel을 상속받는 이름없는 내부클래스
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(backImg1, 0, back1Y, this);
				g.drawImage(backImg2, 0, back2Y, this);
				
				g.drawImage(gunship, gunX, gunY, this);
			}
		};
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 869);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		thread.start();
	}

}
