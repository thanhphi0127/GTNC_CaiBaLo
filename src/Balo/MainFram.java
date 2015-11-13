/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author NguyenThanh
 */
public class MainFram extends javax.swing.JFrame {

    /**
     * Creates new form MainFram
     */
    int weightBag;
    int numOfItem;
    Balo balo = new Balo();
    Dovat dvGreedy[]=new Dovat[100];
    Dovat dvDynamic[]=new Dovat[100];
    
    public MainFram() throws IOException {
        initComponents();
        setIcon();
        //InitData();
        getDataFileToJTable();
    }
    
    //Don't use
    public void InitData()
    {
        dvDynamic[0]  = new Dovat();
        //Get data table
        numOfItem = Table_Dovat.getRowCount();
        for(int i=0;i<numOfItem;i++){
            dvDynamic[i+1] = dvGreedy[i] = new Dovat();
            dvDynamic[i+1].ten = dvGreedy[i].ten = Table_Dovat.getValueAt(i, 0).toString();
            dvDynamic[i+1].soluong = dvGreedy[i].soluong = Integer.parseInt(Table_Dovat.getValueAt(i, 1).toString());
            dvDynamic[i+1].giatri = dvGreedy[i].giatri = Integer.parseInt(Table_Dovat.getValueAt(i, 2).toString());
            dvDynamic[i+1].trongluong = dvGreedy[i].trongluong = Integer.parseInt(Table_Dovat.getValueAt(i, 3).toString());
        }
        //Get max value of the bag
        weightBag = Integer.parseInt(TextW.getText());  

        //Check null and add some conditions
        if (weightBag == 0){
            weightBag = 0;
        }
    }
    
    public void getDataFileToJTable(){
        String fileNameDefined = "src/Balo/Data_1.csv";
        File file = new File(fileNameDefined);
        int i=0;
         
        dvDynamic[0] = new Dovat();
        //Get value from csv file
        try{
            Scanner inputStream = new Scanner(file);
            inputStream.useDelimiter(",");
            while(inputStream.hasNext()){
                dvDynamic[i+1] = dvGreedy[i] = new Dovat();
                dvDynamic[i+1].ten = dvGreedy[i].ten = inputStream.next().trim();            
                dvDynamic[i+1].soluong = dvGreedy[i].soluong = Integer.valueOf(inputStream.next().trim());
                dvDynamic[i+1].giatri = dvGreedy[i].giatri = Integer.valueOf(inputStream.next().trim());
                dvDynamic[i+1].trongluong = dvGreedy[i].trongluong = Integer.valueOf(inputStream.next().trim());
                i++;
            }
            //Set number of Items
            numOfItem = i;
            //Get weight bag
            weightBag = Integer.parseInt(TextW.getText()); 
            inputStream.close();
        }catch (FileNotFoundException e){ 
            e.printStackTrace();
        }
        
        //Set value for JTable
        for (int item=0;item<numOfItem;item++){
            Table_Dovat.setValueAt(dvGreedy[item].ten, item , 0);
            Table_Dovat.setValueAt(dvGreedy[item].soluong, item, 1);
            Table_Dovat.setValueAt(dvGreedy[item].giatri, item, 2);
            Table_Dovat.setValueAt(dvGreedy[item].trongluong, item, 3);
        }  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Chart = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Dovat = new javax.swing.JTable();
        Button_Result = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaGreedy = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaDynamic = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        TextW = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(235, 242, 253));

        Panel_Chart.setBackground(new java.awt.Color(218, 243, 252));

