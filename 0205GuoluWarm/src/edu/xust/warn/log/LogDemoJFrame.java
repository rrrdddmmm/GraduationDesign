package edu.xust.warn.log;

import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JScrollPane;  
import javax.swing.JTextArea;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.xust.warn.log.LabelLogAppender;
import edu.xust.warn.log.TextAreaLogAppender;


  
/** 
 *  
 * 类描述： 
 * 测试日志输出到UI组件 
 * @author 杨胜寒 
 * @date 2011-12-24 创建 
 * @version 1.0 
 */  
public class LogDemoJFrame extends JFrame {  
  
    private JLabel logLabel;  
    private JScrollPane logScrollPane;  
    private JTextArea logTextArea;  
    private final static Logger log = LoggerFactory.getLogger(LogDemoJFrame.class);  
    public LogDemoJFrame() {  
        logLabel = new javax.swing.JLabel();  
        logScrollPane = new javax.swing.JScrollPane();  
        logTextArea = new javax.swing.JTextArea();  
     //  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  
       setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);  
        logLabel.setText(" ");  
  
        logTextArea.setColumns(20);  
        logTextArea.setRows(5);  
        logScrollPane.setViewportView(logTextArea);  
  
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());  
        getContentPane().setLayout(layout);  
        layout.setHorizontalGroup(  
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(logLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE).addContainerGap()).addComponent(logScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE));  
        layout.setVerticalGroup(  
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(logLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(logScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)));  
  
        pack();  
    }  
  
    public void initLog() {  
        try {  
            Thread t1, t2;  
            t1 = new LabelLogAppender(logLabel);  
            t2 = new TextAreaLogAppender(logTextArea, logScrollPane);  
            t1.start();  
            t2.start();  
        } catch (Exception e) {  
            JOptionPane.showMessageDialog(this, e, "绑定日志输出组件错误", JOptionPane.ERROR_MESSAGE);  
        }  
    }    
} 
