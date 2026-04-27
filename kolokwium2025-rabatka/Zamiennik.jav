class Zamiennik extends Kwiatek {
    @Override
    public void podlej(){
        Wspolrzedne poleDoZamiany = 
            new Wspolrzedne(pole.getX() - 1, pole.getY());

        if (rabatka.czyPoleWRabatce(poleDoZamiany) && 
            !rabatka.czyPolePuste(poleDoZamiany)){

            rabatka.zamienMiejscami(pole, poleDoZamiany);
        }
    }

    public String toString(){
        return "Z";
    }
}
