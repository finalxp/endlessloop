package cn.xs.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import net.sf.json.JSONArray;
//import xs.utils.AudioUtils;
//import xs.utils.FileUtils;

//import ValidSoft.SwingWindow;

public class PostTool extends JFrame implements MouseListener {

	private JLabel URL_ADDRESS;

	private JLabel LOG_ID;

	private JLabel USER_ID;

	private JLabel BIOMETRIC_TYPE;

	private JLabel BIOMETRIC_MODE;

	private JLabel AUDIO_FORMAT;

	private JLabel AUDIO_SAMPLE;

	private JLabel AUDIO_GET_TYPE;

	private JLabel AUDIO_FILE_SELECT;

	// ---
	private JTextField urlId;

	private JTextField logId;

	private JTextField userId;

	private JComboBox biometricType;

	private JComboBox biometricMode;

	private JComboBox audioSample;

	private JComboBox audioFormat;

	private JComboBox audioGetType;

	private JTextField audioFileSelect;

	private JButton BUTTON_OPEN_FILE;

	private JButton BUTTON_POST_SEND;

	private TextArea POST_RESULT;

	private static List<String> files;

	private String audioToBase64 = null;

	//
	public PostTool() {
		// crate
		URL_ADDRESS = new JLabel("URL地址:");
		urlId = new JTextField();
		urlId.setPreferredSize(new Dimension(280, 30));
		// urlId.setText("http://192.168.18.216:8081/stdBiometricLite/enrolSpeaker");
		urlId.addMouseListener(this);

		LOG_ID = new JLabel("loggingId:");
		logId = new JTextField();
		logId.setPreferredSize(new Dimension(280, 30));
		// logId.setText("20181112");
		logId.addMouseListener(this);

		USER_ID = new JLabel("identifier:");
		userId = new JTextField();
		userId.setPreferredSize(new Dimension(280, 30));
		// userId.setText("20181112");
		userId.addMouseListener(this);

		BIOMETRIC_TYPE = new JLabel("模式选择");
		biometricType = new JComboBox();
		biometricType.setPreferredSize(new Dimension(200, 30));
		biometricType.addItem(new String("text-independent"));
		biometricType.addItem(new String("text-dependent"));
		biometricType.addMouseListener(this);

		BIOMETRIC_MODE = new JLabel("模型选择");
		biometricMode = new JComboBox();
		biometricMode.setPreferredSize(new Dimension(200, 30));
		biometricMode.addItem(new String("ti_plp2covv2"));
		biometricMode.addItem(new String("td_fuse_8_atn_v2"));
		biometricMode.addItem(new String("td_fuse_16_atn_v2"));
		biometricMode.addMouseListener(this);

		AUDIO_FORMAT = new JLabel("音频格式:");
		audioFormat = new JComboBox();
		audioFormat.setPreferredSize(new Dimension(200, 30));
		audioFormat.addItem(new String("pcm16"));
		audioFormat.addItem(new String("alaw"));
		audioFormat.addItem(new String("ulaw"));
		audioFormat.addMouseListener(this);

		AUDIO_SAMPLE = new JLabel("采样频率:");
		audioSample = new JComboBox();
		audioSample.setPreferredSize(new Dimension(200, 30));
		audioSample.addItem(new String("16000"));
		audioSample.addItem(new String("8000"));
		audioSample.addMouseListener(this);

		AUDIO_GET_TYPE = new JLabel("采集渠道:");
		audioGetType = new JComboBox();
		audioGetType.setPreferredSize(new Dimension(200, 30));
		audioGetType.addItem(new String("default"));
		audioGetType.addItem(new String("IVR"));
		audioGetType.addItem(new String("mobile"));
		audioGetType.addMouseListener(this);

		AUDIO_FILE_SELECT = new JLabel("音频选择:");
		audioFileSelect = new JTextField();
		audioFileSelect.setPreferredSize(new Dimension(180, 30));
		BUTTON_OPEN_FILE = new JButton("打开文件");
		BUTTON_OPEN_FILE.addMouseListener(this);

		BUTTON_POST_SEND = new JButton("   发   送   ");
		BUTTON_POST_SEND.setBackground(Color.red);
		BUTTON_POST_SEND.addMouseListener(this);

		POST_RESULT = new TextArea("", 20, 50);

		// add
		JPanel jPanel_url = new JPanel();
		jPanel_url.add(URL_ADDRESS);
		jPanel_url.add(urlId);

		JPanel jPanel_log = new JPanel();
		jPanel_log.add(LOG_ID);
		jPanel_log.add(logId);

		JPanel jPanel_user_id = new JPanel();
		jPanel_user_id.add(USER_ID);
		jPanel_user_id.add(userId);

		JPanel jPanel_biometric_type = new JPanel();
		jPanel_biometric_type.add(BIOMETRIC_TYPE);
		jPanel_biometric_type.add(biometricType);

		JPanel jPanel_biometric_mode = new JPanel();
		jPanel_biometric_mode.add(BIOMETRIC_MODE);
		jPanel_biometric_mode.add(biometricMode);

		JPanel jPanel_format = new JPanel();
		jPanel_format.add(AUDIO_FORMAT);
		jPanel_format.add(audioFormat);

		JPanel jPanel_sample = new JPanel();
		jPanel_sample.add(AUDIO_SAMPLE);
		jPanel_sample.add(audioSample);

		JPanel jPanel_get_type = new JPanel();
		jPanel_get_type.add(AUDIO_GET_TYPE);
		jPanel_get_type.add(audioGetType);

		JPanel jPanel_open_file = new JPanel();
		jPanel_open_file.add(AUDIO_FILE_SELECT);
		jPanel_open_file.add(audioFileSelect);
		jPanel_open_file.add(BUTTON_OPEN_FILE);

		JPanel jPanel_post_send = new JPanel();
		jPanel_post_send.add(BUTTON_POST_SEND);

		JPanel jPanel_test_area = new JPanel();
		jPanel_test_area.add(POST_RESULT);

		// final
		this.setTitle("效生POST工具");
		this.setSize(450, 850);
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.getContentPane().add(jPanel_url);
		this.getContentPane().add(jPanel_log);
		this.getContentPane().add(jPanel_user_id);
		this.getContentPane().add(jPanel_biometric_type);
		this.getContentPane().add(jPanel_biometric_mode);
		this.getContentPane().add(jPanel_format);
		this.getContentPane().add(jPanel_sample);
		this.getContentPane().add(jPanel_get_type);
		this.getContentPane().add(jPanel_open_file);
		this.getContentPane().add(jPanel_post_send);
		this.getContentPane().add(jPanel_test_area);

	}

