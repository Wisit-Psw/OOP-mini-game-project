package display;

import javax.swing.JButton;
import javax.swing.JFrame;

import Element.EleButton;
import Element.EleLabel;
import Element.Element;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class Display extends JFrame implements ActionListener{
	public Game G ;menu M;endmenu em ;select selected;Display display;
	public int p1_sel=1,p2_sel=1;
	public EleButton start,exit,backtomenu;
	public JButton p1_sel_sw,p2_sel_sw,p1_sel_g,p2_sel_g,fight,bg1,bg2,bg3;EleLabel status;
	public Display() {
		super("project OOP");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 200);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		start = new EleButton("start",15,380,200,200,50);
		start.addActionListener(this);
		exit = new EleButton("exit",15,380,300,200,50);
		exit.addActionListener(this);
		this.add(start);
		this.add(exit);
		M = new menu(this);
		this.getContentPane().add(M);
	}
	public void endGame(String s) {
		this.getContentPane().remove(G);
		status = new EleLabel(s+" WIN",40,450,200,200,50);
		status.setForeground(Color.black);
		backtomenu = new EleButton("backtomenu",15,380,300,200,50);
		backtomenu.addActionListener(this);
		repaint();
		this.add(status);
		this.add(backtomenu);
		em = new endmenu(G.Person1,G.Person2,bg);
		this.getContentPane().add(em);
		
//		repaint();
//		em.repaint();
//		this.getContentPane().add(G);
//		this.getContentPane().remove(G);
//		repaint();
		
		
		
	}
	public String p1_img="img\\Red\\Sword\\",p2_img="img\\Blue\\Sword\\",bg="img\\bg\\std.jpg";
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("start")) {
			
			selected = new select(this);
			this.getContentPane().remove(M);
			this.getContentPane().remove(start);
			this.getContentPane().remove(exit);
			repaint();
			p1_sel_sw = new JButton("sword");
			p1_sel_sw.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					p1_sel=1;
					p1_img="img\\Red\\Sword\\";
					getContentPane().remove(selected);
					repaint();
					selected = new select(this,p1_img,p2_img,bg);
					selected.requestFocus();
					getContentPane().add(selected);
				}
			});
			p1_sel_sw.setBackground(Color.LIGHT_GRAY);
			p1_sel_sw.setForeground(Color.white);
			p1_sel_sw.setFont(Element.getFont(15));
			p1_sel_sw.setBounds(150,100,200,50);
			
			p1_sel_g = new JButton("Gun");
			p1_sel_g.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					p1_sel=2;
					p1_img="img\\Red\\Gun\\";
					getContentPane().remove(selected);
					repaint();
					selected = new select(this,p1_img,p2_img,bg);
					selected.requestFocus();
					getContentPane().add(selected);
				}
			});
			p1_sel_g.setBackground(Color.LIGHT_GRAY);
			p1_sel_g.setForeground(Color.white);
			p1_sel_g.setFont(Element.getFont(15));
			p1_sel_g.setBounds(150,170,200,50);
			
			p2_sel_sw = new JButton("sword");
			p2_sel_sw.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					p2_sel=1;
					p2_img="img\\Blue\\Sword\\";
					getContentPane().remove(selected);
					repaint();
					selected = new select(this,p1_img,p2_img,bg);
					selected.requestFocus();
					getContentPane().add(selected);
				}
			});
			p2_sel_sw.setBackground(Color.LIGHT_GRAY);
			p2_sel_sw.setForeground(Color.white);
			p2_sel_sw.setFont(Element.getFont(15));
			p2_sel_sw.setBounds(600,100,200,50);
			
			p2_sel_g = new JButton("Gun");
			p2_sel_g.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					p2_sel=2;
					p2_img="img\\Blue\\Gun\\";
					getContentPane().remove(selected);
					repaint();
					selected = new select(this,p1_img,p2_img,bg);
					selected.requestFocus();
					getContentPane().add(selected);
				}
			});
			p2_sel_g.setBackground(Color.LIGHT_GRAY);
			p2_sel_g.setForeground(Color.white);
			p2_sel_g.setFont(Element.getFont(15));
			p2_sel_g.setBounds(600,170,200,50);
			
			bg1 = new JButton("meadow");
			bg1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					bg="img\\bg\\std.jpg";
					getContentPane().remove(selected);
					repaint();
					selected = new select(this,p1_img,p2_img,bg);
					selected.requestFocus();
					getContentPane().add(selected);
				}
			});
			bg1.setBackground(Color.LIGHT_GRAY);
			bg1.setForeground(Color.white);
			bg1.setFont(Element.getFont(15));
			bg1.setBounds(150,325,200,50);

			bg2 = new JButton("forest");
			bg2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					bg="img\\bg\\frs.jpg";
					getContentPane().remove(selected);
					repaint();
					selected = new select(this,p1_img,p2_img,bg);
					selected.requestFocus();
					getContentPane().add(selected);
				}
			});
			bg2.setBackground(Color.LIGHT_GRAY);
			bg2.setForeground(Color.white);
			bg2.setFont(Element.getFont(15));
			bg2.setBounds(375,325,200,50);
			
			bg3 = new JButton("beach");
			bg3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					bg="img\\bg\\bec.jpg";
					getContentPane().remove(selected);
					repaint();
					selected = new select(this,p1_img,p2_img,bg);
					selected.requestFocus();
					getContentPane().add(selected);
				}
			});
			bg3.setBackground(Color.LIGHT_GRAY);
			bg3.setForeground(Color.white);
			bg3.setFont(Element.getFont(15));
			bg3.setBounds(600,325,200,50);
			
			fight = new EleButton("fight",15,380,450,200,50);
			fight.addActionListener(this);
			
			this.add(p1_sel_sw);
			this.add(p1_sel_g);
			this.add(p2_sel_sw);
			this.add(p2_sel_g);
			this.add(bg1);
			this.add(bg2);
			this.add(bg3);
			this.add(fight);
			
			selected.requestFocus();
			this.getContentPane().add(selected);
			
		}else if(e.getActionCommand().equals("fight")) {
			this.getContentPane().remove(selected);
			this.getContentPane().remove(p1_sel_sw);
			this.getContentPane().remove(p1_sel_g);
			this.getContentPane().remove(p2_sel_sw);
			this.getContentPane().remove(p2_sel_g);
			this.getContentPane().remove(bg1);
			this.getContentPane().remove(bg2);
			this.getContentPane().remove(bg3);
			this.getContentPane().remove(fight);
			repaint();
			G = new Game(p1_sel,p2_sel,bg);
			G.Person1.opponent=G.Person2;
			G.Person2.opponent=G.Person1;
			this.getContentPane().add(G);
			G.requestFocus();
			repaint();
			
		}else if(e.getActionCommand().equals("backtomenu")) {
			this.getContentPane().remove(em);
			this.getContentPane().remove(status);
			this.getContentPane().remove(backtomenu);
			repaint();
			start = new EleButton("start",15,380,200,200,50);
			start.addActionListener(this);
			exit = new EleButton("exit",15,380,300,200,50);
			exit.addActionListener(this);
			this.add(start);
			this.add(exit);
			M = new menu(this);
			this.getContentPane().add(M);
			M.requestFocus();
		}else if(e.getActionCommand().equals("exit")) {
			this.dispose();
		}
	}

}
