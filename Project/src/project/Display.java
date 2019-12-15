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

public class Display extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEMO_APP_WIDTH = 700;
	private static final int DEMO_APP_HEIGHT = 500;
	private static final String DEMO_APP_TITLE = "DEMO";
	JButton viewButton;
	JButton resetButton;
	JButton exitButton;
	JTextField input;
	JTextField viewResultOfBubbleSort;
	JTextField viewResultOfSelectionSort;
	JTextField viewResultOfQuickSort;
	JTextField viewResultOfMergeSort;
	JComboBox<String> browseBox;
	JComboBox<String> orderBox;
	JTextField viewTimeOfBubbleSort;
	JTextField viewTimeOfSelectionSort;
	JTextField viewTimeOfQuickSort;
	JTextField viewTimeOfMergeSort;
	Input data = new Input();

	public Display() {
		GUI();
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

		JPanel jpanel = new JPanel();
		add(jpanel);
		initComponents(jpanel);

		ImageIcon imageIcon = new ImageIcon("E:\\workspace\\sorting-algorithms.png");
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

		browseBox.addActionListener(this);

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

		viewButton = new JButton();
		viewButton.setBounds(100, 380, 100, 30);
		viewButton.setText("Run");
		viewButton.addActionListener(this);

		jpanel.add(viewButton);

		resetButton = new JButton();
		resetButton.setBounds(300, 380, 100, 30);
		resetButton.setText("Reset");
		resetButton.addActionListener(this);

		jpanel.add(resetButton);

		exitButton = new JButton();
		exitButton.setBounds(500, 380, 100, 30);
		exitButton.setText("Exit");
		exitButton.addActionListener(this);
		jpanel.add(exitButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == browseBox) {
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
		if (e.getSource() == viewButton) {
			if (input.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please input numbers!");
			} else {
				int[] numbers = data.StringToArray(input.getText());
				printResult(numbers);
			}
		}
		if (e.getSource() == resetButton) {

			input.setText("");
			viewResultOfBubbleSort.setText("");
			viewResultOfSelectionSort.setText("");
			viewResultOfQuickSort.setText("");
			viewResultOfMergeSort.setText("");

		}
		if (e.getSource() == exitButton) {
			System.exit(0);

		}
	}

	private void printResult(int[] numbers) {
		Sort sort = new Sort();
		Result result = new Result();
		Result bubbleResult = result.TestSortingAlgorithm(sort::bubbleSort, numbers);
		viewResultOfBubbleSort.setText(Input.ArrayToString(bubbleResult.numbers));
		viewTimeOfBubbleSort.setText(String.valueOf(bubbleResult.time + " ms"));

		Result selectionResult = result.TestSortingAlgorithm(sort::selectionSort, numbers);
		viewResultOfSelectionSort.setText(Input.ArrayToString(selectionResult.numbers));
		viewTimeOfSelectionSort.setText(String.valueOf(selectionResult.time + " ms"));

		Result quickResult = result.TestSortingAlgorithm(sort::quickSortMethod, numbers);
		viewResultOfQuickSort.setText(Input.ArrayToString(quickResult.numbers));
		viewTimeOfQuickSort.setText(String.valueOf(quickResult.time + " ms"));

		Result mergeResult = result.TestSortingAlgorithm(sort::mergeSortMethod, numbers);
		viewResultOfMergeSort.setText(Input.ArrayToString(mergeResult.numbers));
		viewTimeOfMergeSort.setText(String.valueOf(mergeResult.time + " ms"));

	}

}