	public static void main(String[] args) {
		PostTool testBorderLayout = new PostTool();

	}

	private void doFileChoose() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showDialog(this, "请选择输出路径");
		System.out.println(result + "");
		if (result == JFileChooser.APPROVE_OPTION) {
			audioFileSelect.setText(fileChooser.getSelectedFile().getAbsolutePath());

			//files = FileUtils.getFiles(audioFileSelect.getText(), true);

			System.out.println("file -->" + files);

			for (String string : files) {
				System.out.println("file -->" + string);

				//byte[] readFile = AudioUtils.readFile(string, 0);

				//audioToBase64 = new String(readFile);
				System.out.println(audioToBase64);

			}

		}

	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(BUTTON_OPEN_FILE)) {	
			doFileChoose();	
		}else if (e.getSource().equals(BUTTON_POST_SEND)) {
			
			
			String payload_2 = "{\r\n" + 
					"  \"serviceData\": {\r\n" + 
					"    \"loggingId\": \""+logId.getText().toString()+"\"\r\n" + 
					"  },\r\n" + 
					"  \"userData\": {\r\n" + 
					"    \"identifier\": \""+userId.getText().toString()+"\"\r\n" + 
					"  },\r\n" + 
					"  \"processingInformation\": {\r\n" + 
					"    \"biometric\": {\r\n" + 
					"      \"type\": \""+biometricType.getSelectedItem().toString()+"\",\r\n" + 
					"      \"mode\": \""+biometricMode.getSelectedItem().toString()+"\"\r\n" + 
					"    },\r\n" + 
					"    \"audioCharacteristics\": {\r\n" + 
					"      \"samplingRate\": \""+audioSample.getSelectedItem().toString()+"\",\r\n" + 
					"      \"format\": \""+audioFormat.getSelectedItem().toString()+"\"\r\n" + 
					"    },\r\n" + 
					"    \"metaInformation\": [\r\n" + 
					"      {\r\n" + 
					"        \"key\": \"usage-context\",\r\n" + 
					"        \"value\": {\r\n" + 
					"          \"value\": \""+audioGetType.getSelectedItem().toString()+"\",\r\n" + 
					"          \"encrypted\": \"false\"\r\n" + 
					"        }\r\n" + 
					"      },{\r\n" + 
					"        \"key\": \"detect-replay-v2-16k\",\r\n" + 
					"        \"value\": {\r\n" + 
					"          \"value\": \"default\",\r\n" + 
					"          \"encrypted\": \"false\"\r\n" + 
					"        }\r\n" + 
					"      }\r\n" + 
					"    ]\r\n" + 
					"  },\r\n" + 
					"  \"audioInput\": {\r\n" + 
					"    \"secondsThreshold\": \"0\",\r\n" + 
					"    \"audio\": {\r\n" +
					"      \"base64\": \""+audioToBase64+"\"\r\n" +				
					"    }\r\n" + 
					"  }\r\n" + 
					"}";
			
			
			
			
			
			

			System.out.println(payload_2);
			String sendPost = sendPost(urlId.getText().toString(), payload_2);
			POST_RESULT.append(sendPost);
			POST_RESULT.append("\r\n");
			System.out.println(sendPost);
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

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;

			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
