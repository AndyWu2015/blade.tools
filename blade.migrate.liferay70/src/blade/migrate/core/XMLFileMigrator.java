package blade.migrate.core;

import blade.migrate.api.FileMigrator;
import blade.migrate.api.Problem;

import java.io.File;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;

/**
 * @author Andy Wu
 */
public abstract class XMLFileMigrator implements FileMigrator {

	@Activate
	public void activate(ComponentContext ctx) {
		_context = ctx;

		final Dictionary<String, Object> properties = _context.getProperties();

		_problemTitle = (String)properties.get("problem.title");
		_problemUrl = (String)properties.get("problem.url");
		_problemSummary = (String)properties.get("problem.summary");
		_problemType = (String)properties.get("file.extensions");
		_problemTickets = (String)properties.get("problem.tickets");
	}

	@Override
	public List<Problem> analyzeFile(File file) {
		final List<Problem> problems = new ArrayList<>();

		final List<SearchResult> searchResults = searchXMLFile(file);

		if (searchResults != null) {
			for (SearchResult searchResult : searchResults) {
				Problem problem = new Problem(
						_problemTitle, _problemUrl, _problemSummary,
						_problemType, _problemTickets, file,
						searchResult.startLine, searchResult.startOffset,
						searchResult.endOffset);

				problems.add(problem);
			}
		}

		return problems;
	}

	protected abstract List<SearchResult> searchXMLFile(File file);

	private ComponentContext _context;
	private String _problemSummary;
	private String _problemTickets;
	private String _problemTitle;
	private String _problemType;
	private String _problemUrl;

}