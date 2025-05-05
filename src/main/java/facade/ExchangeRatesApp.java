package facade;

public class ExchangeRatesApp {
    public static void main(String[] args) {
        ApiFacade api = new ApiFacade();
        String apiUrl = "https://api.fxratesapi.com/latest";

        try {
            // Retrieve the specific rates using the nested key paths.
            String usdRate = api.getAttributeValueFromJson(apiUrl, "rates.USD");
            String eurRate = api.getAttributeValueFromJson(apiUrl, "rates.EUR");
            String gbpRate = api.getAttributeValueFromJson(apiUrl, "rates.GBP");
            String jpyRate = api.getAttributeValueFromJson(apiUrl, "rates.JPY");

            System.out.println("Exchange Rates:");
            System.out.println("USD: " + usdRate);
            System.out.println("EUR: " + eurRate);
            System.out.println("GBP: " + gbpRate);
            System.out.println("JPY: " + jpyRate);
        } catch (Exception e) {
            System.out.println("Error retrieving exchange rates: " + e.getMessage());
            e.printStackTrace();
        }
    }
}