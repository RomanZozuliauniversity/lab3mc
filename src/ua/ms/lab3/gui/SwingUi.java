package ua.ms.lab3.gui;


import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

public class SwingUi {
    private final int COUNT_OF_COLUMNS = 6;
    private final int COUNT_OF_ROWS = 6;
    private final int COUNT_COL_OF_OUTPUT_TABLE = 2;
    private JFrame frame;
    private JPanel mainPanel;
    private JTable inputDataTable;
    private JTable outputDataTable;
    private JTable outputTable;
    private JTable probabilityTable;
    private final double c1 = 0.2309;
    private JTextArea tactArea;
    private JTextArea probablyArea;
    private JButton calculate;

    public void createUi() {
        createWindow();
        calculateData();
    }

    private void createWindow() {
        createFrame();
        createMainPanel();
        addElements();
    }

    private void createFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        frame = new JFrame("Лабораторна робота 3");
        frame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 350, 1000, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        frame.add(mainPanel);
    }

    private void addElements() {
        addInputDataTable();
        addOutputDataTable();
        addOutputTable();
        addProbabilityTable();
        addLabels();
        createTactAndProbablyTextAreas();
        createButton();
    }

    private void createButton() {
        calculate = new JButton("Обчислити");
        calculate.setBounds(80, 500, 100, 35);
        mainPanel.add(calculate);
    }

    private void addInputDataTable() {
        inputDataTable = createInputDataTable();
        mainPanel.add(inputDataTable);
    }

    private JTable createInputDataTable() {
        JTable table = createTable(COUNT_OF_COLUMNS, COUNT_OF_ROWS);
        table.setBounds(80, 70, 350, COUNT_OF_ROWS * 30);
        return table;
    }

    private void addOutputDataTable() {
        outputDataTable = createOutputDataTable();
        mainPanel.add(outputDataTable);
    }

    private JTable createOutputDataTable() {
        JTable table = createTable(COUNT_OF_COLUMNS, COUNT_OF_ROWS);
        table.setBounds(490, 70, 350, COUNT_OF_ROWS * 30);
        return table;
    }

    private void addOutputTable() {
        outputTable = createOutputTable();
        mainPanel.add(outputTable);
    }

    private JTable createOutputTable() {
        JTable table = createTable(COUNT_COL_OF_OUTPUT_TABLE, COUNT_OF_ROWS);
        table.setBounds(80, 320, 350, COUNT_COL_OF_OUTPUT_TABLE * 30);
        return table;
    }

    private void addProbabilityTable() {
        probabilityTable = createProbabilityTable();
        mainPanel.add(probabilityTable);
    }

    private JTable createProbabilityTable() {
        JTable table = createTable(COUNT_COL_OF_OUTPUT_TABLE, COUNT_OF_ROWS);
        table.setBounds(490, 320, 350, COUNT_COL_OF_OUTPUT_TABLE * 30);
        return table;
    }

    private JTable createTable(int col, int rows) {
        JTable table = new JTable(col, rows);
        initializeColumn(table, col);
        initializeRow(table, rows);
        table.setRowHeight(30);
        return table;
    }

    private void initializeColumn(JTable table, int count) {
        for (int i = 1; i < count; i++) {
            table.setValueAt(i, i, 0);
        }
    }

    private void initializeRow(JTable table, int count) {
        table.setValueAt("N", 0, 0);
        for (int i = 1; i < count; i++) {
            table.setValueAt("z" + i, 0, i);
        }
    }

    private void addLabels() {
        createInputLabel();
        createOutputDataLabel();
        createOutputLabel();
        createProbabilityLabel();
        createCountBeatsLabel();
        createMainProbablyLabel();
    }

    private void createInputLabel() {
        JLabel label = createLabel("Вхідні дані:");
        label.setBounds(80, 20, 200, 30);
        mainPanel.add(label);
    }

    private void createOutputDataLabel() {
        JLabel label = createLabel("Вихідні дані:");
        label.setBounds(490, 20, 200, 30);
        mainPanel.add(label);
    }

    private void createOutputLabel() {
        JLabel label = createLabel("Таблиця виходів:");
        label.setBounds(80, 290, 350, 30);
        mainPanel.add(label);
    }

    private void createProbabilityLabel() {
        JLabel label = createLabel("Таблиця ймовірностей:");
        label.setBounds(490, 290, 350, 30);
        mainPanel.add(label);
    }

    private void createCountBeatsLabel() {
        JLabel label = createLabel("Кількість тактів:");
        label.setBounds(80, 400, 350, 30);
        mainPanel.add(label);
    }

    private void createMainProbablyLabel() {
        JLabel label = createLabel("Ймовірність появи на виході автомата вихідного сигнала рівного 1");
        label.setBounds(490, 400, 800, 30);
        mainPanel.add(label);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        return label;
    }

    private void createTactAndProbablyTextAreas() {
        tactArea = new JTextArea();
        tactArea.setBounds(80, 450, 350, 30);
        mainPanel.add(tactArea);
        probablyArea = new JTextArea();
        probablyArea.setBounds(490, 450, 350, 30);
        mainPanel.add(probablyArea);
    }

    private void calculateData() {
        calculate.addActionListener(e -> {
            double c2 = 1.25 * c1;
            double c3 = 0.78125 * c1;
            double c4 = 0.5625 * c1;
            double c5 = 0.736607143 * c1;

            DecimalFormat decimalFormat = new DecimalFormat();
            probabilityTable.setValueAt(decimalFormat.format(c1), 1, 1);
            probabilityTable.setValueAt(decimalFormat.format(c2), 1, 2);
            probabilityTable.setValueAt(decimalFormat.format(c3), 1, 3);
            probabilityTable.setValueAt(decimalFormat.format(c4), 1, 4);
            probabilityTable.setValueAt(decimalFormat.format(c5), 1, 5);
            Integer tactRand = Integer.parseInt(tactArea.getText()) / 5;
           // List<DataProbability> dataProbabilities = tableViewInput1.getItems();
            for (int i = 1; i < COUNT_OF_ROWS; i++) {
                Integer tactTemp = tactRand;
                if (tactTemp > 0) {
                    System.out.println(tactTemp);
                    if (getDoubleElement(i, 1) != 0) {
                        Integer integer = new Random().nextInt(tactTemp) + 1;
                        if (getDoubleElement(i, 1) < 1) outputDataTable.setValueAt((double) integer, i, 1);
                        else outputDataTable.setValueAt((double) integer + getDoubleElement(i, 1), i, 1);
                        tactTemp -= integer;
                    } else {
                        outputDataTable.setValueAt(0, i, 1);
                    }
                    System.out.println(tactTemp);
                    if (getDoubleElement(i, 2) != 0) {
                        Integer integer = new Random().nextInt(tactTemp) + 1;
                        if (getDoubleElement(i, 2) < 1) outputDataTable.setValueAt((double) integer, i, 2);
                        else outputDataTable.setValueAt((double) integer + getDoubleElement(i, 2), i, 2);
                        tactTemp -= integer;
                    } else {
                        outputDataTable.setValueAt(0, i, 2);
                    }
                    System.out.println(tactTemp);
                    if (getDoubleElement(i, 3) != 0) {
                        Integer integer = new Random().nextInt(tactTemp) + 1;
                        if (getDoubleElement(i, 3) < 1) outputDataTable.setValueAt((double) integer, i, 3);
                        else outputDataTable.setValueAt((double) integer + getDoubleElement(i, 3), i, 3);
                        tactTemp -= integer;
                    } else {
                        outputDataTable.setValueAt(0, i, 3);
                    }
                    System.out.println(tactTemp);
                    if (getDoubleElement(i, 4) != 0) {
                        Integer integer = new Random().nextInt(tactTemp) + 1;
                        if (getDoubleElement(i, 4) < 1) outputDataTable.setValueAt((double) integer, i, 4);
                        else outputDataTable.setValueAt((double) integer + getDoubleElement(i, 4), i, 4);
                        tactTemp -= integer;
                    } else {
                        outputDataTable.setValueAt(0, i, 4);
                    }
                    System.out.println(tactTemp);
                    if (getDoubleElement(i, 5) != 0.0) {
                        Integer integer = new Random().nextInt(tactTemp) + 1;
                        if (getDoubleElement(i, 5) < 1) outputDataTable.setValueAt((double) integer, i, 5);
                        else outputDataTable.setValueAt((double) integer + getDoubleElement(i, 5), i, 5);
                        tactTemp -= integer;
                    } else {
                        outputDataTable.setValueAt(0, i, 5);
                    }
                   System.out.println(tactTemp);

                }
            }
            double result = 0;
            if (getDoubleOutputData(1, 1) == 1) {
                result += c1;
            }
            if (getDoubleOutputData(1, 2) == 1) {
                result += c2;
            }
            if (getDoubleOutputData(1, 3) == 1) {
                result += c3;
            }
            if (getDoubleOutputData(1, 4) == 1) {
                result += c4;
            }
            if (getDoubleOutputData(1, 5) == 1) {
                result += c5;
            }

            probablyArea.setText(decimalFormat.format(result));
        });
    }



    private Double getDoubleOutputData(int row, int col) {
        String value = String.valueOf(outputTable.getValueAt(row, col));
        if (value != null && !value.isEmpty() && !value.equalsIgnoreCase("null")) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {

            }
        }
        return 0.6895; // or any default value you prefer
    }

    private Double getDoubleElement(int row, int col) {
       String value = String.valueOf(inputDataTable.getValueAt(row, col));
       if (value != null && !value.isEmpty() && !value.equalsIgnoreCase("null")) {
           try {
               return Double.parseDouble(value);
           } catch (NumberFormatException e) {

           }
       }
       return 0.0;
   }
}