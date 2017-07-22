package marketdatapullall;

//Non Specific 
import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dsx.DSXExchange;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
//Exchange Specific
import org.knowm.xchange.anx.v2.ANXExchange;
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
import org.knowm.xchange.bter.BTERExchange;
import org.knowm.xchange.campbx.CampBXExchange;
import org.knowm.xchange.ccex.CCEXExchange;
import org.knowm.xchange.cexio.CexIOExchange;
import org.knowm.xchange.coinbase.CoinbaseExchange;
import org.knowm.xchange.coinfloor.CoinfloorExchange;
import org.knowm.xchange.coinmate.CoinmateExchange;
import org.knowm.xchange.cryptofacilities.CryptoFacilitiesExchange;
import org.knowm.xchange.cryptonit.v2.CryptonitExchange;
import org.knowm.xchange.empoex.EmpoExExchange;
import org.knowm.xchange.gatecoin.GatecoinExchange;
import org.knowm.xchange.gdax.GDAXExchange;
import org.knowm.xchange.huobi.HuobiExchange;
import org.knowm.xchange.independentreserve.IndependentReserveExchange;
import org.knowm.xchange.itbit.v1.ItBitExchange;
import org.knowm.xchange.jubi.JubiExchange;
import org.knowm.xchange.kraken.KrakenExchange;
import org.knowm.xchange.lakebtc.LakeBTCExchange;
import org.knowm.xchange.mercadobitcoin.MercadoBitcoinExchange;
import org.knowm.xchange.poloniex.PoloniexExchange;
import org.knowm.xchange.quoine.QuoineExchange;
import org.knowm.xchange.ripple.RippleExchange;
import org.knowm.xchange.taurus.TaurusExchange;
import org.knowm.xchange.therock.TheRockExchange;
import org.knowm.xchange.vircurex.VircurexExchange;
import org.knowm.xchange.yobit.YoBitExchange;

public class marketdatapullall {
	

	 static Exchange[] BTCUSDexchanges = {ExchangeFactory.INSTANCE.createExchange(ANXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitbayExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BTCEExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(BTCTradeExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CampBXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CCEXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CexIOExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CoinbaseExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(CryptonitExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(DSXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(GatecoinExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(GDAXExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(HuobiExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(ItBitExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(KrakenExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(QuoineExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(VircurexExchange.class.getName()), ExchangeFactory.INSTANCE.createExchange(YoBitExchange.class.getName())};
	 
	public static void main(String[] args) throws IOException { 
		
		for (Exchange ex: BTCUSDexchanges){
		
		Exchange exch = ex;
		MarketDataService MDS = exch.getMarketDataService();
		
	    // Get the latest ticker data showing BTC to USD
	    Ticker ticker = MDS.getTicker(CurrencyPair.BTC_USD);
	    System.out.println(ex + ticker.toString());
		    
		}

	}
	

//		//gets the latest asking price for ETH from GDAX 
//		public static String getAsk(MarketDataService MDS) throws IOException {
//			
//			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
//			
//			return OB.getAsks().get(0).getLimitPrice().toString();//the getAsks function returns a list and the function get(0) specifies that you want the thing in the list at position 0, which is always the newest thing. 
//		} 
//		
//		//gets the amount of ETH being offered for the asking price
//		public static String getAVolume(MarketDataService MDS) throws IOException {
//			
//			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
//			
//			return OB.getAsks().get(0).getTradableAmount().toString();
//		} 
//
//		//gets the timestamp for the latest asking price NOTE: This always returns null so if you try and write it to text box it'll break the app
//		public static String getATime(MarketDataService MDS) throws IOException {
//		
//		OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
//		
//		return OB.getAsks().get(0).getTimestamp().toString();
//		} 
//		
//		
//		//Functions that get the latest bid information - works the same as getting the ask information
//		public static String getBid(MarketDataService MDS) throws IOException {
//			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
//			
//			return OB.getBids().get(0).getLimitPrice().toString();
//		} 
//		
//		public static String getBVolume(MarketDataService MDS) throws IOException {
//			OrderBook OB = MDS.getOrderBook(CurrencyPair.BTC_USD,3);
//			
//			return OB.getBids().get(0).getTradableAmount().toString();
//		} 
//		
//		public static String getBTime(MarketDataService MDS) throws IOException {
//			OrderBook OB =MDS.getOrderBook(CurrencyPair.BTC_USD,3);
//			
//			return OB.getBids().get(0).getTimestamp().toString();
//		} 
}
