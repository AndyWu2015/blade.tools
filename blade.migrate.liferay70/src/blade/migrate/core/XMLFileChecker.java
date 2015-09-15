package blade.migrate.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Andy Wu
 */
public class XMLFileChecker {

	public XMLFileChecker(File file) {
		_file = file;

		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			_parser = factory.newSAXParser();
		}
		catch (ParserConfigurationException | SAXException e) {
			new IllegalArgumentException(e);
		}
	}

	public List<SearchResult> findPK(String tagName, String[] attributes) {
		SearchExecutor4PK searcher4pk = new SearchExecutor4PK(tagName,
				attributes);
		try {
			_parser.parse(_file, searcher4pk);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

		return searcher4pk.getResults();
	}

	public List<SearchResult> findTag(String tagName, String value) {
		// start parsing the given file and generates results
		SearchExecutor searcher = new SearchExecutor(tagName, value);
		try {
			_parser.parse(_file, searcher);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

		return searcher.getResults();
	}

	private File _file;
	private SAXParser _parser;

	private class SearchExecutor extends DefaultHandler {

		public SearchExecutor(String tagName, String value) {
			_tagName = tagName;
			_value = value;
			_results = new ArrayList<>();
		}

		@Override
		public void characters(char[] ch, int start, int length)
			throws SAXException {

			String content = new String(ch, start, length);

			if (inState && _value.equals(content)) {
				_results.add(
					new SearchResult(
						_file, 0, 0, locator.getLineNumber(),
						locator.getLineNumber(), true));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
			throws SAXException {

			// reset the state when goes to end of each element

			inState = false;
		}

		public List<SearchResult> getResults() {
			return _results;
		}

		@Override
		public void setDocumentLocator(final Locator locator) {
			this.locator = locator;
		}

		@Override
		public void startDocument() throws SAXException {
			_results.clear();
		}

		@Override
		public void startElement(
				String uri, String localName, String qName,
				Attributes attributes)
			throws SAXException {
			if (_tagName.equals(qName)) {
				inState = true;
			}
		}

		private List<SearchResult> _results = null;
		private String _tagName;
		private String _value;

		// is in the target Tag

		private boolean inState = false;
		private Locator locator;
	}

	private class SearchExecutor4PK extends DefaultHandler {

		public SearchExecutor4PK(String tagName , String[] attributes) {
			_tagName = tagName;
			_attributes = attributes;
			_results = new ArrayList<>();
			_keyValues = new String[_attributes.length][2];
			for(int i = 0 ; i<_attributes.length ; i++){
				_keyValues[i] = _attributes[i].split("=");
			}
		}

		public List<SearchResult> getResults() {
			return _results;
		}

		@Override
		public void setDocumentLocator(final Locator locator) {
			this.locator = locator;
		}

		@Override
		public void startDocument() throws SAXException {
			_results.clear();
		}

		@Override
		public void startElement(
				String uri, String localName, String qName,
				Attributes attributes)
			throws SAXException {
			boolean isFind = true;
			if (!_tagName.equals(qName)) {
				return ;
			}
			for (int i = 0; i < _keyValues.length; i++) {
				if (!_keyValues[i][1].equals(attributes
						.getValue(_keyValues[i][0]))) {
					isFind = false;
				}
			}
			if(isFind){
				_results.add(
						new SearchResult(
							_file, 0, 0, locator.getLineNumber(),
							locator.getLineNumber(), true));
			}


		}

		private List<SearchResult> _results = null;
		private String _tagName;
		private String[] _attributes;
		private String[][] _keyValues;

		private Locator locator;
	}

}