package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Display extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEMO_APP_WIDTH = 700;
	private static final int DEMO_APP_HEIGHT = 500;
	private static final String DEMO_APP_TITLE = "DEMO";
	private static final String DEMO_APP_PATH_IMAGE_ICON = "E:\\workspace\\sorting-algorithms.png";
	private JButton btRun;
	private JButton btReset;
	private JButton btExit;
	private JTextField input;
	private JTextField viewResultOfBubbleSort;
	private JTextField viewResultOfSelectionSort;
	private JTextField viewResultOfQuickSort;
	private JTextField viewResultOfMergeSort;
	private JComboBox<String> browseBox;
	private JComboBox<String> orderBox;
	private JTextField viewTimeOfBubbleSort;
	private JTextField viewTimeOfSelectionSort;
	private JTextField viewTimeOfQuickSort;
	private JTextField viewTimeOfMergeSort;
	private Input data = new Input();

	public Display() {
		GUI();
		controlEvents();
	}

	public static void main(String[] args) {
		Display display = new Display();
		display.setVisible(true);
	}

	private void GUI() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(DEMO_APP_TITLE);
		setSize(DEMO_APP_WIDTH, DEMO_APP_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel jpanel = new JPanel();
		add(jpanel);
		initComponents(jpanel);

		ImageIcon imageIcon = new ImageIcon(DEMO_APP_PATH_IMAGE_ICON);
		setIconImage(imageIcon.getImage());
	}

	private void initComponents(JPanel jpanel) {
		jpanel.setLayout(null);

		JLabel inputLabel = new JLabel("Input:");
		inputLabel.setBounds(20, 10, 50, 30);
		jpanel.add(inputLabel);

		input = new JTextField("");
		input.setBounds(120, 10, 550, 30);
		jpanel.add(input);

		JLabel browseLabel = new JLabel("Browse:");
		browseLabel.setBounds(20, 60, 50, 30);
		jpanel.add(browseLabel);

		browseBox = new JComboBox<>();
		browseBox.setBounds(120, 60, 150, 30);
		browseBox.addItem("Input numbers");
		browseBox.addItem("10 items");
		browseBox.addItem("100 items");
		browseBox.addItem("1000 items");

		jpanel.add(browseBox);

		JLabel orderLabel = new JLabel("Order:");
		orderLabel.setBounds(440, 60, 50, 30);
		jpanel.add(orderLabel);

		orderBox = new JComboBox<>();
		orderBox.setBounds(520, 60, 150, 30);
		orderBox.addItem("Ascending");
		orderBox.addItem("Descending");
		jpanel.add(orderBox);

		JLabel sortingAlgorithm = new JLabel("Sorting Algorithm");
		sortingAlgorithm.setBounds(20, 120, 100, 30);
		jpanel.add(sortingAlgorithm);

		JLabel result = new JLabel("Result");
		result.setBounds(300, 120, 100, 30);
		jpanel.add(result);

		JLabel timeLabel = new JLabel("Time");
		timeLabel.setBounds(600, 120, 100, 30);
		jpanel.add(timeLabel);

		JLabel label = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		label.setBounds(0, 150, 700, 5);
		jpanel.add(label);

		JLabel bubbleSortLabel = new JLabel("Bubble Sort:");
		bubbleSortLabel.setBounds(20, 170, 100, 30);
		jpanel.add(bubbleSortLabel);

		viewResultOfBubbleSort = new JTextField();
		viewResultOfBubbleSort.setBounds(120, 170, 450, 30);
		jpanel.add(viewResultOfBubbleSort);

		viewTimeOfBubbleSort = new JTextField();
		viewTimeOfBubbleSort.setBounds(580, 170, 90, 30);
		jpanel.add(viewTimeOfBubbleSort);

		JLabel selectionSortLabel = new JLabel("Selection Sort:");
		selectionSortLabel.setBounds(20, 220, 100, 30);
		jpanel.add(selectionSortLabel);

		viewResultOfSelectionSort = new JTextField();
		viewResultOfSelectionSort.setBounds(120, 220, 450, 30);
		jpanel.add(viewResultOfSelectionSort);

		viewTimeOfSelectionSort = new JTextField();
		viewTimeOfSelectionSort.setBounds(580, 220, 90, 30);
		jpanel.add(viewTimeOfSelectionSort);

		JLabel quickSortLabel = new JLabel("Quick Sort");
		quickSortLabel.setBounds(20, 270, 100, 30);
		jpanel.add(quickSortLabel);

		viewResultOfQuickSort = new JTextField();
		viewResultOfQuickSort.setBounds(120, 270, 450, 30);
		jpanel.add(viewResultOfQuickSort);

		viewTimeOfQuickSort = new JTextField();
		viewTimeOfQuickSort.setBounds(580, 270, 90, 30);
		jpanel.add(viewTimeOfQuickSort);

		JLabel mergeSortLabel = new JLabel("Merge Sort");
		mergeSortLabel.setBounds(20, 320, 100, 30);
		jpanel.add(mergeSortLabel);

		viewResultOfMergeSort = new JTextField();
		viewResultOfMergeSort.setBounds(120, 320, 450, 30);
		jpanel.add(viewResultOfMergeSort);

		viewTimeOfMergeSort = new JTextField();
		viewTimeOfMergeSort.setBounds(580, 320, 90, 30);
		jpanel.add(viewTimeOfMergeSort);

		btRun = new JButton("Run");
		btRun.setBounds(100, 380, 100, 30);

		jpanel.add(btRun);

		btReset = new JButton("Reset");
		btReset.setBounds(300, 380, 100, 30);

		jpanel.add(btReset);

		btExit = new JButton("Exit");
		btExit.setBounds(500, 380, 100, 30);

		jpanel.add(btExit);
	}

	private void controlEvents() {
		btRunEvents();
		btResetEvents();
		btExitEvents();
		browseBoxEvents();
	}

	private void browseBoxEvents() {
		browseBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (browseBox.getSelectedIndex() == 0) {
					input.setText("");
				}
				if (browseBox.getSelectedIndex() == 1) {
					input.setText(Input.ArrayToString(data.inputByRandom(10)));
				}
				if (browseBox.getSelectedIndex() == 2) {
					input.setText(Input.ArrayToString(data.inputByRandom(100)));
				}
				if (browseBox.getSelectedIndex() == 3) {
					input.setText(Input.ArrayToString(data.inputByRandom(100)));
				}
			}
		});

	}

	private void btRunEvents() {
		btRun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (input.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Please input numbers!");
				} else {
					int[] numbers = data.StringToArray(input.getText());
					if (orderBox.getSelectedIndex() == 0) {
						printResult(numbers, "ASC");
					} else {
						printResult(numbers, "DESC");
					}
				}
			}
		});
	}

	private void btResetEvents() {
		btReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				input.setText("");
				viewResultOfBubbleSort.setText("");
				viewResultOfSelectionSort.setText("");
				viewResultOfQuickSort.setText("");
				viewResultOfMergeSort.setText("");
			}
		});
	}

	private void btExitEvents() {
		btExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void printResult(int[] numbers, String ad) {
		Sort sort = new Sort();
		Result result = new Result();

		Result bubbleResult = null;
		Result selectionResult = null;
		Result quickResult = null;
		Result mergeResult = null;
		if (ad.equals("ASC")) {
			bubbleResult = result.TestSortingAlgorithm(sort::bubbleSort, (a, b) -> a > b, numbers);

			selectionResult = result.TestSortingAlgorithm(sort::selectionSort, (a, b) -> a < b, numbers);

			quickResult = result.TestSortingAlgorithm(sort::quickSortMethod, (a, b) -> a < b, numbers);

			mergeResult = result.TestSortingAlgorithm(sort::mergeSortMethod, (a, b) -> a < b, numbers);
		}
		if (ad.equals("DESC")) {
			bubbleResult = result.TestSortingAlgorithm(sort::bubbleSort, (a, b) -> a < b, numbers);

			selectionResult = result.TestSortingAlgorithm(sort::selectionSort, (a, b) -> a > b, numbers);

			quickResult = result.TestSortingAlgorithm(sort::quickSortMethod, (a, b) -> a > b, numbers);

			mergeResult = result.TestSortingAlgorithm(sort::mergeSortMethod, (a, b) -> a > b, numbers);

		}
		viewResultOfBubbleSort.setText(Input.ArrayToString(bubbleResult.numbers));
		viewTimeOfBubbleSort.setText(String.valueOf(bubbleResult.time + " ms"));

		viewResultOfSelectionSort.setText(Input.ArrayToString(selectionResult.numbers));
		viewTimeOfSelectionSort.setText(String.valueOf(selectionResult.time + " ms"));

		viewResultOfQuickSort.setText(Input.ArrayToString(quickResult.numbers));
		viewTimeOfQuickSort.setText(String.valueOf(quickResult.time + " ms"));

		viewResultOfMergeSort.setText(Input.ArrayToString(mergeResult.numbers));
		viewTimeOfMergeSort.setText(String.valueOf(mergeResult.time + " ms"));
	}

}
