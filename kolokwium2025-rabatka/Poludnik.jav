class Poludnik extends Kwiatek {
    @Override
    public void podlej(){
        // Do gory
        for (int i = pole.getY() - 1; i >= 0; i--){
            Wspolrzedne obecnePole = new Wspolrzedne(pole.getX(), i);
            if (!rabatka.czyPolePuste(obecnePole)){
                break;
            }
            rabatka.posadzKwiatek(new Poludnik(), obecnePole);
        }
        // Do dolu
        for (int i = pole.getY + 1; i < rabatka.rozmiar.getY(); i++){
            Wspolrzedne obecnePole = new Wspolrzedne(pole.getX(), i);
            if (!rabatka.czyPolePuste(obecnePole)){
                break;
            }
            rabatka.posadzKwiatek(new Poludnik(), obecnePole);
    }

    public String toString(){
        return "P";
    }
}

