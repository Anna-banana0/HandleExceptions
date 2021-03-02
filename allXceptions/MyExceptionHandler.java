package allXceptions;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class MyExceptionHandler {
	private static Properties props = new Properties();
	static {
		try {
			props.load(new FileInputStream(
					"C:/Users/RDRIL/eclipse-workspace/BankingSir/src/allXceptions/ActionClassMapping.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Action action;

	public static void handleException(String projName, String moduleName, Exception ex)  {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			// FileInputStream file = new
			// FileInputStream("C:/Users/RDRIL/eclipse-workspace/BankingSir/src/allXceptions/conn.xml");
			Document doc = builder.parse("C:/Users/RDRIL/eclipse-workspace/BankingSir/src/allXceptions/conn.xml");
			Element rootElement = doc.getDocumentElement();

			String projectName = rootElement.getAttribute("name");
			
			//System.out.println("Project is : " + projectName);
			String proModEx = projectName;
			
			NodeList moduleNodes = rootElement.getChildNodes();
			for (int i = 0; i < moduleNodes.getLength(); i++) {
				Node moduleNode = moduleNodes.item(i);
				if (moduleNode.getNodeType() == Node.ELEMENT_NODE) {
					
				//	System.out.println("Module name is: " + ((Element) moduleNode).getAttribute("name"));
					proModEx = proModEx.concat(" " + ((Element) moduleNode).getAttribute("name"));
					
					NodeList exceptionNodes = moduleNode.getChildNodes();
					
					Map<String, List<Action>> exceptionMap = new HashMap<String, List<Action>>();
					List<Action> actionCount = new ArrayList<Action>();
					for (int j = 0; j < exceptionNodes.getLength(); j++) {
						
						
						
						
						Node exceptionNode = exceptionNodes.item(j);// IOException
						if (exceptionNode.getNodeType() == Node.ELEMENT_NODE) {
							
							String exceptionName = ((Element) exceptionNode).getNodeName();
							//System.out.println("exceptionName "+ " : " + ex.getClass().getName());
							proModEx = proModEx.concat(" " + ex.getClass().getSimpleName());
							
							if (exceptionName.equals(ex.getClass().getSimpleName())) {

								// get all actions
								NodeList actionNodes = exceptionNode.getChildNodes();
								// System.out.println(actionNodes.getLength());
								for (int k = 0; k < actionNodes.getLength(); k++) {
									Node actionNode = actionNodes.item(k);

									if (actionNode.getNodeType() == Node.ELEMENT_NODE) {
										String actionName = ((Element) actionNode).getAttribute("name");
										//System.out.println("Action Name: " + actionName);
										NamedNodeMap attributeMap = actionNode.getAttributes();
										Map nvPair = new HashMap();
										for (int l = 0; l < attributeMap.getLength(); l++) {
											Node attrNode = attributeMap.item(l);
											if (attrNode != null) {
												String attributeName = attributeMap.item(l).getNodeName();
												//System.out.println("Attribute Nanme   "+attributeName);
												//System.out.println("*********************");
												String attributeValue = attributeMap.item(l).getNodeValue();
												//System.out.println("Attribute Value   "+attributeValue);
												//System.out.println("*********************");
												if (!attributeName.equals("name")) {
													nvPair.put(attributeName, attributeValue);
													//System.out.println(nvPair.toString());
												}
											}
										}

										// get name of the class for this action
										String className = props.getProperty(actionName);
										Action action = (Action) Class.forName(className).newInstance();
										actionCount.add(action);
										//action.takeAction(nvPair);
										exceptionMap.put(proModEx, actionCount);
										System.out.println("**************************************");
										for(String s: exceptionMap.keySet())
											System.out.print(s);
										
										System.out.println();
										for(List<Action> s: exceptionMap.values())
											for(Action a : s)
											a.takeAction(nvPair);
										
									}
								
								}	
							}
						}
					}
					
				}
			}
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
		}

	}

}