        javax.swing.GroupLayout Panel_ChartLayout = new javax.swing.GroupLayout(Panel_Chart);
        Panel_Chart.setLayout(Panel_ChartLayout);
        Panel_ChartLayout.setHorizontalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Panel_ChartLayout.setVerticalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Title.setBackground(new java.awt.Color(204, 204, 255));
        Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 0, 51));
        Title.setText("Greedy and Dynamic");

        Table_Dovat.setBackground(new java.awt.Color(242, 241, 241));
        Table_Dovat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Table_Dovat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_Dovat.setForeground(new java.awt.Color(0, 0, 153));
        Table_Dovat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"A",  new Integer(5),  new Integer(4),  new Integer(3)},
                {"B",  new Integer(10),  new Integer(5),  new Integer(4)},
                {"C",  new Integer(10),  new Integer(6),  new Integer(5)},
                {"D",  new Integer(10),  new Integer(3),  new Integer(2)},
                {"E",  new Integer(10),  new Integer(1),  new Integer(1)}
            },
            new String [] {
                "Tên đồ vật", "Số lượng", "Giá trị", "Trọng lương"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_Dovat.setGridColor(new java.awt.Color(204, 204, 204));
        Table_Dovat.setSelectionForeground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setViewportView(Table_Dovat);
        if (Table_Dovat.getColumnModel().getColumnCount() > 0) {
            Table_Dovat.getColumnModel().getColumn(0).setResizable(false);
            Table_Dovat.getColumnModel().getColumn(1).setResizable(false);
            Table_Dovat.getColumnModel().getColumn(2).setResizable(false);
            Table_Dovat.getColumnModel().getColumn(3).setResizable(false);
        }

        Button_Result.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/icon_play.png"))); // NOI18N
        Button_Result.setText("Thực thi");
        Button_Result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ResultActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/checkdb.png"))); // NOI18N
        jLabel1.setText("    Dữ liệu thực nghiệm");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/charts-icon.png"))); // NOI18N
        jLabel2.setText("     Biểu đồ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Greedy");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Dynamic");

        TextAreaGreedy.setColumns(20);
        TextAreaGreedy.setRows(5);
        TextAreaGreedy.setText("Đồ vật - Số lượng chọn\n======================");
        jScrollPane2.setViewportView(TextAreaGreedy);

        TextAreaDynamic.setColumns(20);
        TextAreaDynamic.setRows(5);
        TextAreaDynamic.setText("Đồ vật - Số lượng chọn\n======================");
        jScrollPane3.setViewportView(TextAreaDynamic);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Trọng lượng: ");

        TextW.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TextW.setText("20");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextW, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(Button_Result, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Panel_Chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(Button_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                    .addComponent(Panel_Chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ResultActionPerformed
        // TODO add your handling code here:
        
        //==========================================================
        //InitData();
        getDataFileToJTable();
        long timeG1 = balo.timeToRunGreedy(dvGreedy, numOfItem, weightBag);
        String resultGreedy = balo.resultGreedy(dvGreedy, numOfItem);
        TextAreaGreedy.setText(resultGreedy);
        
        long timeD1 = balo.timeToRunDynamic(dvDynamic, numOfItem, weightBag);
        String resultDynamic = balo.resultDynamic(dvDynamic, numOfItem, weightBag);
        TextAreaDynamic.setText(resultDynamic);
        
        balo.PrintArray();
        try {
            balo.getDataFromFile();
            
            //String resultDynamic = balo.resultDynamic(dvDynamic, numOfItem, weightBag);
            //TextAreaDynamic.setText(resultDynamic);
        } catch (IOException ex) {
            Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
        }

        //==========================================================
        DefaultCategoryDataset barChart = new DefaultCategoryDataset();
        barChart.setValue(timeG1,"Greedy","Data 1");
        barChart.setValue(timeD1,"Dynamic","Data 1");

        barChart.setValue(timeG1,"Greedy","Data 2");
        barChart.setValue(timeD1,"Dynamic","Data 2");
        
        JFreeChart jbarChart = ChartFactory.createBarChart("The time chart of Greedy and Dynamic", "Monthly", "Time to run", barChart, PlotOrientation.VERTICAL, true, true, true);
        CategoryPlot barchrt = (CategoryPlot)jbarChart.getPlot();
        barchrt.setRangeGridlinePaint(Color.BLUE);
        
        ChartPanel barPanel = new ChartPanel(jbarChart);
        Panel_Chart.removeAll();
        Panel_Chart.setLayout(new BorderLayout());
        Panel_Chart.add(barPanel, BorderLayout.CENTER);
        Panel_Chart.validate();
    }//GEN-LAST:event_Button_ResultActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFram().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Result;
    private javax.swing.JPanel Panel_Chart;
    private javax.swing.JTable Table_Dovat;
    private javax.swing.JTextArea TextAreaDynamic;
    private javax.swing.JTextArea TextAreaGreedy;
    private javax.swing.JTextField TextW;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void setIcon() throws IOException {
        //Image img = ImageIO.read(getClass().getResource("icon_play.png"));
        //Button_Result.setIcon(new ImageIcon(img));
    }
}