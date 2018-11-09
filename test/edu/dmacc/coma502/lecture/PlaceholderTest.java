package edu.dmacc.coma502.lecture;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Test;

public class PlaceholderTest {

	@Test
	public void test() {
		File inputFile = new File("input.txt");
		Scanner in = null;
		try {
			in = new Scanner(inputFile);

			while (in.hasNext()) {
				String textFromFile = in.next();
				System.out.println(textFromFile);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}

		PrintWriter out = null;
		try {
			out = new PrintWriter("output.txt");
			out.print("> ");
			out.println("Okay, now I can write to a file");
			out.print("this is fun");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}

		URL imageLocation;
		try {
			imageLocation = new URL("http://horstmann.com/java4everyone/duke.gif");
			InputStream in2 = imageLocation.openStream();
			FileOutputStream out2 = new FileOutputStream("duke.gif");

			boolean done = false;
			while (!done) {
				int input = in2.read();
				if (input == -1) {
					done = true;
				} else {
					out2.write(input);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testWritingFile() {

		File file = null;
		try {
			file = File.createTempFile("test", ".tmp");
		} catch (IOException e1) {
			fail();
		}

		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println("Hello");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			boolean didDelete = file.delete();
//			if (didDelete) {
//				System.out.println("deleted: " + file.getAbsolutePath());
//			} else {
//				System.out.println("failed to delete: " + file.getAbsolutePath());
//			}
//			didDelete = file.delete();
//			if (didDelete) {
//				System.out.println("deleted: " + file.getAbsolutePath());
//			} else {
//				System.out.println("failed to delete: " + file.getAbsolutePath());
//			}
		}
	}
	
//	@Test
//	public void testFrame() {
//		JFrame frame1 = new JFrame();
//		frame1.setSize(300, 400);
//		frame1.setLocation(1130, 440);
//		frame1.setTitle("My Window");
//		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JButton yes = new JButton("Yes");
//		JButton no = new JButton("No");
//		JLabel label = new JLabel("Hello, World!");
//		JPanel panel = new JPanel();
//		panel.add(yes);
//		panel.add(no);
//		panel.add(label);
//		frame1.add(panel);
//		frame1.setVisible(true);
//		
//		JFrame frame2 = new JFrame();
//		frame2.setSize(300, 300);
//		frame2.setTitle("frame 2");
//		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame2.setVisible(true);
//		try {
//			Thread.sleep(20000l);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	@Test
	public void testDateTime() {
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
	}
	
	@Test
	public void testPlaceholderProcess() {
		MockLogger logger = new MockLogger();
		Placeholder ph = new Placeholder(logger);
		ph.process();
		assertTrue(logger.infoLogs().contains("processing"));
	}
	
	private class MockLogger implements Logger {

		private List<String> historyOfInfos = new ArrayList<String>(); 
		
		@Override
		public void logInfo(String message) {
			historyOfInfos.add(message);
		}
		
		public List<String> infoLogs() {
			return new ArrayList<String>(historyOfInfos);
		}
		
	}

}
