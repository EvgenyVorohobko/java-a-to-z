 package by.vorokhobko.Templates;
 
 public abstract class TemplatesAction {
	 abstract void start();
	 
	 abstract void finish();
	 
	 public void work() {
		 this.start();
		 this.finish();
	 }
	 
	 public static void main(String[] args) {
		 new CopyAction();
	 }
 }