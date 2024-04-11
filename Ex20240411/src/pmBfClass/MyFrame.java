package pmBfClass;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private File f;
	private JTextArea textArea;
	private JFileChooser jfc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create JFileChooser
	public void makeJFC() {
		jfc = new JFileChooser("C:/My_Study");
	}
	
	// 
	
	public void actionJFC(int cmd, String action){
		//cmd가 0이면(Approve 옵션)과 같다면
		switch(action) {
		case "Open" :
			if(cmd == JFileChooser.APPROVE_OPTION) {
				// [열기] 버튼을 선택했을 때 이 [열기]버튼은 파일을
				// 선택하지 않고는 누를 수 없다.
				// 그래서 사용자가 선택한 파일을 얻어낸다.
				
				f = jfc.getSelectedFile();
				
				// 위의 파일과 스트림을 연결하여 생성
				
				BufferedInputStream br = null;
				
				try {
					br = new BufferedInputStream(new FileInputStream(f));
					int size = -1;
					byte[] buf = new byte[4096];
					while((size = br.read(buf))!=-1) {
						textArea.append(new String(buf, 0, size));
						
					}
					textArea.setCaretPosition(0); // 화면이동
					
				} catch (Exception e2) {
				} finally {
					try {
						if(br != null) {
							br.close();
						}
					} catch (Exception e3) {}
				}
				}
				break;
		case "Save" :
			if(cmd == JFileChooser.APPROVE_OPTION) {
				// [열기] 버튼을 선택했을 때 이 [열기]버튼은 파일을
				// 선택하지 않고는 누를 수 없다.
				// 그래서 사용자가 선택한 파일을 얻어낸다.
				
				f = jfc.getSelectedFile();
				
				// 위의 파일과 스트림을 연결하여 생성
				
				BufferedOutputStream bw = null;
				
				try {
					bw = new BufferedOutputStream(new FileOutputStream(f));
					bw.write(textArea.getText().getBytes());
					bw.flush();
					
				} catch (Exception e2) {
				} finally {
					try {
						if(bw != null) {
							bw.close();
						}
					} catch (Exception e3) {}
				}
				}
				break;

		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 392);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		

		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				makeJFC();
				
				// 파일선택기를 보여주면서 사용자가 선택한 버튼의 종류를 받아둬야한다.
				int cmd = jfc.showOpenDialog(MyFrame.this);
				
				actionJFC(cmd,"Open");
				
			}
		});
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				makeJFC();
				
				int cmd = jfc.showSaveDialog(MyFrame.this);
				
				actionJFC(cmd,"Save");
				
				
			}
		});
		
		
	}

}
