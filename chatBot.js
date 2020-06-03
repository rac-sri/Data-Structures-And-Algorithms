public class chatBot {
  chatBot question;
  chatBot yes, no, recommendation;

  chatBot(chatBot question, chatBot recommendation) {
    this.question = question;
    this.yes = null;        String question;
    String yes , no;
    this.no = null;
    this.recommendation = recommendation;
  }

  private chatBot insertChild(
    chatBot question,
    chatBot recommendation,
    String side
  )
    throws Exception {
    chatBot newTree = new chatBot(question, recommendation);
    Field field = chatBot.class.getField(side);
    field.set(this, newTree);
    return newTree;
  }
}
