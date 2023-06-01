package N3Gallery.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Formatter {
  public static String formatRupiah(double amount) {
    Locale indonesiaLocale = new Locale("id", "ID");

    Currency rupiahCurrency = Currency.getInstance("IDR");

    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(indonesiaLocale);

    DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
    DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
    decimalFormatSymbols.setCurrencySymbol("Rp ");
    decimalFormatSymbols.setInternationalCurrencySymbol("IDR ");
    decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

    decimalFormat.setCurrency(rupiahCurrency);
    decimalFormat.setGroupingUsed(true); 
    
    return decimalFormat.format(amount);
}
}
