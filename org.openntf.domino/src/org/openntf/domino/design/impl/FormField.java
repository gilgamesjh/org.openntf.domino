/**
 * 
 */
package org.openntf.domino.design.impl;

import java.util.logging.Logger;

import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.xml.XMLNode;

/**
 * @author jgallagher
 * 
 */
public class FormField implements org.openntf.domino.design.FormField {
	private static final Logger log_ = Logger.getLogger(FormField.class.getName());

	private final XMLNode node_;

	public FormField(final XMLNode node) {
		node_ = node;
	}

	public Kind getKind() {
		return Kind.valueOf(node_.getAttribute("kind").toUpperCase());
	}

	public void setKind(final Kind kind) {
		node_.setAttribute("kind", kind.toString().toLowerCase());
	}

	public String getName() {
		return node_.getAttribute("name");
	}

	public void setName(final String name) {
		node_.setAttribute("name", name);
	}

	@Override
	public boolean isAllowMultiValues() {
		return node_.getAttribute("allowmultivalues").equals("true");
	}

	@Override
	public void setAllowMultiValues(final boolean allowMultiValues) {
		node_.setAttribute("allowmultivalues", String.valueOf(allowMultiValues));
	}

	@Override
	public boolean isProtected() {
		return node_.getAttribute("protected").equals("true");
	}

	@Override
	public void setProtected(final boolean _protected) {
		node_.setAttribute("protected", String.valueOf(_protected));
	}

	@Override
	public boolean isSign() {
		return node_.getAttribute("sign").equals("true");
	}

	@Override
	public void setSign(final boolean sign) {
		node_.setAttribute("sign", String.valueOf(sign));
	}

	@Override
	public boolean isSeal() {
		return node_.getAttribute("seal").equals("true");
	}

	@Override
	public void setSeal(final boolean seal) {
		node_.setAttribute("seal", String.valueOf(seal));
	}

	@Override
	public boolean isLookUpAddressOnRefresh() {
		return node_.getAttribute("lookupaddressonrefresh").equals("true");
	}

	@Override
	public void setLookUpAddressOnRefresh(final boolean lookUpAddressOnRefresh) {
		node_.setAttribute("lookupaddressonrefresh", String.valueOf(lookUpAddressOnRefresh));
	}

	@Override
	public boolean isLookUpEachChar() {
		return node_.getAttribute("lookupeachchar").equals("true");
	}

	@Override
	public void setLookUpEachChar(final boolean lookUpEachChar) {
		node_.setAttribute("lookupeachchar", String.valueOf(lookUpEachChar));
	}

	@Override
	public String getDefaultValueFormula() {
		XMLNode node = this.getDefaultValueFormulaNode();
		if (node != null) {
			return node.getText();
		}
		return "";
	}

	@Override
	public void setDefaultValueFormula(final String defaultValueFormula) {
		// DXL is not happy with empty default value nodes, so delete when empty
		XMLNode node = this.getDefaultValueFormulaNode();
		if (defaultValueFormula == null || defaultValueFormula.length() == 0) {
			if (node != null) {
				node_.removeChild(node.getParentNode());
			}
		} else {
			if (node == null) {
				if (defaultValueFormula == null || defaultValueFormula.length() == 0) {
					return;
				}
				node = this.createDefaultValueFormulaNode();
			}
			node.setText(defaultValueFormula);
		}
	}

	// DXL uses the "keyword" field type for several field types, so it's more convenient to make a new faux
	// attribute to handle referring to the field type like a human might
	@Override
	public Type getFieldType() {
		String type = node_.getAttribute("type");
		if (type.equals("keyword")) {
			XMLNode keywords = this.getKeywordsNode();
			String ui = keywords.getAttribute("ui");
			if (ui.equals("checkbox")) {
				return Type.CHECKBOX;
			} else if (ui.equals("radiobutton")) {
				return Type.RADIOBUTTON;
			} else if (ui.equals("combobox")) {
				return Type.COMBOBOX;
			} else {
				return Type.DIALOGLIST;
			}
		} else {
			return Type.valueOf(type.toUpperCase());
		}
	}

	@Override
	public void setFieldType(final Type fieldType) {
		try {
			switch (fieldType) {
			case CHECKBOX:
			case COMBOBOX:
			case DIALOGLIST:
			case RADIOBUTTON:
				node_.setAttribute("type", "keyword");
				XMLNode keywords = this.getKeywordsNode();
				keywords.setAttribute("ui", fieldType.toString().toLowerCase());
				keywords.setAttribute("helperbutton", String.valueOf(fieldType.equals("dialoglist")));
				if (keywords.getAttribute("columns").length() == 0) {
					keywords.setAttribute("columns", "1");
				}
				break;
			default:
				node_.setAttribute("type", fieldType.toString().toLowerCase());
				if (fieldType == Type.PASSWORD) {
					node_.setAttribute("seal", "true");
				} else if (fieldType == Type.RICHTEXTLITE) {
					if (getKind() == Kind.COMPUTEDFORDISPLAY || getKind() == Kind.COMPUTEDWHENCOMPOSED) {
						this.setKind(Kind.COMPUTED);
					}
					if (node_.getAttribute("onlyallow").isEmpty()) {
						node_.setAttribute("onlyallow",
								"picture sharedimage attachment view datepicker sharedapplet text object calendar inbox help clear graphic link");
					}
					if (node_.getAttribute("firstdisplay").isEmpty()) {
						node_.setAttribute("firstdisplay", "text");
					}
				} else if (fieldType == Type.RICHTEXT && (getKind() == Kind.COMPUTEDFORDISPLAY || getKind() == Kind.COMPUTEDWHENCOMPOSED)) {
					setKind(Kind.COMPUTED);
				}
				break;
			}
		} catch (Exception e) {
			DominoUtils.handleException(e);
		}
	}

	private XMLNode getKeywordsNode() {
		XMLNode node = node_.selectSingleNode("keywords");

		if (node == null) {
			node = node_.addChildElement("keywords");
		}
		return node;
	}

	private XMLNode getDefaultValueFormulaNode() {
		XMLNode node = node_.selectSingleNode("code[@event='defaultvalue']");

		if (node == null) {
			return null;
		} else {
			node = node.selectSingleNode("formula");
		}
		return node;
	}

	private XMLNode createDefaultValueFormulaNode() {
		XMLNode node = node_.addChildElement("code");
		node.setAttribute("event", "defaultvalue");
		node = node.addChildElement("formula");
		return node;
	}
}
