package eu.orionos.build;

import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Build {
	
	private BuildUnit units;
	private Config cfg;
	
	public Build(String path)
	{
		try {
			this.cfg = Config.getInstance(".config");
			this.cfg.configure();
			this.units = new BuildUnit(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			units.compile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DisabledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		new Build("main.build");
	}
}
