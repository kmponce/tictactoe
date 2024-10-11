import java.util.*;

class Juego extends Tablero
{
	private int partida;
	private Jugadores jugadores;
	private Random random;
	private int aleatorio;
	Juego()
	{
		super();
		jugadores=new Jugadores();
		partida=0;
		reinicia();
	}
	Juego(String fichaJ1, String fichaJ2)
	{
		super();
		jugadores=new Jugadores(fichaJ1,fichaJ2);
		partida=0;
		reinicia();
	}
	public String getFichaJ(int numJugador)
	{
		return jugadores.getFichaJ(numJugador);
	}
	public void reinicia()
	{
		int temp=getRanPos();
		super.reinicia();
		if(partida%2==1)	//Inicia Jugador2
		{
			marcarCasilla(Jugadores.JUGADOR2,temp);	
		}
		partida+=1;
	}
	public int jugadas(int Jugador, int num)
	{
		int temp;
		if(estaEnCasilla(0)==0)
			if(estaEnCasilla(1)==Jugador&&estaEnCasilla(2)==Jugador||estaEnCasilla(3)==Jugador&&estaEnCasilla(6)==Jugador||estaEnCasilla(4)==Jugador&&estaEnCasilla(7)==Jugador)
				return 0;
		if(estaEnCasilla(1)==0)
			if(estaEnCasilla(0)==Jugador&&estaEnCasilla(2)==Jugador||estaEnCasilla(4)==Jugador&&estaEnCasilla(7)==Jugador)
				return 1;
		if(estaEnCasilla(2)==0)
			if(estaEnCasilla(0)==Jugador&&estaEnCasilla(1)==Jugador||estaEnCasilla(4)==Jugador&&estaEnCasilla(6)==Jugador||estaEnCasilla(5)==Jugador&&estaEnCasilla(8)==Jugador)
				return 2;
		if(estaEnCasilla(3)==0)
			if(estaEnCasilla(0)==Jugador&&estaEnCasilla(6)==Jugador||estaEnCasilla(4)==Jugador&&estaEnCasilla(5)==Jugador)
				return 3;
		if(estaEnCasilla(4)==0)
			if(estaEnCasilla(0)==Jugador&&estaEnCasilla(8)==Jugador||estaEnCasilla(1)==Jugador&&estaEnCasilla(7)==Jugador||estaEnCasilla(2)==Jugador&&estaEnCasilla(6)==Jugador||estaEnCasilla(3)==Jugador&&estaEnCasilla(5)==Jugador)
				return 4;
		if(estaEnCasilla(5)==0)
			if(estaEnCasilla(0)==Jugador&&estaEnCasilla(8)==Jugador||estaEnCasilla(3)==Jugador&&estaEnCasilla(4)==Jugador)
				return 5;
		if(estaEnCasilla(6)==0)
			if(estaEnCasilla(0)==Jugador&&estaEnCasilla(3)==Jugador||estaEnCasilla(2)==Jugador&&estaEnCasilla(4)==Jugador||estaEnCasilla(7)==Jugador&&estaEnCasilla(8)==Jugador)
				return 6;
		if(estaEnCasilla(7)==0)
			if(estaEnCasilla(1)==Jugador&&estaEnCasilla(4)==Jugador||estaEnCasilla(6)==Jugador&&estaEnCasilla(8)==Jugador)
				return 7;
		if(estaEnCasilla(8)==0)
			if(estaEnCasilla(0)==Jugador&&estaEnCasilla(4)==Jugador||estaEnCasilla(2)==Jugador&&estaEnCasilla(5)==Jugador||estaEnCasilla(6)==Jugador&&estaEnCasilla(7)==Jugador)
				return 8;
		if(estaEnCasilla(num)==0)
			return num;
		else{
			num=getRanPos();
			temp=jugadas(Jugador,num);
		}
		return temp;
	}

	public int getRanPos()
	{
		random=new Random();
		aleatorio= random.nextInt(9);
		return aleatorio;
	}

	public int juegaAutomatico(int pos)
	{
		int temp;
		marcarCasilla(Jugadores.JUGADOR1,pos);
		if (esGanador(Jugadores.JUGADOR1))
		{
			return 11;
		}
		else if (!hayCasillaLibre())
		{
			return 10;
		}
		else
		{
			int n=getRanPos();
			//checamos si hay jugada ganadora para jugador dos
			temp=jugadas(Jugadores.JUGADOR2, n);
			marcarCasilla(Jugadores.JUGADOR2,temp);
			if(esGanador(Jugadores.JUGADOR2))
			{
				return 9;
			}
			else if (!hayCasillaLibre())
			{
				return 10;
			}
			else
			{
				marcarCasilla(0,temp);
				temp=jugadas(Jugadores.JUGADOR1, n);
				marcarCasilla(Jugadores.JUGADOR2,temp);
				if(esGanador(Jugadores.JUGADOR1))
				{
					return 11;
				}
					marcarCasilla(0,temp);
			}
			marcarCasilla(Jugadores.JUGADOR2,temp);
			}
		return temp;
	}
}