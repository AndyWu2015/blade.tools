package blade.migrate.liferay70;

import java.io.File;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import blade.migrate.api.FileMigrator;
import blade.migrate.core.JavaFileChecker;
import blade.migrate.core.JavaFileMigrator;
import blade.migrate.core.SearchResult;

@Component(
	property = {
		"file.extensions=java,jsp,jspf",
		"problem.summary=All BackgroundTask APIs previously exposed as Liferay Portal API in 6.2 have been move out from portal-service into separate OSGi modules",
		"problem.tickets=LPS-57740",
		"problem.title=BackgroundTask APIs migrated to OSGi module",
		"problem.url="
	},
	service = FileMigrator.class
)
public class BackgroundTaskLegacyAPI extends JavaFileMigrator {

	private static final String[] SERVICE_API_PREFIXES = {
		"com.liferay.portal.service.BackgroundTask"
	};

	@Override
	protected List<SearchResult> searchJavaFile(File file, JavaFileChecker javaFileChecker) {
		return javaFileChecker.findServiceAPIs(SERVICE_API_PREFIXES);
	}

}
