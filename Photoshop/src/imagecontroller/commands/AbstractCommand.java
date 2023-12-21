package imagecontroller.commands;

/**
 * Abstract class for a command. All commands take in a old and new name, so that
 * the commands can be saved to a new location.
 */
public abstract class AbstractCommand implements Command {
  protected String oldName;
  protected String newName;

  AbstractCommand(String oldName, String newName) {
    this.oldName = oldName;
    this.newName = newName;
  }
}
