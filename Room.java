
public class Room implements Comparable<Room> {
	
	private String symbol;
	private int pokoj;
	private String opis;
	
	public Room(String symbol, int pokoj, String opis){
		this.symbol = symbol;
		this.pokoj = pokoj;
		this.opis = opis;
	}
	

	public Room() {}


	String getSymbol(){
		return symbol;
	}
	
	int getPokoj(){
		return pokoj;
	}
	
	String getOpis(){
		return opis;
	}
	
	void setSymbol(String x){
		symbol = x;
	}
	
	void setPokoj(int x){
		pokoj = x;
	}
	
	void setOpis(String x){
		opis = x;
	}

	@Override
	public int compareTo(Room x) {
		int symbolDiff = symbol.compareToIgnoreCase(x.getSymbol());
		if(symbolDiff != 0){
			return symbolDiff;
		}
		return pokoj-x.getPokoj();
	}
	
	@Override
	public String toString(){
		return String.format("Budynek %s : Pokój nr %d (%s)", symbol, pokoj, opis);
		
	}
	
	@Override public boolean equals(Object o){
		if(!(o instanceof Room))
			return false;
		Room x = (Room)o;
		return x.symbol == symbol && x.pokoj == pokoj;
	}

}
