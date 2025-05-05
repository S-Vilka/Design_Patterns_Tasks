package facade;

public class JokeApp {
    public static void main(String[] args) {
        ApiFacade api = new ApiFacade();

        try {
            String joke = api.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            System.out.println("Error fetching joke: " + e.getMessage());
        }
    }
}