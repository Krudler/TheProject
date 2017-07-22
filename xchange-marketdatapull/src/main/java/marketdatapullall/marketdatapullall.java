package marketdatapullall;
import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.gdax.GDAXExchange;//all the other versions of this library will need to be imported. could probs use excel concatenate to copy and paste quickly but I'm sleepy
import org.knowm.xchange.service.marketdata.MarketDataService;

public class marketdatapullall {
	
	 static Exchange[] exchanges = { ExchangeFactory.INSTANCE.createExchange(GDAXExchange.class.getName())};
	 //full list below, all libraries needed for it to work. some of the exchanges are probs broken/wrong and will need to be deleted/replaced.
	 //static Exchange[] exchanges = { ExchangeFactory.INSTANCE.createExchange(ANXv2Exchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(ANXv3Exchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(Atlas ATSExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitbayExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(bitcoin.deExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitcurexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitKonanExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitMarketExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitsoExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BittrexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitVCExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BleutradeExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BTC38Exchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BTCCentralExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BTCChinaExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BTC-EExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BTCTradeExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BterExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CampBXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CaVirtexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(C-CEXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(cex.ioExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(ClevercoinExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CoinbaseExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CoinfloorExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CoinmateExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CoinsetterExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CointraderExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(Crypto FacilitiesExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CryptonitExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CryptsyExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(DSXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(EmpoEXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(GateCoinExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(GDAXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(HitBTCExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(HuobiExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(Independent ReserveExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(itBitExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(JubiExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(KrakenExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(LakeBTCExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(LoyalBitExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(Mercado BitcoinExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(meXBTExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(OKCoinExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(PoloniexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(QuoineExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(RippleExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(TaurusExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(The RockExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(VircurexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(YacunaExchange.class.getName())};
	 
	public static void main(String[] args) throws IOException { 
		for (Exchange ex: exchanges){
		
		Exchange exch = ex;
		MarketDataService MDS = exch.getMarketDataService();
		 
		System.out.println(ex + " Ask: " + getAsk(MDS) + " Ask Volume: " + getAVolume(MDS) + " Bid: " + getBid(MDS) + " Bid Volume: " + getBVolume(MDS));
		//txtATime.setText(getATime(GDaxMDS)); // NOTE THAT THESE ARE COMMENTED OUT BECAUSE THEY CAUSE EVERYTHING TO CRASH DUE TO THE RETURNED NULL VALUE
		//txtBTime.setText(getBTime(GDaxMDS));
		    
		}

	}
	
		//gets the latest asking price for ETH from GDAX 
		public static String getAsk(MarketDataService MDS) throws IOException {
			
			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
			
			return OB.getAsks().get(0).getLimitPrice().toString();//the getAsks function returns a list and the function get(0) specifies that you want the thing in the list at position 0, which is always the newest thing. 
		} 
		
		//gets the amount of ETH being offered for the asking price
		public static String getAVolume(MarketDataService MDS) throws IOException {
			
			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
			
			return OB.getAsks().get(0).getTradableAmount().toString();
		} 

		//gets the timestamp for the latest asking price NOTE: This always returns null so if you try and write it to text box it'll break the app
		public static String getATime(MarketDataService MDS) throws IOException {
		
		OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
		
		return OB.getAsks().get(0).getTimestamp().toString();
		} 
		
		
		//Functions that get the latest bid information - works the same as getting the ask information
		public static String getBid(MarketDataService MDS) throws IOException {
			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
			
			return OB.getBids().get(0).getLimitPrice().toString();
		} 
		
		public static String getBVolume(MarketDataService MDS) throws IOException {
			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
			
			return OB.getBids().get(0).getTradableAmount().toString();
		} 
		
		public static String getBTime(MarketDataService MDS) throws IOException {
			OrderBook OB =MDS.getOrderBook(CurrencyPair.BTC_USD,3);
			
			return OB.getBids().get(0).getTimestamp().toString();
		} 
}
