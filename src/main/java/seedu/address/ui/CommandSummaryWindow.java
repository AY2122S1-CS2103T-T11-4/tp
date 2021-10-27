package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.CommandEnum;

/**
 * Controller for the Command Summary page.
 */
public class CommandSummaryWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(CommandSummaryWindow.class);
    private static final String FXML = "CommandSummaryWindow.fxml";

    @FXML
    private Accordion commandDescription;

    /**
     * Creates a new CommandSummaryWindow
     *
     * @param root Stage to use as the root of the CommandSummaryWindow.
     */
    public CommandSummaryWindow(Stage root) {
        super(FXML, root);
        for (CommandEnum command : CommandEnum.values()) {
            commandDescription.getPanes().add(new CommandDescCard(command, this).getRoot());
        }
    }

    public CommandSummaryWindow() {
        this(new Stage());
    }

    public void show() {
        logger.fine("Showing command summary page");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    public boolean isShowing() {
        return getRoot().isShowing();
    }

    public void hide() {
        getRoot().hide();
    }

    public void focus() {
        getRoot().requestFocus();
    }
}
