package fr.renater.idegest.util;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathUtil {

  public XPathUtil() {
    super();
  }
  /**
   * 
   * @param stream document XML
   * @param expressionXPath valide pour le doc 
   * @return les branches de l'arbre répondant au filtre
   * @throws IOException 
   */
  public static NodeList eval(InputStream stream, String expressionXPath)
      throws IOException {
    NodeList res = null;
    try {
      // création du XPath
      XPathFactory fabrique = XPathFactory.newInstance();
      XPath xpath = fabrique.newXPath();

      // évaluation de l'expression XPath
      XPathExpression exp = xpath.compile(expressionXPath);

      // exploitation
      InputSource source = new InputSource(stream);
      res = (NodeList) exp.evaluate(source, XPathConstants.NODESET);

    } catch (XPathExpressionException e) {
      throw new IOException(e.getMessage());
    }
    return res;
  }

}
