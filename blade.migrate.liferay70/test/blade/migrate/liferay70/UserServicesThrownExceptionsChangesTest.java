
package blade.migrate.liferay70;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import blade.migrate.api.Problem;

public class UserServicesThrownExceptionsChangesTest
{
	final File testFile = new File( "projects/filetests/UserServicesThrownExceptionsChangesTest.java" );
	UserServicesThrownExceptionsChanges cte;

	@Before
	public void beforeTest()
	{
		assertTrue( testFile.exists() );
		cte = new UserServicesThrownExceptionsChanges();
	}

    @Test
    public void ChangesUserServicesAnalyzeTest() throws Exception
    {
        List<Problem> problems = cte.analyzeFile(testFile);

        assertNotNull( problems );
        assertEquals( 2, problems.size() );
    }

    @Test
    public void ChangesUserServicesAnalyzeTestTwice() throws Exception
    {
    	List<Problem> problems = cte.analyzeFile(testFile);
    	problems = cte.analyzeFile(testFile);

        assertNotNull( problems );
        assertEquals( 2, problems.size() );
    }
}