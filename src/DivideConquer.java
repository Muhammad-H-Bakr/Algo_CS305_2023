import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.Arrays;

public class DivideConquer extends JFrame {
    DivideConquer() {
        super("D&C");
        initComponents();
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jLabel1.setText("Enter an Array:");
        jButton1.setText("Start");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jLabel2.setText("Result:");
        jLabel4.setText("Time estimated:");
        jButton2.setText("Graph");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        //Inserting components:
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 93, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(162, 162, 162)
                                                                .addComponent(jButton1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(161, 161, 161)
                                                                .addComponent(jButton2)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }

    //Algorithm testing:
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource().equals(jButton1)) {
            String helper = jTextField1.getText();
            String[] nums = helper.split(" ");
            int[] numbers = new int[nums.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(nums[i]);
            }
            long t1 = System.nanoTime();
            DCAlgo.mergeSort3(numbers.length, numbers);
            long t2 = System.nanoTime();
            jLabel3.setText(Arrays.toString(numbers));
            jLabel5.setText((t2 - t1) + " ns");
        }
    }

    //Graphing:
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource().equals(jButton2)) {
            XYSeries plot = new XYSeries("Sort");
            for (int i = 1; i <= 300000; i *= 2) {
                int[] arr = new int[i];
                DCAlgo.fillArray(arr);
                long t1 = System.nanoTime();
                DCAlgo.mergeSort3(i, arr);
                long t2 = System.nanoTime();
                plot.add(i, t2 - t1);
            }
            XYSeriesCollection data = new XYSeriesCollection();
            data.addSeries(plot);
            JFreeChart chart = ChartFactory.createXYLineChart("3-way Merge",
                    "Size", "Time (ns)", data, PlotOrientation.VERTICAL,
                    true, true, false);
            ChartPanel panel = new ChartPanel(chart);
            JFrame plotPanel = new JFrame("Plot");
            plotPanel.setContentPane(panel);
            plotPanel.setSize(400, 400);
            plotPanel.setVisible(true);
        }
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private final JLabel jLabel2 = new JLabel();
    private final JLabel jLabel3 = new JLabel();
    private final JLabel jLabel4 = new JLabel();
    private final JLabel jLabel1 = new JLabel();

}
