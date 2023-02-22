package Markets;

public class AlserMarketFactory implements MarketFactory{
    @Override
    public Market createMarket() {
        return new Alser();
    }
}
