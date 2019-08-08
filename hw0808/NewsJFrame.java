package ws;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsJFrame extends JFrame implements ActionListener{
	public NewsJFrame() {
		jinit(); 
		jevent(); 
//		jshowlist(); 
	}

	private void jshowlist() {
		// TODO Auto-generated method stub
		
	}
	
	JButton b = new JButton("Show News"); 
	JList lists = new JList<>();
	JTextArea ta = new JTextArea("");
	JPanel cp = new JPanel();
	JPanel cnp = new JPanel();
	JPanel ccp = new JPanel();
	JPanel ccp1 = new JPanel();
	JPanel ccp2 = new JPanel();
	public void jinit() {
		cp = (JPanel)this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(cnp,  BorderLayout.NORTH );
		cp.add(ccp,  BorderLayout.CENTER);
		cnp.setLayout(new BorderLayout());
		cnp.add(b,  BorderLayout.CENTER);
		
		ccp.setLayout(new GridLayout(2,1,5,5));
		ccp.add(ccp1);
		ccp.add(ccp2);
		
		ccp1.setLayout(new BorderLayout());
		ccp1.add(lists,BorderLayout.CENTER);

		ccp2.setLayout(new BorderLayout());
		ccp2.add(ta,BorderLayout.CENTER);
		ta.setEditable(false);
		
		this.setTitle("Light Day news Information ver 0.1");
		this.setSize(600,700);
		this.setVisible(true);
	}
	public void jevent() {
		this.addWindowFocusListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.out.println("swing ~end~" +  new Date());
				System.exit(0);
			}
		});
		b.addActionListener(this);
		//내가 ActionListenner 구현한 핸들러 객체다.  // 내 안에 핸들러 메서드가 있다. 
		lists.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				News cuw = (News)lists.getSelectedValue();
				String fx = String.format("News : %s \n %s \n %s",  
						cuw.getTitle(), cuw.getDesc(), cuw.getLink());
				ta.setText(fx);
				ta.setLineWrap(true);
			}
		});
		/*
		 * lists.addListSelectionListener(e ->{
				News cuw = (News)lists.getSelectedValue();
				String fx = String.format("News : %s \n %s \n %s",  
						cuw.getTitle(), cuw.getDesc(), cuw.getLink());
				ta.setText(fx);
				ta.setLineWrap(true);
		});
		*/
		//값이 바뀌면, 
	}

	public static void main(String[] args) {
		NewsJFrame frame = new NewsJFrame();
				
	}
	NewsDao dao = NewsDao.getInstance();

	@Override // 핸들러 메서드 b 버튼을 누르면 실행. 
	public void actionPerformed(ActionEvent e) {
		List<News> wls  = dao.getNewsList(); 
		lists.removeAll(); 
		lists.setListData(wls.toArray());
	}
	

}
