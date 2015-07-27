

public class PageContextParamChangedTest {

	public static void main(String[] args){
		PageContext pageContext = new PageContext() ;
		String str = "";
		LanguageWrapper languageWrapper = new LanguageWrapper();
		LanguageWrapper[] languageWrappers = null;

		LanguageUtil.format(pageContext , str , languageWrapper);
		LanguageUtil.format(pageContext , str , languageWrapper, true);
		LanguageUtil.format(pageContext , str , languageWrappers);
		LanguageUtil.format(pageContext , str , languageWrappers,true);

		UnicodeLanguageUtil.format(pageContext , str , languageWrapper);
		UnicodeLanguageUtil.format(pageContext , str , languageWrapper, true);
		UnicodeLanguageUtil.format(pageContext , str , languageWrappers);
		UnicodeLanguageUtil.format(pageContext , str , languageWrappers,true);

		List<Object> list = null;
		Long lovar = 1;
		short shortVar = 1;
		PortletDisplayTemplateUtil.renderDDMTemplate(pageContext , lovar , list);
		LanguageUtil.getTimeDescription(pageContext , shortVar);
		//match twice
		LanguageUtil.getTimeDescription(pageContext , lovar);

	}

}
