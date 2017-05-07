package by.vorokhobko.Templates;
/**
 * TemplatesAction.
 *
 * Class TemplatesAction abstract class 002, lesson 7.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 05.05.2017.
 * @version 1.
 */
public abstract class TemplatesAction {
	/**
	 * Abstract method determining the start program.
	 */
	abstract void start();
	/**
	 * Abstract method determining the finish program.
	 */
	abstract void finish();
	/**
	 * Method determining work program.
	 */
	public void work() {
		this.start();
		this.finish();
	}
	/**
	 * Main method.
	 * @param args - args.
	 */
	public static void main(String[] args) {
		new CopyAction();
	}
}