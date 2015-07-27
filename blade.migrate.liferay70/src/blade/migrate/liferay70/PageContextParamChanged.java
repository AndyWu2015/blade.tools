package blade.migrate.liferay70;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import blade.migrate.api.FileMigrator;
import blade.migrate.core.JavaFileChecker;
import blade.migrate.core.JavaFileMigrator;
import blade.migrate.core.SearchResult;

@Component(
	property = {
		"file.extensions=java,jsp,jspf",
		"problem.title=Using util-taglib No Longer Binds You to Using portal-service's javax.servlet.jsp Implementation",
		"problem.summary=Several APIs in portal-service.jar contained references to the javax.servlet.jsp package. This forced util-taglib, which depended on many of the package's features, to be bound to the same JSP implementation. " +
										"Due to this, the following APIs had breaking changes:" +
										"LanguageUtil," +
										"UnicodeLanguageUtil," +
										"VelocityTaglibImpl," +
										"ThemeUtil," +
										"RuntimePageUtil," +
										"PortletDisplayTemplateUtil," +
										"DDMXSDUtil," +
										"PortletResourceBundles," +
										"ResourceActionsUtil," +
										"PortalUtil.",
		"problem.tickets=LPS-47682",
		"problem.url=https://github.com/liferay/liferay-portal/blob/master/readme/7.0/BREAKING_CHANGES.markdown#using-util-taglib-no-longer-binds-you-to-using-portal-services-javaxservletjsp-implementation"
	},
	service = FileMigrator.class
)
public class PageContextParamChanged extends JavaFileMigrator {

