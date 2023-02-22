package Markets;

public class TehnodomMarketFactory implements MarketFactory{
    @Override
    public Market createMarket() {
        return new Tehnodom();
    }
}
