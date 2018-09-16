package console.command;

public interface ICommandListener {
	public void onExecute(String head, String[] param);
}
