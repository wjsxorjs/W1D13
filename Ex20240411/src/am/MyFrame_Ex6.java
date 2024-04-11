package am;

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class MyFrame_Ex6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private File f;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame_Ex6 frame = new MyFrame_Ex6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void saveData() {
		//바로 저장하기
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new PrintWriter(f));
			
			// 저장할 자원은 JTextArea에 있는 문자열들이다.
			String str = textArea.getText();
			bw.write(str);
			bw.flush();
			this.setTitle(f.getAbsolutePath());
			
		}catch (Exception e1) {}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {}
		}
	}
	
	private void saveFile() {
		// 파일선택기 생성
		JFileChooser jfc = new JFileChooser("C:/My_Study");
		
		int cmd = jfc.showSaveDialog(MyFrame_Ex6.this);
		
		if(cmd == JFileChooser.APPROVE_OPTION) {
			f = jfc.getSelectedFile();
			saveData();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public MyFrame_Ex6() {
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
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일이 이미 열려있는 상태라면 그대로 저장한다.
				// 그렇지 않을때만 파일 선택기를 생성하고 보여준다.

				if(f != null) {
					saveData();
				} else {
					saveFile();
				}
				
			}
		});
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
				JFileChooser jfc = new JFileChooser("C:/My_Study");
				
				// 파일선택기를 보여주면서 사용자가 선택한 버튼의 종류를 받아둬야한다.
				
				int cmd = jfc.showOpenDialog(MyFrame_Ex6.this);
				
				//cmd가 0이면(Approve 옵션)과 같다면
				if(cmd == JFileChooser.APPROVE_OPTION) {
					
					// [열기] 버튼을 선택했을 때 이 [열기]버튼은 파일을
					// 선택하지 않고는 누를 수 없다.
					// 그래서 사용자가 선택한 파일을 얻어낸다.
					
					f = jfc.getSelectedFile();
					
					// 위의 파일과 스트림을 연결하여 생성
					
					BufferedReader br = null;
//					StringBuffer sb = new StringBuffer("");
					
					try {
						br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
						String str = null;
						textArea.setText("");
						while((str = br.readLine())!=null) {
//							sb.append(str);
//							sb.append("\r\n");
							textArea.append(str);
							textArea.append("\r\n");
							
						}
						textArea.setCaretPosition(0); // 화면이동
//						textArea.setText(sb.toString());
						
					} catch (Exception e2) {
					} finally {
						try {
							if(br != null) {
								br.close();
							}
						} catch (Exception e3) {}
					}
					
				}
			}
		});
	}

}
