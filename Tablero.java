class Tablero
{
	private int[] casilla;
	private int i;
	Tablero()
	{
		casilla=new int[9];
		for(i=0;i<9;i++)
			casilla[i]=0;
	}

	public boolean casillaLibre(int posicion)
	{
		return casilla[posicion]==0 ? true: false;
	}
	public void marcarCasilla(int Jugador,int posicion)
	{
		casilla[posicion]=Jugador;
	}
	public int estaEnCasilla(int posicion)
	{
		return casilla[posicion];
	}
	public boolean esGanador(int Jugador)
	{
		//Diagonal
		if(casilla[0]==Jugador&&casilla[4]==Jugador&&casilla[8]==Jugador||casilla[2]==Jugador&&casilla[4]==Jugador&&casilla[6]==Jugador)
			return true;
		//Horizontal
		for(i=0;i<9;i+=3)
			if(casilla[i]==Jugador&&casilla[i+1]==Jugador&&casilla[i+2]==Jugador)
				return true;
		//Vertical
		for(i=0;i<3;i++)
			if(casilla[i]==Jugador&&casilla[i+3]==Jugador&&casilla[i+3*2]==Jugador)
				return true;

		return false;
	}
	public void reinicia()
	{
		for(i=0;i<9;i++)
			casilla[i]=0;	
	}
	public boolean hayCasillaLibre()
	{
		for(i=0;i<9;i++)
			if(casillaLibre(i))
				return true;
		return false;
	}
}