public class Solution {

  public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
    int l = a.size();
    ArrayList<String> res = new ArrayList<String>();
    int maxLengthTillIndexInLine = 0, currentWordIndex = 0, wordCount =
      0, totalLengthInThisLine = 0;
    while (currentWordIndex < l) {
      //if not first line we need a space minimum before adding next word
      if (wordCount != 0) maxLengthTillIndexInLine++;
      maxLengthTillIndexInLine += a.get(currentWordIndex).length();
      //if length tillthis point doesnot exceed required length
      if (maxLengthTillIndexInLine <= b) {
        wordCount++;
        totalLengthInThisLine += a.get(currentWordIndex).length();
        currentWordIndex++;
        //if currentIndex is last word i.e. while will exit next time
        // Here is where program ends
        if (currentWordIndex == l) {
          StringBuilder sb = new StringBuilder();
          while (wordCount > 0) {
            sb.append(a.get(currentWordIndex - wordCount--));
            if (wordCount != 0) sb.append(" ");
          }
          totalLengthInThisLine = sb.length();
          while (totalLengthInThisLine++ < b) {
            sb.append(" ");
          }
          res.add(sb.toString());
        }
      } else {
        StringBuilder sb = new StringBuilder();
        // if there is only onw word in line
        if (wordCount == 1) {
          sb.append(a.get(currentWordIndex - 1));
          while (totalLengthInThisLine++ < b) {
            sb.append(" ");
          }
        } else {
          // if we have more than one word in line
          // If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
          int tempWordCount = wordCount;
          int totalSpaces = (b - totalLengthInThisLine);
          while (tempWordCount > 1) {
            int spacesAfterWord = (totalSpaces % (tempWordCount - 1) > 0)
              ? (totalSpaces / (tempWordCount - 1) + 1)
              : (totalSpaces / (tempWordCount - 1));
            totalSpaces -= spacesAfterWord;
            sb.append(a.get(currentWordIndex - tempWordCount--));
            while (spacesAfterWord-- > 0) {
              sb.append(" ");
            }
          }
          sb.append(a.get(currentWordIndex - 1));
        }
        res.add(sb.toString());
        wordCount = 0;
        maxLengthTillIndexInLine = 0;
        totalLengthInThisLine = 0;
      }
    }
    return res;
  }
}
