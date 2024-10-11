import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Visual extends JFrame implements ActionListener, MouseListener
{
	private JButton bBotonX;
	private JButton bBotonO;
	private JLabel[] posicion;
	private JLabel eSeleccion;
	private JFrame vFicha;
	private Juego juego;
	Visual()
	{
		super("Gato");
		setLayout(null);
		setSize(550,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Border borde=LineBorder.createGrayLineBorder();

		posicion=new JLabel[9];
		setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++){
			posicion[i]=new JLabel("");
			Font auxFont=posicion[0].getFont();
			posicion[i].addMouseListener(this);
			posicion[i].setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 130));
			posicion[i].setHorizontalAlignment(JLabel.CENTER);
			posicion[i].setVerticalTextPosition(JLabel.CENTER);
			posicion[i].setBorder(borde);
			add(posicion[i]);
		}
		pack();
		vFicha=new JFrame("");
		vFicha.setSize(300,100);
		vFicha.setVisible(true);
		
		eSeleccion=new JLabel("Con que quiere jugar?");
		bBotonX=new JButton("X");
		bBotonO=new JButton("O");
		bBotonX.addActionListener(this);
		bBotonO.addActionListener(this);
		eSeleccion.setHorizontalAlignment(JLabel.CENTER);
		vFicha.setLayout(new BorderLayout());
		vFicha.add(eSeleccion,BorderLayout.NORTH);
		vFicha.setLayout(new FlowLayout());
		vFicha.add(bBotonX);
		vFicha.add(bBotonO);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bBotonX)
		{
			juego=new Juego("X","O");
		}
		if(e.getSource()==bBotonO)
		{
			juego=new Juego("O","X");
		}
		vFicha.setVisible(false);
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mouseExited(MouseEvent m1){}
	public void mouseEntered(MouseEvent m1){}
	public void mouseReleased(MouseEvent m1){}
	public void mousePressed(MouseEvent m1)
	{
		int temp;
		for(int pos=0;pos<9;pos++)
		{
			if(m1.getSource()==posicion[pos]&&juego.casillaLibre(pos))
			{
				temp=juego.juegaAutomatico(pos);
				delay();
				if (temp==11)
				{
					setTitle("GANO! DE CLICK PARA VOLVER A JUGAR.");
					break;
				}
				else if(temp==10)
				{
					setTitle("EMPATE. DE CLICK PARA VOLVER A JUGAR.");
					break;
				}
				else if(temp==9)
				{
					setTitle("PERDIO. DE CLICK PARA VOLVER A JUGAR.");
					break;
				}		
			}

			if (!juego.hayCasillaLibre())
			{
				setTitle("Gato");
				reinicia();
			}
			else if(juego.esGanador(Jugadores.JUGADOR2))
			{
				setTitle("Gato");
				reinicia();
			}
			else if(juego.esGanador(Jugadores.JUGADOR1))
			{
				setTitle("Gato");
				reinicia();
			}
		}
	}
	public void actualizarPos()
	{
		for(int j=0;j<9;j++){
		if(juego.estaEnCasilla(j)==Jugadores.JUGADOR1)
			posicion[j].setText(juego.getFichaJ(Jugadores.JUGADOR1));
		else if(juego.estaEnCasilla(j)==Jugadores.JUGADOR2)
			posicion[j].setText(juego.getFichaJ(Jugadores.JUGADOR2));
		else
			posicion[j].setText("");
		}
	}
	public void reinicia()
	{
		for(int i=0;i<9;i++)
			posicion[i].setText("");
		juego.reinicia();
		delay();
	}
	public void delay()
	{
		try
		{
			Thread.sleep(200);
			actualizarPos();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}