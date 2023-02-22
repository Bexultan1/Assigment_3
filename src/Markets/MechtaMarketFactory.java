package Markets;

public class MechtaMarketFactory implements MarketFactory{
    @Override
    public Market createMarket() {
        return new Mechta();
    }
}
