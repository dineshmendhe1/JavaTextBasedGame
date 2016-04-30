
// class to check game end when player collects all items in a bag.
public class GameEndIfCollectedAllItems implements GameEnd {

	// overridden method from GameEnd interface.
	@Override
    public boolean gameEndCheck(Inventory player) {
        return player.hasItemNamed("bag");
    }
}
