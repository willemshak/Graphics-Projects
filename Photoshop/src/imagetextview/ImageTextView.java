package imagetextview;

import java.io.IOException;

/**
 * Interface for an ImageTextView. Displays messages from the controller.
 */
public interface ImageTextView {

  /**
   * Renders a message to some appendable (typically System.in).
   *
   * @param s The message to append.
   * @throws IOException When the message can't be appended to the appendable.
   */
  void renderMessage(String s) throws IOException;
}
