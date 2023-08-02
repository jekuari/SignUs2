/**
 * This class is used to store the options for a card.
 * It stores the image path, the letter, and the position.
 * The position is used to determine the order of the cards.
 * The letter is used to determine if the cards are a match.
 * The image path is used to display the card.
 */
public class CardOptions {
  public String imagePath;
  public int width;
  public int height;
  public char letter;
  public int position;

  /**
   * Contructor
   * Parameters:
   * * imagePath - The path to the image for the card
   * * letter - The letter for the card
   */
  public CardOptions(String imagePath, char letter) {
    this.imagePath = imagePath;
    this.letter = letter;
  }
}
