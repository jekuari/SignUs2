public class CardOptions {
   public String imagePath;
   public int width;
   public int height;
   public char letter;
   public int position;

   public CardOptions(String imagePath, char letter) {
      this.imagePath = imagePath;
      this.letter = letter;
   }
}
