package com.xielc;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Jf extends JFrame{
	
	    private static final long serialVersionUID = 1L;
	    
		private JPanel scoresPane;
	    private JPanel mainPane;
	    private JLabel labelMaxScores ;
	    private JLabel labelScores;
	    private JLabel tips;                    //��ʾ������ǩ
	    private JTextField textMaxScores;
	    private JLabel textScores;
	    private JLabel[][] texts;
	    private Icon icon2;
	    private int times = 16;                    //��¼ʣ��շ�����Ŀ
	    private int scores = 0;                    //��¼����
	    private int l1,l2,l3,l4,l5;                //�����ж���Ϸ�Ƿ�ʧ��
	    Font font = new Font("", Font.BOLD,14);            //�����������ͺʹ�С
	    Font font2 = new Font("", Font.BOLD,30);
	    Random random = new Random();
	    
	    public static void main(String[] args){
	        EventQueue.invokeLater(new Runnable(){
	            public void run(){
	                try{
	                	Jf frame = new Jf();
	                    frame.setVisible(true);
	                //    Thread thread = new Thread(frame);
	                //    thread.start();
	                }
	                catch(Exception e1){
	                    e1.printStackTrace();
	                }
	            }
	        });
	    }
	    /**
	     * ���췽��
	     */
	    public Jf(){
	        super();
	        setResizable(false);            //��ֹ���������С
	        getContentPane().setLayout(null);    //���ÿղ���
	        setBounds(500, 50, 500, 615);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("2048PC��");            //���ô������
	        
	        scoresPane = new JPanel();                    //����������ʾ���
	        scoresPane.setBackground(Color.green);        //���÷�����ʾ���ı���ɫ
	        scoresPane.setBounds(20, 20, 460, 40);
	        scoresPane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));    //���õ÷����ı߿�
	        getContentPane().add(scoresPane);            //���÷������ӵ�����
	        scoresPane.setLayout(null);                    //�������ղ���
	        
	        labelMaxScores = new JLabel("��߷�:");        //��߷ֱ�ǩ
	        labelMaxScores.setFont(font);                //�����������ͺʹ�С
	        labelMaxScores.setBounds(10, 5, 50, 30);    //��������ֱ�ǩ��λ�óߴ�
	        scoresPane.add(labelMaxScores);    //����߷ֱ�ǩ��ӵ��÷�������
	        
	        textMaxScores = new JTextField("�ݲ�����");            //�÷ֱ�ǩ
	        textMaxScores.setBounds(60, 5, 150, 30);
	        textMaxScores.setFont(font);
	        textMaxScores.setEditable(false);
	        scoresPane.add(textMaxScores);                //���÷ֱ�ǩ��ӵ����������
	        
	        labelScores = new JLabel("��    ��:");
	        labelScores.setFont(font);                    //�����������ͺʹ�С
	        labelScores.setBounds(240, 5, 50, 30);
	        scoresPane.add(labelScores);
	        
	        textScores = new JLabel(String.valueOf(scores));
	        textScores.setFont(font);
	        textScores.setBounds(290, 5, 150, 30);
	        scoresPane.add(textScores);
	        
	        mainPane = new JPanel();                //������Ϸ�����
	        mainPane.setBounds(20, 70, 460, 500);    //���������λ�óߴ�
	        
	        this.getContentPane().add(mainPane);
	        mainPane.setLayout(null);                //���ÿղ���
	        
	        texts = new  JLabel[4][4];            //�����ı����ά����
	        for(int i = 0; i < 4; i++){                //��������
	            for(int j = 0; j < 4; j++){
	                texts[i][j] = new JLabel();    //������ǩ
	                texts[i][j].setFont(font2);
	                texts[i][j].setHorizontalAlignment(SwingConstants.CENTER);
	                texts[i][j].setText("");
	                texts[i][j].setBounds(120 * j, 120 * i, 100, 100);        //���÷���Ĵ�Сλ��
	                setColor(i, j, "");
	                texts[i][j].setOpaque(true);
	                texts[i][j].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));//���÷���߿���ɫ
	                mainPane.add(texts[i][j]);                            //���������ı������    
	                
	            }
	        }
	        
	        tips = new JLabel("Tips��ʹ���ϡ��¡����Ҽ�����W��S��A��D������");
	        tips.setFont(font);
	        tips.setBounds(60,480,400,20);
	        mainPane.add(tips);
	        
	        textMaxScores.addKeyListener(new KeyAdapter(){                //Ϊ��߷ֱ�ǩ��Ӱ���������
	            public void keyPressed(  KeyEvent e){
	                 do_label_keyPressed(e);                //����ʱ�䴦����
	            }
	        });
	    
	        Create2();
	        Create2();
	    }
	    
	    /**
	     * ���������¼��Ĵ�����
	     * @param e
	     */
	    protected  void do_label_keyPressed(final KeyEvent e){
	        int code = e.getKeyCode();    //��ȡ��������
	        int a ;                        //a ��������Ϊ�˷�ֹ���ӵ��������
	        String str ;                                
	        String str1;
	        int num;
	        switch(code){
	        case KeyEvent.VK_LEFT:
	        case KeyEvent.VK_A:                        //����������������������A��
	            for(int i = 0; i < 4; i++){    
	                a = 5;
	                for(int k = 0; k < 3; k++){
	                    for(int j = 1; j < 4; j++){                    //����16������
	                        str = texts[i][j].getText();            //��ȡ��ǰ�����ǩ�ı��ַ�
	                        str1 = texts[i][j-1].getText();            //��ȡ��ǰ��1�����ǩ�ı��ַ�
	                        
	                        if(str1.compareTo("") == 0){                //�����1�����ı�Ϊ���ַ�
	                            texts[i][j-1].setText(str);                //�ַ�����
	                            setColor(i, j-1,str);
	                            texts[i][j].setText("");                //��ǰ�����ַ��ÿ�
	                            setColor(i, j, "");
	                        }else if((str.compareTo(str1) == 0) && (j !=a) && (j != a-1)){            //�����ǰ�������1�����ı��ַ����
	                            num  = Integer.parseInt(str);
	                            scores += num;
	                            times ++;
	                            str = String.valueOf(2 * num);
	                            texts[i][j-1].setText(str);        //��1�����ı��ַ���Ϊ������֮��
	                            setColor(i, j-1, str);
	                            texts[i][j].setText("");                //��ǰ�����ַ��ÿ�
	                            setColor(i, j, "");
	                            a = j;
	                        }
	                    }    
	                }
	            }
	            l1 = 1;                //�����ж���Ϸ�Ƿ�ʧ��
	            Create2();
	            break;
	        case KeyEvent.VK_RIGHT:
	        case KeyEvent.VK_D:
	            for(int i = 0; i < 4; i ++){
	                a = 5;
	                for(int k = 0; k < 3; k++){
	                    for(int j = 2; j >= 0; j--){
	                        str = texts[i][j].getText();
	                        str1 = texts[i][j + 1].getText();
	                        
	                        if(str1.compareTo("") == 0){
	                            texts[i][j + 1].setText(str);
	                            setColor(i, j+1, str);
	                            texts[i][j].setText("");
	                            setColor(i, j, "");
	                        }
	                        else if(str.compareTo(str1) == 0 && j !=a && j != a+ 1){
	                            num  = Integer.parseInt(str);
	                            scores += num ;
	                            times ++;
	                            str = String.valueOf(2 * num);
	                            texts[i][j + 1].setText(str);
	                            setColor(i, j+1, str);
	                            texts[i][j].setText("");
	                            setColor(i, j, "");
	                            a = j;
	                        }
	                    }
	                }
	            }
	            l2 = 1;
	            Create2();
	            break;
	        case KeyEvent.VK_UP:
	        case KeyEvent.VK_W:
	            for(int j = 0; j < 4; j++){
	                a = 5;
	                for(int k = 0; k < 3; k++){
	                    for(int i = 1; i < 4; i++){
	                        str = texts[i][j].getText();
	                        str1 = texts[i - 1][j].getText();
	                    
	                        if(str1.compareTo("") == 0){
	                            texts[i - 1][j].setText(str);
	                            setColor(i-1, j, str);
	                            texts[i][j].setText("");
	                            setColor(i, j, "");
	                        }
	                        else if(str.compareTo(str1) == 0 && i != a && i != a -1){
	                            num  = Integer.parseInt(str);
	                            scores += num ;
	                            times ++;
	                            str = String.valueOf(2 * num);
	                            texts[i - 1][j].setText(str);
	                            setColor(i-1, j, str);
	                            texts[i][j].setText("");
	                            setColor(i, j, "");
	                            a = i;
	                        }
	                    }
	                }
	            }
	            l3 =1;
	            Create2();
	            break;
	        case KeyEvent.VK_DOWN:
	        case KeyEvent.VK_S:
	            for(int j = 0; j < 4; j ++){
	                a = 5;
	                for(int k = 0; k < 5; k++){
	                    for(int i = 2; i >= 0; i--){
	                        str = texts[i][j].getText();
	                        str1 = texts[i + 1][j].getText();
	                        
	                        if(str1.compareTo("") == 0){
	                            texts[i + 1][j].setText(str);
	                            setColor(i+1, j, str);
	                            texts[i][j].setText("");
	                            setColor(i, j, "");
	                        }
	                        else if(str.compareTo(str1) == 0 && i != a && i != a + 1){
	                            num  = Integer.parseInt(str);
	                            scores += num ;
	                            times ++;
	                            str = String.valueOf(2 * num);
	                            texts[i + 1][j].setText(str );
	                            setColor(i+1, j, str);
	                            texts[i][j].setText("");
	                            setColor(i, j, "");
	                            a = i;
	                        }
	                    }
	                }
	            }
	            l4 = 1;
	            Create2();
	            break;
	            default:
	                break;
	        }
	        textScores.setText(String.valueOf(scores));
	    }
	    
	    /**
	     * �����λ�ò���һ��2�ŷ���ķ���
	     * @param i,j
	     */
	    public void Create2(){
	        int i ,j;
	        boolean r = false;
	        String str;
	        
	        if(times > 0){
	            while(!r){
	                i = random.nextInt(4);
	                j = random.nextInt(4);
	                str = texts[i][j].getText();
	                if((str.compareTo("") == 0)){
	                    texts[i][j].setIcon(icon2);
	                    texts[i][j].setText("2");
	                    setColor(i, j, "2");
	                    
	                    times --;
	                    r = true;
	                    l1 = l2 = l3 = l4 = 0;            
	                }
	            }
	        }
	        else if(l1 >0 && l2 >0 && l3 > 0 && l4 > 0){        //l1��l4ͬʱ�����̸�ֵΪ1˵���κη���������ܲ����µ�����2��˵����Ϸʧ��
	                tips.setText("                            GAME��OVER ��");
	            
	        }
	    }
	    
	    /**
	     * ���ñ�ǩ��ɫ
	     * @param i , j ,str
	     */
	    public void setColor(int i, int j, String str){
	        switch(str){
	        case "2":
	            texts[i][j].setBackground(Color.yellow);
	            break;
	        case "4":
	            texts[i][j].setBackground(Color.red);
	            break;
	        case "8":
	            texts[i][j].setBackground(Color.pink);
	            break;
	        case "16":
	            texts[i][j].setBackground(Color.orange);
	            break;
	        case "32":
	            texts[i][j].setBackground(Color.magenta);
	            break;
	        case "64":
	            texts[i][j].setBackground(Color.LIGHT_GRAY);
	            break;
	        case "128":
	            texts[i][j].setBackground(Color.green);
	            break;
	        case "256":
	            texts[i][j].setBackground(Color.gray);
	            break;
	        case "512":
	            texts[i][j].setBackground(Color.DARK_GRAY);
	            break;
	        case "1024":
	            texts[i][j].setBackground(Color.cyan);
	            break;
	        case "2048":
	            texts[i][j].setBackground(Color.blue);
	            break;
	        case "":
	        case "4096":
	            texts[i][j].setBackground(Color.white);
	            break;
	        default:
	            break;
	        }

	    }

	}
