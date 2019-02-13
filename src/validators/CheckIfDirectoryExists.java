import java.io.File; 
public class CheckIfDirectoryExists {
	public boolean CheckIfDirectoryExists(String outputDirectory){       
        File dir = new File(outputDirectory);
         
        // Tests whether the directory denoted by this abstract pathname exists.
        boolean exists = dir.exists();
         return exists;   
    }
}