	@Override
	protected List<SearchResult> searchJavaFile(File file,
			JavaFileChecker javaFileChecker) {

		final List<SearchResult> searchResults = new ArrayList<>();

		// LanguageUtil
		List<SearchResult> languageUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "LanguageUtil", "format",
						new String[] { "PageContext", "String",
								"LanguageWrapper" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "format", new String[] { "PageContext",
						"String", "LanguageWrapper", "boolean" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "format", new String[] { "PageContext",
						"String", "LanguageWrapper[]" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "format", new String[] { "PageContext",
						"String", "LanguageWrapper[]", "boolean" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "format", new String[] { "PageContext",
						"String", "Object" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "format", new String[] { "PageContext",
						"String", "Object", "boolean" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "format", new String[] { "PageContext",
						"String", "Object[]" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "format", new String[] { "PageContext",
						"String", "Object[]", "boolean" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "LanguageUtil", "get",
						new String[] { "PageContext", "String" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "get", new String[] { "PageContext", "String",
						"String" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "getTimeDescription", new String[] {
						"PageContext", "long" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "getTimeDescription", new String[] {
						"PageContext", "long", "boolean" });
		searchResults.addAll(languageUtilInvocations);
		languageUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"LanguageUtil", "getTimeDescription", new String[] {
						"PageContext", "Long" });
		searchResults.addAll(languageUtilInvocations);

		// UnicodeLanguageUtil
		List<SearchResult> uniCodeLanguageUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "UnicodeLanguageUtil", "format",
						new String[] { "PageContext", "String",
								"LanguageWrapper" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "UnicodeLanguageUtil", "format",
						new String[] { "PageContext", "String",
								"LanguageWrapper", "boolean" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "format", new String[] {
						"PageContext", "String", "LanguageWrapper[]" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "format",
				new String[] { "PageContext", "String", "LanguageWrapper[]",
						"boolean" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "format", new String[] {
						"PageContext", "String", "Object" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "format", new String[] {
						"PageContext", "String", "Object", "boolean" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "format", new String[] {
						"PageContext", "String", "Object[]" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "format", new String[] {
						"PageContext", "String", "Object[]", "boolean" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "get", new String[] {
						"PageContext", "String" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "get", new String[] {
						"PageContext", "String", "String" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "getTimeDescription",
				new String[] { "PageContext", "String", "long" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);
		uniCodeLanguageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "UnicodeLanguageUtil", "getTimeDescription",
				new String[] { "PageContext", "String", "Long" });
		searchResults.addAll(uniCodeLanguageUtilInvocations);

		// VelocityTaglibImpl
		// taglib java implementation , no need to check

		// ThemeUtil
		List<SearchResult> themeUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "ThemeUtil", "include",
						new String[] { "ServletContext", "HttpServletRequest",
								"HttpServletResponse", "PageContext", "String",
								"Theme" });
		searchResults.addAll(themeUtilInvocations);
		themeUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"ThemeUtil", "includeFTL", new String[] { "ServletContext",
						"HttpServletRequest", "PageContext", "String", "Theme",
						"boolean" });
		searchResults.addAll(themeUtilInvocations);
		themeUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"ThemeUtil", "includeVM", new String[] { "ServletContext",
						"HttpServletRequest", "PageContext", "String", "Theme",
						"boolean" });
		searchResults.addAll(themeUtilInvocations);
		themeUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "ThemeUtil", "doDispatch",
						new String[] { "ServletContext", "HttpServletRequest",
								"HttpServletResponse", "PageContext", "String",
								"Theme", "boolean", "String" });
		searchResults.addAll(themeUtilInvocations);
		themeUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"ThemeUtil", "doIncludeFTL", new String[] { "ServletContext",
						"HttpServletRequest", "PageContext", "String", "Theme",
						"boolean", "boolean" });
		searchResults.addAll(themeUtilInvocations);
		themeUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"ThemeUtil", "doIncludeVM", new String[] { "ServletContext",
						"HttpServletRequest", "PageContext", "String", "Theme",
						"boolean", "boolean" });
		searchResults.addAll(themeUtilInvocations);

		// RuntimePageUtil
		List<SearchResult> runtimePageUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "RuntimePageUtil",
						"getProcessedTemplate", new String[] { "PageContext",
								"String", "TemplateResource" });
		searchResults.addAll(runtimePageUtilInvocations);
		runtimePageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "RuntimePageUtil", "processCustomizationSettings",
				new String[] { "PageContext", "TemplateResource" });
		searchResults.addAll(runtimePageUtilInvocations);
		runtimePageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "RuntimePageUtil", "processTemplate", new String[] {
						"PageContext", "String", "TemplateResource" });
		searchResults.addAll(runtimePageUtilInvocations);
		runtimePageUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "RuntimePageUtil", "processTemplate", new String[] {
						"PageContext", "TemplateResource" });
		searchResults.addAll(runtimePageUtilInvocations);

		// PortletDisplayTemplateUtil
		List<SearchResult> portletDisplayTemplateUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "PortletDisplayTemplateUtil",
						"renderDDMTemplate", new String[] { "PageContext",
								"long", "List<?>" });
		searchResults.addAll(portletDisplayTemplateUtilInvocations);
		portletDisplayTemplateUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "PortletDisplayTemplateUtil",
						"renderDDMTemplate", new String[] { "PageContext",
								"long", "List<?>", "Map<String, Object>" });
		searchResults.addAll(portletDisplayTemplateUtilInvocations);

		// DDMXSDUtil
		List<SearchResult> dDMXSDUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "DDMXSDUtil",
						"getFieldHTMLByName", new String[] { "PageContext",
								"long", "long", "String", "Field", "String",
								"String", "String", "boolean", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getHTML", new String[] { "PageContext",
						"DDMStructure", "Fields", "String", "String",
						"boolean", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getHTML", new String[] { "PageContext",
						"DDMTemplate", "Fields", "String", "String", "boolean",
						"Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getHTML", new String[] { "PageContext",
						"String", "Fields", "String", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getHTML", new String[] { "PageContext",
						"String", "Fields", "String", "String", "boolean",
						"Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getHTML", new String[] { "PageContext",
						"String", "Fields", "String", "String", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getHTML", new String[] { "PageContext",
						"String", "Fields", "String", "String", "String",
						"boolean", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getHTML", new String[] { "PageContext",
						"String", "String", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getSimpleFieldHTML", new String[] {
						"PageContext", "Element", "Field", "String", "String",
						"String", "boolean", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);
		dDMXSDUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"DDMXSDUtil", "getSimpleFieldHTMLByName", new String[] {
						"PageContext", "long", "long", "Field", "String",
						"String", "String", "boolean", "Locale" });
		searchResults.addAll(dDMXSDUtilInvocations);

		// PortletResourceBundles
		List<SearchResult> portletResourceBundlesInvocations = javaFileChecker
				.findMethodInvocations(null, "PortletResourceBundles",
						"getString", new String[] { "PageContext", "String" });
		searchResults.addAll(portletResourceBundlesInvocations);
		portletResourceBundlesInvocations = javaFileChecker
				.findMethodInvocations(null, "PortletResourceBundles",
						"_getString", new String[] { "PageContext", "String" });
		searchResults.addAll(portletResourceBundlesInvocations);

		// ResourceActionsUtil
		List<SearchResult> resourceActionsUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "ResourceActionsUtil",
						"getAction", new String[] { "PageContext", "String" });
		searchResults.addAll(resourceActionsUtilInvocations);
		resourceActionsUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "ResourceActionsUtil", "getActionsNames", new String[] {
						"PageContext", "List<String>" });
		searchResults.addAll(resourceActionsUtilInvocations);
		resourceActionsUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "ResourceActionsUtil", "getActionsNames", new String[] {
						"PageContext", "String", "long" });
		searchResults.addAll(resourceActionsUtilInvocations);
		resourceActionsUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "ResourceActionsUtil", "getModelResource", new String[] {
						"PageContext", "String" });
		searchResults.addAll(resourceActionsUtilInvocations);

		// PortalUtil
		List<SearchResult> portalUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "PortalUtil",
						"getFirstPageLayoutTypes",
						new String[] { "PageContext" });
		searchResults.addAll(portalUtilInvocations);
		return searchResults;
	}
}
