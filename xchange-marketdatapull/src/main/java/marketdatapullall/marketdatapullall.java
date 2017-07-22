package marketdatapullall;
import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitbay.BitbayExchange;
import org.knowm.xchange.bitcurex.BitcurexExchange;
import org.knowm.xchange.bitfinex.v1.BitfinexExchange;
import org.knowm.xchange.bitmarket.BitMarketExchange;
import org.knowm.xchange.bitso.BitsoExchange;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.bittrex.v1.BittrexExchange;
import org.knowm.xchange.bleutrade.BleutradeExchange;
import org.knowm.xchange.btcchina.BTCChinaExchange;
import org.knowm.xchange.btce.v3.BTCEExchange;
import org.knowm.xchange.btctrade.BTCTradeExchange;
import org.knowm.xchange.campbx.CampBXExchange;
import org.knowm.xchange.ccex.CCEXExchange;
import org.knowm.xchange.coinbase.CoinbaseExchange;
import org.knowm.xchange.coinfloor.CoinfloorExchange;
import org.knowm.xchange.coinmate.CoinmateExchange;
import org.knowm.xchange.cryptofacilities.CryptoFacilitiesExchange;
import org.knowm.xchange.cryptonit.v2.CryptonitExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.examples.anx.v2.marketdata.ANXTickerDemo;
import org.knowm.xchange.gdax.GDAXExchange;//all the other versions of this library will need to be imported. could probs use excel concatenate to copy and paste quickly but I'm sleepy
import org.knowm.xchange.huobi.HuobiExchange;
import org.knowm.xchange.independentreserve.IndependentReserveExchange;
import org.knowm.xchange.jubi.JubiExchange;
import org.knowm.xchange.kraken.KrakenExchange;
import org.knowm.xchange.lakebtc.LakeBTCExchange;
import org.knowm.xchange.mercadobitcoin.MercadoBitcoinExchange;
import org.knowm.xchange.poloniex.PoloniexExchange;
import org.knowm.xchange.quoine.QuoineExchange;
import org.knowm.xchange.ripple.RippleExchange;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.taurus.TaurusExchange;
import org.knowm.xchange.therock.TheRockExchange;
import org.knowm.xchange.vircurex.VircurexExchange;

public class marketdatapullall {
	
	 //static Exchange[] exchanges = { ExchangeFactory.INSTANCE.createExchange(GDAXExchange.class.getName())};
	 //full list below, all libraries needed for it to work. some of the exchanges are probs broken/wrong and will need to be deleted/replaced.
	 static Exchange[] exchanges = { ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName()),ExchangeFactory.INSTANCE.createExchange(BTCEExchange.class.getName()),  ExchangeFactory.INSTANCE.createExchange(CCEXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(GDAXExchange.class.getName()),ExchangeFactory.INSTANCE.createExchange(KrakenExchange.class.getName())};
	 
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
