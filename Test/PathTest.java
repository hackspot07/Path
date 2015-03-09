import com.Path.Database;
import com.Path.PathFinder;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;



public class PathTest{
	private Map<String, List<String>> getDB()throws Exception{
		return Database.createDbDatabase();
	}
	@Test
	public void pathWillReturnTruefromBangaloreToSingapore()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		boolean getPathStatus  = pf.path("Bangalore","Singapore");
		assertEquals(getPathStatus,true);
	}
	@Test
	public void pathWillReturntruefromBangaloreToSeoul()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		boolean getPathStatus  = pf.path("Bangalore","Seoul");
		assertEquals(getPathStatus,true);
	}
	@Test
	public void pathWillReturnNocityAsGivenSource()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		try{
			pf.path("Mumbai","Seoul");
		}catch(Exception e){
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(), "No city Named Mumbai");
		}
	}
	@Test
	public void pathWillReturnNocityAsGivenDestination()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		try{
			pf.path("Bangalore","Mumbai");
		}catch(Exception e){
			assertEquals(e.getMessage(), "No city Named Mumbai");
		}
	}
	@Test
	public void pathWillReturntruewForSingaporeToDubai()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		boolean getPathStatus  = pf.path("Singapore","Dubai");
		assertEquals(getPathStatus,true);
	}
	@Test
	public void pathWillReturntruewForSingaporeToSeoul()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		boolean getPathStatus  = pf.path("Singapore","Seoul");
		assertEquals(getPathStatus,true);
	}
	@Test
	public void pathWillReturnTrueFromBangaloretoTokyo()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		boolean getPathStatus  = pf.path("Bangalore","Tokyo");
		assertEquals(getPathStatus,true);
	}
	@Test
	public void pathWillReturnTrueFromTokyotoBangalore()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		boolean getPathStatus  = pf.path("Tokyo","Bangalore");
		assertEquals(getPathStatus,true);
	}
	@Test
	public void pathWillReturnfalseFromTokyotoPak()throws Exception{
		PathFinder pf = new PathFinder(getDB());
		boolean getPathStatus  = pf.path("Tokyo","Pak");
		assertEquals(getPathStatus,false);
	}
};