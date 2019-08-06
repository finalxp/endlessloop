package cn.xs.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cn.xs.api.NativeMethod.EnrolResults;
import cn.xs.api.NativeMethod.VerifyResults;

import com.sun.jna.platform.win32.WinDef.UINT;
import com.sun.jna.platform.win32.WinDef.ULONG;
import com.sun.jna.platform.win32.WinDef.ULONGByReference;

public class AppWindow implements MouseListener {
	public static void main(String[] args) {

		// path_audio
		JLabel labelDir = null;
		JLabel labelDir2 = null;// 设置空白间隔

		// path_input_enrol
		JTextField txtDirEnrol = null;
		JButton btnDirSelectedEnrol = null;

		// path_output_enrol
		JTextField txtOutputPathEnrol = null;
		JButton btnOutputPathEnrol = null;

		// path_input_verify
		JTextField txtDirVerify = null;
		JButton btnDirSelectedVerify = null;

		// start_enrol
		JButton btnEnrol = null;

		// start_validate
		JButton btnVerify = null;

		// start_separation
		JButton btnSeparation = null;

		// sampling
		JButton btnSampling8 = null;
		JButton btnSampling16 = null;

		// audio_coded
		JButton btnAudioCoded2 = null;
		JButton btnAudioCoded3 = null;
		JButton btnAudioCoded4 = null;

		// log
		TextArea taArea = new TextArea();

		// exit
		JButton btnExit = null;

		// voicePrint
		float[] voicePrint = new float[100000];

		// audioPath
		String audioPath = null;

		// audioOutputPath
		String audioOutputPath = null;

		// audioHzSelect
		UINT audioHzSelect = new UINT(16000);

		// audioCodeSelect
		String audioCodeSelect = new String("pcm16");

		// Start
		JFrame jFrame = new JFrame();
		jFrame.setVisible(true);

		jFrame.setSize(580, 900);

		// window_change
		jFrame.setResizable(true);

		// skip_conter
		jFrame.setLocationRelativeTo(null);

		// panel_one
		JPanel panelOne = new JPanel();
		BoxLayout layoutOne = new BoxLayout(panelOne, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutOne);

		// panel_two
		JPanel panelTwo = new JPanel();
		BoxLayout layoutTwo = new BoxLayout(panelTwo, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutTwo);

		// panel_three
		JPanel panelThree = new JPanel();
		BoxLayout layoutThree = new BoxLayout(panelThree, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutThree);

		// panel_four
		JPanel panelFour = new JPanel();
		BoxLayout layoutFour = new BoxLayout(panelFour, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutFour);

		// panel_five
		JPanel panelFive = new JPanel();
		BoxLayout layoutFive = new BoxLayout(panelFive, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutFive);

		// panel_six
		JPanel panelSix = new JPanel();
		BoxLayout layoutSix = new BoxLayout(panelSix, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutSix);

		// panel_seven
		JPanel panelSeven = new JPanel();
		BoxLayout layoutSeven = new BoxLayout(panelSeven, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutSeven);

		// panel_nigt
		JPanel panelNigt = new JPanel();
		BoxLayout layoutNigt = new BoxLayout(panelNigt, BoxLayout.X_AXIS);
		panelOne.setLayout(layoutNigt);

		// set blank space
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(3, 5, 5, 3));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 99999, 5));
		contentPane.setBounds(5, 5, 5, 5);

		jFrame.setContentPane(contentPane);

		// path_input
		panelOne.setLayout(new FlowLayout(8));
		labelDir = new JLabel("输入文件目录:");
		panelOne.add(labelDir);

		txtDirEnrol = new JTextField();
		txtDirEnrol.setPreferredSize(new Dimension(280, 30));
		txtDirEnrol.setEditable(false);
		panelOne.add(txtDirEnrol);

		btnDirSelectedEnrol = new JButton("音频输入选择");
		btnDirSelectedEnrol.addMouseListener(null);
		panelOne.add(btnDirSelectedEnrol);
		jFrame.add(panelOne);

		// path_output
		panelTwo.setLayout(new FlowLayout(8));
		labelDir = new JLabel("输出文件路径:");
		panelTwo.add(labelDir);

		txtOutputPathEnrol = new JTextField();
		txtOutputPathEnrol.setPreferredSize(new Dimension(280, 30));
		txtOutputPathEnrol.setEditable(false);
		panelTwo.add(txtOutputPathEnrol);

		btnOutputPathEnrol = new JButton("音频输出路径");
		btnOutputPathEnrol.addMouseListener(null);
		panelTwo.add(btnOutputPathEnrol);
		jFrame.add(panelTwo);

		// path_input_verify
		panelThree.setLayout(new FlowLayout(8));
		labelDir = new JLabel("对照文件目录:");
		panelThree.add(labelDir);

		txtDirVerify = new JTextField();
		txtDirVerify.setPreferredSize(new Dimension(280, 30));
		txtDirVerify.setEditable(false);
		panelThree.add(txtDirVerify);

		btnDirSelectedVerify = new JButton("特征文件选择");
		btnDirSelectedVerify.addMouseListener(null);
		panelThree.add(btnDirSelectedVerify);
		jFrame.add(panelThree);

		// sampling
		labelDir = new JLabel("采样率: ");
		btnSampling8 = new JButton("8000 ");
		btnSampling8.addMouseListener(null);
		btnSampling16 = new JButton("16000");
		btnSampling16.setEnabled(false);
		btnSampling16.addMouseListener(null);
		panelFive.add(labelDir);
		panelFive.add(btnSampling8);
		panelFive.add(btnSampling16);
		jFrame.add(panelFive);

		// audio coded
		labelDir = new JLabel("     音频编码: ");
		panelFive.add(labelDir);
		btnAudioCoded2 = new JButton("pcm16");
		btnAudioCoded2.setEnabled(false);
		btnAudioCoded2.addMouseListener(null);
		panelFive.add(btnAudioCoded2);
		btnAudioCoded3 = new JButton("alaw ");
		btnAudioCoded3.addMouseListener(null);
		panelFive.add(btnAudioCoded3);
		btnAudioCoded4 = new JButton("ulaw ");
		btnAudioCoded4.addMouseListener(null);
		panelFive.add(btnAudioCoded4);
		jFrame.add(panelFive);

		// select_thread
		labelDir = new JLabel("     线程选择: ");

		JSpinner jSpinner = new JSpinner();

		jSpinner.setModel(new SpinnerNumberModel(1, 1, 2000, 1));
		int threadNumber = (int) jSpinner.getValue();

		labelDir2 = new JLabel("             ");

		panelSix.add(labelDir);
		panelSix.add(jSpinner);
		panelSix.add(labelDir2);
		jFrame.add(panelSix);

		// enrol
		btnEnrol = new JButton("开始注册");
		btnEnrol.setBackground(Color.CYAN);
		btnEnrol.addMouseListener(null);
		panelSix.add(btnEnrol);
		jFrame.add(panelSix);

		// vailfy
		btnVerify = new JButton("开始验证");
		btnVerify.setBackground(Color.green);
		btnVerify.addMouseListener(null);
		panelSix.add(btnVerify);
		jFrame.add(panelSix);

		// separation
		btnSeparation = new JButton("开始剥离");
		btnSeparation.setBackground(Color.orange);
		btnSeparation.addMouseListener(null);
		panelSix.add(btnSeparation);
		jFrame.add(panelSix);

		// log
		taArea.setBackground(Color.white);
		taArea.setSize(90, 90);
		taArea.setRows(37);
		taArea.setColumns(68);
		taArea.setEditable(false);
		taArea.setText("log日志信息:" + "\r\n");
		taArea.append("您默认选择了：单线程，音频采样率16000hz，音频格式pcm16。\r\n可在界面更换选项\r\n");

		jFrame.add(taArea);
		jFrame.add(panelNigt);

		// exit
		labelDir = new JLabel(
				"                                                                                                                      ");
		btnExit = new JButton("退出程序");
		btnExit.setBackground(Color.red);
		btnExit.addMouseListener(null);
		panelNigt.add(labelDir);
		panelNigt.add(btnExit);
		jFrame.add(panelNigt);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
