
package blade.migrate.liferay70;

import blade.migrate.api.FileMigrator;
import blade.migrate.core.SearchResult;
import blade.migrate.core.XMLFileChecker;
import blade.migrate.core.XMLFileMigrator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"file.extensions=xml",
		"problem.title=Removed Support for filterFindBy Generation or InlinePermissionUtil Usage for Tables When the Primary Key Type Is Not long",
		"problem.summary=ServiceBuilder and inline permission filter support has been removed for non-long primary key types.",
		"problem.tickets=LPS-54590",
		"problem.url=https://github.com/liferay/liferay-portal/blob/master/readme/7.0/BREAKING_CHANGES.markdown#removed-support-for-filterfindby-generation-or-inlinepermissionutil-usage-for-tables-when-the-primary-key-type-is-not-long"
	},
	service = FileMigrator.class
)
public class PrimaryKeyNotLongInServiceBuilder extends XMLFileMigrator {

	@Override
	protected List<SearchResult> searchXMLFile(File file) {
		// check if it is service.xml file

		if (!"service.xml".equals(file.getName())) {
			return Collections.emptyList();
		}

		final XMLFileChecker xmlFileChecker = new XMLFileChecker(file);

		final List<SearchResult> results = new ArrayList<>();

		results.addAll(xmlFileChecker.findPK("column", new String[] {
				"primary=true", "type=int" }));
		results.addAll(xmlFileChecker.findPK("column", new String[] {
				"primary=true", "type=float" }));
		results.addAll(xmlFileChecker.findPK("column", new String[] {
				"primary=true", "type=double" }));
		results.addAll(xmlFileChecker.findPK("column", new String[] {
				"primary=true", "type=boolean" }));
		results.addAll(xmlFileChecker.findPK("column", new String[] {
				"primary=true", "type=short" }));

		return results;
	}

}
