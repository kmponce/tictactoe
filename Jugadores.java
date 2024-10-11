class Jugadores
{
	public static final int JUGADOR1=1;
	public static final int JUGADOR2=2;

	//Tipos de jugadores

	private String fichaJ1;
	private String fichaJ2;

	Jugadores()
	{
		fichaJ1="X";
		fichaJ2="O";
	}

	Jugadores(String fichaJ1,String fichaJ2)
	{
		this.fichaJ1=fichaJ1;
		this.fichaJ2=fichaJ2;
	}

	public String getFichaJ(int numJugador)
	{
		if(numJugador==JUGADOR1)
			return fichaJ1;
		return fichaJ2;
	}
}