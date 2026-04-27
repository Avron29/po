public class Ekspansor extends Kwiatek {
    
    private int liczbaPlatkow;

    public int getPlatki(){ return liczbaPlatkow; };
    public void setPlatki(int platki){ liczbaPlatkow = platki; }

    @Override
    public void podlej(){
        // Iteruje wszystkie sasiednie pola
        for (int i = pole.getX() - 1; i <= 1; i++){
            for (int j = pole.getY() -1; j <= 1; j++){
                Wspolrzedne obecnePole = new Wspolrzedne(i, j);

                if ((i == pole.getX() && j == pole.getY()) ||
                    !rabatka.czyPoleWRabatce(obecnePole) ||
                    rabatka.czyPolePuste(obecnePole)){
                    continue;
                }
                rabatka.posadzKwiatek(new Ekspansor(), new Wspolrzedne(i, j));
            }
        }
    }

    @Override
    public String toString(){
        return Integer.toString(liczbaPlatkow);
    }
}

