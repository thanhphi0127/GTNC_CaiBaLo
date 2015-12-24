/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balo;

import com.opencsv.CSVWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
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
    DefaultTableModel model;
    int weightBag;
    int numOfItem;
    Balo balo = new Balo();
    Dovat dvGreedy[]=new Dovat[1000];
    Dovat dvDynamic[]=new Dovat[1000];
    
    Dovat dvGreedy2[]=new Dovat[1000];
    Dovat dvDynamic2[]=new Dovat[1000];
    int numOfItem2 = 30;
    
    private void RandomData(int numOfItem2){
        dvDynamic2[0] = new Dovat();
        int min = 1;
        int max = 100;
        Random rn = new Random();
        int range = max - min + 1;
        for(int i=0;i<numOfItem2;i++){
            dvDynamic2[i+1] = dvGreedy2[i] = new Dovat();
            dvDynamic2[i+1].ten = dvGreedy2[i].ten = String.valueOf(min + rn.nextInt(range));           
            dvDynamic2[i+1].soluong = dvGreedy2[i].soluong = min + rn.nextInt(range);
            dvDynamic2[i+1].giatri = dvGreedy2[i].giatri = min + rn.nextInt(range);
            dvDynamic2[i+1].trongluong = dvGreedy2[i].trongluong = min + rn.nextInt(range);
        }
    }
    public MainFram() throws IOException {
        initComponents();
        
        Object[] columns = {"Tên đồ vật", "Số lượng", "Giá trị", "Trọng lượng"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);    
        Table_Dovat.setModel(model);
        getDataFileToJTable();
        
        //Add group
        GroupChart.add(RadioColumn);
        GroupChart.add(RadioLine);
        GroupChart.add(RadioItemChage);
        
        RadioColumn.setSelected(true);
        
        RandomData(numOfItem2);
        
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
    }
    
   public void getDataFileToJTable(){
        String fileNameDefined = "src/Balo/Data_3.csv";
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
            Object[] row = new Object[4];
            row[0] = dvGreedy[item].ten;
            row[1] = dvGreedy[item].soluong;
            row[2] = dvGreedy[item].giatri;
            row[3] = dvGreedy[item].trongluong;
            model.addRow(row);
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

        GroupChart = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Dovat = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TextW = new javax.swing.JTextField();
        RadioColumn = new javax.swing.JRadioButton();
        RadioLine = new javax.swing.JRadioButton();
        Button_Result = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaGreedy = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaDynamic = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        Panel_Chart = new javax.swing.JPanel();
        RadioItemChage = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(215, 228, 247));
        setForeground(java.awt.Color.white);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        Title.setBackground(new java.awt.Color(204, 204, 255));
        Title.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        Title.setForeground(new java.awt.Color(204, 0, 0));
        Title.setText("BÀI TOÁN CÁI BA LÔ (SỐ LƯỢNG ĐỒ VẬT GIỚI HẠN) BẰNG GIẢI THUẬT THAM ĂN VÀ QUY HOACH ĐỘNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Trọng lượng: ");

        TextW.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TextW.setText("150");

        RadioColumn.setText("Mặc định");

        RadioLine.setText("W ba lô thay đổi");

        Button_Result.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Button_Result.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/icon_play.png"))); // NOI18N
        Button_Result.setText("Thực thi");
        Button_Result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ResultActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("KẾT QUẢ GIẢI THUẬT THAM ẮN");

        TextAreaGreedy.setEditable(false);
        TextAreaGreedy.setColumns(20);
        TextAreaGreedy.setRows(5);
        TextAreaGreedy.setText("Đồ vật - Số lượng chọn\n======================");
        jScrollPane2.setViewportView(TextAreaGreedy);

        TextAreaDynamic.setEditable(false);
        TextAreaDynamic.setColumns(20);
        TextAreaDynamic.setRows(5);
        TextAreaDynamic.setText("Đồ vật - Số lượng chọn\n======================");
        jScrollPane3.setViewportView(TextAreaDynamic);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("KẾT QUẢ GIẢI THUẬT QUY HOẠCH ĐỘNG");

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

        RadioItemChage.setText("Số ĐVật thay đổi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TextW, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(RadioColumn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RadioLine)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(RadioItemChage)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_Result, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RadioColumn)
                            .addComponent(RadioLine)
                            .addComponent(RadioItemChage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/checkdb.png"))); // NOI18N
        jLabel1.setText("    Dữ liệu thực nghiệm");

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/add1.png"))); // NOI18N
        jButtonAdd.setText("Thêm");
        jButtonAdd.setPreferredSize(new java.awt.Dimension(95, 45));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/delete.png"))); // NOI18N
        jButtonDelete.setText("Xóa");
        jButtonDelete.setPreferredSize(new java.awt.Dimension(87, 45));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Balo/charts-icon.png"))); // NOI18N
        jLabel2.setText("     Biểu đồ về thời gian thực hiện của hai giải thuật ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel1)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ResultActionPerformed
        // TODO add your handling code here:
        //==========================================================
        if(RadioLine.isSelected()){
            long timeG = 0;
            long timeD = 0;
            String csv = "D:\\ResultGTNC.csv";
            CSVWriter writer = null;
            try {
                writer = new CSVWriter(new FileWriter(csv));
            } catch (IOException ex) {
                Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[] {"Weight", "Greedy", "Dynamic"});
            weightBag = Integer.parseInt(TextW.getText()); 
            DefaultCategoryDataset barChart = new DefaultCategoryDataset();
            //Get all data
            for(int i=10;i<=700; i=i+40){
                InitData();
                timeG = balo.timeToRunGreedy(dvGreedy, numOfItem, i);
                timeD = balo.timeToRunDynamic(dvDynamic, numOfItem, i);
                barChart.setValue(timeG,"Tham ăn          ", String.valueOf(i));
                barChart.setValue(timeD,"Quy hoạch động   ", String.valueOf(i));
                data.add(new String[] {String.valueOf(i), String.valueOf(timeG), String.valueOf(timeD)});
            }
            
            writer.writeAll(data);
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
            }
            //==========================================================
            JFreeChart jbarChart = ChartFactory.createLineChart("Biểu đồ thời gian thực hiện", "Trọng lượng của ba lô", "micro giây", barChart, PlotOrientation.VERTICAL, true, true, true);
            CategoryPlot barchrt = (CategoryPlot)jbarChart.getPlot();
            ChartPanel barPanel = new ChartPanel(jbarChart);
            Panel_Chart.removeAll();
            Panel_Chart.setLayout(new BorderLayout());
            Panel_Chart.add(barPanel, BorderLayout.CENTER);
            Panel_Chart.validate();
        }
        else if(RadioColumn.isSelected()){
            String csv = "D:\\ResultColumn.csv";
            CSVWriter writer = null;
            try {
                writer = new CSVWriter(new FileWriter(csv));
            } catch (IOException ex) {
                Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[] {"Result", "Greedy", "Dynamic"});
            InitData();
            weightBag = Integer.parseInt(TextW.getText()); 
            long timeG = balo.timeToRunGreedy(dvGreedy, numOfItem, weightBag);
            String resultGreedy = balo.resultGreedy(dvGreedy, numOfItem);
            TextAreaGreedy.setText(resultGreedy);
            long timeD = balo.timeToRunDynamic(dvDynamic, numOfItem, weightBag);
            String resultDynamic = balo.resultDynamic(dvDynamic, numOfItem, weightBag);
            TextAreaDynamic.setText(resultDynamic);

            //Random data
            long timeG2 = balo.timeToRunGreedy(dvGreedy2, numOfItem2, weightBag);
            long timeD2 = balo.timeToRunDynamic(dvDynamic2, numOfItem2, weightBag);
            
            data.add(new String[] {"File", String.valueOf(timeG), String.valueOf(timeD)});
            data.add(new String[] {"Random", String.valueOf(timeG2), String.valueOf(timeD2)});
            writer.writeAll(data);
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //==========================================================
            DefaultCategoryDataset barChart = new DefaultCategoryDataset();
            barChart.setValue(timeG,"Tham ăn          ", "Dữ liệu thực nghiệm");
            barChart.setValue(timeD,"Quy hoạch động   ", "Dữ liệu thực nghiệm");
            
            barChart.setValue(timeG2,"Tham ăn          ", "Dữ liệu ngẫu nhiên" );
            barChart.setValue(timeD2,"Quy hoạch động   ", "Dữ liệu ngẫu nhiên");

            JFreeChart jbarChart = ChartFactory.createBarChart("Biểu đồ thời gian thực hiện", "Trọng lượng tối đa của ba lô", "micro giây", barChart, PlotOrientation.VERTICAL, true, true, true);
            CategoryPlot barchrt = (CategoryPlot)jbarChart.getPlot();

            ChartPanel barPanel = new ChartPanel(jbarChart);
            Panel_Chart.removeAll();
            Panel_Chart.setLayout(new BorderLayout());
            Panel_Chart.add(barPanel, BorderLayout.CENTER);
            Panel_Chart.validate();
        }
        else{ // Trọng lượng không đổi, số lượng đồ vật thay đổi.
            long timeG = 0;
            long timeD = 0;
            String csv = "D:\\ResultItemChage.csv";
            CSVWriter writer = null;
            try {
                writer = new CSVWriter(new FileWriter(csv));
            } catch (IOException ex) {
                Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[] {"Num of Item", "Greedy", "Dynamic"});
            weightBag = Integer.parseInt(TextW.getText()); 
            DefaultCategoryDataset barChart = new DefaultCategoryDataset();
            //Get all data
            for(int i=1;i<=77; i=i+4){
                RandomData(i);
                timeG = balo.timeToRunGreedy(dvGreedy2, i, weightBag);
                timeD = balo.timeToRunDynamic(dvDynamic2, i, weightBag);
                barChart.setValue(timeG,"Tham ăn          ", String.valueOf(i));
                barChart.setValue(timeD,"Quy hoạch động   ", String.valueOf(i));
                data.add(new String[] {String.valueOf(i), String.valueOf(timeG), String.valueOf(timeD)});
            }
            
            writer.writeAll(data);
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFram.class.getName()).log(Level.SEVERE, null, ex);
            }
            //==========================================================
            JFreeChart jbarChart = ChartFactory.createLineChart("Biểu đồ thời gian thực hiện khi số lượng đồ vật thay đổi", "Số lượng đồ vật", "micro giây", barChart, PlotOrientation.VERTICAL, true, true, true);
            CategoryPlot barchrt = (CategoryPlot)jbarChart.getPlot();
            ChartPanel barPanel = new ChartPanel(jbarChart);
            Panel_Chart.removeAll();
            Panel_Chart.setLayout(new BorderLayout());
            Panel_Chart.add(barPanel, BorderLayout.CENTER);
            Panel_Chart.validate();  
        }
    }//GEN-LAST:event_Button_ResultActionPerformed

    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked
        // TODO add your handling code here:
        numOfItem = Table_Dovat.getRowCount();
        Object[] row = new Object[4];
        row[0] = "";
        row[1] = "";
        row[2] = "";
        row[3] = "";
        model.addRow(row);
    }//GEN-LAST:event_jButtonAddMouseClicked

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        int i = Table_Dovat.getSelectedRow();
        if (i >=0 ) model.removeRow(i);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        numOfItem = Table_Dovat.getRowCount();
        Object[] row = new Object[4];
        row[0] = "";
        row[1] = "";
        row[2] = "";
        row[3] = "";
        model.addRow(row);
    }//GEN-LAST:event_jButtonAddActionPerformed

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
    private javax.swing.ButtonGroup GroupChart;
    private javax.swing.JPanel Panel_Chart;
    private javax.swing.JRadioButton RadioColumn;
    private javax.swing.JRadioButton RadioItemChage;
    private javax.swing.JRadioButton RadioLine;
    private javax.swing.JTable Table_Dovat;
    private javax.swing.JTextArea TextAreaDynamic;
    private javax.swing.JTextArea TextAreaGreedy;
    private javax.swing.JTextField TextW;
    private javax.swing.JLabel Title;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void setIcon() throws IOException {
        //Image img = ImageIO.read(getClass().getResource("icon_play.png"));
        //Button_Result.setIcon(new ImageIcon(img));
    }
}
