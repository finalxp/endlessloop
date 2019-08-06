package cn.xs.main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.xs.utils.AudioUtils;
import cn.xs.utils.FileUtilsTwo;

public class audiotobase64tool extends JFrame implements MouseListener{
	
	private static JFrame jFrame;
	private static JLabel jLabel_fileOpen;
	private static JTextField jTextField_fileDirectory;
	private static JButton jButton_fileOpen;
	private static JPanel jPanel_start;
	private static JButton jButton_start;
	private static JLabel jLabel_message;
	private String string_file;

	public static void main(String[] args) {
		
		audiotobase64tool audiotobase64tool = new audiotobase64tool();
		
		audiotobase64tool.demo();
		
		
	}

	private void demo() {
		
		string_file = new String();
		
		jLabel_fileOpen = new JLabel("文件选择:");
		jTextField_fileDirectory = new JTextField();
		jTextField_fileDirectory.setPreferredSize(new Dimension(200, 30));
		jButton_fileOpen = new JButton("打开目录");
		jButton_fileOpen.addMouseListener(this);
		
		jButton_start = new JButton("开始转换");
		
		jLabel_message = new JLabel("生成文件存放于文件选择目录下");
		
		JPanel jPanel = new JPanel();
		jPanel.add(jLabel_fileOpen);
		jPanel.add(jTextField_fileDirectory);
		jPanel.add(jButton_fileOpen);
		add(jPanel);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.add(jButton_start);
		add(jPanel2);
		
		JPanel jPanel3 = new JPanel();
		jPanel3.add(jLabel_message);
		add(jPanel3);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setTitle("音频转BASE64工具");
		setSize(450,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void doFileChoose() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showDialog(jFrame, "请选择输出路径");
		System.out.println(result + "");
		if (result == JFileChooser.APPROVE_OPTION) {
			jLabel_fileOpen.setText(fileChooser.getSelectedFile()
					.getAbsolutePath());
			
			string_file = jLabel_fileOpen.toString();
			

		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(jButton_fileOpen)) {	
			doFileChoose();	
		}else if (e.getSource().equals(jButton_start)) {
			doStart();
		}
		
	}

	private void doStart() {
		List<String> files = FileUtilsTwo.getFiles(string_file);
		for (String string : files) {
			byte[] readAudioData = AudioUtils.readAudioData(string);
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
