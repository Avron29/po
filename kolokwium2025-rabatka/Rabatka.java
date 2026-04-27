public class Rabatka {
    private Kwiatek rabatka[][];
    private Wspolrzedne rozmiar
    
    public Rabatka(Wspolrzedne rozmiar){
        this.rabatka = new Kwiatek[rozmiar.getY()][rozmiar.getX()];
        this.rozmiar = new Wspolrzedne(rozmiar.getY(), rozmiar.getX());
    }

    private Kwiatek getKwiatekNaPolu(Wspolrzedne pole){
        return rabatka[pole.getY()][pole.getX()];
    }

    private void setKwiatekNaPolu(Kwiatek kwiatek, Wspolrzedne pole){
        rabatka[pole.getY()][pole.getX()] = kwiatek;
    }

    public boolean czyPoleWRabatce(Wspolrzedne pole){
        return (pole.getY() >= 0 && pole.getY() < rozmiar.getY() &&
                pole.getY() >= 0 && pole.getX() < rozmiar.getX());
    }

    public boolean czyPolePuste(Wspolrzedne pole){
        assert czyPoleWRabatce(pole);
        return (getKwiatekNaPolu(pole) == null);
    }

    // Sadzi nawet jesli jest juz tam kwiatek
    public void posadzKwiatek(Kwiatek kwiatek, Wspolrzedne pole){
        assert czyPoleWRabatce(pole);

        kwiatek.posadzNaRabtce(rabatka);
        kwiatek.posadzNaPolu(pole);

        setKwiatekNaPolu(kwiatek, pole);
    }

    public void zamienKwiatki(Wspolrzedne pole1, Wspolrzedne pole2){
        assert czyPoleWRabatce(pole1) && czyPoleWRabatce(pole2);

        getKwiatekNaPolu(pole2).posadzNaPolu(pole1);
        getKwiatekNaPolu(pole1).posadzNaPolu(pole2);

        Kwiatek tymczasowy = getKwiatekNaPolu(pole1);
        setKwiatekNaPolu(getKwiatekNaPolu(pole2), pole1);
        setKwiatekNaPolu(tymczasowy, pole2);
    }


    public void podlej(){
        for (int i = 0; i < rozmiar.getY(); i++){
            for (int j = 0; j < rozmiar.getX(); j++){
                if (rabatka[i][j] != null){
                    rabatka[i][j].podlej();
                }
            }
        }
    }

    // Odwraca wlacznie z poczatek, bez koniec
    private void odwrocKawalekWiersza(int wiersz, int poczatek, int koniec){
        for (int i = 0; i < koniec - poczatek; i++){
            zamienKwiatki(new Wspolrzedne(poczatek + i, wiersz), 
                          new Wspolrzedne(koniec - 1 - i, wiersz));
        }
    }

    // n - liczba miejsc do przesuniecia
    // korzysta z algorytmu opowiedzianego na koncu labow
    private void przesunCyklicznieWiersz(int wiersz, int n){
        odwrocKawalekWiersza(wiersz, 0, rozmiar.getX());
        odwrocKawalekWiersza(wiersz, 0, n);
        odwrocKawalekWiersza(wiersz, n, rozmiar.getX());
    }

    public void TajemniczyTaniec(){
        for (int wiersz = 0; wiersz < rozmiar.getY(); wiersz++){
            przesunCyklicznieWiersz(wiersz, (wiersz + 1) % rozmiar.getX());
        }
    }

    public String toString(){
        String wynik = "";
        for (int i = 0; i < rozmiar.getY(); i++){
            for (int j = 0; j < rozmiar.getX(); j++){
                if (rabatka[i][j] == null){
                    wynik = wynik + '.';
                }
                else {
                    wynik = wynik + rabatka[i][j].toString();
                }
            wynik = wynik + '\n';
        }
        return wynik;
    }
}


