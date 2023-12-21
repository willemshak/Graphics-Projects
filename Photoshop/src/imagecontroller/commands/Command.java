package imagecontroller.commands;

import java.io.IOException;

import imagemodel.IImageModel;

/**
 * Interface for a Command on an IImageModels. For the command design pattern, and each Command
 * is a function object.
 */
public interface Command {

  /**
   * The command to execute based on the object.
   *
   * @param model The model that the command is operating on.
   * @throws IOException if the model is invalid (hashmap doesn't have correct values).
   */
  void execute(IImageModel model) throws IOException;
}
